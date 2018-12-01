package com.aoc.days2018.day21;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyOne extends DayBase {

    private static final String DAY_NR = "TwentyOne";

    public DayTwentyOne() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyOne(DAY_NR);
        //solution.setInput(Reader.readFromInput("2018/21.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyOne(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}