package com.aoc.solutionbase;

import com.aoc.util.log.Logger;

/**
 * @author Llamadmiral.
 */
public abstract class SolutionBase {

    private static final Logger LOG = new Logger();

    private static final String TEMPLATE_SOL = "\tSolution for Day %s, part %s: %s, computation took %s ms";
    protected String input;
    private String day;
    private Object solutionOne = null;
    private Object solutionTwo = null;

    protected SolutionBase(final String day) {
        this.day = day;
    }

    public final void setInput(final String input) {
        this.input = input;
    }

    protected final void setSolutionOne(final Object solutionOne) {
        this.solutionOne = solutionOne;
    }

    protected final void setSolutionTwo(final Object solutionTwo) {
        this.solutionTwo = solutionTwo;
    }

    public final void getPartOne() {
        final long startTime = System.nanoTime();
        solvePartOne();
        final long endTime = System.nanoTime();
        if (solutionOne != null) {
            LOG.log(String.format(TEMPLATE_SOL, day, 1, solutionOne.toString(), ((endTime - startTime) / 1000000)));
        }
    }

    public final void getPartTwo() {
        final long startTime = System.nanoTime();
        solvePartTwo();
        final long endTime = System.nanoTime();
        if (solutionTwo != null) {
            LOG.log(String.format(TEMPLATE_SOL, day, 2, solutionTwo.toString(), ((endTime - startTime) / 1000000)));
        }
    }

    protected abstract void solvePartOne();

    protected abstract void solvePartTwo();

    public void init() {
        //default implementation
    }
}
