package com.aoc.days2016.day09;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionNine extends SolutionBase {
    SolutionNine(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int size = input.length();
        long fullSize = 0L;
        int i = 0;
        while (i < size) {
            final char currentChar = input.charAt(i);
            if (currentChar == '(') {
                int j = i + 1;
                while (input.charAt(j) != 'x') {
                    j++;
                }
                final int charsToRepeat = Integer.parseInt(input.substring(i + 1, j));
                final int sliceStart = j + 1;
                j++;
                while (input.charAt(j) != ')') {
                    j++;
                }
                final int repeatAmount = Integer.parseInt(input.substring(sliceStart, j));
                fullSize += charsToRepeat * repeatAmount;
                i = j + charsToRepeat + 1;
            } else {
                i++;
                fullSize++;
            }
        }
        setSolutionOne(fullSize);
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(getLengthOfSubString(0, input.length()));
    }

    private long getLengthOfSubString(int start, int end) {
        long length = 0L;
        int i = start;
        while (i < end) {
            if (input.charAt(i) == '(') {
                int j = i + 1;
                while (input.charAt(j) != 'x') {
                    j++;
                }
                final int charsToRepeat = Integer.parseInt(input.substring(i + 1, j));
                final int sliceStart = j + 1;
                j++;
                while (input.charAt(j) != ')') {
                    j++;
                }
                final int repeatAmount = Integer.parseInt(input.substring(sliceStart, j));
                length += getLengthOfSubString(j + 1, j + 1 + charsToRepeat) * repeatAmount;
                i = j + charsToRepeat + 1;
            } else {
                length++;
                i++;
            }
        }
        return length;
    }
}