package com.aoc.days2019.day09;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayNine extends DayBase {

    private static final String DAY_NR = "Nine";

    public DayNine() {
        dayNr = DAY_NR;
        solution = new SolutionNine(DAY_NR);
        //solution.setInput(Reader.readFromInput("2019/9.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNine(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}