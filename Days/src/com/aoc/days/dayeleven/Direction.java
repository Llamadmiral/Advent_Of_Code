package com.aoc.days.dayeleven;

/**
 * I hate circulal lists...
 *
 * @author maczaka.
 */
class Direction {
    private Direction previousDirection;
    private Direction nextDirection;
    private String direction;

    Direction(final String direction) {
        this.direction = direction;
    }

    String getDirection() {
        return direction;
    }

    Direction getPreviousDirection() {
        return previousDirection;
    }

    void setPreviousDirection(final Direction previousDirection) {
        this.previousDirection = previousDirection;
    }

    Direction getNextDirection() {
        return nextDirection;
    }

    void setNextDirection(final Direction nextDirection) {
        this.nextDirection = nextDirection;
    }

    int getDistance(final String directionName) {
        int distance = 0;
        if (!directionName.equals(this.direction)) {
            distance++;
            Direction prevDir = this.previousDirection;
            Direction nextDir = this.nextDirection;
            while (!prevDir.getDirection().equals(directionName) && !nextDir.getDirection().equals(directionName)) {
                distance++;
                prevDir = prevDir.getPreviousDirection();
                nextDir = nextDir.getNextDirection();
            }
        }
        return distance;
    }
}
