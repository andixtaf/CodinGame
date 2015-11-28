package ChuckNorris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChuckNorrisTest
{

	public static final Boolean ONE = Boolean.TRUE;
	private ChuckNorris classUnderTest;

	@Before
	public void setUp() throws Exception
	{
		classUnderTest = new ChuckNorris();
	}

	@Test
	public void changeAsciiToBinaryEasy() throws Exception
	{
		String toTest = "C";

		String binary = classUnderTest.changeAsciiToBinary(toTest);

		Assert.assertEquals("Ascii to Binary<.", "1000011", binary);
	}

//	@Test
//	public void changeAsciiToBinaryHard() throws Exception
//	{
//		String toTest = "%";
//
//		String binary = classUnderTest.changeAsciiToBinary(toTest);
//
//		Assert.assertEquals("Ascii to Binary<.", "00", binary);
//	}

	@Test
	public void changeAsciiToBinary() throws Exception
	{
		String toTest = "CC";

		String binary = classUnderTest.changeAsciiToBinary(toTest);

		Assert.assertEquals("Ascii to Binary<.", "10000111000011", binary);
	}

	@Test
	public void GetPositionOfChar() throws Exception
	{
		Boolean actualValue = ONE;

		String toTest = "1000011";

		List<Integer> listChar = classUnderTest.determineCountOfZeros(toTest);

		Assert.assertEquals("count of zeros", 4, listChar.size());

		Assert.assertEquals(1, listChar.get(0).intValue());
		Assert.assertEquals(1, listChar.get(1).intValue());
		Assert.assertEquals(4, listChar.get(2).intValue());
		Assert.assertEquals(2, listChar.get(3).intValue());

	}

	@Test
	public void chaneCodingString() throws Exception
	{
		List<Integer> listChar = new ArrayList<>();
		listChar.add(1);
		listChar.add(4);
		listChar.add(2);


		String codedString = classUnderTest.buildCodedString(listChar);

		Assert.assertEquals("coded String: ", "0 0 00 0000 0 00", codedString);
	}

	@Test
	public void complexTest() throws Exception
	{

		String toTest = "%";

		String binary = classUnderTest.changeAsciiToBinary(toTest);

		List<Integer> listChar = classUnderTest.determineCountOfZeros(binary);

		String codedString = classUnderTest.buildCodedString(listChar);

		System.out.println(codedString);

	}

}
