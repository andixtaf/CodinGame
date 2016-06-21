package XXO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class XXO
{
	private static Integer[][] playground = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
	};

	private static XXOValidator validator = new XXOValidator();

	private static Integer actualPlayer = 1;

	public static void main(String[] args)
	{
		init();

		System.out.println("XXO starts!");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = "";

		while(!validator.checkWinForGivenPlayer(playground, actualPlayer))
		{
			printField();

			System.out.println("Player: " + actualPlayer);
			System.out.println("Set Input x,y:");

			try
			{
				input = reader.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			String[] coordinates = input.split(",");

			Integer x = Integer.parseInt(coordinates[0]);
			Integer y = Integer.parseInt(coordinates[1]);

			playground[x][y] = actualPlayer++;

			if(actualPlayer > 2)
			{
				actualPlayer = 1;
			}
		}

		System.out.println("Player: " + actualPlayer + " has won!!!!");
		printField();

	}

	private static void printField()
	{
		for(int i = 0; i < playground.length; i++)
		{
			System.out.println(Arrays.toString(playground[i]));
		}
	}

	private static void init()
	{
		actualPlayer = 1;

		playground = new Integer[][]{
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
	}

}
