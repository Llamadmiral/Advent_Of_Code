package com.aoc.days2015.day06;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySix extends DayBase {

    private static final String DAY_NR = "Six";

    public DaySix() {
        dayNr = DAY_NR;
        solution = new SolutionSix(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/6.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSix(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"turn on 0,0 through 999,999",
                "toggle 0,0 through 999,0",
                "turn on 499,499 through 500,500"};
    }
}