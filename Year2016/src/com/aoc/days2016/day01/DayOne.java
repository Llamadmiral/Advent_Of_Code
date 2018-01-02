package com.aoc.days2016.day01;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayOne extends DayBase {

    private static final String DAY_NR = "One";

    public DayOne() {
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/1.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionOne(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"R2, L3", "R2, R2, R2", "R5, L5, R5, R3"};
    }
}