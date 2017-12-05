package com.aoc.solutionbase;

/**
 * @author maczaka.
 */
public abstract class SolutionBase {
    private static final String TEMPLATE_SOL = "Solution for Day %s, part %s: %s, Solution took %s ms";
    protected Object input;
    private String day;
    private Object solutionOne = "NOT YET DONE";
    private Object solutionTwo = "NOT YET DONE";

    protected SolutionBase(final String day) {
        this.day = day;
    }

    public void setInput(final Object input) {
        this.input = input;
    }

    protected void setSolutionOne(final Object solutionOne) {
        this.solutionOne = solutionOne;
    }

    protected void setSolutionTwo(final Object solutionTwo) {
        this.solutionTwo = solutionTwo;
    }

    public void getPartOne() {
        final long startTime = System.nanoTime();
        solvePartOne();
        final long endTime = System.nanoTime();
        System.out.println(String.format(TEMPLATE_SOL, day, 1, solutionOne.toString(), ((endTime - startTime) / 1000000)));
    }

    public void getPartTwo() {
        final long startTime = System.nanoTime();
        solvePartTwo();
        final long endTime = System.nanoTime();
        System.out.println(String.format(TEMPLATE_SOL, day, 2, solutionTwo.toString(), ((endTime - startTime) / 1000000)));
    }

    protected abstract void solvePartOne();

    protected abstract void solvePartTwo();
}
