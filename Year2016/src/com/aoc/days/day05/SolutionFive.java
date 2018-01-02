package com.aoc.days.day05;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFive extends DayBase {

    private static final String DAY_NR = "Five";

    public DayFive() {
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(Reader.readFromInput("5.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFive(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{}
}