package com.aoc.solutionbase;

/**
 * @author maczaka.
 */
public abstract class SolutionBase {
    private static final String TEMPLATE_SOL = "Solution for Day %s, part %s: %s";
    private String day;
    private Object solutionOne = "NOT YET DONE";
    private Object solutionTwo = "NOT YET DONE";
    protected Object input;

    protected SolutionBase(final String day) {
        this.day = day;
    }

    protected void setSolutionOne(final Object solutionOne) {
        this.solutionOne = solutionOne;
    }

    protected void setSolutionTwo(final Object solutionTwo) {
        this.solutionTwo = solutionTwo;
    }

    public void getPartOne() {
        solvePartOne();
        System.out.println(String.format(TEMPLATE_SOL, day, 1, solutionOne.toString()));
    }

    public void getPartTwo() {
        solvePartTwo();
        System.out.println(String.format(TEMPLATE_SOL, day, 2, solutionTwo.toString()));
    }

    protected abstract void solvePartOne();

    protected abstract void solvePartTwo();
}
