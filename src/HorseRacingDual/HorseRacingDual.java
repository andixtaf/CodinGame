package HorseRacingDual;

import java.util.List;

public class HorseRacingDual
{

    public Integer calcSmallestStrengthDistance(List<Integer> list)
    {
        Integer smallestDistance = 1_000_000;

        for(int i = 1; i < list.size(); i++)
        {
            Integer distance = list.get(i) - list.get(i-1);

            if(distance < smallestDistance)
            {
                smallestDistance = distance;
            }
        }

        return smallestDistance;
    }

}


