package com.aoc.days2016.day16;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionSixteen extends SolutionBase {

    private static final int PART_ONE_SIZE = 272;
    private static final int PART_TWO_SIZE = 35651584;

    SolutionSixteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        this.setSolutionOne(generateDragonCurve(PART_ONE_SIZE));
    }

    @Override
    protected void solvePartTwo() {
        this.setSolutionTwo(generateDragonCurve(PART_TWO_SIZE));
    }

    private String generateDragonCurve(final int size) {
        final boolean[] checkSum = generateCheckSum(generateFullDragonCurve(size));
        final StringBuilder builder = new StringBuilder();
        for (final boolean bit : checkSum) {
            builder.append(bit ? '1' : '0');
        }
        return builder.toString();
    }

    private boolean[] getStartingBits() {
        final boolean[] startingBits = new boolean[input.length()];
        final char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            startingBits[i] = '1' == charArray[i];
        }
        return startingBits;
    }

    private boolean[] generateFullDragonCurve(final int requiredSize) {
        boolean[] bits = getStartingBits();
        while (bits.length < requiredSize) {
            bits = addReversedNegatedCopy(bits);
        }
        boolean[] cutBits = new boolean[requiredSize];
        System.arraycopy(bits, 0, cutBits, 0, requiredSize);
        return cutBits;
    }

    private boolean[] addReversedNegatedCopy(final boolean[] bits) {
        final int n = bits.length;
        final boolean[] reversedNegatedCopy = new boolean[n * 2 + 1];
        System.arraycopy(bits, 0, reversedNegatedCopy, 0, n);
        for (int i = 0; i < n; i++) {
            reversedNegatedCopy[(n * 2) - i] = !bits[i];
        }
        reversedNegatedCopy[n / 2] = false;
        return reversedNegatedCopy;
    }

    private boolean[] generateCheckSum(final boolean[] bits) {
        boolean[] checkSum = convertToChecksum(bits);
        while (checkSum.length % 2 == 0) {
            checkSum = convertToChecksum(checkSum);
        }
        return checkSum;
    }

    private boolean[] convertToChecksum(final boolean[] bits) {
        final boolean[] checkSum = new boolean[bits.length / 2];
        for (int i = 0; i < bits.length; i = i + 2) {
            checkSum[i / 2] = bits[i] == bits[i + 1];
        }
        return checkSum;
    }

}