package com.aoc.days2020.day20;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwenty extends DayBase {

    private static final String DAY_NR = "Twenty";

    public DayTwenty() {
        dayNr = DAY_NR;
        solution = new SolutionTwenty(DAY_NR);
        //solution.setInput(Reader.readFromInput("2020/20.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwenty(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}