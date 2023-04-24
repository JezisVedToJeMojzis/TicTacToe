public class PressEnter {

    public void pressEnter()
    {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}