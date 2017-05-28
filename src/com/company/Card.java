package com.company;

/**
 * Created by annakertesz on 5/26/17.
 */
public class Card {

    public Color[][] actualEdges;
    private Color[] colorsInZeroPosition;
    private Card otherSide;
    private int actualPosition;


    public Card(Color... colors) {
        this.colorsInZeroPosition = colors;
        this.actualEdges = setEdges(0);
        actualPosition = 0;
    }


    public Card getOtherSide() {
        return otherSide;
    }


    public int getActualPosition() {
        return actualPosition;
    }


    public Color[] getEdge(int edge) {
        return  new Color[]{actualEdges[edge][0] , actualEdges[edge][1]};
    }


    public void setOtherSide(Card card){
        otherSide = card;
        card.otherSide = this;
    }


    public void setPosition(int newPosition){
        actualEdges = setEdges(newPosition*2);
        actualPosition = newPosition;
    }


    private Color[][] setEdges(int positionValue){
        Color[][] edges = new Color[4][2];
        int y = positionValue;
        for (int i = 0; i < 4; i++) {
            if (y>7) y=0;
            edges[i][0] = colorsInZeroPosition[y];
            y++;
            if (y>7) y=0;
            edges[i][1] = colorsInZeroPosition[y];
            y++;
        }
        return edges;
    }


    public int isEdgesJoinable(Color[] edgeToJoin, int neededEdge){
        for (int i = 0; i<4; i++){
            if (actualEdges[i][0] == edgeToJoin[1] && actualEdges[i][1] == edgeToJoin[0]) {
                int difference = i-neededEdge;
                return difference>=0 ? difference : 4+difference;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return "    | " + actualEdges[0][0] + " " + actualEdges[0][1] + " |\n"
                + "    |" + actualEdges[3][1] + "   " + actualEdges[1][0] + "|\n"
                + "    |" + actualEdges[3][0] + "   " + actualEdges[1][1] + "|\n"
                +"    | " + actualEdges[2][1] + " " + actualEdges[2][0] + " |\n";

    }
}
