package MarsLander;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andreas on 19.08.2015.
 */
public class Player_MarsLanderTest {

    private Player_MarsLander player_marsLander;

    @org.junit.Before
    public void setUp() throws Exception {
        player_marsLander = new Player_MarsLander();
    }

    @Test
    public void testOptimalAngle() throws Exception {

        int vSpeed = 20;
        int rotate = 50;
        int power = 2;

        int optAngle = Player_MarsLander.optimalAngle(vSpeed, rotate, power);

        assertEquals(35, optAngle);
    }

    @Test
    public void optPower() throws Exception {
        int vSpeed = 20;
        int power = 2;

        int optAngle = Player_MarsLander.optPower(vSpeed, power);

        assertEquals(0, optAngle);

        vSpeed = -50;
        power = 2;

        optAngle = Player_MarsLander.optPower(vSpeed, power);

        assertEquals(3, optAngle);
    }
}