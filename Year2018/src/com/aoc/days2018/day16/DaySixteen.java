package com.aoc.days2018.day16;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySixteen extends DayBase {

    private static final String DAY_NR = "Sixteen";

    public DaySixteen() {
        dayNr = DAY_NR;
        solution = new SolutionSixteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/16.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSixteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Before: [3, 2, 1, 1]\n"
            + "9 2 1 2\n"
            + "After:  [3, 2, 2, 1]"};
    }
}