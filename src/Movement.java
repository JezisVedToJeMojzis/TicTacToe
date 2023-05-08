import java.util.Random;
public class Movement {
    Board gameBoard = new Board();
    Random rand = new Random();
    KeyboardInput input = new KeyboardInput();
    public Movement(){

    }

    public String[][] playerOccupySpot(String pSymbol, int pNumber){

         String row = input.readString("Row:");
         System.out.println(row);
         int column = input.readInt("Column:");
         System.out.println(column);

        //check if chosen spot is not already occupied
        while(gameBoard.isOccupied(row,column)){
            System.out.println("This spot is already occupied. Try again.");
            row = input.readString("Row:");
            System.out.println(row);
            column = input.readInt("Column:");
            System.out.println(column);
        }

        //rewrite spot based on players symbol
        gameBoard.setBoard(row,column, pSymbol);
        System.out.println("\nPlayer " + pNumber + " (" + pSymbol + ")" + " occupied: " + row + column);
        return gameBoard.getBoard();
    }

    public String[][] botOccupySpot(String bSymbol){
        char r = (char) ('A' + rand.nextInt(3)); // A-C
        String row = "" + r;
        int column = rand.nextInt(3); // 0-2
        column++; //to avoid 0

        //check if chosen spot is not already occupied
        while(gameBoard.isOccupied(row,column)){
            r = (char) ('A' + rand.nextInt(3)); // A-C
            row = "" + r;
            column = rand.nextInt(3); // 0-2
            column++; //to avoid 0
        }

        //rewrite spot based on players symbol
        gameBoard.setBoard(row,column, bSymbol);
        System.out.println("\nBot " + " (" + bSymbol + ")" + " occupied: " + row + column);
        return gameBoard.getBoard();
    }

    public Boolean winMove(String playerSymbol) {
        String[][] getBoard = gameBoard.getBoard();
        String[][] currentBoard = new String[][]{
                {"□","□","□"},
                {"□","□","□"},
                {"□","□","□"}
        };

        int i=0,j=0;
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                currentBoard[i][j] = getBoard[a][b];
                j++;
            }
            j=0;
            i++;
        }

        if(checkRow(playerSymbol, currentBoard)){
            gameBoard.refreshBoard();
            return true;
        }
        if(checkColumn(playerSymbol, currentBoard)){
            gameBoard.refreshBoard();
            return true;
        }
        if(checkDiagonal(playerSymbol, currentBoard)){
            gameBoard.refreshBoard();
            return true;
        }
        return false;
    }

    public boolean checkDiagonal(String playerSymbol, String[][] currentBoard){
        int countDiagonalSymbolsFromLeft = 0; //diagonal from top right to left bottom
        int countDiagonalSymbolsFromRight = 0; //diagonal from top right to left bottom

        //diagonal from top left to right bottom
        if(currentBoard[0][0].equals(playerSymbol)){
            countDiagonalSymbolsFromLeft++;
            //diagonal from top left to right bottom win
            if(countDiagonalSymbolsFromLeft == 3){
                gameBoard.refreshBoard();
                return true;
            }
        }
        if(currentBoard[1][1].equals(playerSymbol)){
            countDiagonalSymbolsFromLeft++;
            //diagonal from top left to right bottom win
            if(countDiagonalSymbolsFromLeft == 3){
                gameBoard.refreshBoard();
                return true;
            }
        }
        if(currentBoard[2][2].equals(playerSymbol)){
            countDiagonalSymbolsFromLeft++;
            //diagonal from top left to right bottom win
            if(countDiagonalSymbolsFromLeft == 3){
                gameBoard.refreshBoard();
                return true;
            }
        }

        //diagonal from top right to left bottom
        if(currentBoard[0][2].equals(playerSymbol)){
            countDiagonalSymbolsFromRight++;
            //diagonal from top right to left bottom win
            if(countDiagonalSymbolsFromRight == 3){
                gameBoard.refreshBoard();
                return true;
            }
        }
        if(currentBoard[1][1].equals(playerSymbol)){
            countDiagonalSymbolsFromRight++;
            //diagonal from top right to left bottom win
            if(countDiagonalSymbolsFromRight == 3){
                gameBoard.refreshBoard();
                return true;
            }
        }
        if(currentBoard[2][0].equals(playerSymbol)){
            countDiagonalSymbolsFromRight++;
            //diagonal from top right to left bottom win
            if(countDiagonalSymbolsFromRight == 3){
                gameBoard.refreshBoard();
                return true;

            }
        }
        return false;
    }

    public boolean checkRow(String playerSymbol, String[][] currentBoard){
        int countRowSymbols = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(currentBoard[i][j].equals(playerSymbol)){
                    countRowSymbols++;
                    //row win
                    if(countRowSymbols == 3){
                        return true;
                    }
                }
            }
            countRowSymbols = 0;
        }
        return false;
    }

    public boolean checkColumn(String playerSymbol, String[][] currentBoard){
        int countColumnSymbols = 0;

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                if(currentBoard[i][j].equals(playerSymbol)){
                    countColumnSymbols++;
                    //column win
                    if(countColumnSymbols == 3){
                        return true;
                    }
                }
            }
            countColumnSymbols = 0;
        }
        return false;
    }
}

