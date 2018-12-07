package com.aoc.days2018.day07;

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
        solution.setInput(Reader.readFromInput("2018/7.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Step C must be finished before step A can begin.\n"
            + "Step C must be finished before step F can begin.\n"
            + "Step A must be finished before step B can begin.\n"
            + "Step A must be finished before step D can begin.\n"
            + "Step B must be finished before step E can begin.\n"
            + "Step D must be finished before step E can begin.\n"
            + "Step F must be finished before step E can begin."};
    }
}