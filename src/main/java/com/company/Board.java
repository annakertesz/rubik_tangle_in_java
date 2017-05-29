package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class Board {

    BoardField[] fields;
    Hand hand;
    ArrayList<Card> wasInFirstPlace;


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

    public void makePuzzle(){
        if (placeCard(0)) System.out.println(this);
        else System.out.println("FAIL");
    }

    private boolean placeCard(int indexOfField){

        if (indexOfField==9) return true;
        if (indexOfField==0) {
            if (fields[0].card==null) {
                fields[0].card=hand.get();
                hand.remove(fields[0].card);
            }
            else if (!placeFirstCard()) return false;
            return placeCard(indexOfField+1);
        }


        else{
            for (Card card : hand.inHand){
                if (fields[indexOfField-1].wasNeighbour.contains(card)) continue;
                if (fields[indexOfField].placeCard(card, hand)){
                    fields[indexOfField-1].wasNeighbour.add(card);
                    fields[indexOfField].wasNeighbour = new ArrayList<Card>();
                    return placeCard(indexOfField+1);
                }
            }
            if (indexOfField>1) hand.add(fields[indexOfField-1].card);
            return placeCard(indexOfField-1);
        }

    }

    private boolean placeFirstCard(){
         if (fields[0].card.getPosition()==3){
             hand.add(fields[0].card);
             if (wasInFirstPlace.size()==9) return false;
             for (Card card : hand.inHand){
                 if (wasInFirstPlace.contains(card)) continue;
                 fields[0].card = card;
                 hand.remove(card);
                 wasInFirstPlace.add(card);
                 fields[0].wasNeighbour = new ArrayList<Card>();
                 break;
             }

        }
        else fields[0].card.turnCard();
        return true;
    }

    @Override
    public String toString() {
        return "\n| " + fields[0].card.getActualSides()[0][0] + " " +   fields[0].card.getActualSides()[0][1] + " || " + fields[1].card.getActualSides()[0][0] + " " +   fields[1].card.getActualSides()[0][1] + " || " + fields[2].card.getActualSides()[0][0] + " " +   fields[2].card.getActualSides()[0][1] + " |\n"
                + "|" + fields[0].card.getActualSides()[3][1] + "   " + fields[0].card.getActualSides()[1][0] + "||" +   fields[1].card.getActualSides()[3][1] + "   " + fields[1].card.getActualSides()[1][0] + "||" +   fields[2].card.getActualSides()[3][1] + "   " + fields[2].card.getActualSides()[1][0] + "|\n"
                + "|" + fields[0].card.getActualSides()[3][0] + "   " + fields[0].card.getActualSides()[1][1] + "||" +   fields[1].card.getActualSides()[3][0] + "   " + fields[1].card.getActualSides()[1][1] + "||" +   fields[2].card.getActualSides()[3][0] + "   " + fields[2].card.getActualSides()[1][1] + "|\n"
                +"|_" + fields[0].card.getActualSides()[2][1] + "_" +   fields[0].card.getActualSides()[2][0] + "_||_" + fields[1].card.getActualSides()[2][1] + "_" +   fields[1].card.getActualSides()[2][0] + "_||_" + fields[2].card.getActualSides()[2][1] + "_" +   fields[2].card.getActualSides()[2][0] + "_|\n"

                +"| " + fields[3].card.getActualSides()[0][0] + " " +   fields[3].card.getActualSides()[0][1] + " || " + fields[4].card.getActualSides()[0][0] + " " +   fields[4].card.getActualSides()[0][1] + " || " + fields[5].card.getActualSides()[0][0] + " " +   fields[5].card.getActualSides()[0][1] + " |\n"
                + "|" + fields[3].card.getActualSides()[3][1] + "   " + fields[3].card.getActualSides()[1][0] + "||" +   fields[4].card.getActualSides()[3][1] + "   " + fields[4].card.getActualSides()[1][0] + "||" +   fields[5].card.getActualSides()[3][1] + "   " + fields[5].card.getActualSides()[1][0] + "|\n"
                + "|" + fields[3].card.getActualSides()[3][0] + "   " + fields[3].card.getActualSides()[1][1] + "||" +   fields[4].card.getActualSides()[3][0] + "   " + fields[4].card.getActualSides()[1][1] + "||" +   fields[5].card.getActualSides()[3][0] + "   " + fields[5].card.getActualSides()[1][1] + "|\n"
                +"|_" + fields[3].card.getActualSides()[2][1] + "_" +   fields[3].card.getActualSides()[2][0] + "_||_" + fields[4].card.getActualSides()[2][1] + "_" +   fields[4].card.getActualSides()[2][0] + "_||_" + fields[5].card.getActualSides()[2][1] + "_" +   fields[5].card.getActualSides()[2][0] + "_|\n"

                +"| " + fields[6].card.getActualSides()[0][0] + " " +   fields[6].card.getActualSides()[0][1] + " || " + fields[7].card.getActualSides()[0][0] + " " +   fields[7].card.getActualSides()[0][1] + " || " + fields[8].card.getActualSides()[0][0] + " " +   fields[8].card.getActualSides()[0][1] + " |\n"
                + "|" + fields[6].card.getActualSides()[3][1] + "   " + fields[6].card.getActualSides()[1][0] + "||" +   fields[7].card.getActualSides()[3][1] + "   " + fields[7].card.getActualSides()[1][0] + "||" +   fields[8].card.getActualSides()[3][1] + "   " + fields[8].card.getActualSides()[1][0] + "|\n"
                + "|" + fields[6].card.getActualSides()[3][0] + "   " + fields[6].card.getActualSides()[1][1] + "||" +   fields[7].card.getActualSides()[3][0] + "   " + fields[7].card.getActualSides()[1][1] + "||" +   fields[8].card.getActualSides()[3][0] + "   " + fields[8].card.getActualSides()[1][1] + "|\n"
                +"|_" + fields[6].card.getActualSides()[2][1] + "_" +   fields[6].card.getActualSides()[2][0] + "_||_" + fields[7].card.getActualSides()[2][1] + "_" +   fields[7].card.getActualSides()[2][0] + "_||_" + fields[8].card.getActualSides()[2][1] + "_" +   fields[8].card.getActualSides()[2][0] + "_|\n";

    }
}
