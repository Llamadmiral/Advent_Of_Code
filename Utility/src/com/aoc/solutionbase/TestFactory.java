package com.aoc.solutionbase;

import com.aoc.daybase.DayBase;
import com.aoc.util.log.Logger;

/**
 * @author maczaka
 */
public final class TestFactory {

    private static final String DIVIDER = "\t----------";

    private static final Logger LOG = new Logger();

    private TestFactory() {
    }

    public static void createAndRunTests(final DayBase dayBase, final String... inputs) {
        for (final String input : inputs) {
            final SolutionBase solution = dayBase.getSolutionForTest();
            solution.setInput(input);
            solution.init();
            solution.getPartOne();
            solution.getPartTwo();
            LOG.log(DIVIDER);
        }
    }
}
