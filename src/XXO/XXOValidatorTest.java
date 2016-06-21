package XXO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class XXOValidatorTest
{
	private XXOValidator classUnderTest;

	@Before
	public void setUp() throws Exception
	{
		classUnderTest = new XXOValidator();
	}

	@Test
	public void testIsVictoryHorizontalWhenPlayerOneHasFirstRowReturnTrue() throws Exception
	{
		Integer[][] matrix = {
				{1,1,1},
				{0,0,0},
				{0,0,0}
		};

		Integer playerValue = 1;

		Boolean isVictory = classUnderTest.isVictoryHorizontal(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}

	@Test
	public void testIsVictoryHorizontalWhenPlayerOneHasLastRowReturnTrue() throws Exception
	{
		Integer[][] matrix = {
				{1,0,1},
				{0,0,0},
				{2,2,2}
		};

		Integer playerValue = 2;

		Boolean isVictory = classUnderTest.isVictoryHorizontal(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}

	@Test
	public void testIsVictoryVerticalWhenPlayerOneHasFirstRowReturnTrue() throws Exception
	{
		Integer[][] matrix = {
				{1,1,1},
				{1,0,0},
				{1,0,0}
		};

		Integer playerValue = 1;

		Boolean isVictory = classUnderTest.isVictoryVertical(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}

	@Test
	public void testIsVictoryVerticalWhenPlayerOneHasLastRowReturnTrue() throws Exception
	{
		Integer[][] matrix = {
				{1,0,2},
				{0,0,2},
				{2,2,2}
		};

		Integer playerValue = 2;

		Boolean isVictory = classUnderTest.isVictoryVertical(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}

	@Test
	public void testIsVictoryDiagonalWhenPlayerOneHasDiagonalOneReturnTrue() throws Exception
	{
		Integer[][] matrix = {
				{1,0,2},
				{0,1,2},
				{2,2,1}
		};

		Integer playerValue = 1;

		Boolean isVictory = classUnderTest.isVictoryDiagonal(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}

	@Test
	public void testIsVictoryDiagonalWhenPlayerOneHasDiagonalTwoReturnTrue() throws Exception
	{
		Integer[][] matrix = {
				{1,0,2},
				{0,2,2},
				{2,2,2}
		};

		Integer playerValue = 2;

		Boolean isVictory = classUnderTest.isVictoryDiagonal(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}


	@Test
	public void testIsVictoryWhenAllFieldsTrue() throws Exception
	{
		Integer[][] matrix = {
				{0,0,0},
				{0,0,0},
				{0,0,0}
		};

		Boolean isVictory = classUnderTest.checkWinForGivenPlayer(matrix, 1);

		Assert.assertThat(isVictory, is(false));
	}

	@Test
	public void testIsVictoryWhenFirstRowPlayerOne() throws Exception
	{
		Integer[][] matrix = {
				{1,1,1},
				{2,2,2},
				{0,0,0}
		};

		Boolean isVictory = classUnderTest.checkWinForGivenPlayer(matrix, 2);

		Assert.assertThat(isVictory, is(true));
	}

	@Test
	public void errorCaseReal() throws Exception
	{
		Integer[][] matrix = {
				{1,1,0},
				{2,0,0},
				{2,0,0}
		};

		Boolean isVictory = classUnderTest.checkWinForGivenPlayer(matrix, 1);

		Assert.assertThat(isVictory, is(false));
	}

	@Test
	public void errorCaseReal2() throws Exception
	{
		Integer[][] matrix = {
				{1,1,1},
				{2,2,0},
				{0,0,0}
		};

		Boolean isVictory = classUnderTest.checkWinForGivenPlayer(matrix, 1);

		Assert.assertThat(isVictory, is(true));
	}

}