public class PlayerMovement {
    Board gameBoard = new Board();
    KeyboardInput input = new KeyboardInput();
    private int countRowSymbols = 0;
    private int countColumnSymbols = 0;
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

        if(checkRow(playerSymbol, currentBoard)){
            gameBoard.refreshBoard();
            return true;
        }
        if(checkColumn(playerSymbol, currentBoard)){
            gameBoard.refreshBoard();
            return true;
        }

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



//        else if(checkDiagonalFromTopLeftToRightBottom(0,0,playerSymbol, currentBoard)){
//            gameBoard.refreshBoard();
//            return true;
//        }
//        else if(checkDiagonalFromTopLeftToRightBottom(1,1,playerSymbol, currentBoard)){
//            gameBoard.refreshBoard();
//            return true;
//        }
//        else if(checkDiagonalFromTopLeftToRightBottom(2,2,playerSymbol, currentBoard)){
//            gameBoard.refreshBoard();
//            return true;
//        }
//
//
//
//        else if(checkDiagonalFromTopRightToLeftBottom(0,2,playerSymbol,currentBoard)){
//            gameBoard.refreshBoard();
//            return true;
//        }
//        else if(checkDiagonalFromTopRightToLeftBottom(1,1,playerSymbol,currentBoard)){
//            gameBoard.refreshBoard();
//            return true;
//        }
//        else if(checkDiagonalFromTopRightToLeftBottom(2,0,playerSymbol,currentBoard)){
//            gameBoard.refreshBoard();
//            return true;
//        }


        return false;
    }

    public boolean checkRow(String playerSymbol, String[][] currentBoard){
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

//    public boolean checkDiagonalFromTopLeftToRightBottom(int row, int column, String playerSymbol, String[][] currentBoard){
//
//        if(currentBoard[row][column].equals(playerSymbol)){
//          countDiagonalSymbolsFromLeft++;
//            //diagonal from top left to right bottom win
//            if(countDiagonalSymbolsFromLeft == 3){
//                return true;
//            }
//        }
//
//        return false;
//    }

//    public boolean checkDiagonalFromTopRightToLeftBottom(int row, int column, String playerSymbol, String[][] currentBoard){
//        if(currentBoard[row][column].equals(playerSymbol)){
//            countDiagonalSymbolsFromRight++;
//            //diagonal from top left to right bottom win
//            if(countDiagonalSymbolsFromRight == 3){
//                return true;
//            }
//        }
//        return false;
//    }
}

