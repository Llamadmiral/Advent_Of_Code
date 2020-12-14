package com.aoc.days2020.day12;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {

    private final List<Instruction> instructions = new ArrayList<>();

    SolutionTwelve(final String day) {
        super(day);
    }

    @Override
    public void init() {
        for (final String row : input.split("\n")) {
            instructions.add(new Instruction(row.charAt(0), Integer.valueOf(row.substring(1))));
        }
    }

    @Override
    protected void solvePartOne() {
        final Ship ship = new Ship();
        for (final Instruction instruction : instructions) {
            ship.move(instruction, true);
        }
        setSolutionOne(manhattanDistance(0, ship.getX(), 0, ship.getY()));
    }

    @Override
    protected void solvePartTwo() {
        final Ship ship = new Ship();
        for (final Instruction instruction : instructions) {
            ship.move(instruction, false);
        }
        setSolutionTwo(manhattanDistance(0, ship.getX(), 0, ship.getY()));
    }

    private int manhattanDistance(final int x1, final int x2, final int y1, final int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}