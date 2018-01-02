package com.aoc.days2017.day13;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayThirteen extends DayBase {

    private static final String DAY_NR = "Thirteen";

    public DayThirteen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionThirteen(DAY_NR);
        this.solution.setInput(Reader.readFromInput("2017/13.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThirteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"0: 3\n1: 2\n4: 4\n6: 4"};
    }
}
