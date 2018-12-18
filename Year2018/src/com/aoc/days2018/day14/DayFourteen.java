package com.aoc.days2018.day14;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayFourteen extends DayBase {

    private static final String DAY_NR = "Fourteen";

    public DayFourteen() {
        dayNr = DAY_NR;
        solution = new SolutionFourteen(DAY_NR);
        solution.setInput("637061");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFourteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"51589", "01245", "92510", "59414"};
    }
}