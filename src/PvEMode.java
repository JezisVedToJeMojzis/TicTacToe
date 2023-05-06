import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PvEMode {
    PressToContinue key = new PressToContinue();
    Player player = new Player();
    PlayerMovement playerMove = new PlayerMovement();
    Bot bot = new Bot();
    BotMovement botMove = new BotMovement();
    List<Player> players = new ArrayList<Player>();
    int freeSpots = 9; //for draw
    boolean gameOver = false;
    int rounds = 1;

    public void startGame(){
        initialSetup();
        printRound();

        while (gameOver != true) {
            switchTurns();
            if(player.getTurn() == true){
                playerMove(player);
                freeSpots--; //substract from free spots
                if(playerWon(player)){
                    player.addWin();
                    printScoreBoard();
                    if(quitGame()){
                        gameOver = true;
                        break;
                    }
                    newRound();
                }

                //check draw
                if (isDraw()) {
                    printScoreBoard();
                    if(quitGame()){
                        gameOver = true;
                        break;
                    }
                    newRound();
                }
            }

            if(bot.getTurn() == true){
                botMove(bot);
                freeSpots--;
                if(botWon(bot)){
                    bot.addWin();
                    printScoreBoard();
                    if(quitGame()){
                        gameOver = true;
                        break;
                    }
                    newRound();
                }

                //check draw
                if (isDraw()) {
                    printScoreBoard();
                    if(quitGame()){
                        gameOver = true;
                        break;
                    }
                    newRound();
                }

            }
            System.out.println("\n____________________________________________________________________\n");
        }
    }

    public boolean playerWon(Player player){
        boolean won = false;
        //check if current player won
        if (playerMove.playerWin(player.getSymbol())) {
            System.out.println("\n*PLAYER " + player.getNumber() + " (" + player.getSymbol() + ")" + " WON*\n");
            won = true;
            return won;
        }
        return won;
    }

    public boolean botWon(Bot bot){//ADJUST
        boolean won = false;
        //check if current player won
        if (playerMove.playerWin(bot.getSymbol())) {
            System.out.println("\n*PLAYER (" + bot.getSymbol() + ")" + " WON*\n");
            won = true;
            return won;
        }
        return won;
    }

    public void newRound(){
        freeSpots = 9;
        rounds++;
        switchSymbols();
        printRound();
    }

    public boolean isDraw(){
        boolean draw = false;
        if (freeSpots == 0) {
            System.out.println("\n*ITS A DRAW*\n");
            draw = true;
            return draw;
        }
        return draw;
    }

    public boolean quitGame(){
        boolean quit = false;
        if(key.pressQtoQuit()){
            System.out.println("\n*SEE YOU SOON*");
            quit = true;
            return quit;
        }
        return quit;
    }

    public void botMove(Bot bot){
        System.out.println("\nBot " + " (" + bot.getSymbol() + ")" + " turn.");
    }
    public void playerMove(Player player){
        System.out.println("\nPlayer " + player.getNumber() + " (" + player.getSymbol() + ")" + " turn.");

        //occupying spot + printing current state of game board
        System.out.println(Arrays.deepToString(playerMove.occupySpot(player.getSymbol(), player.getNumber())).replace("], ", "\n")
                .replace("]", "")
                .replace("[", "")
                .replace(",", ""));
    }

    public void initialSetup(){
        //assigning symbols
        player.setSymbol("X");
        bot.setSymbol("O");
        bot.setTurn(true); //switching logic (player starts)
    }

    public void switchTurns(){
        //switch player turns
        if (player.getTurn() == true) {
            bot.setTurn(true);
            player.setTurn(false);
        } else if (bot.getTurn() == true) {
            player.setTurn(true);
            bot.setTurn(false);
        }
    }

    public void switchSymbols(){
        //switch symbols of players
        if (player.getSymbol() == "X") {
            player.setSymbol("O");
            bot.setSymbol("X");
        } else {
            player.setSymbol("X");
            bot.setSymbol("O");
        }
    }

    public void printRound(){
        System.out.println("\n*******************************************************************\n");
        System.out.println("                          *** ROUND: " + rounds + " ***");
        printSymbolsOfEachPlayer();
        System.out.println("\n*******************************************************************\n");
    }

    public void printSymbolsOfEachPlayer(){
        System.out.println("\n                      *SYMBOLS OF EACH PLAYER*");
        System.out.println("                            Player: " + player.getSymbol());
        System.out.println("                            Bot: " + bot.getSymbol());
    }

    public void printScoreBoard(){
        System.out.println("\n*******************************************************************\n");
        System.out.println("                            *SCORE BOARD*");
        System.out.println("                             Player: " + player.getWins());
        System.out.println("                             Bot: " + bot.getWins());
        System.out.println("\n*******************************************************************\n");
    }
}
