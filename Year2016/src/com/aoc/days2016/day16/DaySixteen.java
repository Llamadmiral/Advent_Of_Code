package com.aoc.days2016.day16;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DaySixteen extends DayBase {

    private static final String DAY_NR = "Sixteen";

    public DaySixteen() {
        dayNr = DAY_NR;
        solution = new SolutionSixteen(DAY_NR);
        solution.setInput("01000100010010111");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSixteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}