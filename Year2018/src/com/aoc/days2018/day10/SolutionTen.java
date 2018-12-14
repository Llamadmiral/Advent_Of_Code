package com.aoc.days2018.day10;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionTen extends SolutionBase {

    private static final int THRESHOLD = 40000;
    private Set<Star> stars = new HashSet<>();

    private int smallestDistance = -1;
    private int smallestDistanceIndex;

    SolutionTen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        for (int i = 1; i < THRESHOLD; i++) {
            stepStars(1);
            searchForSmallestCluster(i);
        }
        setSolutionOne(getStarMap(smallestDistanceIndex));
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(smallestDistanceIndex);
    }

    private void stepStars(final int seconds) {
        for (final Star star : stars) {
            star.step(seconds);
        }
    }

    @Override
    public void init() {
        for (final String row : input.split("\n")) {
            int x = Integer.parseInt(row.substring(10, row.indexOf(',')).trim());
            int y = Integer.parseInt(row.substring(row.indexOf(", ") + 1, row.indexOf('>')).trim());
            int vX = Integer.parseInt(row.substring(row.lastIndexOf('<') + 1, row.lastIndexOf(',')).trim());
            int vY = Integer.parseInt(row.substring(row.lastIndexOf(", ") + 1, row.lastIndexOf('>')).trim());
            stars.add(new Star(x, y, vX, vY));
        }

    }

    private void searchForSmallestCluster(final int i) {
        final int[] averageCoordinates = getAverageCoordinates();
        int sum = 0;
        for (final Star star : stars) {
            sum += getManhattanDistance(star.getX(), star.getY(), averageCoordinates);
        }
        if (smallestDistance == -1 || smallestDistance > sum) {
            smallestDistance = sum;
            smallestDistanceIndex = i;
        }
    }

    private int[] getAverageCoordinates() {
        int x = 0;
        int y = 0;
        for (final Star star : stars) {
            x += star.getX();
            y += star.getY();
        }
        return new int[]{x / stars.size(), y / stars.size()};
    }

    private int getManhattanDistance(final int x1, final int y1, final int[] coords) {
        return Math.abs(x1 - coords[0]) + Math.abs(y1 - coords[1]);
    }

    private String getStarMap(final int smallestDistanceIndex) {
        resetStars();
        stepStars(smallestDistanceIndex);
        normalizeStars();
        int maxX = 0;
        int maxY = 0;
        for (final Star star : stars) {
            if (maxX < star.getX()) {
                maxX = star.getX();
            }
            if (maxY < star.getY()) {
                maxY = star.getY();
            }
        }
        final boolean[][] map = new boolean[maxY + 1][maxX + 1];
        for (final Star star : stars) {
            map[star.getY()][star.getX()] = true;
        }
        final StringBuilder builder = new StringBuilder("\n");
        for (final boolean[] row : map) {
            for (final boolean piece : row) {
                if (piece) {
                    builder.append('#');
                } else {
                    builder.append('.');
                }
            }
            builder.append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }

    private void resetStars() {
        for (final Star star : stars) {
            star.reset();
        }
    }

    private void normalizeStars() {
        Integer smallestX = null;
        Integer smallestY = null;
        for (final Star star : stars) {
            if (smallestX == null || smallestX > star.getX()) {
                smallestX = star.getX();
            }
            if (smallestY == null || smallestY > star.getY()) {
                smallestY = star.getY();
            }
        }
        smallestX = -smallestX;
        smallestY = -smallestY;
        for (final Star star : stars) {
            star.addToX(smallestX);
            star.addToY(smallestY);
        }
    }
}