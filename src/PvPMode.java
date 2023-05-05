import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PvPMode {
    private boolean gameOver = false;

    public void startGame() {
        PlayerMovement move = new PlayerMovement();
        PressToContinue key = new PressToContinue();

        int freeSpots = 9; //for draw
        boolean gameOver = false;

        Player player1 = new Player();
        Player player2 = new Player();

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        player1.setNumber(1);
        player2.setNumber(2);

        System.out.println("\n*You have chosen to play PvP mode*");

        System.out.println("\n*THE GAME BEGINS*");

        //assigning symbols to players
        player1.setSymbol("X");
        player2.setSymbol("O");

        System.out.println("\n*SYMBOLS OF EACH PLAYER*");
        System.out.println("Player 1: " + player1.getSymbol());
        System.out.println("Player 2: " + player2.getSymbol());

        //player 1 always begins (because of switching logic player 2 needs to be true)
        player2.setTurn(true);

        //game logic
        while (gameOver != true) {
            //switch player turns
            if (player1.getTurn() == true) {
                player2.setTurn(true);
                player1.setTurn(false);
            } else if (player2.getTurn() == true) {
                player1.setTurn(true);
                player2.setTurn(false);
            }
            for (Player player : players) {
                if (player.getTurn() == true) {
                    System.out.println("\n___________________________________________________________________\n");
                    System.out.println("\nPlayer " + player.getNumber() + " (" + player.getSymbol() + ")" + " turn.");

                    //occupying spot + printing current state of game board
                    System.out.println(Arrays.deepToString(move.occupySpot(player.getSymbol(), player.getNumber())).replace("], ", "\n")
                            .replace("]", "")
                            .replace("[", "")
                            .replace(",", ""));
                    freeSpots--; //substract from free spots

                    //check if current player won
                    if (move.playerWin(player.getSymbol())) {
                        System.out.println("\n*PLAYER " + player.getNumber() + " (" + player.getSymbol() + ")" + " WON*\n");
                        player.addWin();
                        System.out.println("\n*SCORE BOARD*");
                        System.out.println("Player 1: " + player1.getWins());
                        System.out.println("Player 2: " + player2.getWins());
                        if(key.pressQtoQuit() == true){
                            System.out.println("\n*SEE YOU SOON*");
                            gameOver = true;
                            break;
                        }

                        //switch symbols of players
                        if (player1.getSymbol() == "X") {
                            player1.setSymbol("O");
                            player2.setSymbol("X");
                        } else {
                            player1.setSymbol("X");
                            player2.setSymbol("O");
                        }
                        System.out.println("\n___________________________________________________________________\n");
                        System.out.println("\n***NEW ROUND***\n");
                        System.out.println("*NEW SYMBOLS OF EACH PLAYER*");
                        System.out.println("Player 1: " + player1.getSymbol());
                        System.out.println("Player 2: " + player2.getSymbol());
                        freeSpots = 9;
                        key.pressEnter();
                    }

                    //check draw
                    if (freeSpots == 0) {
                        System.out.println("\n*ITS A DRAW*\n");
                        System.out.println("\n*SCORE BOARD*");
                        System.out.println("Player 1: " + player1.getWins());
                        System.out.println("Player 2: " + player2.getWins());
                        if(key.pressQtoQuit() == true){
                            System.out.println("\n*SEE YOU SOON*");
                            gameOver = true;
                            break;
                        }
                        //switch symbols of players
                        if (player1.getSymbol() == "X") {
                            player1.setSymbol("O");
                            player2.setSymbol("X");
                        } else {
                            player1.setSymbol("X");
                            player2.setSymbol("O");
                        }
                        System.out.println("\n___________________________________________________________________\n");
                        System.out.println("\n*NEW ROUND*");
                        System.out.println("*NEW SYMBOLS OF EACH PLAYER*");
                        System.out.println("Player 1: " + player1.getSymbol());
                        System.out.println("Player 2: " + player2.getSymbol());
                        freeSpots = 9;
                        key.pressEnter();
                    }
                }
            }
        }
    }
}
