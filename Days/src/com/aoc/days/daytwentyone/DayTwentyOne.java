package com.aoc.days.daytwentyone;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayTwentyOne extends DayBase {

    private static final String DAY_NR = "TwentyOne";

    public DayTwentyOne() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionTwentyOne(DAY_NR);
        this.solution.setInput(Reader.readFromInput("21.txt"));
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"../.# => ##./#../...\n" +
                ".#./..#/### => #..#/..../..../#..#"};
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyOne(DAY_NR);
    }
}
