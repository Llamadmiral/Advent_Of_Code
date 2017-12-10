package com.aoc.days.dayten;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayTen extends DayBase {

    private static final String DAY_NR = "Ten";

    public DayTen() {
        dayNr = DAY_NR;
        solution = new SolutionTen(dayNr);
        solution.setInput(Reader.readFromInput("10.txt"));
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"3,4,1,5", "", "AoC 2017", "1,2,3", "1,2,4"};
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTen(DAY_NR);
    }
}
