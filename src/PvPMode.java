import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PvPMode {
    PressToContinue key = new PressToContinue();
    Player player1 = new Player();
    Player player2 = new Player();
    PlayerMovement move = new PlayerMovement();
    List<Player> players = new ArrayList<Player>();
    int freeSpots = 9; //for draw
    boolean gameOver = false;
    int rounds = 1;

    public void startGame() {
        initialSetup();
        System.out.println("\n********************************************************************\n");
        System.out.println("                          *** ROUND: " + rounds + " ***");
        printSymbolsOfEachPlayer();
        System.out.println("\n********************************************************************\n");

        //game logic
        while (gameOver != true) {
            switchTurns();
            for (Player player : players) {
                if (player.getTurn() == true) {
                    playerMove(player);
                    freeSpots--;

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
                    System.out.println("\n____________________________________________________________________\n");
                }
            }
        }
    }

    public void playerMove(Player player){
        System.out.println("\nPlayer " + player.getNumber() + " (" + player.getSymbol() + ")" + " turn.");

        //occupying spot + printing current state of game board
        System.out.println(Arrays.deepToString(move.occupySpot(player.getSymbol(), player.getNumber())).replace("], ", "\n")
                .replace("]", "")
                .replace("[", "")
                .replace(",", ""));
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

    public boolean isDraw(){
        boolean draw = false;
        if (freeSpots == 0) {
            System.out.println("\n*ITS A DRAW*\n");
            draw = true;
            return draw;
        }
        return draw;
    }

    public boolean playerWon(Player player){
        boolean won = false;
        //check if current player won
        if (move.playerWin(player.getSymbol())) {
            System.out.println("\n*PLAYER " + player.getNumber() + " (" + player.getSymbol() + ")" + " WON*\n");
            won = true;
            return won;
        }
        return won;
    }


    public void initialSetup(){
        players.add(player1);
        players.add(player2);

        //assigning numbers of players
        player1.setNumber(1);
        player2.setNumber(2);

        //assigning symbols to players
        player1.setSymbol("X");
        player2.setSymbol("O");

        //needs to be set as true because of switching logic (player 1 will start)
        player2.setTurn(true);
    }

    public void switchTurns(){
        //switch player turns
        if (player1.getTurn() == true) {
            player2.setTurn(true);
            player1.setTurn(false);
        } else if (player2.getTurn() == true) {
            player1.setTurn(true);
            player2.setTurn(false);
        }
    }

    public void switchSymbols(){
        //switch symbols of players
        if (player1.getSymbol() == "X") {
            player1.setSymbol("O");
            player2.setSymbol("X");
        } else {
            player1.setSymbol("X");
            player2.setSymbol("O");
        }
    }

    public void newRound(){
        freeSpots = 9;
        rounds++;
        switchSymbols();
        System.out.println("\n*******************************************************************\n");
        System.out.println("                      *** ROUND: " + rounds + " ***");
        printSymbolsOfEachPlayer();
        System.out.println("\n*******************************************************************\n");
    }

    public void printScoreBoard(){
        System.out.println("\n                           *SCORE BOARD*");
        System.out.println("                              Player 1: " + player1.getWins());
        System.out.println("                              Player 2: " + player2.getWins());
    }

    public void printSymbolsOfEachPlayer(){
        System.out.println("\n                      *SYMBOLS OF EACH PLAYER*");
        System.out.println("                            Player 1: " + player1.getSymbol());
        System.out.println("                            Player 2: " + player2.getSymbol());
    }
}
