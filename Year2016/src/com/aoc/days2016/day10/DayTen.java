package com.aoc.days2016.day10;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTen extends DayBase {

    private static final String DAY_NR = "Ten";

    public DayTen() {
        dayNr = DAY_NR;
        solution = new SolutionTen(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/10.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"value 5 goes to bot 2\n"
            + "bot 2 gives low to bot 1 and high to bot 0\n"
            + "value 3 goes to bot 1\n"
            + "bot 1 gives low to output 1 and high to bot 0\n"
            + "bot 0 gives low to output 2 and high to output 0\n"
            + "value 2 goes to bot 2"};
    }
}