package com.aoc.daybase;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.solutionbase.TestFactory;
import com.aoc.util.log.Logger;

/**
 * @author Llamadmiral.
 */
public abstract class DayBase {

    private static final Logger LOG = new Logger(DayBase.class);

    private static final String NOT_IMPLD = "Not yet implemented!";
    protected SolutionBase solution;
    protected String dayNr;

    private static void printNotImpl() {
        LOG.log(NOT_IMPLD);
    }

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
