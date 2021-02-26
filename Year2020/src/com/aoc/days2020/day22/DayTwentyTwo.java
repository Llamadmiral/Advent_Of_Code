package com.aoc.days2020.day22;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyTwo extends DayBase {

    private static final String DAY_NR = "TwentyTwo";

    public DayTwentyTwo() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyTwo(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/22.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyTwo(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Player 1:\n"
            + "9\n"
            + "2\n"
            + "6\n"
            + "3\n"
            + "1\n"
            + "\n"
            + "Player 2:\n"
            + "5\n"
            + "8\n"
            + "4\n"
            + "7\n"
            + "10"};
    }
}