
public class Board {
    private String[][] board;
  //  private int r;
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
    public void refreshBoard(){
        board = new String[][]{
                {" ","1","2","3"},
                {"A","□","□","□"},
                {"B","□","□","□"},
                {"C","□","□","□"}
        };
    }
}
