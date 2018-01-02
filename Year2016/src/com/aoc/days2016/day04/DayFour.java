package com.aoc.days2016.day04;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFour extends DayBase {

    private static final String DAY_NR = "Four";

    public DayFour() {
        dayNr = DAY_NR;
        solution = new SolutionFour(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/4.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"aaaaa-bbb-z-y-x-123[abxyz]",
                "a-b-c-d-e-f-g-h-987[abcde]",
                "not-a-real-room-404[oarel]",
                "totally-real-room-200[decoy]"
        };
    }
}