package SkyNetVirus;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SkyNetVirusTest
{

	private SkyNetVirus classUnderTest;

	@org.junit.Before
	public void setUp() throws Exception
	{
		classUnderTest = new SkyNetVirus();
	}

	@Test
	public void linearNetwork() throws Exception
	{
		Map<Integer, LinkedHashSet<Integer>> network = new HashMap<>();

		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		set.add(0);
		set.add(2);
		network.put(1, set);

		LinkedHashSet<Integer> gatewaySet = new LinkedHashSet<>();

		gatewaySet.add(2);

		int enemyPosition = 1;

		String link = SkyNetVirus.calcNextLink(network, gatewaySet, enemyPosition);

		Assert.assertEquals("", "1 2", link);
	}

	@Test
	public void loopNetwork() throws Exception
	{
		Map<Integer, LinkedHashSet<Integer>> network = new HashMap<>();

		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		set.add(1);
		set.add(2);
		network.put(0, set);

		set = new LinkedHashSet<>();
		set.add(3);
		network.put(1, set);

		set = new LinkedHashSet<>();
		set.add(3);
		network.put(2, set);

		LinkedHashSet<Integer> gatewaySet = new LinkedHashSet<>();

		gatewaySet.add(3);

		int enemyPosition = 0;

		String link = SkyNetVirus.calcNextLink(network, gatewaySet, enemyPosition);

		Assert.
				assertEquals("", "3 2", link);
	}

	@Test
	public void loopNetwork2() throws Exception
	{
		Map<Integer, LinkedHashSet<Integer>> network = new HashMap<>();

		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		network.put(0, set);

		set = new LinkedHashSet<>();
		set.add(2);
		set.add(0);
		set.add(5);
		network.put(1, set);

		set = new LinkedHashSet<>();
		set.add(3);
		set.add(0);
		network.put(2, set);

		set = new LinkedHashSet<>();
		set.add(4);
		set.add(0);
		network.put(3, set);

		set = new LinkedHashSet<>();
		set.add(1);
		set.add(0);
		network.put(4, set);

		set = new LinkedHashSet<>();
		set.add(1);
		network.put(5, set);

		LinkedHashSet<Integer> gatewaySet = new LinkedHashSet<>();

		gatewaySet.add(0);

		int enemyPosition = 5;

		String link = SkyNetVirus.calcNextLink(network, gatewaySet, enemyPosition);

		Assert.assertEquals("", "1 0", link);
	}

    @Test
    public void loopNetworkStar() throws Exception
    {
        Map<Integer, LinkedHashSet<Integer>> network = new HashMap<>();

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        network.put(0, set);

        set = new LinkedHashSet<>();
        set.add(2);
        set.add(0);
        network.put(1, set);

        set = new LinkedHashSet<>();
        set.add(3);
	    set.add(0);
        network.put(2, set);

        set = new LinkedHashSet<>();
        set.add(4);
	    set.add(0);
	    network.put(3, set);

        set = new LinkedHashSet<>();
        set.add(5);
	    set.add(0);
	    network.put(4, set);

        set = new LinkedHashSet<>();
        set.add(6);
	    set.add(0);
	    network.put(5, set);

        set = new LinkedHashSet<>();
        set.add(7);
	    set.add(0);
	    network.put(6, set);

        set = new LinkedHashSet<>();
        set.add(8);
	    set.add(0);
	    network.put(7, set);

        set = new LinkedHashSet<>();
        set.add(9);
	    set.add(0);
	    network.put(8, set);

        set = new LinkedHashSet<>();
        set.add(10);
	    set.add(0);
	    network.put(9, set);

        set = new LinkedHashSet<>();
        set.add(1);
	    set.add(0);
	    network.put(10, set);

        set = new LinkedHashSet<>();
        set.add(6);
        set.add(5);
        set.add(7);
        network.put(11, set);

        LinkedHashSet<Integer> gatewaySet = new LinkedHashSet<>();

        gatewaySet.add(0);

        int enemyPosition = 11;

        String link = classUnderTest.calcNextLink(network, gatewaySet, enemyPosition);

        Assert.assertEquals("", "3 2", link);
    }

}