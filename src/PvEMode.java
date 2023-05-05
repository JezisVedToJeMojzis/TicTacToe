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

    public void startGame(){
        //assigning symbols
        player.setSymbol("X");
        bot.setSymbol("O");

        System.out.println("\n*SYMBOLS OF EACH PLAYER*");
        System.out.println("Player: " + player.getSymbol());
        System.out.println("Bot: " + bot.getSymbol());

        bot.setTurn(true); //switching logic (player starts)

        while (gameOver != true) {
            //switch player turns
            if (player.getTurn() == true) {
                bot.setTurn(true);
                player.setTurn(false);
            } else if (bot.getTurn() == true) {
                player.setTurn(true);
                bot.setTurn(false);
            }

            if(player.getTurn() == true){
                System.out.println("\n___________________________________________________________________\n");
                System.out.println("\nPlayer " + " (" + player.getSymbol() + ")" + " turn.");

                //occupying spot + printing current state of game board
                System.out.println(Arrays.deepToString(playerMove.occupySpot(player.getSymbol(), player.getNumber())).replace("], ", "\n")
                        .replace("]", "")
                        .replace("[", "")
                        .replace(",", ""));
                freeSpots--; //substract from free spots
            }

            if(bot.getTurn() == true){
                System.out.println("\n___________________________________________________________________\n");
                System.out.println("\nBot " + " (" + bot.getSymbol() + ")" + " turn.");

            }

        }
    }
}
