package com.aoc.days2019.day02;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwo extends DayBase {

    private static final String DAY_NR = "Two";

    public DayTwo() {
        dayNr = DAY_NR;
        solution = new SolutionTwo(DAY_NR);
        solution.setInput(Reader.readFromInput("2019/2.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwo(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"1,0,0,0,99", "2,3,0,3,99", "2,4,4,5,99,0", "1,1,1,4,99,5,6,0,99"};
    }
}