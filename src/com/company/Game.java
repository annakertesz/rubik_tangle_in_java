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
        while (hand.size()>0){
//            if (!placeCard(currentField)) {
                if (currentField>1) board.getField(currentField-1).removeCard(hand);
                if (placeCard(currentField-1)) break;
//            }
//            else System.out.println(currentField);
        }
        System.out.println(board.getField(1).getCard());
        System.out.println(board);

    }


    private boolean placeCard(int indexOfField){

        if (currentField==1) System.out.println("line 45" + board.getField(1).getCard());
        currentField = indexOfField;
//        System.out.println(indexOfField);
//        System.out.println(hand.size());
//        System.out.println(board.formerCards);
        if (currentField==9) return true;
        if (indexOfField==0) {
            System.out.println("in zero");
            if (!placeFirstCard()) return false;
            return placeCard(indexOfField + 1);
        }
        else{
//            hand.add(board.getField(indexOfField-1).getCard());
            for (Card card : hand.getHand()){
                if (board.getField(indexOfField-1).wasNeighbour(card)) continue;
                if (board.getField(indexOfField).placeCard(card, hand)){
//                    board.getField(indexOfField).clearHistory();
                    board.getField(indexOfField-1).addNeighbourhood(card);
                    if (currentField==1) System.out.println("line 61" + board.getField(1).getCard());
//                    if (currentField==2) System.out.println(board.getField(1).getCard());
                    return placeCard(indexOfField+1);
                }
            }

            return false;
        }
    }


    private boolean placeFirstCard(){
        System.out.println("I'm in placefirstcard");
        BoardField firstField = board.getField(0);
        if (firstField.isEmpty()) {
            System.out.println("It thinks it's empty");
            firstField.placeCard(hand.get(), hand);
            hand.remove(firstField.getCard());
            return true;
        }
        int position = firstField.getCardPosition();
        if (position==3){
            System.out.println("put new to first place");
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
        else {
            System.out.println("turn first");
            firstField.turnCard(position+1);
        }
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


//        Card firstA = new Card(Color.R, Color.G, Color.Y, Color.R, Color.G, Color.B, Color.Y, Color.B);
//        Card secondA = new Card(Color.B, Color.Y, Color.G, Color.B, Color.Y, Color.R, Color.G, Color.R);
//        Card thirdA = new Card(Color.R, Color.G, Color.B, Color.R, Color.G, Color.Y, Color.B, Color.Y);
//        Card forthA = new Card(Color.G, Color.R, Color.Y, Color.G, Color.R, Color.B, Color.Y, Color.B);
//        Card fifthA = new Card(Color.G, Color.Y, Color.R, Color.G, Color.Y, Color.B, Color.R, Color.B);
//        Card sixthA = new Card(Color.B, Color.Y, Color.R, Color.B, Color.Y, Color.G, Color.R, Color.G);
//        Card seventhA = new Card(Color.G, Color.B, Color.Y, Color.G, Color.B, Color.R, Color.Y, Color.R);
//        Card eighthA = new Card(Color.Y, Color.B, Color.G, Color.Y, Color.B, Color.R, Color.G, Color.R);
//        Card ninthA = new Card(Color.B, Color.G, Color.R, Color.B, Color.G, Color.Y, Color.R, Color.Y);
//
//        Card firstB = new Card(Color.R, Color.G, Color.Y, Color.R, Color.G, Color.B, Color.Y, Color.B);
//        Card secondB = new Card(Color.B, Color.Y, Color.G, Color.B, Color.Y, Color.R, Color.G, Color.R);
//        Card thirdB = new Card(Color.R, Color.G, Color.B, Color.R, Color.G, Color.Y, Color.B, Color.Y);
//        Card forthB = new Card(Color.G, Color.R, Color.Y, Color.G, Color.R, Color.B, Color.Y, Color.B);
//        Card fifthB = new Card(Color.G, Color.Y, Color.R, Color.G, Color.Y, Color.B, Color.R, Color.B);
//        Card sixthB = new Card(Color.B, Color.Y, Color.R, Color.B, Color.Y, Color.G, Color.R, Color.G);
//        Card seventhB = new Card(Color.G, Color.B, Color.Y, Color.G, Color.B, Color.R, Color.Y, Color.R);
//        Card eighthB = new Card(Color.Y, Color.B, Color.G, Color.Y, Color.B, Color.R, Color.G, Color.R);
//        Card ninthB = new Card(Color.B, Color.G, Color.R, Color.B, Color.G, Color.Y, Color.R, Color.Y);

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
        fields[0] = new BoardField(null,null);
        fields[1] = new BoardField(null,fields[0]);
        fields[2] = new BoardField(null,fields[1]);
        fields[3] = new BoardField(fields[0],null);
        fields[4] = new BoardField(fields[1],fields[3]);
        fields[5] = new BoardField(fields[2],fields[4]);
        fields[6] = new BoardField(fields[3],null);
        fields[7] = new BoardField(fields[4],fields[6]);
        fields[8] = new BoardField(fields[5],fields[7]);
        return fields;
    }
}
