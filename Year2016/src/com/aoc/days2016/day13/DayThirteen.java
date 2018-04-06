package com.aoc.days2016.day13;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayThirteen extends DayBase {

    private static final String DAY_NR = "Thirteen";

    public DayThirteen() {
        dayNr = DAY_NR;
        solution = new SolutionThirteen(DAY_NR);
        solution.setInput("1362x31,39");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThirteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"10x7,4"};
    }
}