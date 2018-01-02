package com.aoc.days2017.day04;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFour extends DayBase {

    private static final String DAY_NR = "Four";

    public DayFour() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionFour(dayNr, Reader.readFromInput("2017/4.txt"));

    }

    @Override
    public String getDayNr() {
        return DAY_NR;
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"aa bb cc dd ee",
            "aa bb cc dd aa",
            "aa bb cc dd aaa",
            "abcde fghij",
            "abcde xyz ecdab",
            "a ab abc abd abf abj",
            "iiii oiii ooii oooi oooo",
            "oiii ioii iioi iiio is"
        };
    }
}
