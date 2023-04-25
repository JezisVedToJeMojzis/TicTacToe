
public class Board {
    private String[][] board;
    public Board(){
        board = new String[][]{
                {" ","1","2","3"},
                {"A","□","□","□"},
                {"B","□","□","□"},
                {"C","□","□","□"}
        };
    }
    public String[][] getBoard(){
        return this.board;
    }

    //put X or O on board based on players input
    public void setBoard(String row, int column, String symbol){
        int r = 0;
        if(row.equals("A")){
            r = 1;
        }
        if(row.equals("B")){
            r = 2;
        }if(row.equals("C")){
            r = 3;
        }
        board[r][column] = symbol;
    }
    //refresh board
    public void refreshBoard(){
        board = new String[][]{
                {" ","1","2","3"},
                {"A","□","□","□"},
                {"B","□","□","□"},
                {"C","□","□","□"}
        };
    }
    //check if spot is already occupied
    public Boolean isOccupied(String row, int column){
        int r = 0;
        Boolean occupied = false;
        if(row.equals("A")){
            r = 1;
        }
        if(row.equals("B")){
            r = 2;
        }if(row.equals("C")){
            r = 3;
        }
        if(board[r][column].equals("X") || board[r][column].equals("O")){
            occupied = true;
        }
        return occupied;
    }
}
