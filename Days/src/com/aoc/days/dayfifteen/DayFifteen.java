package com.aoc.days.dayfifteen;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
public class DayFifteen extends DayBase {

    private static final String DAY_NR = "Fifteen";

    public DayFifteen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionFifteen(DAY_NR);
        this.solution.setInput("634, 301");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFifteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"65, 8921"};
    }
}
