package com.aoc.days2016.day24;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayTwentyFour extends DayBase {

    private static final String DAY_NR = "TwentyFour";

    public DayTwentyFour() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyFour(DAY_NR);
        //solution.setInput(Reader.readFromInput("2016/24.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}