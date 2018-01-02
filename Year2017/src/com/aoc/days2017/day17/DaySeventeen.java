package com.aoc.days2017.day17;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
public class DaySeventeen extends DayBase {

    private static final String DAY_NR = "Seventeen";

    public DaySeventeen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionSeventeen(DAY_NR);
        this.solution.setInput("363");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeventeen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"3"};
    }
}
