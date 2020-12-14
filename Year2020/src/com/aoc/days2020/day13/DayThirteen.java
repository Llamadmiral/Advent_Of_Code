package com.aoc.days2020.day13;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayThirteen extends DayBase {

    private static final String DAY_NR = "Thirteen";

    public DayThirteen() {
        dayNr = DAY_NR;
        solution = new SolutionThirteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/13.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThirteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"939\n"
            + "7,13,x,x,59,x,31,19", "0\n17,x,13,19", "0\n67,7,59,61", "0\n67,x,7,59,61", "0\n67,7,x,59,61", "0\n1789,37,47,1889"};
    }
}