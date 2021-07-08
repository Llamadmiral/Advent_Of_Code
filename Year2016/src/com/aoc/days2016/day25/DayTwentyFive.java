package com.aoc.days2016.day25;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyFive extends DayBase {

    private static final String DAY_NR = "TwentyFive";

    public DayTwentyFive() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyFive(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/25.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFive(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"cpy 41 a\n" +
                "inc a\n" +
                "inc a\n" +
                "dec a\n" +
                "jnz a 2\n" +
                "dec a"};
    }
}