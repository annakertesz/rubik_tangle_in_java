package com.company;

import java.util.ArrayList;

/**
 * Created by annakertesz on 5/26/17.
 */
public class Board {

    private BoardField[] fields;
    private ArrayList<Card> formerCards;


    public Board(BoardField[] fields) {
        this.fields = fields;
        formerCards = new ArrayList<Card>();
    }


    public BoardField getField(int index){
        return fields[index];
    }


    public boolean wasOnFirstPlace(Card card) {
        return formerCards.contains(card);
    }


    public boolean triedAllPossibilities(){
        return formerCards.size()==18;
    }


    public void addToHistory(Card card) {formerCards.add(card);}


    public void placeFirstCard(Hand hand){
        fields[0].placeCard(hand.get(), hand);
    }


    @Override
    public String toString() {
        return "\n| " + fields[0].getCard().actualEdges[0][0] + " " +   fields[0].getCard().actualEdges[0][1] + " || " + fields[1].getCard().actualEdges[0][0] + " " +   fields[1].getCard().actualEdges[0][1] + " || " + fields[2].getCard().actualEdges[0][0] + " " +   fields[2].getCard().actualEdges[0][1] + " |\n"
                + "|" + fields[0].getCard().actualEdges[3][1] + "   " + fields[0].getCard().actualEdges[1][0] + "||" +   fields[1].getCard().actualEdges[3][1] + "   " + fields[1].getCard().actualEdges[1][0] + "||" +   fields[2].getCard().actualEdges[3][1] + "   " + fields[2].getCard().actualEdges[1][0] + "|\n"
                + "|" + fields[0].getCard().actualEdges[3][0] + "   " + fields[0].getCard().actualEdges[1][1] + "||" +   fields[1].getCard().actualEdges[3][0] + "   " + fields[1].getCard().actualEdges[1][1] + "||" +   fields[2].getCard().actualEdges[3][0] + "   " + fields[2].getCard().actualEdges[1][1] + "|\n"
                +"|_" + fields[0].getCard().actualEdges[2][1] + "_" +   fields[0].getCard().actualEdges[2][0] + "_||_" + fields[1].getCard().actualEdges[2][1] + "_" +   fields[1].getCard().actualEdges[2][0] + "_||_" + fields[2].getCard().actualEdges[2][1] + "_" +   fields[2].getCard().actualEdges[2][0] + "_|\n"

                +"| " + fields[3].getCard().actualEdges[0][0] + " " +   fields[3].getCard().actualEdges[0][1] + " || " + fields[4].getCard().actualEdges[0][0] + " " +   fields[4].getCard().actualEdges[0][1] + " || " + fields[5].getCard().actualEdges[0][0] + " " +   fields[5].getCard().actualEdges[0][1] + " |\n"
                + "|" + fields[3].getCard().actualEdges[3][1] + "   " + fields[3].getCard().actualEdges[1][0] + "||" +   fields[4].getCard().actualEdges[3][1] + "   " + fields[4].getCard().actualEdges[1][0] + "||" +   fields[5].getCard().actualEdges[3][1] + "   " + fields[5].getCard().actualEdges[1][0] + "|\n"
                + "|" + fields[3].getCard().actualEdges[3][0] + "   " + fields[3].getCard().actualEdges[1][1] + "||" +   fields[4].getCard().actualEdges[3][0] + "   " + fields[4].getCard().actualEdges[1][1] + "||" +   fields[5].getCard().actualEdges[3][0] + "   " + fields[5].getCard().actualEdges[1][1] + "|\n"
                +"|_" + fields[3].getCard().actualEdges[2][1] + "_" +   fields[3].getCard().actualEdges[2][0] + "_||_" + fields[4].getCard().actualEdges[2][1] + "_" +   fields[4].getCard().actualEdges[2][0] + "_||_" + fields[5].getCard().actualEdges[2][1] + "_" +   fields[5].getCard().actualEdges[2][0] + "_|\n"

                +"| " + fields[6].getCard().actualEdges[0][0] + " " +   fields[6].getCard().actualEdges[0][1] + " || " + fields[7].getCard().actualEdges[0][0] + " " +   fields[7].getCard().actualEdges[0][1] + " || " + fields[8].getCard().actualEdges[0][0] + " " +   fields[8].getCard().actualEdges[0][1] + " |\n"
                + "|" + fields[6].getCard().actualEdges[3][1] + "   " + fields[6].getCard().actualEdges[1][0] + "||" +   fields[7].getCard().actualEdges[3][1] + "   " + fields[7].getCard().actualEdges[1][0] + "||" +   fields[8].getCard().actualEdges[3][1] + "   " + fields[8].getCard().actualEdges[1][0] + "|\n"
                + "|" + fields[6].getCard().actualEdges[3][0] + "   " + fields[6].getCard().actualEdges[1][1] + "||" +   fields[7].getCard().actualEdges[3][0] + "   " + fields[7].getCard().actualEdges[1][1] + "||" +   fields[8].getCard().actualEdges[3][0] + "   " + fields[8].getCard().actualEdges[1][1] + "|\n"
                +"|_" + fields[6].getCard().actualEdges[2][1] + "_" +   fields[6].getCard().actualEdges[2][0] + "_||_" + fields[7].getCard().actualEdges[2][1] + "_" +   fields[7].getCard().actualEdges[2][0] + "_||_" + fields[8].getCard().actualEdges[2][1] + "_" +   fields[8].getCard().actualEdges[2][0] + "_|\n";

    }
}
