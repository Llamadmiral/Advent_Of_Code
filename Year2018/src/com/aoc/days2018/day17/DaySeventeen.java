package com.aoc.days2018.day17;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySeventeen extends DayBase {

    private static final String DAY_NR = "Seventeen";

    public DaySeventeen() {
        dayNr = DAY_NR;
        solution = new SolutionSeventeen(DAY_NR);
        //solution.setInput(Reader.readFromInput("2018/17.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeventeen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}