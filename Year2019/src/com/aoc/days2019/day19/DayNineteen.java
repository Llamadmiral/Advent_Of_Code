package com.aoc.days2019.day19;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayNineteen extends DayBase {

    private static final String DAY_NR = "Nineteen";

    public DayNineteen() {
        dayNr = DAY_NR;
        solution = new SolutionNineteen(DAY_NR);
        //solution.setInput(Reader.readFromInput("2019/19.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNineteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}