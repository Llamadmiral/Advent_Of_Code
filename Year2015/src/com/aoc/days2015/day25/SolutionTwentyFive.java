package com.aoc.days2015.day25;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyFive extends SolutionBase {

    private static final long SEED = 20151125;
    private static final long MULTIPLIER = 252533;

    private static final long DIVIDER = 33554393;

    SolutionTwentyFive(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final long generatedCode = getGeneratedCode(3010, 3019);
        setSolutionOne(generatedCode);
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo("2015 is done!");
    }

    private long getGeneratedCode(final int targetRow, final int targetColumn) {
        int row = 1;
        int column = 1;
        int rowHeight = 1;
        long previousValue = SEED;
        while (row != targetRow || column != targetColumn) {
            row--;
            column++;
            if (row == 0) {
                rowHeight++;
                row = rowHeight;
                column = 1;
            }
            previousValue = (previousValue * MULTIPLIER) % DIVIDER;
        }
        return previousValue;
    }

}