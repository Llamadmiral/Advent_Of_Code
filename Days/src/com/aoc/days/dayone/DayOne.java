package com.aoc.days.dayone;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayOne extends DayBase {

    private static final String DAY_NR = "One";

    public DayOne() {
        final String input = Reader.readFromInput("1.txt");
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(input);
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionOne(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"1122", "1111", "1234", "91212129", "1212", "1221", "123425", "123123", "12131415"};
    }
}
