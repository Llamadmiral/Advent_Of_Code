package com.aoc.days2020.day16;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySixteen extends DayBase {

    private static final String DAY_NR = "Sixteen";

    public DaySixteen() {
        dayNr = DAY_NR;
        solution = new SolutionSixteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/16.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSixteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"class: 1-3 or 5-7\n"
            + "row: 6-11 or 33-44\n"
            + "seat: 13-40 or 45-50\n"
            + "\n"
            + "your ticket:\n"
            + "7,1,14\n"
            + "\n"
            + "nearby tickets:\n"
            + "7,3,47\n"
            + "40,4,50\n"
            + "55,2,20\n"
            + "38,6,12"};
    }
}