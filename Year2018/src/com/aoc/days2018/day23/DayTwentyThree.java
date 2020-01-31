package com.aoc.days2018.day23;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyThree extends DayBase {

    private static final String DAY_NR = "TwentyThree";

    public DayTwentyThree() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyThree(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/23.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{
              "pos=<10,12,12>, r=2\n"
            + "pos=<12,14,12>, r=2\n"
            + "pos=<16,12,12>, r=4\n"
            + "pos=<14,14,14>, r=6\n"
            + "pos=<50,50,50>, r=200\n"
            + "pos=<10,10,10>, r=5"};
    }
}