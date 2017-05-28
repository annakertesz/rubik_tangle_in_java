package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class BoardField {

    private Card card;
    BoardField topDependency;
    BoardField leftDependency;
    private ArrayList<Card> formerNeighbours;
//    int debugPos;

    public BoardField(BoardField topDependency, BoardField leftDependency, int debugPos) {
//        this.debugPos = debugPos;
        this.topDependency = topDependency;
        this.leftDependency = leftDependency;
//        if (topDependency != null && topDependency.getCard() == null) {
//            int szar = 5;
//        }
//        if (leftDependency != null && leftDependency.getCard() == null) {
//            int szar = 5;
//        }
        formerNeighbours = new ArrayList<Card>();
    }


    public void removeCard(Hand hand){
        if (!isEmpty()) {
            hand.add(card);
//            System.out.println("removing card from " + debugPos);
            card = null;
        }
    }


    public boolean placeCard(Card cardToInsert, Hand hand){
//        int[] neededPosition = new int[2];
//        for (int i = 0; i<2; i++) {
//            if (dependencies[i] == null) neededPosition[i]= 4;
//            else cardToInsert.isEdgesJoinable(dependencies[i].card.getEdge(2-i), 3*i);
//        }
//        int rightPosition = calculateRightPosition(neededPosition);
//        if (rightPosition < 0) return false;
//        cardToInsert.setPosition(rightPosition);
//        this.card = cardToInsert;
//        clearHistory();
//        hand.remove(cardToInsert);
//        return true;

//        System.out.println("trying to place a card at " + debugPos);
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
        if (neededPosition < 0) return false;  //felesleges
        if (neededPosition==4) neededPosition=0; //felesleges
        cardToInsert.setPosition(neededPosition);
//        System.out.println("placing card to " + debugPos);
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
