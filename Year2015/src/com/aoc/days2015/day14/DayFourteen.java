package com.aoc.days2015.day14;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFourteen extends DayBase {

    private static final String DAY_NR = "Fourteen";

    public DayFourteen() {
        dayNr = DAY_NR;
        solution = new SolutionFourteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/14.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFourteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n"
            + "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."};
    }
}