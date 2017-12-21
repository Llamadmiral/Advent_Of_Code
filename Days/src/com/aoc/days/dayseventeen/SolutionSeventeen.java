package com.aoc.days.dayseventeen;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an easier way, but I'm not a math genius unfortunetaly :<.
 *
 * @author maczaka.
 */
class SolutionSeventeen extends SolutionBase {

    private static final int spinAmount = 2017;

    private static final int FIFTY_MILLION = 50000000;

    SolutionSeventeen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int jumpAmount = Integer.parseInt((String) input);
        int currentPosition = 0;
        final List<Integer> buffer = new ArrayList<>();
        buffer.add(0);
        for (int i = 1; i < spinAmount + 1; i++) {
            currentPosition = (currentPosition + jumpAmount) % buffer.size();
            buffer.add(currentPosition, i);
            currentPosition++;
        }
        setSolutionOne(buffer.get(currentPosition));
    }

    @Override
    protected void solvePartTwo() {
        final int jumpAmount = Integer.parseInt((String) input);
        int currentPosition = 0;
        int numberAfterZero = 0;
        int listSize = 1;
        for (int i = 1; i < FIFTY_MILLION; i++) {
            currentPosition = ((currentPosition + jumpAmount) % listSize) + 1;
            listSize++;
            if (currentPosition == 1) {
                numberAfterZero = i;
            }
        }
        setSolutionTwo(numberAfterZero);
    }

}
