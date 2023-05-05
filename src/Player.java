public class Player {
    private String symbol;
    private boolean turn;

    private int wins;
    public Player(){
        symbol = " ";
        turn = false;
        wins = 0;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void addWin(){
        this.wins++;
    }

    public void resetWins(){
        this.wins = 0;
    }
}
