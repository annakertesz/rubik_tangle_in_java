package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class BoardField {

    private Card card;
    private BoardField topDependency;
    private BoardField leftDependency;
    private ArrayList<Card> formerNeighbours;

    public BoardField(BoardField[] dependencies) {
        this.topDependency = dependencies[0];
        this.leftDependency = dependencies[1];
        formerNeighbours = new ArrayList<Card>();
    }


    public void removeCard(Hand hand){
        if (!isEmpty()) {
            hand.add(card);
        }
    }


    public Card getCard() {
        return card;
    }

    public int getCardPosition(){
        return card.getPosition();
    }


    public void turnCard(){
            card.setPosition(getCardPosition()+1);
    }


    public boolean isEmpty(){
        return card==null;
    }


    public boolean wasNeighbour(Card card){
        return formerNeighbours.contains(card);
    }


    public void addNeighbour(Card card){
        formerNeighbours.add(card);
    }


    public void clearHistory(){
        formerNeighbours = new ArrayList<Card>();
    }


    public void setCard(Card card) {        this.card = card;
    }

    public boolean placeCard(Card cardToInsert){
        int neededPosition = 4;
        if (topDependency != null) {
            int positionToTop = cardToInsert.isSidesJoinable(topDependency.card.getSide(2), 0);
            if (positionToTop == -1) {
                return false;
            }
            neededPosition = positionToTop;
        }
        if (leftDependency != null) {
            int positionToLeft = cardToInsert.isSidesJoinable(leftDependency.card.getSide(1), 3);
            if (neededPosition == 4 || neededPosition == positionToLeft) neededPosition = positionToLeft;
            else {
                return false;
            }
        }
        if (neededPosition < 0) {
            return false;
        }
        if (neededPosition==4) neededPosition=0;
        cardToInsert.setPosition(neededPosition);
        this.card = cardToInsert;
        System.out.println("card inserted");
        return true;
    }


}
