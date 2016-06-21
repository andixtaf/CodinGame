package XXO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class XXOTest
{
	private XXO classUnderTest;

	@Before
	public void setUp() throws Exception
	{
		classUnderTest = new XXO();
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
	public void testIsVictoryWhenAllFieldsTrue() throws Exception
	{
		Integer[][] matrix = {
				{0,0,0},
				{0,0,0},
				{0,0,0}
		};

		Integer playerValue = 1;

		Boolean isVictory = classUnderTest.isVictory(matrix, playerValue);

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

		Integer playerValue = 1;

		Boolean isVictory = classUnderTest.isVictory(matrix, playerValue);

		Assert.assertThat(isVictory, is(true));
	}

}