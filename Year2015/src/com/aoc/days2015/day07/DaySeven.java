package com.aoc.days2015.day07;

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
        solution = new SolutionSeven(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/7.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"123 -> x\n"
            + "456 -> y\n"
            + "x AND y -> d\n"
            + "x OR y -> e\n"
            + "x LSHIFT 2 -> f\n"
            + "y RSHIFT 2 -> g\n"
            + "NOT x -> h\n"
            + "NOT y -> i"};
    }
}