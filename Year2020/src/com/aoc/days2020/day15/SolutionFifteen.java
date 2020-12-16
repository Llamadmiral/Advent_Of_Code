package com.aoc.days2020.day15;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionFifteen extends SolutionBase {

    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int lastNumber = getLastSpokenNumber(2020);
        setSolutionOne(lastNumber);
    }

    @Override
    protected void solvePartTwo() {
        final int lastNumber = getLastSpokenNumber(30000000);
        setSolutionTwo(lastNumber);
    }


    private int getLastSpokenNumber(final int turns) {
        final int[] memory = new int[turns];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = -1;
        }
        int lastSpokenNumber = 0;
        int index = 0;
        final String[] numbers = input.split(",");
        for (final String number : numbers) {
            final int value = Integer.parseInt(number);
            memory[value] = index;
            lastSpokenNumber = value;
            index++;
        }
        int nextNumber = index - 1;
        for (int i = index; i < turns; i++) {
            lastSpokenNumber = (i - 1) - nextNumber;
            nextNumber = put(memory, lastSpokenNumber, i);
        }
        return lastSpokenNumber;
    }

    private int put(final int[] memory, final int key, final int value) {
        final int returnValue = memory[key];
        memory[key] = value;
        return returnValue == -1 ? value : returnValue;
    }


}