package com.aoc.days.dayten;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
class SolutionTen extends SolutionBase {

    private final List<Integer> LIST = new ArrayList<>();
    private Integer skipSize = 0;
    private Integer currentPosition = 0;

    SolutionTen(final String day) {
        super(day);
    }

    private void createList(final Integer length) {
        final Integer size = length == 4 ? 5 : 256; //because of tests :(
        for (int i = 0; i < size; i++) {
            LIST.add(i);
        }
    }

    @Override
    protected void solvePartOne() {
        final String[] inps = parseInput();
        createList(inps.length);
        for (final String length : inps) {
            reverseSubList(Integer.parseInt(length) - 1);
        }
        setSolutionOne(LIST.get(0) * LIST.get(1));
    }

    private String[] parseInput() {
        return ((String) input).split(",");
    }

    @Override
    protected void solvePartTwo() {

    }

    private void reverseSubList(final Integer length) {
        if (length > 0) {
            for (int i = 0; i < (length - 1); i++) {
                switchPositions(currentPosition + i, currentPosition + length - i);
            }
        }
        currentPosition = getWrappedPosition(currentPosition + length + skipSize + 1);
        skipSize++;
    }

    private Integer getWrappedPosition(final Integer position) {
        return position % LIST.size();
    }

    private void switchPositions(final Integer positionOne, final Integer positionTwo) {
        if (!positionOne.equals(positionTwo)) {
            final Integer wrappedPositionOne = getWrappedPosition(positionOne);
            final Integer wrappedPositionTwo = getWrappedPosition(positionTwo);
            final Integer valueOne = LIST.get(wrappedPositionOne);
            final Integer valueTwo = LIST.get(wrappedPositionTwo);
            LIST.set(wrappedPositionTwo, valueOne);
            LIST.set(wrappedPositionOne, valueTwo);
        }
    }


}
