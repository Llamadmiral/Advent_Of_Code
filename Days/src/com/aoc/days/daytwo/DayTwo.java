package com.aoc.days.daytwo;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwo extends DayBase {

    private static final String DAY_NR = "Two";

    public DayTwo() {
        dayNr = DAY_NR;
        solution = new SolutionTwo(dayNr);
        solution.setInput(Reader.readFromInput("2.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwo(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"};
    }
}
