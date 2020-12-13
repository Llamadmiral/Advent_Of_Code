package com.aoc.days2020.day09;

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
        solution.setInput(Reader.readFromInput("2020/9.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNine(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"35\n"
            + "20\n"
            + "15\n"
            + "25\n"
            + "47\n"
            + "40\n"
            + "62\n"
            + "55\n"
            + "65\n"
            + "95\n"
            + "102\n"
            + "117\n"
            + "150\n"
            + "182\n"
            + "127\n"
            + "219\n"
            + "299\n"
            + "277\n"
            + "309\n"
            + "576"};
    }
}