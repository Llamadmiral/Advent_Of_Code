package com.aoc.days2018.day19;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayNineteen extends DayBase {

    private static final String DAY_NR = "Nineteen";

    public DayNineteen() {
        dayNr = DAY_NR;
        solution = new SolutionNineteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/19.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNineteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"#ip 0\n"
            + "seti 5 0 1\n"
            + "seti 6 0 2\n"
            + "addi 0 1 0\n"
            + "addr 1 2 3\n"
            + "setr 1 0 0\n"
            + "seti 8 0 4\n"
            + "seti 9 0 5"};
    }
}