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
        if (pressedButton.equals("R")){
            showRules = true;
        }
        return showRules;
   }
}