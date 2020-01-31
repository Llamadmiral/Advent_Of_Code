package com.aoc.days2018.day23;

/**
 * @author maczaka.
 */
public class Bot {
    private static int count = 0;

    private int x;
    private int y;
    private int z;
    private int r;
    private int id;

    public Bot(final String row) {
        final String[] data = row.split(",");
        this.x = Integer.parseInt(data[0].substring(5));
        this.y = Integer.parseInt(data[1]);
        this.z = Integer.parseInt(data[2].substring(0, data[2].length() - 1));
        this.r = Integer.parseInt(data[3].substring(3));
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
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

    public int getZ() {
        return z;
    }

    public void setZ(final int z) {
        this.z = z;
    }

    public int getR() {
        return r;
    }
}
