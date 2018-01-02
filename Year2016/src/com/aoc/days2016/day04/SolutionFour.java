package com.aoc.days2016.day04;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {
    SolutionFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int realRooms = 0;
        for (final String row : input.split("\n")) {
            final Room room = new Room(row);
            if (room.isRealRoom(false)) {
                realRooms++;
            }
        }
        setSolutionOne(realRooms);
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }
}