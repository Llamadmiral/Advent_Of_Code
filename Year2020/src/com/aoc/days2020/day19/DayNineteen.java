package com.aoc.days2020.day19;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayNineteen extends DayBase {

    private static final String DAY_NR = "Nineteen";

    public DayNineteen() {
        dayNr = DAY_NR;
        solution = new SolutionNineteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/19.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNineteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"0: 4 1 5\n"
            + "1: 2 3 | 3 2\n"
            + "2: 4 4 | 5 5\n"
            + "3: 4 5 | 5 4\n"
            + "4: \"a\"\n"
            + "5: \"b\"\n"
            + "\n"
            + "ababbb\n"
            + "bababa\n"
            + "abbbab\n"
            + "aaabbb\n"
            + "aaaabbb"};
    }
}