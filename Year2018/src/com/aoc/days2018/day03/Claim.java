package com.aoc.days2018.day03;

/**
 * @author maczaka.
 */
class Claim {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;

    private Claim(final int id, final int x, final int y, final int width, final int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    static Claim make(final String row) {
        final String[] data = row.split(" ");
        final String[] coords = data[2].split(",");
        final String[] dimension = data[3].split("x");
        return new Claim(
            Integer.parseInt(data[0].substring(1)),
            Integer.parseInt(coords[0]),
            Integer.parseInt(coords[1].substring(0, coords[1].length() - 1)),
            Integer.parseInt(dimension[0]),
            Integer.parseInt(dimension[1])
        );
    }

    int getId() {
        return id;
    }

    int getX() {
        return x;
    }

    void setX(final int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(final int y) {
        this.y = y;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "#" + this.id + " @ " + this.x + "," + this.y + ": " + this.width + "x" + this.height;
    }
}
