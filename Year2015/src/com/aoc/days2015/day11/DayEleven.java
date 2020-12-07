package com.aoc.days2015.day11;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DayEleven extends DayBase {

    private static final String DAY_NR = "Eleven";

    public DayEleven() {
        dayNr = DAY_NR;
        solution = new SolutionEleven(DAY_NR);
        solution.setInput("hepxcrrq");
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEleven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"hijklmmn", "abbceffg", "abbcegjk", "abcdffaa"};
    }
}