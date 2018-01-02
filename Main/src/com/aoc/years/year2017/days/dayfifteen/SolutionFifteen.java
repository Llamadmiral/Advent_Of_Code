package com.aoc.years.year2017.days.dayfifteen;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
class SolutionFifteen extends SolutionBase {

    private static final int GENERATOR_A_FACTOR = 16807;
    private static final int GENERATOR_B_FACTOR = 48271;

    private static final int FORTY_MILLION = 40000000;
    private static final int FIVE_MILLION = 5000000;
    private final Generator generatorA = new Generator(GENERATOR_A_FACTOR);
    private final Generator generatorB = new Generator(GENERATOR_B_FACTOR);
    private int matches = 0;

    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        setupGenerators();
        for (int i = 0; i < FORTY_MILLION; i++) {
            if (isLastSixteenBitEquals(generatorA.nextValue(), generatorB.nextValue())) {
                matches++;
            }
        }
        setSolutionOne(matches);
    }

    /**
     * It's not really efficient to re-parse stuff just so we can reset the generators, but eh.
     */
    @Override
    protected void solvePartTwo() {
        setupGenerators();
        matches = 0;
        for (int i = 0; i < FIVE_MILLION; i++) {
            if (isLastSixteenBitEquals(generatorA.nextValueWithCriteria(), generatorB.nextValueWithCriteria())) {
                matches++;
            }
        }
        setSolutionTwo(matches);
    }

    private boolean isLastSixteenBitEquals(final int integerA, final int integerB) {
        int length = 0;
        int numberA = integerA;
        int numberB = integerB;
        while ((numberA % 2) == (numberB % 2) && length < 16) {
            numberA /= 2;
            numberB /= 2;
            length++;
        }
        return length == 16;
    }

    private void setupGenerators() {
        final String[] startingValues = ((String) input).split(", ");
        generatorA.setPreviousValue(Integer.parseInt(startingValues[0]));
        generatorA.setCriteria(4);
        generatorB.setPreviousValue(Integer.parseInt(startingValues[1]));
        generatorB.setCriteria(8);
    }

}
