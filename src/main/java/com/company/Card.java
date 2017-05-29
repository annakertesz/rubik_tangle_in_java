package com.company;

/**
 * Created by annakertesz on 5/26/17.
 */
public class Card {

    private Color[][] actualSides;
    private Color[] colorsInZeroPosition;
    private int position;


    public Card(Color... colors) {
        this.colorsInZeroPosition = colors;
        this.actualSides = setSides(0);
        position = 0;
    }


    public Color[][] getActualSides() {
        return actualSides;
    }


    public int isSidesJoinable(Color[] sideToJoin, int neededSide){
        for (int i = 0; i<4; i++){
            if (actualSides[i][0] == sideToJoin[1] && actualSides[i][1] == sideToJoin[0]) {
                int difference = i-neededSide;
                return difference>=0 ? difference : 4+difference;
            }
        }
        return -1;
    }


    public int getPosition() {
        return position;
    }


    public void turnCard(){
        setPosition(position+1);
    }


    public void setPosition(int newPosition){
        actualSides = setSides(newPosition*2);
        position = newPosition;
    }


    public Color[] getSide(int side) {
        return  new Color[]{actualSides[side][0] , actualSides[side][1]};
    }


    private Color[][] setSides(int positionValue){
        Color[][] sides = new Color[4][2];
        int y = positionValue;
        for (int i = 0; i < 4; i++) {
            if (y>7) y=0;
            sides[i][0] = colorsInZeroPosition[y];
            y++;
            if (y>7) y=0;
            sides[i][1] = colorsInZeroPosition[y];
            y++;
        }
        return sides;
    }


    @Override
    public String toString(){
        return "    | " + actualSides[0][0] + " " + actualSides[0][1] + " |\n"
                + "    |" + actualSides[3][1] + "   " + actualSides[1][0] + "|\n"
                + "    |" + actualSides[3][0] + "   " + actualSides[1][1] + "|\n"
                +"    | " + actualSides[2][1] + " " + actualSides[2][0] + " |\n";

    }
}
