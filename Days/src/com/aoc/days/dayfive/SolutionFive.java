package com.aoc.days.dayfive;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * I'm pretty sure the exercise here wasn't that if you can solve it,
 * but rather to find a better solution than the base. Well, I couldn't really think of one.
 *
 * @author Llamadmiral.
 */
class SolutionFive extends SolutionBase {
    private static final List<Integer> OFFSETS = new ArrayList<>();
    private int steps = 0;
    private int position = 0;

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
        OFFSETS.clear();
        steps = 0;
        position = 0;
        parseInput();
        jump(true);
        setSolutionTwo(steps);
    }

    private void jump(final boolean partTwo) {
        while (position < OFFSETS.size() && position >= 0) {
            steps++;
            final int offset = OFFSETS.get(position);
            if (partTwo && offset > 2) {
                OFFSETS.set(position, OFFSETS.get(position) - 1);
            } else {
                OFFSETS.set(position, OFFSETS.get(position) + 1);
            }
            position += offset;
        }
    }

    private void parseInput() {
        final String[] jumps = ((String) input).split("\n");
        for (final String jump : jumps) {
            if (!jump.isEmpty()) {
                OFFSETS.add(Integer.parseInt(jump));
            }
        }
    }
}
