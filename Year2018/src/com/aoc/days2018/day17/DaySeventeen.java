package com.aoc.days2018.day17;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySeventeen extends DayBase {

    private static final String DAY_NR = "Seventeen";

    public DaySeventeen() {
        dayNr = DAY_NR;
        solution = new SolutionSeventeen(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/17.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSeventeen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{
            /*"x=495, y=2..7\n"
                + "y=7, x=495..501\n"
                + "x=501, y=3..7\n"
                + "x=498, y=2..4\n"
                + "x=506, y=1..2\n"
                + "x=498, y=10..13\n"
                + "x=504, y=10..13\n"
                + "y=13, x=498..504",*/
            "x=495, y=2..15\n"
                + "y=15, x=495..515\n"
                + "x=515, y=2..15\n"
                + "x=503, y=10..12\n"
                + "y=12, x=503..505\n"
                + "x=505, y=10..12"};
    }
}