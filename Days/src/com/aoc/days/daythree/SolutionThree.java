package com.aoc.days.daythree;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
public class SolutionThree extends SolutionBase {
    private static final Integer INPUT = 289326;
    private static final Integer STARTPOS = 14;
    private static final Integer START_LEVEL = 5;

    SolutionThree(final String day) {
        super(day);
        input = INPUT;
    }

    SolutionThree(final String day, final int input) {
        super(day);
        this.input = input;
    }

    @Override
    protected void solvePartOne() {
        setSolutionOne(getCurrentLevelForNumber((int) input));
    }

    @Override
    protected void solvePartTwo() {

    }

    //dont even ask about the default settings
    private Integer getCurrentLevelForNumber(final int number) {
        boolean found = false;
        int currentPos = STARTPOS;
        double currentLevel = START_LEVEL;
        int jumpAmount = 3;
        int added = 1;
        int previousPos = 13;
        while (!found) {
            added++;
            previousPos = currentPos;
            currentLevel++;
            if (added == 2) {
                added = 0;
                jumpAmount++;
                currentPos += jumpAmount;
            } else {
                currentPos += jumpAmount;
            }
            if (previousPos <= number && currentPos > number) {
                found = true;
            }
        }
        return calculateDistance(currentPos - 1, previousPos, number) + ((int) (Math.ceil((currentLevel) / 4)));
    }

    private Integer calculateDistance(final int endPos, final int prevPos, final int number) {
        int dist = (int) Math.floor((endPos - ((endPos - (prevPos - 1)) / 2.0)));
        return number > dist ? number - dist : dist - number;
    }

}
