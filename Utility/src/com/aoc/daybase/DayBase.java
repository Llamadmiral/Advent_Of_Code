package com.aoc.daybase;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
public abstract class DayBase {

    private static final String NOT_IMPLD = "Not yet implemented!";
    protected SolutionBase solution;
    protected String dayNr;

    private static void printNotImpl() {
        System.out.println(NOT_IMPLD);
    }

    public void tests1() {
        printNotImpl();
    }

    public void tests2() {
        printNotImpl();
    }

    public void finalSolution() {
        solution.getPartOne();
        solution.getPartTwo();
    }

    public String getDayNr() {
        return dayNr;
    }
}
