package com.aoc.days2018.day13;

/**
 * @author maczaka.
 */
public class Cart {
    private static int count = 0;

    private int nextIntersectionDir = 0; //0 = LEFT, 1 = STRAIGHT, 2 = RIGHT
    private int currentDir; //0 = LEFT, 1 = UP, 2 = RIGHT, 3 = DOWN
    private int x;
    private int y;
    private int id;
    private boolean alive = true;

    public Cart(final int x, final int y, final int direction) {
        this.x = x;
        this.y = y;
        this.currentDir = direction;
        this.id = count;
        count++;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(final boolean alive) {
        this.alive = alive;
    }

    public int getNextIntersectionDir() {
        return nextIntersectionDir;
    }

    public void setNextIntersectionDir(final int nextIntersectionDir) {
        this.nextIntersectionDir = nextIntersectionDir;
    }

    public int getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(final int currentDir) {
        this.currentDir = currentDir;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }
}
