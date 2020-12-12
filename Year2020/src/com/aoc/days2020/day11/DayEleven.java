package com.aoc.days2020.day11;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayEleven extends DayBase {

    private static final String DAY_NR = "Eleven";

    public DayEleven() {
        dayNr = DAY_NR;
        solution = new SolutionEleven(DAY_NR);
        //solution.setInput(Reader.readFromInput("2020/11.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEleven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}