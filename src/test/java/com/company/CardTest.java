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

    @Before
    public void setUp() throws Exception {
        cardA = new Card(Color.B, Color.G, Color.R, Color.G, Color.Y, Color.B, Color.R, Color.Y);
        cardB = new Card(Color.G, Color.Y, Color.R, Color.B, Color.G, Color.R, Color.B, Color.Y);

    }

    @org.junit.Test
    public void isSidesJoinable() throws Exception {
        assertEquals(cardB.isSidesJoinable(cardA.getSide(1), 3), 3);
    }



    @org.junit.Test
    public void setPositionToZero() throws Exception {
        cardA.setPosition(0);
        Color[][] expected = new Color[][] {{Color.B, Color.G}, {Color.R, Color.G}, {Color.Y, Color.B}, {Color.R, Color.Y}};
        assertArrayEquals(expected, cardA.actualSides);

    }

    @org.junit.Test
    public void setPositionToTwo() throws Exception {
        cardA.setPosition(2);
        Color[][] expected = new Color[][] {{Color.Y, Color.B}, {Color.R, Color.Y},{Color.B, Color.G}, {Color.R, Color.G}, };
        assertArrayEquals(expected, cardA.actualSides);

    }


}