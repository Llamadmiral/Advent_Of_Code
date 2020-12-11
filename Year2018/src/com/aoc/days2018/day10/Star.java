package com.aoc.days2018.day10;

/**
 * @author maczaka.
 */
class Star {
    private int initialX;
    private int initialY;

    private int x;
    private int y;
    private int vX;
    private int vY;

    Star(final int x, final int y, final int vX, final int vY) {
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
        this.vX = vX;
        this.vY = vY;
    }

    void step(final int seconds) {
        x += vX * seconds;
        y += vY * seconds;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void addToX(final Integer smallestX) {
        this.x += smallestX;
    }

    void addToY(final Integer smallestY) {
        this.y += smallestY;
    }

    void reset() {
        this.x = initialX;
        this.y = initialY;
    }
}
