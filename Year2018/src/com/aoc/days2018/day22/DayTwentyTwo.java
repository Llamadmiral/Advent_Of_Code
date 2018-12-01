package com.aoc.days2018.day22;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyTwo extends DayBase {

    private static final String DAY_NR = "TwentyTwo";

    public DayTwentyTwo() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyTwo(DAY_NR);
        //solution.setInput(Reader.readFromInput("2018/22.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyTwo(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}