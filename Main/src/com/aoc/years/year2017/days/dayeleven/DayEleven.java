package com.aoc.years.year2017.days.dayeleven;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayEleven extends DayBase {

    private static final String DAY_NR = "Eleven";

    public DayEleven() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionEleven(DAY_NR);
        this.solution.setInput(Reader.readFromInput("11.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEleven(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{
            "ne,ne,ne",
            "ne,ne,sw,sw",
            "ne,ne,s,s",
            "se,sw,se,sw,sw",
            "s,s,s,se,ne,se,n,n,n",
            "n,ne",
            "ne,nw,ne,nw,ne,nw"
        };
    }

    //
}
