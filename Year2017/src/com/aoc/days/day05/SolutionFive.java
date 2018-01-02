package com.aoc.days.day05;

import com.aoc.solutionbase.SolutionBase;

/**
 * I'm pretty sure the exercise here wasn't that if you can solve it,
 * but rather to find a better solution than the base. Well, I couldn't really think of one.
 *
 * @author Llamadmiral.
 */
class SolutionFive extends SolutionBase {
    private int[] baseOffsets;
    private int steps = 0;

    SolutionFive(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        jump(false);
        setSolutionOne(steps);
    }

    @Override
    protected void solvePartTwo() {
        steps = 0;
        jump(true);
        setSolutionTwo(steps);
    }

    private void jump(final boolean partTwo) {
        final int[] offsets = baseOffsets.clone();
        int position = 0;
        while (position < offsets.length) {
            steps++;
            final int offset = offsets[position];
            if (partTwo && offset > 2) {
                offsets[position] = offsets[position] - 1;
            } else {
                offsets[position] = offsets[position] + 1;
            }
            position += offset;
        }
    }

    private void parseInput() {
        final String[] jumps = ((String) input).split("\n");
        baseOffsets = new int[jumps.length];
        for (int i = 0; i < jumps.length; i++) {
            baseOffsets[i] = (Integer.parseInt(jumps[i]));
        }
    }
}
