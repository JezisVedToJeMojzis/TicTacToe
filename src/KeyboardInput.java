import java.io.*;

public class KeyboardInput
{
    public static char readChar(String string_for_user)
    {
        char c = ' ';
        InputStreamReader keyboardInput = new InputStreamReader(System.in);
        try
        {	System.out.println(string_for_user);
            c = (char) keyboardInput.read();
        }
        catch (Exception e)
        {
            System.out.println("Wrong input. Try again...");
            c = readChar(string_for_user);
        }

        return c;
    }

    public String readString(String string_for_user)
    {
        String s = "";

        BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println(string_for_user);
            s = keyboardInput.readLine();
            while(!s.equals("A") && !s.equals("B") && !s.equals("C") ){
                System.out.println("Wrong input. Try again.");
                System.out.println(string_for_user);
                s = keyboardInput.readLine();

            }
        }
        catch (Exception e)
        {
            System.out.println("Wrong input. Try again.");
            s = readString(string_for_user);
        }

        return s;
    }

    public static int readInt(String string_for_user)
    {
        int n = 0;
        String s;

        BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println(string_for_user);
            s = keyboardInput.readLine();
            while(!s.equals("1") && !s.equals("2") && !s.equals("3")){
                System.out.println("Wrong input. Try again.");
                System.out.println(string_for_user);
                s = keyboardInput.readLine();

            }
            n = Integer.parseInt(s);

        }
        catch (Exception e)
        {
            System.out.println("Wrong input. Try again.");
            n = readInt(string_for_user);
        }

        return n;
    }

    public static double readDouble(String string_for_user)
    {
        double x = 0.0;
        String s;

        BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        try
        {	System.out.println(string_for_user);
            s = keyboardInput.readLine();
            x = Double.parseDouble(s);
        }
        catch (Exception e)
        {
            System.out.println("Wrong input. Try again.");
            x = readDouble(string_for_user);
        }

        return x;
    }
}