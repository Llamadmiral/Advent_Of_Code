package com.aoc.days2017.day24;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayTwentyFour extends DayBase {

    private static final String DAY_NR = "TwentyFour";

    public DayTwentyFour() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionTwentyFour(DAY_NR);
        this.solution.setInput(Reader.readFromInput("2017/24.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"0/2\n"
            + "2/2\n"
            + "2/3\n"
            + "3/4\n"
            + "3/5\n"
            + "0/1\n"
            + "10/1\n"
            + "9/10"};
    }
}
