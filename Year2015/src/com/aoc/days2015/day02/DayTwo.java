package com.aoc.days2015.day02;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwo extends DayBase {

    private static final String DAY_NR = "Two";

    public DayTwo() {
        dayNr = DAY_NR;
        solution = new SolutionTwo(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/2.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwo(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}