package com.aoc.days2017.day03;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral
 */
public class DayThree extends DayBase {

    private static final String DAY_NR = "Three";

    public DayThree() {
        dayNr = DAY_NR;
        solution = new SolutionThree(dayNr);
        solution.setInput("289326");
    }


    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"23", "1024"};
    }
}
