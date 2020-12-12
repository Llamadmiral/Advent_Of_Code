package com.aoc.days2020.day05;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionFive extends SolutionBase {

    private static final String FRONT_SEAT = "FFFFFFF";
    private static final String BACK_SEAT = "BBBBBBB";

    private final char[][] seats = new char[128][8];

    private List<String> boardingPasses = new ArrayList<>();

    SolutionFive(final String day) {
        super(day);
    }

    @Override
    public void init() {
        boardingPasses.addAll(Arrays.asList(input.split("\n")));
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 8; j++) {
                seats[i][j] = '.';
            }
        }
    }

    @Override
    protected void solvePartOne() {
        int highestSeatId = 0;
        for (final String pass : boardingPasses) {
            final int seatId = getSeatId(pass);
            if (seatId > highestSeatId) {
                highestSeatId = seatId;
            }
        }
        setSolutionOne(highestSeatId);
    }

    @Override
    protected void solvePartTwo() {
        int myRow = 0;
        int myColumn = 0;
        boolean found = false;
        for (int row = 1; row < seats.length - 1; row++) {
            for (int column = 1; column < seats[row].length - 1; column++) {
                if (seats[row][column] == '.') {
                    if (seats[row][column - 1] == '#' && seats[row][column + 1] == '#') {
                        myRow = row;
                        myColumn = column;
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }
        setSolutionTwo(myRow * 8 + myColumn);
    }

    private int getSeatId(final String pass) {
        final int row = getRow(pass);
        final int column = getColumn(pass);
        seats[row][column] = '#';
        return row * 8 + column;
    }

    private int getRow(final String value) {
        return getValueInRange(value.substring(0, value.length() - 3), 128);
    }

    private int getColumn(final String value) {
        return getValueInRange(value.substring(7), 8);
    }

    private int getValueInRange(final String value, final int originalMax) {
        int min = 0;
        int max = originalMax;
        for (int i = 0; i < value.length(); i++) {
            final char seatDirection = value.charAt(i);
            if (seatDirection == 'F' || seatDirection == 'L') {
                max = max - ((max - min) / 2);
            } else {
                min = min + ((max - min) / 2);
            }
        }
        return min;
    }
}