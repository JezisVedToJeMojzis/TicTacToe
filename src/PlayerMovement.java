public class PlayerMovement {
    Board gameBoard = new Board();
    KeyboardInput input = new KeyboardInput();

    public PlayerMovement(){

    }

    public String[][] occupySpot(String pSymbol, int pNumber){

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

    public Boolean playerWin(String playerSymbol) {
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

        int n = 3;
        int countRowSymbols = 0;
        int countColumnSymbols = 0;
        int countDiagonalSymbolsFromLeft = 0;//diagonal from top left to right bottom
        int countDiagonalSymbolsFromRight = 0; //diagonal from top right to left bottom
        i=0;
        j=0;

        //check row win situation
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                if(currentBoard[i][j].equals(playerSymbol)){
                    countRowSymbols++;
                    //row win
                    if(countRowSymbols == 3){
                        gameBoard.refreshBoard();
                        return true;
                    }
                }
            }
            countRowSymbols = 0;
        }

        //check column win situation
        for(j = 0; j < n; j++){
            for(i = 0; i < n; i++){
                if(currentBoard[i][j].equals(playerSymbol)){
                    countColumnSymbols++;
                    //column win
                    if(countColumnSymbols == 3){
                        gameBoard.refreshBoard();
                        return true;
                    }
                }
            }
            countColumnSymbols = 0;
        }

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
}

