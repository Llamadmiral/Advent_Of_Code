package com.aoc.days2015.day18;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEighteen extends SolutionBase {

    private static final int STEPS = 100;
    private static final int[][] NEIGHBOUR_MATRIX = new int[][]{
        new int[]{-1, -1},
        new int[]{-1, 0},
        new int[]{-1, 1},
        new int[]{0, -1},
        new int[]{0, 1},
        new int[]{1, -1},
        new int[]{1, 0},
        new int[]{1, 1},
    };

    private boolean[][] lights;

    SolutionEighteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] split = input.split("\n");
        lights = new boolean[split.length][split.length];
        for (int rows = 0; rows < split.length; rows++) {
            final String row = split[rows];
            for (int column = 0; column < row.length(); column++) {
                lights[rows][column] = row.charAt(column) == '#';
            }
        }
    }

    @Override
    protected void solvePartOne() {
        simulateLights(true);
        int onLights = countLights();
        setSolutionOne(onLights);
    }

    @Override
    protected void solvePartTwo() {
        init();
        turnOnCorners();
        simulateLights(false);
        int onLights = countLights();
        setSolutionTwo(onLights);
    }

    private void simulateLights(final boolean partOne) {
        for (int steps = 0; steps < STEPS; steps++) {
            final boolean[][] newLights = new boolean[lights.length][lights.length];
            for (int row = 0; row < lights.length; row++) {
                for (int column = 0; column < lights[row].length; column++) {
                    final boolean current = lights[row][column];
                    boolean next;
                    int onNeighbours = countOnNeighbours(row, column);
                    if (current) {
                        next = onNeighbours == 2 || onNeighbours == 3;
                    } else {
                        next = onNeighbours == 3;
                    }
                    newLights[row][column] = next;
                }
            }
            lights = newLights;
            if (!partOne) {
                turnOnCorners();
            }
        }
    }

    private void turnOnCorners() {
        lights[0][0] = true;
        lights[0][lights[lights.length - 1].length - 1] = true;
        lights[lights.length - 1][0] = true;
        lights[lights.length - 1][lights[lights.length - 1].length - 1] = true;
    }

    private int countOnNeighbours(final int row, final int column) {
        int count = 0;
        for (final int[] offsets : NEIGHBOUR_MATRIX) {
            boolean on = getNeighbour(row + offsets[0], column + offsets[1]);
            if (on) {
                count++;
            }
        }
        return count;
    }

    private boolean getNeighbour(final int row, final int column) {
        return row >= 0 && row < lights.length && column >= 0 && column < lights[row].length && lights[row][column];
    }

    private int countLights() {
        int count = 0;
        for (final boolean[] row : lights) {
            for (final boolean light : row) {
                if (light) {
                    count++;
                }
            }
        }

        return count;
    }

    private void log() {
        final StringBuilder builder = new StringBuilder();
        for (final boolean[] row : lights) {
            for (final boolean light : row) {
                builder.append(light ? "#" : ".");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}