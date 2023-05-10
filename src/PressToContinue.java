public class PressToContinue {

    KeyboardInput input = new KeyboardInput();
    public void pressEnter()
    {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

   public Boolean pressRforRules(){
        Boolean showRules = false;
        String pressedButton = input.readStringToManageGameLogic("\nPress R and then Enter to show the rules...\nPress only Enter to start the game...");
        if (pressedButton.equals("R") || pressedButton.equals("r")){
            showRules = true;
        }
        return showRules;
   }

    public Boolean pressPforPvP(){
        Boolean playPvP = false;
        String pressedButton = input.readStringToManageGameLogic("\nPress P and then Enter to play PvP mode...\nPress only Enter to play PvE mode...");
        if (pressedButton.equals("P") || pressedButton.equals("p")){
            playPvP = true;
        }
        return playPvP;
    }

    public Boolean pressQtoQuit(){
        Boolean quitGame = false;
        String pressedButton = input.readStringToManageGameLogic("\nPress Q and then Enter to quit the game...\nPress only Enter to continue playing...");
        if (pressedButton.equals("Q") || pressedButton.equals("q")){
            quitGame = true;
        }
        return quitGame;
    }
}