package com.aoc.days.daysixteen;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DaySixteen extends DayBase {
    private static final String DAY_NR = "Sixteen";

    public DaySixteen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionSixteen(DAY_NR);
        this.solution.setInput(Reader.readFromInput("16.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSixteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"s1", "x3/4", "pe/b"};
    }
}
