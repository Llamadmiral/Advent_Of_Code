package com.aoc.days.daytwentytwo;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayTwentyTwo extends DayBase {

    private static final String DAY_NR = "TwentyTwo";

    public DayTwentyTwo() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionTwentyTwo(DAY_NR);
        this.solution.setInput(Reader.readFromInput("22.txt"));
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"..#\n"
            + "#..\n"
            + "..."};
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyTwo(DAY_NR);
    }
}
