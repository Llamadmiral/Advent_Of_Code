package com.aoc.days2015.day06;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionSix extends SolutionBase {

    private int[][] lights = new int[1000][1000];

    SolutionSix(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        initiateLights(false);
        setSolutionOne(countLights());
    }

    @Override
    protected void solvePartTwo() {
        lights = new int[1000][1000];
        initiateLights(true);
        setSolutionTwo(countLights());
    }

    private void initiateLights(final boolean partTwo) {
        for (final String row : input.split("\n")) {
            final String[] data = row.split(" ");
            if ("toggle".equals(data[0])) {
                final String[] startFrom = data[1].split(",");
                final String[] endAt = data[3].split(",");
                toggle(Integer.parseInt(startFrom[0]),
                        Integer.parseInt(startFrom[1]),
                        Integer.parseInt(endAt[0]),
                        Integer.parseInt(endAt[1]),
                        partTwo);
            } else {
                final String[] startFrom = data[2].split(",");
                final String[] endAt = data[4].split(",");
                turn("on".equals(data[1]), Integer.parseInt(startFrom[0]),
                        Integer.parseInt(startFrom[1]),
                        Integer.parseInt(endAt[0]),
                        Integer.parseInt(endAt[1]),
                        partTwo);
            }
        }
    }

    private int countLights() {
        int amount = 0;
        for (final int[] row : lights) {
            for (final int light : row) {
                amount += light;
            }
        }
        return amount;
    }

    private void toggle(final int startX, final int startY, final int endX, final int endY, final boolean partTwo) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (partTwo) {
                    lights[x][y] += 2;
                } else {
                    lights[x][y] = (lights[x][y] + 1) % 2;
                }
            }
        }
    }

    private void turn(final boolean on,
                      final int startX, final int startY,
                      final int endX, final int endY,
                      final boolean partTwo) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (on) {
                    if (partTwo) {
                        lights[x][y]++;
                    } else {
                        lights[x][y] = 1;
                    }
                } else {
                    if (partTwo) {
                        lights[x][y] += lights[x][y] == 0 ? 0 : -1;
                    } else {
                        lights[x][y] = 0;
                    }
                }
            }
        }
    }

}