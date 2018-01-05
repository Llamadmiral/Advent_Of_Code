package com.aoc.days2016.day07;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySeven extends DayBase {

    private static final String DAY_NR = "Seven";

    public DaySeven() {
        dayNr = DAY_NR;
        solution = new SolutionSeven(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/7.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"abba[mnop]qrst", "abcd[bddb]xyyx", "aaaa[qwer]tyui", "ioxxoj[asdfgh]zxcvbn"};
    }
}