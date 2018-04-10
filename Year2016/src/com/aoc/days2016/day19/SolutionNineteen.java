package com.aoc.days2016.day19;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionNineteen extends SolutionBase {

    private static final int STARTING_SIZE = 3005290;

    SolutionNineteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int i = 1;
        while (i * 2 < STARTING_SIZE) {
            i *= 2;
        }
        setSolutionOne((STARTING_SIZE - i) * 2 + 1);
    }

    /**
     * Not my code... I couldn't solve it in a reasonable time. :(
     */
    @Override
    protected void solvePartTwo() {
        int winner = 1;
        for (int i = 1; i < STARTING_SIZE; i++) {
            winner = winner % i + 1;
            if (winner > (i + 1) / 2) {
                winner++;
            }
        }
        setSolutionTwo(winner);
    }
}