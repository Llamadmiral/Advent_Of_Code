package com.aoc.days.daytwentytwo;

/**
 * @author maczaka.
 */
class Carrier {
    private static final int[][] DIRECTION_STEPS = new int[][]{
        new int[]{1, 0},
        new int[]{0, -1},
        new int[]{-1, 0},
        new int[]{0, 1}
    };

    private Coordinate coordinates;
    private int direction = 2;
    private int infectedNodes = 0;

    Carrier(final int x, final int y) {
        coordinates = new Coordinate(x, y);
    }


    //turn to a new direction, infect or clean, then move.
    void burst(final boolean infected) {
        direction = (infected ? direction + 1 : direction - 1) % 4;
        if (direction < 0) {
            direction = 3;
        }
        if (!infected) {
            infectedNodes++;
        }
        coordinates.move(DIRECTION_STEPS[direction]);
    }


    void burstTwo(final Integer flag) {
        direction = (direction + (flag - 1)) % 4;
        if (direction < 0) {
            direction = 3;
        }
        if (flag == 1) {
            infectedNodes++;
        }
        coordinates.move(DIRECTION_STEPS[direction]);
    }

    Coordinate getCoordinates() {
        return coordinates;
    }

    int getInfectedNodes() {
        return infectedNodes;
    }
}
