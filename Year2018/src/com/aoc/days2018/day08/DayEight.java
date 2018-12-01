package com.aoc.days2018.day08;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayEight extends DayBase {

    private static final String DAY_NR = "Eight";

    public DayEight() {
        dayNr = DAY_NR;
        solution = new SolutionEight(DAY_NR);
        //solution.setInput(Reader.readFromInput("2018/8.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEight(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}