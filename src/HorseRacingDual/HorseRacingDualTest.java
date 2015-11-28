package HorseRacingDual;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andreas on 19.08.2015.
 */
public class HorseRacingDualTest
{

    private HorseRacingDual classUnderTest;

    @org.junit.Before
    public void setUp() throws Exception
    {
        classUnderTest = new HorseRacingDual();
    }

    @Test
    public void testOptimalAngle() throws Exception
    {

        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(9);
        list.add(8);

        Collections.sort(list);

        Integer smallestDistance = classUnderTest.calcSmallestStrengthDistance(list);

        Assert.assertEquals("", 1, smallestDistance.intValue());
    }



}