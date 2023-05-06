import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println("                The rules of the game are simple and.....");
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
