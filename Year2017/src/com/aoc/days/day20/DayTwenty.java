package com.aoc.days.day20;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayTwenty extends DayBase {
    private static final String DAY_NR = "Twenty";

    public DayTwenty() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionTwenty(DAY_NR);
        this.solution.setInput(Reader.readFromInput("20.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwenty(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>\n"
            + "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>"};
    }
}
