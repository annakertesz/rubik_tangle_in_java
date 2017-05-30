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


    public BoardField(BoardField topDependency, BoardField leftDependency) {
        this.topDependency = topDependency;
        this.leftDependency = leftDependency;
        formerNeighbours = new ArrayList<Card>();
    }


    public void removeCard(Hand hand){
        if (!isEmpty()) {
            hand.add(card);
        }
    }


    public boolean placeCard(Card cardToInsert, Hand hand){

        int neededPosition = 4;
        if (topDependency != null) {
            int positionToTop = cardToInsert.isEdgesJoinable(topDependency.card.getEdge(2), 0);
            if (positionToTop == -1) return false;
            neededPosition = positionToTop;
        }
        if (leftDependency != null) {
            int positionToLeft = cardToInsert.isEdgesJoinable(leftDependency.card.getEdge(1), 3);
            if (neededPosition == 4 || neededPosition == positionToLeft) neededPosition = positionToLeft;
            else return false;
        }
        if (neededPosition < 0) return false;
        if (neededPosition==4) neededPosition=0;
        cardToInsert.setPosition(neededPosition);
        this.card = cardToInsert;
        clearHistory();
        hand.remove(cardToInsert);
        return true;

//        int[] neededPosition = new int[2];
//        for (int i = 0; i<2; i++) {
//            if (dependencies[i] == null) neededPosition[i]= 4;
//            else neededPosition[i] = cardToInsert.isEdgesJoinable(dependencies[i].card.getEdge(2-i), 3*i);
//        }
//        int rightPosition = calculateRightPosition(neededPosition);
//        if (rightPosition < 0) {
//
//            return false;
//        }
//        cardToInsert.setPosition(rightPosition);
//        this.card = cardToInsert;
//        clearHistory();
//        hand.remove(cardToInsert);
//        return true;
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
