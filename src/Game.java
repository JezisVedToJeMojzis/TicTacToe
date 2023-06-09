import java.util.Arrays;

public class Game {
    static Board gameBoard = new Board();
    static PressToContinue key = new PressToContinue();
    public static void main(String[] args) {
        gameIntroduction();
        //show rules
        if(key.pressRforRules()){
            gameRules();
        }

        //PvP mode
        if(key.pressPforPvP() == true){
            System.out.println("\n*You have chosen to play PvP mode*");
            System.out.println("\n*THE GAME BEGINS*");
            PvPMode game = new PvPMode();
            game.startGame();
        }

        //PvE mode
        else{
            System.out.println("\n*You have chosen to play PvE mode*");
            System.out.println("\n*THE GAME BEGINS*");
            PvEMode game = new PvEMode();
            game.startGame();
        }
    }

    public static void gameRules(){
        System.out.println("\n********************************************************************\n");
        System.out.println("                       *** RULES OF THE GAME ***");
        System.out.println("                   The rules of the game are simple:");
        System.out.println(" 1. Each player can choose a position by selecting row as A, B or C");
        System.out.println("    (A,B,C must be capital letter!) and column as 1, 2 or 3");
        System.out.println(" 2. Players can only select a position that is not occupied.");
        System.out.println(" 3. The first player to get three of their symbols in a row ");
        System.out.println("    (horizontally, vertically, or diagonally) wins the game.");
        System.out.println(" 4. If all the positions are filled and no player won than game");
        System.out.println("    is considered as 'Draw'.");
        System.out.println("\n********************************************************************\n");
    }

    public static void gameIntroduction(){
        //Board gameBoard = new Board();
        System.out.println("\n********************************************************************\n");
        System.out.println("                         *** TIC TAC TOE ***");
        System.out.println("\n********************************************************************\n");
        System.out.println("\n* GAME BOARD *");
        System.out.println(Arrays.deepToString(gameBoard.getBoard()).replace("], ", "\n")
                .replace("]", "")
                .replace("[", "")
                .replace(",", ""));
    }
}
