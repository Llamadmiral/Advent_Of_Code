package com.aoc.days.day19;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayNineteen extends DayBase {
    private static final String DAY_NR = "Nineteen";

    public DayNineteen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionNineteen(DAY_NR);
        this.solution.setInput(Reader.readFromInput("19.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNineteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"     |          \n" +
            "     |  +--+    \n" +
            "     A  |  C    \n" +
            " F---|----E|--+ \n" +
            "     |  |  |  D \n" +
            "     +B-+  +--+ \n"};
    }
}
