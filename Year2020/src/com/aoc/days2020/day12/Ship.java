package com.aoc.days2020.day12;

class Ship {

    private static final char[] DIRECTIONS = new char[]{'E', 'S', 'W', 'N'};
    private int direction = 0;
    private int x = 0;
    private int y = 0;
    private Waypoint waypoint = new Waypoint();

    void move(final Instruction instruction, final boolean partOne) {
        if (partOne) {
            move(instruction.getAction(), instruction.getValue());
        } else {
            performInstruction(instruction.getAction(), instruction.getValue());
        }
    }

    private void performInstruction(final char action, final int value) {
        switch (action) {
            case 'N':
                this.waypoint.addToY(value);
                break;
            case 'S':
                this.waypoint.addToY(-value);
                break;
            case 'E':
                this.waypoint.addToX(value);
                break;
            case 'W':
                this.waypoint.addToX(-value);
                break;
            case 'L':
            case 'R':
                this.waypoint.rotate(action, value / 90);
                break;
            case 'F':
                this.x += value * this.waypoint.getX();
                this.y += value * this.waypoint.getY();
                break;
        }
    }

    private void move(final char action, final int value) {
        switch (action) {
            case 'N':
                this.y += value;
                break;
            case 'S':
                this.y -= value;
                break;
            case 'E':
                this.x += value;
                break;
            case 'W':
                this.x -= value;
                break;
            case 'L':
            case 'R':
                turn(action, value);
                break;
            case 'F':
                move(DIRECTIONS[this.direction], value);
                break;
        }
    }

    private void turn(final char action, final int value) {
        int directionChange = value / 90;
        if (action == 'R') {
            this.direction = (this.direction + directionChange) % 4;
        } else {
            this.direction = (this.direction + 4 - directionChange) % 4;
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Ship{" +
            "direction=" + direction +
            ", x=" + x +
            ", y=" + y +
            '}';
    }
}
