package com.aoc.days.day05;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFive extends DayBase {
    private static final String DAY_NR = "Five";
    private static final String TEST_CASE = "0\n3\n0\n1\n-3\n";

    public DayFive() {
        dayNr = DAY_NR;
        solution = new SolutionFive(dayNr);
        solution.setInput(Reader.readFromInput("5.txt"));
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{TEST_CASE};
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFive(DAY_NR);
    }
}
