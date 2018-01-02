package com.aoc.days2016.day08;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayEight extends DayBase {

    private static final String DAY_NR = "Eight";

    public DayEight() {
        dayNr = DAY_NR;
        solution = new SolutionEight(DAY_NR);
        //solution.setInput(Reader.readFromInput("2016/8.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEight(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}