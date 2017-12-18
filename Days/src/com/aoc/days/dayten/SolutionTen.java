package com.aoc.days.dayten;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maczaka.
 */
class SolutionTen extends SolutionBase {

    private static final Integer[] TRAILING_BYTES = new Integer[]{17, 31, 73, 47, 23};
    private static final char[] HEX_TABLE = "0123456789abcdef".toCharArray();
    private final List<Integer> SPARSE_HASH = new ArrayList<>();
    private final List<Integer> LENGTHS = new ArrayList<>();
    private final List<Integer> DENSE_HASH = new ArrayList<>();
    private Integer skipSize = 0;
    private Integer currentPosition = 0;


    SolutionTen(final String day) {
        super(day);
    }

    private void createList() {
        SPARSE_HASH.clear();
        for (int i = 0; i < 256; i++) {
            SPARSE_HASH.add(i);
        }
    }


    @Override
    protected void solvePartOne() {
        final String inp = ((String) input);
        createList();
        final String[] lengths = inp.contains(",") ? inp.split(",") : new String[]{};
        for (final String length : lengths) {
            reverseSubList(Integer.parseInt(length));
        }
        setSolutionOne(SPARSE_HASH.get(0) * SPARSE_HASH.get(1));
    }

    String initKnotHashGeneration() {
        skipSize = 0;
        currentPosition = 0;
        parseInput();
        createList();
        for (int i = 0; i < 64; i++) {
            LENGTHS.forEach(this::reverseSubList);
        }
        crushSparseHash();
        return generateKnotHash();
    }


    @Override
    protected void solvePartTwo() {
        initKnotHashGeneration();
    }

    private String generateKnotHash() {
        final StringBuilder builder = new StringBuilder();
        DENSE_HASH.forEach(hash -> builder.append(getHexValue(hash)));
        final String knotHash = builder.toString();
        setSolutionTwo(knotHash);
        return knotHash;
    }

    /**
     * I'm cheating a bit here, since we know that the input is between 0 and 255.
     */
    private String getHexValue(final Integer intInput) {
        return new String(new char[]{
                HEX_TABLE[intInput / 16], HEX_TABLE[intInput % 16]
        });
    }

    private void crushSparseHash() {
        for (int i = 0; i < 16; i++) {
            DENSE_HASH.add(getXorValue(SPARSE_HASH.subList(16 * i, 16 * i + 16)));
        }
    }

    private Integer getXorValue(final List<Integer> integers) {
        Integer xorValue = integers.get(0);
        for (int i = 1; i < 16; i++) {
            xorValue ^= integers.get(i);
        }
        return xorValue;
    }

    private void reverseSubList(final Integer length) {
        for (int i = 0; i < (length / 2); i++) {
            switchPositions(currentPosition + i, currentPosition + length - i - 1);
        }
        currentPosition = getWrappedPosition(currentPosition + length + skipSize);
        skipSize++;
    }

    private Integer getWrappedPosition(final Integer position) {
        return position % SPARSE_HASH.size();
    }

    private void switchPositions(final Integer positionOne, final Integer positionTwo) {
        if (!positionOne.equals(positionTwo)) {
            final Integer wrappedPositionOne = getWrappedPosition(positionOne);
            final Integer wrappedPositionTwo = getWrappedPosition(positionTwo);
            final Integer valueOne = SPARSE_HASH.get(wrappedPositionOne);
            final Integer valueTwo = SPARSE_HASH.get(wrappedPositionTwo);
            SPARSE_HASH.set(wrappedPositionTwo, valueOne);
            SPARSE_HASH.set(wrappedPositionOne, valueTwo);
        }
    }

    private void parseInput() {
        final String inp = (String) input;
        for (int i = 0; i < inp.length(); i++) {
            LENGTHS.add((int) inp.charAt(i));
        }
        LENGTHS.addAll(Arrays.asList(TRAILING_BYTES));
    }
}
