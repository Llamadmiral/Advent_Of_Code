package com.aoc.days2015.day24;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyFour extends DayBase {

    private static final String DAY_NR = "TwentyFour";

    public DayTwentyFour() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyFour(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/24.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"1\n2\n3\n4\n5\n7\n8\n9\n10\n11"};
    }
}