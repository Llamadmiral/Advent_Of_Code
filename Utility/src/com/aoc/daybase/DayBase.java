package com.aoc.daybase;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.solutionbase.TestFactory;

/**
 * @author Llamadmiral.
 */
public abstract class DayBase {

    protected SolutionBase solution;
    protected String dayNr;

    public void test() {
        TestFactory.createAndRunTests(this, getTestInputs());
    }

    public void finalSolution() {
        solution.getPartOne();
        solution.getPartTwo();
    }

    public String getDayNr() {
        return dayNr;
    }

    public abstract SolutionBase getSolutionForTest();

    public String[] getTestInputs() {
        return new String[]{};
    }
}
