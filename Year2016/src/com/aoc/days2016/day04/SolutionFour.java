package com.aoc.days2016.day04;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {
    private final List<Room> rooms = new ArrayList<>();

    SolutionFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        int sumOfSectorIds = 0;
        for (final Room room : rooms) {
            if (room.isRealRoom()) {
                sumOfSectorIds += room.getSectorId();
            }
        }
        setSolutionOne(sumOfSectorIds);
    }

    @Override
    protected void solvePartTwo() {
        for (final Room room : rooms) {
            if (room.getShiftedName().contains("northpole")) {
                setSolutionTwo(room.getSectorId());
                break;
            }
        }
    }

    private void parseInput() {
        for (final String row : input.split("\n")) {
            rooms.add(new Room(row));
        }
    }
}