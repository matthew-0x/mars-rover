package com.marsRover;

/**
 * Created by mv on 1/12/2016.
 */
public class Plateau {

    private int xBorder=5;
    private int yBorder=5;

    public Plateau(int x, int y){
        this.xBorder=x;
        this.yBorder=y;

    }

    public int getxBorder() {
        return xBorder;
    }

    public int getyBorder() {
        return yBorder;
    }
}
