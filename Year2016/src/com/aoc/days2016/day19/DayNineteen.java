package com.aoc.days2016.day19;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayNineteen extends DayBase {

    private static final String DAY_NR = "Nineteen";

    public DayNineteen() {
        dayNr = DAY_NR;
        solution = new SolutionNineteen(DAY_NR);
        //solution.setInput(Reader.readFromInput("2016/19.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNineteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}