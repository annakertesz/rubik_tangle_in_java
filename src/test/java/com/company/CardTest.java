package com.company;

import org.junit.Before;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by annakertesz on 5/29/17.
 */
public class CardTest {

    Card cardA;
    Card cardB;
    Card cardC;

    @Before
    public void setUp() throws Exception {
        cardA = new Card(Color.B, Color.G, Color.R, Color.G, Color.Y, Color.B, Color.R, Color.Y);
        cardB = new Card(Color.G, Color.Y, Color.R, Color.B, Color.G, Color.R, Color.B, Color.Y);
        cardC = new Card(Color.G, Color.Y, Color.R, Color.G , Color.B, Color.Y, Color.B, Color.R);

    }

    @org.junit.Test
    public void isSidesJoinable() throws Exception {
        assertEquals(3, cardB.isSidesJoinable(cardA.getSide(1), 3));
    }

    @org.junit.Test
    public void isSidesJoinableItsNot() throws Exception {
        assertEquals(-1, cardC.isSidesJoinable(cardA.getSide(1), 3));
    }



    @org.junit.Test
    public void setPositionToZero() throws Exception {
        cardA.setPosition(0);
        Color[][] expected = new Color[][] {{Color.B, Color.G}, {Color.R, Color.G}, {Color.Y, Color.B}, {Color.R, Color.Y}};
        assertArrayEquals(expected, cardA.getActualSides());

    }

    @org.junit.Test
    public void setPositionToTwo() throws Exception {
        cardA.setPosition(2);
        Color[][] expected = new Color[][] {{Color.Y, Color.B}, {Color.R, Color.Y},{Color.B, Color.G}, {Color.R, Color.G}, };
        assertArrayEquals(expected, cardA.getActualSides());

    }


}