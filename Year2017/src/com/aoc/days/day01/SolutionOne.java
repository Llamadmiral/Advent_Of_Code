package com.aoc.days.day01;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

/**
 * @author Llamadmiral.
 */
class SolutionOne extends SolutionBase {

    SolutionOne(final String dayNr) {
        super(dayNr);
    }

    @Override
    protected void solvePartOne() {
        final String inp = input;
        final Character firstChar = inp.charAt(0);
        Character prevChar = firstChar;
        int sums = 0;
        for (int i = 1; i < inp.length(); i++) {
            if (prevChar.equals(inp.charAt(i))) {
                sums += SolutionHelper.charToInt(prevChar);
            }
            prevChar = inp.charAt(i);
        }
        setSolutionOne(firstChar.equals(inp.charAt(inp.length() - 1))
            ? sums + SolutionHelper.charToInt(firstChar)
            : sums);
    }

    @Override
    protected void solvePartTwo() {
        final int length = input.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            final Character currentCharacter = input.charAt(i);
            if (currentCharacter.equals(input.charAt(getNextPosition(i, length)))) {
                sum += SolutionHelper.charToInt(currentCharacter);
            }
        }
        setSolutionTwo(sum);
    }

    private int getNextPosition(final int currentPosition, final int length) {
        return (length / 2 + currentPosition) % length;
    }
}
