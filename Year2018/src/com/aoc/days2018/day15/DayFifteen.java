package com.aoc.days2018.day15;

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
        solution.setInput(Reader.readFromInput("2018/15.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFifteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Before: [3, 2, 1, 1]\n"
            + "9 2 1 2\n"
            + "After:  [3, 2, 2, 1]"};
    }
}