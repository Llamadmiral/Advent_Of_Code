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
        return new String[]{"ADVENT", "A(1x5)BC", "(3x3)XYZ", "(6x1)(1x3)A", "X(8x2)(3x3)ABCY", "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN", "(27x12)(20x12)(13x14)(7x10)(1x12)A"};
    }
}