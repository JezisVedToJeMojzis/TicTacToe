import java.util.Random;
public class BotMovement {
    Random rand = new Random();
    Board gameBoard = new Board();
    Boolean gameOver = false;
    private int countRowSymbols = 0;
    private int countColumnSymbols = 0;
    public BotMovement(){

    }

//    public String[][] occupySpot(String bSymbol, int bNumber){
//
//    }

    public boolean botWin(String botSymbol){
        return true;
    }

    public boolean checkRow(String botSymbol, String[][] currentBoard){
        return true;
    }

    public boolean checkColumn(String botSymbol, String[][] currentBoard){
        return true;
    }

}
