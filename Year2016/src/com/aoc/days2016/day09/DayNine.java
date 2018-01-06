package com.aoc.days2016.day09;

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
        solution.setInput(Reader.readFromInput("2016/9.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNine(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"A(1x5)BC", "(3x3)XYZ", "(6x1)(1x3)A"};
    }
}