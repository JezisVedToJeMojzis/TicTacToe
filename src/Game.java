import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        PressToContinue key = new PressToContinue();

        boolean gameOver = false;

        System.out.println("___________________________________________________________________");
        System.out.println("                        ***TIC TAC TOE***");
        System.out.println("___________________________________________________________________");
        System.out.println("\n*GAME BOARD*");
        System.out.println(Arrays.deepToString(gameBoard.getBoard()).replace("], ", "\n")
                .replace("]", "")
                .replace("[", "")
                .replace(",", ""));

        //show rules
        if(key.pressRforRules() == true){
            System.out.println("\n*RULES OF THE GAME*");
            System.out.println("BLABLABLA");
        }

        //PvP mode
        if(key.pressPforPvP() == true){
            PvPMode game = new PvPMode();
            game.startGame();
        }

        //PvE mode
        else{
            System.out.println("\n*You have chosen to play PvE mode*");

            System.out.println("\n*THE GAME BEGINS*");
        }


    }
}
