package com.aoc.days2017.day11;

/**
 * I hate circulal lists...
 *
 * @author maczaka.
 */
class Direction {
    private Direction previousDirection;
    private Direction nextDirection;
    private String directionName;

    Direction(final String directionName) {
        this.directionName = directionName;
    }

    String getDirectionName() {
        return directionName;
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
        if (!directionName.equals(this.directionName)) {
            distance++;
            Direction prevDir = this.previousDirection;
            Direction nextDir = this.nextDirection;
            while (!prevDir.getDirectionName().equals(directionName) && !nextDir.getDirectionName().equals(directionName)) {
                distance++;
                prevDir = prevDir.getPreviousDirection();
                nextDir = nextDir.getNextDirection();
            }
        }
        return distance;
    }
}
