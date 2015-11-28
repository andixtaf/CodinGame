package ASCII_Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ASCII_Display {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        List<String> matrix = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            matrix.add(ROW);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        for(int i = 0; i < T.length(); i++)
        {
            int pos = (int)T.charAt(i) - 80;

            for(int j = 0; j < H; j++)
            {
                System.out.print("");
            }
        }
    }

    public int getPositionOfChar(char x)
    {
        return 0;
    }
}
