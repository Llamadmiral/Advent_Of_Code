package com.aoc.days2017.day14;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka
 */
public class DayFourteen extends DayBase {

    private static final String DAY_NR = "Fourteen";

    public DayFourteen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionFourteen(DAY_NR);
        this.solution.setInput("hfdlxzhv");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFourteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"flqrgnkx"};
    }
}
