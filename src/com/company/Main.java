package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Card first = new Card(Color.R, Color.G, Color.Y, Color.R, Color.G, Color.B, Color.Y, Color.B);
        Card second = new Card(Color.B, Color.Y, Color.G, Color.B, Color.Y, Color.R, Color.G, Color.R);
        Card third = new Card(Color.R, Color.G, Color.B, Color.R, Color.G, Color.Y, Color.B, Color.Y);
        Card forth = new Card(Color.G, Color.R, Color.Y, Color.G, Color.R, Color.B, Color.Y, Color.B);
        Card fifth = new Card(Color.G, Color.Y, Color.R, Color.G, Color.Y, Color.B, Color.R, Color.B);
        Card sixth = new Card(Color.B, Color.Y, Color.R, Color.B, Color.Y, Color.G, Color.R, Color.G);
        Card seventh = new Card(Color.G, Color.B, Color.Y, Color.G, Color.B, Color.R, Color.Y, Color.R);
        Card eighth = new Card(Color.Y, Color.B, Color.G, Color.Y, Color.B, Color.R, Color.G, Color.R);
        Card nineth = new Card(Color.B, Color.G, Color.R, Color.B, Color.G, Color.Y, Color.R, Color.Y);


        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(first, second, third, forth, fifth, sixth, seventh, eighth, nineth));
        Board board = new Board(cards);
        board.makePuzzle();

    }
}
