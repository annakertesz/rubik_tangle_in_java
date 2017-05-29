package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class BoardField {

    Card card;
    BoardField topDependency;
    BoardField leftDependency;
    ArrayList<Card> wasNeighbour;

    public BoardField(BoardField[] dependencies) {
        this.topDependency = dependencies[0];
        this.leftDependency = dependencies[1];
        wasNeighbour = new ArrayList<Card>();
    }

    public boolean placeCard(Card cardToInsert, Hand hand){
//        System.out.println("    card to insert:\n");
//        System.out.println(cardToInsert);
        int neededPosition = 4;
        if (topDependency != null) {
            int positionToTop = cardToInsert.isSidesJoinable(topDependency.card.getSide(2), 0);
            if (positionToTop == -1) return false;
            neededPosition = positionToTop;
        }
        if (leftDependency != null) {
            int positionToLeft = cardToInsert.isSidesJoinable(leftDependency.card.getSide(1), 3);
            if (neededPosition == 4 || neededPosition == positionToLeft) neededPosition = positionToLeft;
            else return false;
        }
        if (neededPosition < 0) return false;
        if (neededPosition==4) neededPosition=0;
        cardToInsert.setPosition(neededPosition);
        this.card = cardToInsert;
        hand.remove(cardToInsert);
        return true;
    }


}
