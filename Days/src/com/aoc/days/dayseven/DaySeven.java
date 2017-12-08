package com.aoc.days.dayseven;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DaySeven extends DayBase {

    private static final String DAY_NR = "Seven";

    public DaySeven() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionSeven(DAY_NR);
        this.solution.setInput(Reader.readFileIntoList("7.txt"));
    }

    @Override
    public void tests1() {
        final SolutionSeven solutionSeven = new SolutionSeven(DAY_NR);
        solutionSeven.setInput(Reader.readFileIntoList("7.txt"));
        solutionSeven.getPartOne();
    }
}
