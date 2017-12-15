package com.aoc.days.dayeleven;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
public class DayEleven extends DayBase {

    private static final String DAY_NR = "Eleven";

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEleven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"ne,ne,ne", "ne,ne,sw,sw", "ne,ne,s,s", "se,sw,se,sw,sw"};
    }
}
