package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Card firstA = new Card(Color.B, Color.Y, Color.R, Color.G, Color.B, Color.G, Color.Y, Color.R);
        Card secondA = new Card(Color.G, Color.B, Color.R, Color.Y, Color.G, Color.Y, Color.B, Color.R);
        Card thirdA = new Card(Color.B, Color.Y, Color.G, Color.R, Color.B, Color.R, Color.Y, Color.G);
        Card forthA = new Card(Color.R, Color.Y, Color.B, Color.G, Color.R, Color.G, Color.Y, Color.B);
        Card fifthA = new Card(Color.B, Color.R, Color.G, Color.Y, Color.B, Color.Y, Color.R, Color.G);
        Card sixthA = new Card(Color.Y, Color.B, Color.G, Color.R, Color.Y, Color.R, Color.B, Color.G);
        Card seventhA = new Card(Color.Y, Color.B, Color.R, Color.G, Color.Y, Color.G, Color.B, Color.R);
        Card eighthA = new Card(Color.G, Color.R, Color.B, Color.Y, Color.G, Color.Y, Color.R, Color.B);
        Card ninethA = new Card(Color.G, Color.Y, Color.B, Color.R, Color.G, Color.R, Color.Y, Color.B);

        Card firstB = new Card(Color.G, Color.Y, Color.R, Color.B, Color.G, Color.B, Color.Y, Color.R);
        Card secondB = new Card(Color.Y, Color.G, Color.R, Color.B, Color.Y, Color.B, Color.G, Color.R);
        Card thirdB = new Card(Color.Y, Color.R, Color.G, Color.B, Color.Y, Color.B, Color.R, Color.G);
        Card forthB = new Card(Color.R, Color.G, Color.B, Color.Y, Color.R, Color.Y, Color.G, Color.B);
        Card fifthB = new Card(Color.R, Color.Y, Color.G, Color.B, Color.R, Color.B, Color.Y, Color.G);
        Card sixthB = new Card(Color.R, Color.B, Color.G, Color.Y, Color.R, Color.Y, Color.B, Color.G);
        Card seventhB = new Card(Color.B, Color.G, Color.R, Color.Y, Color.B, Color.Y, Color.G, Color.R);
        Card eighthB = new Card(Color.Y, Color.G, Color.B, Color.R, Color.Y, Color.R, Color.G, Color.B);
        Card ninethB = new Card(Color.Y, Color.R, Color.B, Color.G, Color.Y, Color.G, Color.R, Color.B);

        firstA.pair(firstB);
        secondA.pair(secondB);
        thirdA.pair(thirdB);
        forthA.pair(forthB);
        fifthA.pair(fifthB);
        sixthA.pair(sixthB);
        seventhA.pair(seventhB);
        eighthA.pair(eighthB);
        ninethA.pair(ninethB);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(
                firstA, secondA, thirdA, forthA, fifthA, sixthA, seventhA, eighthA, ninethA,
                firstB, secondB, thirdB, forthB, fifthB, sixthB, seventhB, eighthB, ninethB));
        Board board = new Board(cards);
        board.makePuzzle();

    }
}
