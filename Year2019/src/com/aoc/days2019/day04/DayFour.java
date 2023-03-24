package com.aoc.days2019.day04;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayFour extends DayBase {

    private static final String DAY_NR = "Four";

    public DayFour() {
        dayNr = DAY_NR;
        solution = new SolutionFour(DAY_NR);
        solution.setInput("138307-654504");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{
                "112233-112234",
                "123444-123445",
                "111122-111123"
        };
    }
}