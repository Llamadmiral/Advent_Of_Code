package com.aoc.days2015.day01;

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
        //solution.setInput(Reader.readFromInput("2015/1.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionOne(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}