package com.aoc.days2015.day15;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFifteen extends DayBase {

    private static final String DAY_NR = "Fifteen";

    public DayFifteen() {
        dayNr = DAY_NR;
        solution = new SolutionFifteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/15.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFifteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n"
            + "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"};
    }
}