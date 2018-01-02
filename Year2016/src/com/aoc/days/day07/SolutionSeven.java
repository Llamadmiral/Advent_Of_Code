package com.aoc.days.day07;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySeven extends DayBase {

    private static final String DAY_NR = "Seven";

    public DaySeven() {
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(Reader.readFromInput("7.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{}
}