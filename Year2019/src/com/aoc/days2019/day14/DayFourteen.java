package com.aoc.days2019.day14;

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
        //solution.setInput(Reader.readFromInput("2019/14.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFourteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}