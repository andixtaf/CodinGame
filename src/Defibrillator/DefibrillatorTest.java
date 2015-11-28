package Defibrillator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas on 15.11.2015 for CodinGame.
 */
public class DefibrillatorTest
{
	private Defibrillator classUnderTest;

	private Point ownPosition;

	public DefibrillatorTest()
	{
		ownPosition = new Point(3.879483D, 43.608177D);
	}

	@Before
	public void setUp() throws Exception
	{
		classUnderTest = new Defibrillator();

	}

	@Test
	public void calcDistance() throws Exception
	{
		Double x = 3.874054D;
		Double y = 43.606779D;
		ownPosition = new Point(x, y);

		Double lon = 3.87064343057042D;
		Double lat = 43.6068847626242D;

		Point a = new Point(lon, lat);

		Double resultX = classUnderTest.calcDistance(ownPosition, a);

		Assert.assertEquals("", 0.27485402503215d, resultX, 0.001d);
	}

	@Test
	public void calcDistance2() throws Exception
	{
		Double x = 3.874054D;
		Double y = 43.606779D;
		ownPosition = new Point(x, y);

		Double lon = 3.91465549573187D;
		Double lat = 43.6068978500869D;

		Point a = new Point(lon, lat);

		Double resultX = classUnderTest.calcDistance(ownPosition, a);

		Assert.assertEquals("", 0.23885270971142d, resultX, 0.001d);
	}

	@Test
	public void calcAllDistances() throws Exception
	{
		Double x = 3.874054D;
		Double y = 43.606779D;

		ownPosition = new Point(x, y);

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;04 67 02 21 60;3,87952263361082;43,6071285339217");
		map.put(2, "2;Hotel de Ville;1 place Georges Freche 34267 Montpellier;04 67 34 44 93;3,89652239197876;43,5987299452849");
		map.put(3, "3;Zoo de Lunaret;50 avenue Agropolis 34090 Mtp;04 67 54 45 23;3,87388031141133;43,6395872778854");
		map.put(4, "48;PATINOIRE VEGAPOLIS;Place de France MONTPELLIER;04 99 522 600;3,91489059571308;43,6029210639592");


		Integer smallesDistance = classUnderTest.calcDistances(map, ownPosition);

		Assert.assertEquals("", 1, smallesDistance.intValue());
	}




}