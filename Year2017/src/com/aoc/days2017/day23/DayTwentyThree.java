package com.aoc.days2017.day23;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayTwentyThree extends DayBase {

    private static final String DAY_NR = "TwentyThree";

    public DayTwentyThree() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionTwentyThree(DAY_NR);
        this.solution.setInput(Reader.readFromInput("2017/23.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyThree(DAY_NR);
    }
}
