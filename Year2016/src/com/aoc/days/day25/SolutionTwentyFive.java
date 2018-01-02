package com.aoc.days.day25;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyFive extends DayBase {

    private static final String DAY_NR = "TwentyFive";

    public DayTwentyFive() {
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(Reader.readFromInput("25.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFive(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{}
}