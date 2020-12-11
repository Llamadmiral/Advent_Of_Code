package com.aoc.days2018.day11;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEleven extends SolutionBase {

    private static final int SERIAL_NUMBER = 5535;

    private int largestPowerForAnySize = 0;
    private String largestDescriptor = null;

    private int[][] sum = new int[301][301];

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        searchForLargestPowerArea(3);
        setSolutionOne(largestDescriptor);
    }

    private void searchForLargestPowerArea(final int size) {
        int largestArea = 0;
        int bx = 0;
        int by = 0;
        for (int y = size; y <= 300; y++) {
            for (int x = size; x <= 300; x++) {
                int total = sum[y][x] - sum[y - size][x] - sum[y][x - size] + sum[y - size][x - size];
                if (total > largestArea) {
                    largestArea = total;
                    bx = x;
                    by = y;
                }
            }
        }
        final String currentDescriptor = (bx - size + 1) + "," + (by - size + 1) + "," + size;
        if (largestArea > largestPowerForAnySize) {
            largestPowerForAnySize = largestArea;
            largestDescriptor = currentDescriptor;
        }
    }

    @Override
    protected void solvePartTwo() {
        for (int i = 1; i < 300; i++) {
            searchForLargestPowerArea(i);
        }
        setSolutionTwo(largestDescriptor);
    }

    @Override
    public void init() {
        for (int y = 1; y < 301; y++) {
            for (int x = 1; x < 301; x++) {
                final int powerLevel = getFuelPowerLevel(x, y);
                sum[y][x] = powerLevel + sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1];
            }
        }
    }


    private int getFuelPowerLevel(final int x, final int y) {
        final int rackId = x + 10;
        int powerLevel = rackId * y;
        powerLevel += SERIAL_NUMBER;
        powerLevel *= rackId;
        if (powerLevel > 100) {
            powerLevel = getHundreds(powerLevel);
        } else {
            powerLevel = 0;
        }
        powerLevel -= 5;
        return powerLevel;
    }

    private int getHundreds(final int powerLevel) {
        return (powerLevel % 1000 / 100);
    }
}