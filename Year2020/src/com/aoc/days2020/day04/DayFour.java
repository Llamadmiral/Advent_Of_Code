package com.aoc.days2020.day04;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFour extends DayBase {

    private static final String DAY_NR = "Four";

    public DayFour() {
        dayNr = DAY_NR;
        solution = new SolutionFour(DAY_NR);
        //solution.setInput(Reader.readFromInput("2020/4.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}