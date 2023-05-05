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
        String pressedButton = input.readStringToManageGameLogic("\nPress R to show the rules...\nPress anything else to start the game...");
        if (pressedButton.equals("R") || pressedButton.equals("r")){
            showRules = true;
        }
        return showRules;
   }

    public Boolean pressPforPvP(){
        Boolean playPvP = false;
        String pressedButton = input.readStringToManageGameLogic("\nPress P to play PvP mode...\nPress anything else to play PvE mode...");
        if (pressedButton.equals("P") || pressedButton.equals("p")){
            playPvP = true;
        }
        return playPvP;
    }
}