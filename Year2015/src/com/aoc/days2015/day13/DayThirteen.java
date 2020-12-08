package com.aoc.days2015.day13;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayThirteen extends DayBase {

    private static final String DAY_NR = "Thirteen";

    public DayThirteen() {
        dayNr = DAY_NR;
        solution = new SolutionThirteen(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/13.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThirteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Alice would gain 54 happiness units by sitting next to Bob.\n"
            + "Alice would lose 79 happiness units by sitting next to Carol.\n"
            + "Alice would lose 2 happiness units by sitting next to David.\n"
            + "Bob would gain 83 happiness units by sitting next to Alice.\n"
            + "Bob would lose 7 happiness units by sitting next to Carol.\n"
            + "Bob would lose 63 happiness units by sitting next to David.\n"
            + "Carol would lose 62 happiness units by sitting next to Alice.\n"
            + "Carol would gain 60 happiness units by sitting next to Bob.\n"
            + "Carol would gain 55 happiness units by sitting next to David.\n"
            + "David would gain 46 happiness units by sitting next to Alice.\n"
            + "David would lose 7 happiness units by sitting next to Bob.\n"
            + "David would gain 41 happiness units by sitting next to Carol."};
    }
}