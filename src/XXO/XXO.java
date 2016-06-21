package XXO;

import java.util.Objects;

class XXO
{
	boolean isVictory(Integer[][] matrix, Integer playerValue)
	{
		return false;
	}

	Boolean isVictoryHorizontal(Integer[][] matrix, Integer playerValue)
	{
		Boolean isVictory = true;

		for (Integer[] firstRow : matrix)
		{
			isVictory = true;

			for (int i = 0; i < firstRow.length-1; i++)
			{
				isVictory &= (Objects.equals(firstRow[i], playerValue));
			}

			if(isVictory)
			{
				break;
			}

		}
		return isVictory;
	}

	public Boolean isVictoryVertical(Integer[][] matrix, Integer playerValue)
	{
		Boolean isVictory = true;

		for (int i = 0; i < matrix.length; i++)
		{
			isVictory = true;

			for (int j = 0; j < matrix.length; j++)
			{
				isVictory &= (Objects.equals(matrix[j][i], playerValue));
			}

			if(isVictory)
			{
				break;
			}

		}
		return isVictory;
	}
}
