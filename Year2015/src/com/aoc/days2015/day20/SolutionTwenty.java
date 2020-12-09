package com.aoc.days2015.day20;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionTwenty extends SolutionBase {

    private static final int PRESENTS = 36000000;

    private static final int ARRAY_SIZE = 1000000;

    SolutionTwenty(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int[] houses = new int[ARRAY_SIZE];
        for (int i = 1; i < ARRAY_SIZE; i++) {
            final boolean foundHouse = givePresents(houses, i, true);
            if (foundHouse) {
                setSolutionOne(i);
                break;
            }
        }
    }

    @Override
    protected void solvePartTwo() {
        final int[] houses = new int[ARRAY_SIZE];
        for (int i = 1; i < ARRAY_SIZE; i++) {
            final boolean foundHouse = givePresents(houses, i, false);
            if (foundHouse) {
                setSolutionTwo(i);
                break;
            }
        }
    }


    private boolean givePresents(final int[] houses, final int incrementBy, final boolean partOne) {
        boolean foundIt = false;
        for (int i = incrementBy; i < houses.length; i += incrementBy) {
            if (partOne) {
                houses[i] += incrementBy * 10;
            } else if (i <= incrementBy * 50) {
                houses[i] += incrementBy * 11;
            }
            if (houses[i] > PRESENTS) {
                foundIt = true;
            }
        }
        return foundIt;
    }


}