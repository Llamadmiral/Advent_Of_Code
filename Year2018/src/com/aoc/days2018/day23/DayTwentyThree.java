package com.aoc.days2018.day23;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyThree extends DayBase {

    private static final String DAY_NR = "TwentyThree";

    public DayTwentyThree() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyThree(DAY_NR);
        //solution.setInput(Reader.readFromInput("2018/23.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}