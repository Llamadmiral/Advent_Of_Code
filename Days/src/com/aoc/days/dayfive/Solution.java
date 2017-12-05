package com.aoc.days.dayfive;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
public class Solution extends SolutionBase {
    private static final List<Integer> OFFSETS = new ArrayList<>();
    private int steps = 0;


    protected Solution(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        jump(0);
        setSolutionOne(steps);
    }

    @Override
    protected void solvePartTwo() {

    }

    private void jump(final int currentPosition) {
        if (currentPosition < OFFSETS.size() && currentPosition >= 0) {
            steps++;
            final int offset = OFFSETS.get(currentPosition);
            OFFSETS.set(currentPosition, OFFSETS.get(currentPosition) + 1);
            final int newPosition = currentPosition + offset;
            jump(newPosition);
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
