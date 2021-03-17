package com.aoc.days2020.day23;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayTwentyThree extends DayBase {

    private static final String DAY_NR = "TwentyThree";

    public DayTwentyThree() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyThree(DAY_NR);
        solution.setInput("318946572");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"389125467"};
    }
}