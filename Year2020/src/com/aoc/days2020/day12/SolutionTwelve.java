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
        final Ship ship = moveShip(true);
        setSolutionOne(manhattanDistance(ship.getX(), ship.getY()));
    }

    @Override
    protected void solvePartTwo() {
        final Ship ship = moveShip(false);
        setSolutionTwo(manhattanDistance(ship.getX(), ship.getY()));
    }

    private Ship moveShip(final boolean partOne) {
        final Ship ship = new Ship();
        for (final Instruction instruction : instructions) {
            ship.move(instruction, partOne);
        }
        return ship;
    }

    private int manhattanDistance(final int x, final int y) {
        return Math.abs(x) + Math.abs(y);
    }
}