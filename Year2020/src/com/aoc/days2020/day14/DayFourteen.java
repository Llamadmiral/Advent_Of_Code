package com.aoc.days2020.day14;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFourteen extends DayBase {

    private static final String DAY_NR = "Fourteen";

    public DayFourteen() {
        dayNr = DAY_NR;
        solution = new SolutionFourteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/14.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFourteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{
            "mask = 000000000000000000000000000000X1001X\n"
                + "mem[42] = 100\n"
                + "mask = 00000000000000000000000000000000X0XX\n"
                + "mem[26] = 1"};
    }
}