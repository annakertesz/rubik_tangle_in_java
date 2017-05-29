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

    public void repace(Card cardToRemove, Card cardToAdd){

        if (cardToRemove!=null) inHand.remove(cardToRemove);
        if (cardToAdd!=null) {
            cardToAdd.setPosition(0);
            inHand.add(cardToAdd);
        }
    }

    public void remove(Card card){
        inHand.remove(card);
    }

    public void add(Card card){
        card.setPosition(0);
        inHand.add(card);
    }

    public int size(){
        return inHand.size();
    }

    public Card get(){
        return inHand.get(0);
    }

}
