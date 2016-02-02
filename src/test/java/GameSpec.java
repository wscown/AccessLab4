/**
 * Created by wscown on 2/1/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class GameSpec {

    @Test
    public void testgetCardValue() {

        //With
        Card test1 = new Card(Suit.CLUBS, Value.ACE);
        int testnumb1 = 0;
        Card test2 = new Card(Suit.DIAMONDS, Value.ACE);
        int testnumb2 = 0;
        Card test3 = new Card(Suit.CLUBS, Value.TWO);
        int testnumb3 = 0;
        Card test4 = new Card(Suit.DIAMONDS, Value.TWO);
        int testnumb4 = 0;
        Card test5 = new Card(Suit.CLUBS, Value.THREE);
        int testnumb5 = 3;
        Card test6 = new Card(Suit.DIAMONDS, Value.THREE);
        int testnumb6 = 3;
        Card test7 = new Card(Suit.CLUBS, Value.JACK);
        int testnumb7 = 10;
        Card test8 = new Card(Suit.DIAMONDS, Value.JACK);
        int testnumb8 = 15;
        Card test9 = new Card(Suit.CLUBS, Value.QUEEN);
        int testnumb9 = 14;
        Card test10 = new Card(Suit.DIAMONDS, Value.QUEEN);
        int testnumb10 = 18;
        Card test11 = new Card(Suit.CLUBS, Value.KING);
        int testnumb11 = 20;
        Card test12 = new Card(Suit.DIAMONDS, Value.KING);
        int testnumb12 = 22;

        //Then
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb1, testnumb1, Game.getCardValue(test1));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb2, testnumb2, Game.getCardValue(test2));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb3, testnumb3, Game.getCardValue(test3));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb4, testnumb4, Game.getCardValue(test4));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb5, testnumb5, Game.getCardValue(test5));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb6, testnumb6, Game.getCardValue(test6));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb7, testnumb7, Game.getCardValue(test7));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb8, testnumb8, Game.getCardValue(test8));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb9, testnumb9, Game.getCardValue(test9));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb10, testnumb10, Game.getCardValue(test10));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb11, testnumb11, Game.getCardValue(test11));
        assertEquals("Entered the ace of clubs. Value returned should be " + testnumb12, testnumb12, Game.getCardValue(test12));
    }

    @Test
    public void testConstructor(){
        Game game = new Game();


    }

}
