package com.aoc.days2015.day01;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionOne extends SolutionBase {
    SolutionOne(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int floor = 0;
        for (final char direction : input.toCharArray()) {
            if (direction == '(') {
                floor++;
            } else {
                floor--;
            }
        }
        setSolutionOne(floor);
    }

    @Override
    protected void solvePartTwo() {
        int floor = 0;
        int steps = 0;
        for (final char direction : input.toCharArray()) {
            steps++;
            if (direction == '(') {
                floor++;
            } else {
                floor--;
            }
            if (floor < 0) {
                setSolutionTwo(steps);
                break;
            }
        }
    }
}