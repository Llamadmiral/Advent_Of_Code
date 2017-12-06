package com.aoc.days.dayfive;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFive extends DayBase {
    private static final String TEST_CASE = "0\n3\n0\n1\n-3\n";

    public DayFive() {
        dayNr = "Five";
        solution = new SolutionFive(dayNr);
        solution.setInput(Reader.readFromInput("5.txt"));
    }

    @Override
    public void tests1() {
        final SolutionFive solutionFive = new SolutionFive("Five");
        solutionFive.setInput(TEST_CASE);
        solutionFive.getPartOne();
    }

    @Override
    public void tests2() {
        final SolutionFive solutionFive = new SolutionFive("Five");
        solutionFive.setInput(TEST_CASE);
        solutionFive.getPartTwo();
    }
}
