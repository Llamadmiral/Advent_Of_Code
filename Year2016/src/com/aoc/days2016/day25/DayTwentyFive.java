package com.aoc.days2016.day25;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayTwentyFive extends DayBase {

    private static final String DAY_NR = "TwentyFive";

    public DayTwentyFive() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyFive(DAY_NR);
        //solution.setInput(Reader.readFromInput("2016/25.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFive(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}