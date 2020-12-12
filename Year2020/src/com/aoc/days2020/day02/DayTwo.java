package com.aoc.days2020.day02;

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
        solution.setInput(Reader.readFromInput("2020/2.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwo(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"1-3 a: abcde\n"
            + "1-3 b: cdefg\n"
            + "2-9 c: ccccccccc"};
    }
}