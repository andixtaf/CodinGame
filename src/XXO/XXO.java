package XXO;

import java.util.Objects;

class XXO
{
	boolean isVictory(Integer[][] matrix, Integer playerValue)
	{
		return isVictoryHorizontal(matrix, playerValue) ||
				isVictoryVertical(matrix, playerValue) ||
				isVictoryDiagonal(matrix, playerValue);
	}

	Boolean isVictoryHorizontal(Integer[][] matrix, Integer playerValue)
	{
		Boolean isVictory = true;

		for (Integer[] firstRow : matrix)
		{
			isVictory = true;

			for (int i = 0; i < firstRow.length - 1; i++)
			{
				isVictory &= (Objects.equals(firstRow[i], playerValue));
			}

			if (isVictory)
			{
				break;
			}

		}
		return isVictory;
	}

	Boolean isVictoryVertical(Integer[][] matrix, Integer playerValue)
	{
		Boolean isVictory = true;

		for (int i = 0; i < matrix.length; i++)
		{
			isVictory = true;

			for (int j = 0; j < matrix.length; j++)
			{
				isVictory &= (Objects.equals(matrix[j][i], playerValue));
			}

			if (isVictory)
			{
				break;
			}

		}
		return isVictory;
	}

	Boolean isVictoryDiagonal(Integer[][] matrix, Integer playerValue)
	{
		Boolean isVictory = true;

		for (int i = 0; i < matrix.length; i++)
		{
			isVictory &= (Objects.equals(matrix[i][i], playerValue));

		}

		if(!isVictory)
		{
			isVictory = true;

			for (int i = matrix.length-1; i > 0; i--)
			{
				isVictory &= (Objects.equals(matrix[i][i], playerValue));

			}
		}

		return isVictory;
	}
}
