package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class BoardField {

    private Card card;
    private BoardField[] dependencies;
    private ArrayList<Card> formerNeighbours;


    public BoardField(BoardField[] dependencies) {
        this.dependencies = dependencies;
        formerNeighbours = new ArrayList<Card>();
    }


    public void removeCard(Hand hand){
        if (!isEmpty()) {
            hand.add(card);
            card = null;
        }
    }


    public boolean placeCard(Card cardToInsert, Hand hand){
        int[] neededPosition = new int[2];
        for (int i = 0; i<2; i++) {
            if (dependencies[i] == null) neededPosition[i]= 4;
            else cardToInsert.isEdgesJoinable(dependencies[i].card.getEdge(2-i), 3*i);
        }
        int rightPosition = calculateRightPosition(neededPosition);
        if (rightPosition < 0) return false;
        cardToInsert.setPosition(rightPosition);
        this.card = cardToInsert;
        clearHistory();
        hand.remove(cardToInsert);
        return true;
    }


    public boolean isEmpty() {return card==null;}


    public int getCardPosition() {
        return card.getActualPosition();
    }


    public void turnCard(int position){
        card.setPosition(position);
    }


    public boolean wasNeighbour(Card card){
        return formerNeighbours.contains(card);
    }


    public void addNeighbourhood(Card card) {
        formerNeighbours.add(card);
    }


    public void clearHistory(){
        formerNeighbours = new ArrayList<Card>();
    }


    public Card getCard() {
        return card;
    }


    private int calculateRightPosition(int[] positionList){
        int rightPosition;
        if (positionList[0] == 4) rightPosition = positionList[1];
        else if (positionList[1] == 4) rightPosition = positionList[0];
        else rightPosition = positionList[0] == positionList[1] ? positionList[0] : -1;
        return rightPosition == 4 ? 0 : rightPosition;
    }



}
