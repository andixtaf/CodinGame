package SkyNetVirus;

import java.util.*;

public class SkyNetVirus
{

    public static String calcNextLink(Map<Integer, LinkedHashSet<Integer>> network, LinkedHashSet<Integer> gatewaySet, int enemyPosition)
    {
        String linkToRemove;

	    Integer startPosition;
	    Integer endPosition;

	    List<LinkedHashSet<Integer>> wayToGateList = new ArrayList<>();

	    LinkedHashSet<Integer> wayToGate = new LinkedHashSet<>();

	    for(Integer gateway : gatewaySet)
	    {
		    wayToGateList.add(findPathToGateway(network, enemyPosition, gatewaySet, 0));
	    }

	    int size = 99999;
	    LinkedHashSet<Integer> pathToGateIndex = new LinkedHashSet<>();
	    for(LinkedHashSet<Integer> pathToGate : wayToGateList)
	    {
		    if(pathToGate.size() < size)
		    {
			    size = pathToGate.size();
			    pathToGateIndex = pathToGate;
		    }
	    }

	    Object[] list = pathToGateIndex.toArray();

	    startPosition = (Integer) list[size - 2];
	    endPosition = (Integer) list[size - 1];

	    System.err.println(pathToGateIndex);

	    linkToRemove = startPosition + " " + endPosition;

        return linkToRemove;
    }

	private static LinkedHashSet<Integer> findPathToGateway(Map<Integer, LinkedHashSet<Integer>> network, Integer startPosition, LinkedHashSet<Integer> gatewaySet, Integer counter)
	{
		LinkedHashSet<Integer> wayToGate = new LinkedHashSet<>();

		System.err.println("startPosition : " + startPosition);

		if(network.containsKey(startPosition) && counter < network.size())
		{
			LinkedHashSet<Integer> values = network.get(startPosition);
			LinkedHashSet<Integer> result;

			for(Integer node : values)
			{
				if(gatewaySet.contains(node))
				{
					wayToGate.add(startPosition);
					wayToGate.add(node);
					return wayToGate;
				}
			}

			for(Integer node : values)
			{

				if(network.containsKey(node))
				{
					counter++;
					result = findPathToGateway(network, node, gatewaySet, counter);

					if(!result.isEmpty() && result.size() < 12)
					{
						wayToGate.add(startPosition);
						wayToGate.addAll(result);
						return wayToGate;
					}
				}

			}
		}

		return wayToGate;
	}
}


