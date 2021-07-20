package com.aoc.days2019.day02;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwo extends SolutionBase {
    private static final int LOOKUP_VALUE = 19690720;

    final private List<Integer> originalValues = new ArrayList<>();

    SolutionTwo(final String day) {
        super(day);
    }

    @Override
    public void init() {
        for (final String row : input.split(",")) {
            originalValues.add(Integer.valueOf(row));
        }
    }

    @Override
    protected void solvePartOne() {
        final int result = getIntCodeResult(12, 2);
        setSolutionOne(result);
    }

    @Override
    protected void solvePartTwo() {
        boolean found = false;
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                final int intCodeResult = getIntCodeResult(noun, verb);
                if (intCodeResult == LOOKUP_VALUE) {
                    found = true;
                    setSolutionTwo(noun * 100 + verb);
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }

    private int getIntCodeResult(final int noun, final int verb) {
        int currentPosition = 0;
        final List<Integer> values = new ArrayList<>(originalValues);
        values.set(1, noun);
        values.set(2, verb);
        boolean halt = false;
        while (!halt) {
            final int command = values.get(currentPosition);
            switch (command) {
                case 1:
                    final int sum = values.get(values.get(currentPosition + 1)) + values.get(values.get(currentPosition + 2));
                    values.set(values.get(currentPosition + 3), sum);
                    break;
                case 2:
                    final int multiple = values.get(values.get(currentPosition + 1)) * values.get(values.get(currentPosition + 2));
                    values.set(values.get(currentPosition + 3), multiple);
                    break;
                case 99:
                    halt = true;
                    break;
                default:
                    System.out.println("You done goofed!");
                    break;
            }
            currentPosition += 4;
        }
        return values.get(0);
    }
}