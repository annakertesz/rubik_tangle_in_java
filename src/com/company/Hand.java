package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/27/17.
 */
public class Hand {

    ArrayList<Card> inHand;

    public Hand(ArrayList<Card> inHand) {
        this.inHand = inHand;
    }


    public void remove(Card card){

        inHand.remove(card);
        inHand.remove(card.pair);
    }

    public void add(Card card){
        card.setPosition(0);
        card.pair.setPosition(0);
        inHand.add(card);
        inHand.add(card.pair);
    }

    public int size(){
        return inHand.size();
    }

    public Card get(){
        return inHand.get(0);
    }

}
