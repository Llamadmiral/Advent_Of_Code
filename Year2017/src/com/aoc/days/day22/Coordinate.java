package com.aoc.days.day22;

/**
 * @author maczaka.
 */
class Coordinate {
    private int x;
    private int y;

    Coordinate(final int[] coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coordinate)) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    //This is very not optimal, since any coordinate above 991*787 can be false-equals.
    @Override
    public int hashCode() {
        int hash = 9973;
        hash = 9613 * hash + this.x;
        hash = 9613 * hash + this.y;
        return hash;
    }

    void move(final int[] directionStep) {
        x += directionStep[0];
        y += directionStep[1];
    }
}
