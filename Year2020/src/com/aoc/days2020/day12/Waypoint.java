package com.aoc.days2020.day12;

class Waypoint {
    private int x = 10;
    private int y = 1;

    void addToX(final int value) {
        this.x += value;
    }

    void addToY(final int value) {
        this.y += value;
    }

    void rotate(final char direction, final int degree) {
        if (degree != 0) {
            if (direction == 'R') {
                final int temp = this.x;
                this.x = this.y;
                this.y = -temp;
            } else {
                final int temp = this.y;
                this.y = this.x;
                this.x = -temp;
            }
            rotate(direction, degree - 1);
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
