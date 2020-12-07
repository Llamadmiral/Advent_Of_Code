package com.aoc.days2015.day10;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayTen extends DayBase {

    private static final String DAY_NR = "Ten";

    public DayTen() {
        dayNr = DAY_NR;
        solution = new SolutionTen(DAY_NR);
        solution.setInput("1113122113");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"1"};
    }
}