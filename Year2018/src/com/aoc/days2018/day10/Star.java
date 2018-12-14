package com.aoc.days2018.day10;

/**
 * @author maczaka.
 */
public class Star {
    private int initialX;
    private int initialY;

    private int x;
    private int y;
    private int vX;
    private int vY;

    public Star(final int x, final int y, final int vX, final int vY) {
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
        this.vX = vX;
        this.vY = vY;
    }

    public void step(final int seconds) {
        x += vX * seconds;
        y += vY * seconds;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getvX() {
        return vX;
    }

    public int getvY() {
        return vY;
    }

    public void addToX(final Integer smallestX) {
        this.x += smallestX;
    }

    public void addToY(final Integer smallestY) {
        this.y += smallestY;
    }

    public void reset() {
        this.x = initialX;
        this.y = initialY;
    }
}
