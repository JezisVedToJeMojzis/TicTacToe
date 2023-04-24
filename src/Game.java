import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player player1 = new Player();
        Player player2 = new Player();
        PressEnter enter = new PressEnter();
        KeyboardInput input = new KeyboardInput();

        int gameOver = 0;

        while(gameOver!=1){
            if(player1.getSymbol() == "X"){
                player1.setSymbol("O");
                player2.setSymbol("X");
            }
            else{
                player1.setSymbol("X");
                player2.setSymbol("O");
            }

          //  gameBoard.refreshBoard();
        //    String board[][] = gameBoard.getBoard();

         //   System.out.println("\n***TIC TAC TOE***");
        //    System.out.println("\n*RULES*");
            // enter.pressEnter();


         //   System.out.println("\n*SYMBOLS OF EACH PLAYER*");
            System.out.println("Player 1: " + player1.getSymbol());
            System.out.println("Player 2: " + player2.getSymbol());
        //    enter.pressEnter();

            System.out.println("\nPlayer 1 turn, symbol: " + player1.getSymbol());
            player1.setTurn(true);

            String row = "";
            int column;
            row = input.readString("Row:");
            System.out.println(row);
            column = input.readInt("Column:");
            System.out.println(column);

            if(row.equals("A") && column == 1){
                gameBoard.setBoard(row,column, "X");
            }
            else if(row.equals("A") && column == 2){
                gameBoard.setBoard(row,column, "X");
            }
            else if(row.equals("A") && column == 3){
                gameBoard.setBoard(row,column, "X");
            }

            else if(row.equals("B") && column == 1){
                gameBoard.setBoard(row,column, "X");
            }
            else if(row.equals("B") && column == 2){
                gameBoard.setBoard(row,column, "X");
            }
            else if(row.equals("B") && column == 3){
                gameBoard.setBoard(row,column, "X");
            }

            else if(row.equals("C") && column == 1){
                gameBoard.setBoard(row,column, "X");
            }
            else if(row.equals("C") && column == 2){
                gameBoard.setBoard(row,column, "X");
            }
            else if(row.equals("C") && column == 3){
                gameBoard.setBoard(row,column, "X");
            }
            else{
                System.out.println("\nWrong input");
            }

            System.out.println("\nPlayer 1 occupied: " + row + column);
            System.out.println(Arrays.deepToString(gameBoard.getBoard()).replace("], ", "\n")
                    .replace("]", "")
                    .replace("[", "")
                    .replace(",", ""));
        }
    }
}
