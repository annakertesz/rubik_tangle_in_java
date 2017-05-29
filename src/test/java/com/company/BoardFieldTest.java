package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by annakertesz on 5/29/17.
 */
public class BoardFieldTest {

    BoardField fieldA;
    BoardField fieldB;
    BoardField fieldC;
    Card cardA;
    Card cardB;
    Card cardC;
    Card cardD;
    Hand hand;

    @Before
    public void setUp() throws Exception {
        fieldA = new BoardField(new BoardField[]{null,null});
        fieldB = new BoardField(new BoardField[]{null,null});
        fieldC = new BoardField(new BoardField[]{fieldA, fieldB});
        cardA = new Card(Color.G, Color.Y, Color.R, Color.B, Color.Y, Color.B, Color.R, Color.G);
        cardB = new Card(Color.B, Color.G, Color.R, Color.G, Color.Y, Color.B, Color.R, Color.Y);
        cardC = new Card(Color.G, Color.Y, Color.R, Color.B, Color.G, Color.R, Color.B, Color.Y);
        cardD = new Card(Color.G, Color.Y, Color.R, Color.B , Color.B, Color.Y, Color.G, Color.R);
        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(cardC, cardD));
        hand = new Hand(cards);
        fieldA.placeCard(cardA);
        fieldB.placeCard(cardB);
    }

    @Test
    public void placeCard() throws Exception {
        assertTrue(fieldC.placeCard(cardC));
    }

    @Test
    public void placeCardWithBadCard() throws Exception {
        assertFalse(fieldC.placeCard(cardD));
    }

}