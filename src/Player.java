public class Player {
    private String symbol;
    private boolean turn;
    public Player(){
        symbol = " ";
        turn = false;
    }
    public void setSymbol(String sym)
    {
        symbol = sym;
    }
    public String getSymbol() {
        return symbol;
    }
    public boolean getTurn(){
        return turn;
    }
    public void setTurn(boolean trn){
        turn = trn;
    }
}
