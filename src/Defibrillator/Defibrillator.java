package Defibrillator;

import java.util.Map;

/**
 * Created by Andreas on 15.11.2015 for CodinGame.
 */
public class Defibrillator
{

	protected static Double calcY(Point a, Point b)
	{
		Double result = b.getLat() - a.getLat();

		return result;
	}

	protected static Double calcX(Point a, Point b)
	{
		Double result = b.getLon() - a.getLon();

		result *= Math.cos(a.getLat()+b.getLat()/2);

		return result;
	}

	protected static Double calcDistance(Point a, Point b)
	{
//		Double earthRadius = 6371D; // metres
//		Double phi1 = Math.toRadians(a.getLat());
//		Double phi2 = Math.toRadians(b.getLat());
//		Double deltaPhi = Math.toRadians((b.getLat()-a.getLat()));
//		Double deltaLambda = Math.toRadians((b.getLon()-a.getLon()));
//
//		Double aCalc = Math.sin(deltaPhi/2) * Math.sin(deltaPhi/2) +
//				Math.cos(phi1) * Math.cos(phi2) *
//						Math.sin(deltaLambda/2) * Math.sin(deltaLambda/2);
//
//		Double c = 2 * Math.atan2(Math.sqrt(aCalc), Math.sqrt(1-aCalc));
//
//		Double distance = earthRadius * c;

		Double x = calcX(a, b);
		Double y = calcY(a, b);

		Double distance = Math.hypot(x,y) * 6371;

		return distance;
	}

	protected static Integer calcDistances(Map<Integer, String> map, Point ownPosition)
	{
		Integer smallestDistanceIndex = 0;
		Double smallestDistance = Double.MAX_VALUE;
		Point destinationPosition;
		Double x,y, distance;

		for(String s : map.values())
		{
			String[] splitedValues = s.split(";");

			x = createDoubleFromText(splitedValues[4]);
			y = createDoubleFromText(splitedValues[5]);

			destinationPosition = new Point(x,y);

			distance = calcDistance(ownPosition, destinationPosition);

			if(smallestDistance > distance)
			{
				smallestDistance = distance;
				smallestDistanceIndex = Integer.parseInt(splitedValues[0]);

			}

			System.err.println("smallest Dist: " + distance + " @ " + splitedValues[0]);
		}

		return smallestDistanceIndex;
	}

	protected static double createDoubleFromText(String numberText)
	{
		return Double.parseDouble(numberText.replace(",", "."));
	}
}

class Point {
	Double lon;
	Double lat;

	public Point(Double lon, Double lat)
	{
		this.lon = Math.toRadians(lon);
		this.lat = Math.toRadians(lat);
	}

	public Double getLonAsRadian()
	{
		return Math.toRadians(lon);
	}

	public Double getLatAsRadian()
	{
		return Math.toRadians(lat);
	}

	public Double getLon()
	{
		return lon;
	}

	public Double getLat()
	{
		return lat;
	}
}


