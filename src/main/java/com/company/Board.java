package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class Board {

    BoardField[] fields;
    Hand hand;
    ArrayList<Card> wasInFirstPlace;
    static int actualIndex = 0;


    public Board(ArrayList<Card> cardsInHand) {
        hand = new Hand(cardsInHand);
        this.fields = new BoardField[9];
        fields[0] = new BoardField(new BoardField[]{null,null});
        fields[1] = new BoardField(new BoardField[]{null,fields[0]});
        fields[2] = new BoardField(new BoardField[]{null,fields[1]});
        fields[3] = new BoardField(new BoardField[]{fields[0],null});
        fields[4] = new BoardField(new BoardField[]{fields[1],fields[3]});
        fields[5] = new BoardField(new BoardField[]{fields[2],fields[4]});
        fields[6] = new BoardField(new BoardField[]{fields[3],null});
        fields[7] = new BoardField(new BoardField[]{fields[4],fields[6]});
        fields[8] = new BoardField(new BoardField[]{fields[5],fields[7]});
        wasInFirstPlace = new ArrayList<Card>();
    }


    public void play(){
        if (makePuzzle()) System.out.println(this);
        else System.out.println("failed");
    }


    private boolean makePuzzle(){
        if (!placeCard(actualIndex)) {
            while (wasInFirstPlace.size() < 9) {
                if (placeCard(actualIndex - 1)) return true;
            }
            return false;
        }
        return true;
    }


    private boolean placeCard(int indexOfField){
        actualIndex = indexOfField;
        System.out.println(indexOfField + " " + hand.size());
        if (indexOfField==9) return true;
        if (indexOfField==0) {
            if (fields[0].isEmpty()) {
                System.out.println("field is empty");
                fields[0].placeCard(hand.get());
                hand.remove(fields[0].getCard());
                wasInFirstPlace.add(fields[0].getCard());
            }
            else if (!placeFirstCard()) return false;

            return placeCard(1);
        }


        else{
            Card currentCard = fields[indexOfField].getCard();
            if (currentCard != null) hand.add(currentCard);
            Card correctCard = null;
            for (Card card : hand.inHand){
                if (fields[indexOfField-1].wasNeighbour(card)) continue;
                if (fields[indexOfField].placeCard(card)){
                    fields[indexOfField-1].addNeighbour(card);
                    fields[indexOfField].clearHistory();
//                    correctCard = card;
                }
            }
            hand.remove(fields[indexOfField].getCard());
            System.out.println("I removed a card from hand");
            return placeCard(indexOfField+1);
//            return false;
        }

    }

    private boolean placeFirstCard(){
        System.out.println("I'm in placeFirstCard()");
         if (fields[0].getCardPosition()==3){
             System.out.println("In position 3");
             hand.add(fields[0].getCard());
             if (wasInFirstPlace.size()>9) {
                 System.out.println("I want to return false");
                 return false;
             }
             System.out.println(hand.size() + " cards in my hand");
             for (Card card : hand.inHand){
                 if (wasInFirstPlace.contains(card)) continue;
                 fields[0].setCard(card);
                 System.out.println("I added a card to first place");
                 wasInFirstPlace.add(card);
                     break;
             }
             hand.remove(fields[0].getCard());

        }
        else {
             System.out.println("turned card");
             fields[0].turnCard();
         }
        return true;
    }

    @Override
    public String toString() {
        return "\n| " + fields[0].getCard().getActualSides()[0][0] + " " +   fields[0].getCard().getActualSides()[0][1] + " || " + fields[1].getCard().getActualSides()[0][0] + " " +   fields[1].getCard().getActualSides()[0][1] + " || " + fields[2].getCard().getActualSides()[0][0] + " " +   fields[2].getCard().getActualSides()[0][1] + " |\n"
                + "|" + fields[0].getCard().getActualSides()[3][1] + "   " + fields[0].getCard().getActualSides()[1][0] + "||" +   fields[1].getCard().getActualSides()[3][1] + "   " + fields[1].getCard().getActualSides()[1][0] + "||" +   fields[2].getCard().getActualSides()[3][1] + "   " + fields[2].getCard().getActualSides()[1][0] + "|\n"
                + "|" + fields[0].getCard().getActualSides()[3][0] + "   " + fields[0].getCard().getActualSides()[1][1] + "||" +   fields[1].getCard().getActualSides()[3][0] + "   " + fields[1].getCard().getActualSides()[1][1] + "||" +   fields[2].getCard().getActualSides()[3][0] + "   " + fields[2].getCard().getActualSides()[1][1] + "|\n"
                +"|_" + fields[0].getCard().getActualSides()[2][1] + "_" +   fields[0].getCard().getActualSides()[2][0] + "_||_" + fields[1].getCard().getActualSides()[2][1] + "_" +   fields[1].getCard().getActualSides()[2][0] + "_||_" + fields[2].getCard().getActualSides()[2][1] + "_" +   fields[2].getCard().getActualSides()[2][0] + "_|\n"

                +"| " + fields[3].getCard().getActualSides()[0][0] + " " +   fields[3].getCard().getActualSides()[0][1] + " || " + fields[4].getCard().getActualSides()[0][0] + " " +   fields[4].getCard().getActualSides()[0][1] + " || " + fields[5].getCard().getActualSides()[0][0] + " " +   fields[5].getCard().getActualSides()[0][1] + " |\n"
                + "|" + fields[3].getCard().getActualSides()[3][1] + "   " + fields[3].getCard().getActualSides()[1][0] + "||" +   fields[4].getCard().getActualSides()[3][1] + "   " + fields[4].getCard().getActualSides()[1][0] + "||" +   fields[5].getCard().getActualSides()[3][1] + "   " + fields[5].getCard().getActualSides()[1][0] + "|\n"
                + "|" + fields[3].getCard().getActualSides()[3][0] + "   " + fields[3].getCard().getActualSides()[1][1] + "||" +   fields[4].getCard().getActualSides()[3][0] + "   " + fields[4].getCard().getActualSides()[1][1] + "||" +   fields[5].getCard().getActualSides()[3][0] + "   " + fields[5].getCard().getActualSides()[1][1] + "|\n"
                +"|_" + fields[3].getCard().getActualSides()[2][1] + "_" +   fields[3].getCard().getActualSides()[2][0] + "_||_" + fields[4].getCard().getActualSides()[2][1] + "_" +   fields[4].getCard().getActualSides()[2][0] + "_||_" + fields[5].getCard().getActualSides()[2][1] + "_" +   fields[5].getCard().getActualSides()[2][0] + "_|\n"

                +"| " + fields[6].getCard().getActualSides()[0][0] + " " +   fields[6].getCard().getActualSides()[0][1] + " || " + fields[7].getCard().getActualSides()[0][0] + " " +   fields[7].getCard().getActualSides()[0][1] + " || " + fields[8].getCard().getActualSides()[0][0] + " " +   fields[8].getCard().getActualSides()[0][1] + " |\n"
                + "|" + fields[6].getCard().getActualSides()[3][1] + "   " + fields[6].getCard().getActualSides()[1][0] + "||" +   fields[7].getCard().getActualSides()[3][1] + "   " + fields[7].getCard().getActualSides()[1][0] + "||" +   fields[8].getCard().getActualSides()[3][1] + "   " + fields[8].getCard().getActualSides()[1][0] + "|\n"
                + "|" + fields[6].getCard().getActualSides()[3][0] + "   " + fields[6].getCard().getActualSides()[1][1] + "||" +   fields[7].getCard().getActualSides()[3][0] + "   " + fields[7].getCard().getActualSides()[1][1] + "||" +   fields[8].getCard().getActualSides()[3][0] + "   " + fields[8].getCard().getActualSides()[1][1] + "|\n"
                +"|_" + fields[6].getCard().getActualSides()[2][1] + "_" +   fields[6].getCard().getActualSides()[2][0] + "_||_" + fields[7].getCard().getActualSides()[2][1] + "_" +   fields[7].getCard().getActualSides()[2][0] + "_||_" + fields[8].getCard().getActualSides()[2][1] + "_" +   fields[8].getCard().getActualSides()[2][0] + "_|\n";

    }
}
