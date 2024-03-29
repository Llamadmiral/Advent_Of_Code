package com.aoc.days2018.day15;

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
//        solution.setInput(Reader.readFromInput("2018/15.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFifteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"#########\n"
            + "#G..G..G#\n"
            + "#.......#\n"
            + "#.......#\n"
            + "#G..E..G#\n"
            + "#.......#\n"
            + "#.......#\n"
            + "#G..G..G#\n"
            + "#########"};
    }
}