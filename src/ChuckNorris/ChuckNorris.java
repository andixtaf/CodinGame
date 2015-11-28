package ChuckNorris;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas on 04.11.2015 for CodinGame.
 */
public class ChuckNorris
{

	public String changeAsciiToBinary(String ascii)
	{
		StringBuilder binaryResult = new StringBuilder();

		for(byte currentChar : ascii.getBytes())
		{
			StringBuilder binary = new StringBuilder();
			for(int i = 0; i < 8; i++)
			{
				binary.append((currentChar & 128) == 0 ? 0 : 1);
				currentChar <<= 1;
			}
			binaryResult.append(binary.toString().replaceFirst("0", ""));
		}
		return binaryResult.toString();
	}

	public List<Integer> determineCountOfZeros(String s)
	{
		Integer countOfChar = 0;

		Character startChar = s.charAt(0);

		List<Integer> charList = new ArrayList<>();

		if(startChar == '1')
		{
			charList.add(1);
		} else {
			charList.add(0);
		}


		for(Character c : s.toCharArray())
		{
			if(startChar == c)
			{
				countOfChar++;
			} else
			{
				charList.add(countOfChar);
				countOfChar = 1;

				startChar = setNewChar(startChar);
			}
		}
		charList.add(countOfChar);

		return charList;
	}

	public String buildCodedString(List<Integer> listChar)
	{

		String codedString = "";

		String value = listChar.get(0) == 1 ? "0" : "00";

		listChar.remove(0);

		for(Integer i : listChar)
		{
			codedString += value + " ";

			for(int j = 0; j < i; j++)
			{
				codedString += "0";
			}
			codedString += " ";

			value += "0";

			if(value.length() > 2)
			{
				value = "0";
			}
		}

		return codedString.trim();
	}

	@NotNull
	private Character setNewChar(Character startChar)
	{
		if(startChar == '1')
		{
			startChar = '0';
		} else
		{
			startChar = '1';
		}
		return startChar;
	}
}
