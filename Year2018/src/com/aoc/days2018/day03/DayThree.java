package com.aoc.days2018.day03;

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
        solution = new SolutionThree(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/3.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"#1 @ 1,3: 4x4\n"
            + "#2 @ 3,1: 4x4\n"
            + "#3 @ 5,5: 2x2"};
    }
}