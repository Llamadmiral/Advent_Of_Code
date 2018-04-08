package com.aoc.days2016.day15;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFifteen extends DayBase {

    private static final String DAY_NR = "Fifteen";

    public DayFifteen() {
        dayNr = DAY_NR;
        solution = new SolutionFifteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/15.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFifteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Disc #1 has 5 positions; at time=0, it is at position 4.\n" +
                "Disc #2 has 2 positions; at time=0, it is at position 1."};
    }
}