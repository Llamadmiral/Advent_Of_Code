package com.aoc.days.day03;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayThree extends DayBase {

    private static final String DAY_NR = "Three";

    public DayThree() {
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(Reader.readFromInput("3.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{}
}