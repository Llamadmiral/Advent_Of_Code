package com.aoc.days.day08;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayEight extends DayBase {

    private static final String DAY_NR = "Eight";

    public DayEight() {
        dayNr = DAY_NR;
        solution = new SolutionEight(DAY_NR);
        solution.setInput(Reader.readFromInput("8.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEight(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"b inc 5 if a > 1\n" +
            "a inc 1 if b < 5\n" +
            "c dec -10 if a >= 1\n" +
            "c inc -20 if c == 10"};
    }
}
