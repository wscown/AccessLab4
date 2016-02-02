/**
 * Created by wscown on 2/1/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PlayerSpec {

    @Test
    public void testConstructor(){

        //With
        Player player = new Player("Test Name");

        //Then
        assertEquals("Player object constructor initialised. Game score should be 0.", 0 , player.getGameScore());
        assertEquals("Player object constructor initialised. Round score should be 0.", 0 , player.getRoundScore());
        assertTrue("Player object constructor initialised. Player name score should be 'Test Name'.", player.getName().equals("Test Name"));
    }

    @Test
    public void testgetsetName(){
        //With
        Player player = new Player("Will");

        //When
        player.setName("John");

        //Then
        assertEquals("Players name was set to John but this was not returned by the getter function", "John", player.getName());
    }

    @Test
    public void testgetsetRoundScore(){
        //With
        Player player = new Player("Will");

        //When
        player.setGameScore(99);

        //Then
        assertEquals("Game score was set to 99 but this was not returned by the getter function", 99, player.getGameScore());
    }

    @Test
    public void testgetsetGameScore(){
        //With
        Player player = new Player("Will");

        //When
        player.setRoundScore(99);

        //Then
        assertEquals("Round score was set to 99 but this was not returned by the getter function", 99, player.getRoundScore());
    }
}
