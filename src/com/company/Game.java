package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by annakertesz on 5/28/17.
 */
public class Game {

    private static Game game = new Game();
    private Board board;
    private Hand hand;
    private int currentField;


    private Game() {
        this.board = new Board(getMediumBoard());
        this.hand = new Hand(getTwoSidedCards());
        this.currentField = 1;
    }


    public static void startNewGame() {
        game.makePuzzle();
    }


    public void makePuzzle(){
        board.placeFirstCard(hand);
        while (hand.size()>0){
            if (!placeCard(currentField)) {
                board.getField(currentField-1).removeCard(hand);
                placeCard(currentField-1);
            }
            else break;
        }
        System.out.println(board);
    }


    private boolean placeCard(int indexOfField){
        currentField = indexOfField;
        if (indexOfField==9) return true;
        if (indexOfField==0) return (placeFirstCard()) && placeCard(indexOfField+1);
        else{
            for (Card card : hand.getHand()){
                if (board.getField(indexOfField-1).wasNeighbour(card)) continue;
                if (board.getField(indexOfField).placeCard(card, hand)){
                    board.getField(indexOfField-1).addNeighbourhood(card);
                    return placeCard(indexOfField+1);
                }
            }
            return false;
        }
    }


    private boolean placeFirstCard(){
        BoardField firstField = board.getField(0);
        if (firstField.isEmpty()) {
            firstField.placeCard(hand.get(), hand);
            return true;
        }
        int position = firstField.getCardPosition();
        if (position==3){
            firstField.removeCard(hand);
            if (board.triedAllPossibilities()) return false;
            for (Card card : hand.getHand()){
                if (board.wasOnFirstPlace(card)) continue;
                firstField.placeCard(card, hand);
                board.addToHistory(card);
                firstField.clearHistory();
                break;
            }
        }
        else firstField.turnCard(position+1);
        return true;
    }


    private ArrayList<Card> getTwoSidedCards(){
        Card firstA = new Card(Color.B, Color.Y, Color.R, Color.G, Color.B, Color.G, Color.Y, Color.R);
        Card secondA = new Card(Color.G, Color.B, Color.R, Color.Y, Color.G, Color.Y, Color.B, Color.R);
        Card thirdA = new Card(Color.B, Color.Y, Color.G, Color.R, Color.B, Color.R, Color.Y, Color.G);
        Card forthA = new Card(Color.R, Color.Y, Color.B, Color.G, Color.R, Color.G, Color.Y, Color.B);
        Card fifthA = new Card(Color.B, Color.R, Color.G, Color.Y, Color.B, Color.Y, Color.R, Color.G);
        Card sixthA = new Card(Color.Y, Color.B, Color.G, Color.R, Color.Y, Color.R, Color.B, Color.G);
        Card seventhA = new Card(Color.Y, Color.B, Color.R, Color.G, Color.Y, Color.G, Color.B, Color.R);
        Card eighthA = new Card(Color.G, Color.R, Color.B, Color.Y, Color.G, Color.Y, Color.R, Color.B);
        Card ninthA = new Card(Color.G, Color.Y, Color.B, Color.R, Color.G, Color.R, Color.Y, Color.B);

        Card firstB = new Card(Color.G, Color.Y, Color.R, Color.B, Color.G, Color.B, Color.Y, Color.R);
        Card secondB = new Card(Color.Y, Color.G, Color.R, Color.B, Color.Y, Color.B, Color.G, Color.R);
        Card thirdB = new Card(Color.Y, Color.R, Color.G, Color.B, Color.Y, Color.B, Color.R, Color.G);
        Card forthB = new Card(Color.R, Color.G, Color.B, Color.Y, Color.R, Color.Y, Color.G, Color.B);
        Card fifthB = new Card(Color.R, Color.Y, Color.G, Color.B, Color.R, Color.B, Color.Y, Color.G);
        Card sixthB = new Card(Color.R, Color.B, Color.G, Color.Y, Color.R, Color.Y, Color.B, Color.G);
        Card seventhB = new Card(Color.B, Color.G, Color.R, Color.Y, Color.B, Color.Y, Color.G, Color.R);
        Card eighthB = new Card(Color.Y, Color.G, Color.B, Color.R, Color.Y, Color.R, Color.G, Color.B);
        Card ninthB = new Card(Color.Y, Color.R, Color.B, Color.G, Color.Y, Color.G, Color.R, Color.B);

        firstA.setOtherSide(firstB);
        secondA.setOtherSide(secondB);
        thirdA.setOtherSide(thirdB);
        forthA.setOtherSide(forthB);
        fifthA.setOtherSide(fifthB);
        sixthA.setOtherSide(sixthB);
        seventhA.setOtherSide(seventhB);
        eighthA.setOtherSide(eighthB);
        ninthA.setOtherSide(ninthB);
        return new ArrayList<Card>(Arrays.asList(
                firstA, secondA, thirdA, forthA, fifthA, sixthA, seventhA, eighthA, ninthA,
                firstB, secondB, thirdB, forthB, fifthB, sixthB, seventhB, eighthB, ninthB));
    }


    private BoardField[] getMediumBoard(){
        BoardField[] fields = new BoardField[9];
        fields[0] = new BoardField(null,null, 0);
        fields[1] = new BoardField(null,fields[0], 1);
        fields[2] = new BoardField(null,fields[1], 2);
        fields[3] = new BoardField(fields[0],null, 3);
        fields[4] = new BoardField(fields[1],fields[3], 4);
        fields[5] = new BoardField(fields[2],fields[4], 5);
        fields[6] = new BoardField(fields[3],null, 6);
        fields[7] = new BoardField(fields[4],fields[6], 7);
        fields[8] = new BoardField(fields[5],fields[7], 8);
        return fields;
    }

}
