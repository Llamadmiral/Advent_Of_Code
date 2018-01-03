package com.aoc.days2016.day05;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayFive extends DayBase {

    private static final String DAY_NR = "Five";

    public DayFive() {
        dayNr = DAY_NR;
        solution = new SolutionFive(DAY_NR);
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFive(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}