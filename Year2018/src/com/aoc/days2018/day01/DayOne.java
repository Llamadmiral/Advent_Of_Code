package com.aoc.days2018.day01;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayOne extends DayBase {

    private static final String DAY_NR = "One";

    public DayOne() {
        dayNr = DAY_NR;
        solution = new SolutionOne(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/1.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionOne(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"+1\n-1",
                "+3\n+3\n+4\n-2\n-4",
                "-6\n+3\n+8\n+5\n-6",
                "+7\n+7\n-2\n-7\n-4"
        };
    }
}