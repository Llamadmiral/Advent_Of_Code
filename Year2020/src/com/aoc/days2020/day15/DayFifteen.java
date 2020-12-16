package com.aoc.days2020.day15;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayFifteen extends DayBase {

    private static final String DAY_NR = "Fifteen";

    public DayFifteen() {
        dayNr = DAY_NR;
        solution = new SolutionFifteen(DAY_NR);
        solution.setInput("1,0,15,2,10,13");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFifteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"0,3,6", "1,3,2", "2,1,3", "1,2,3", "2,3,1", "3,2,1", "3,1,2"};
    }
}