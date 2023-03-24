package com.aoc.days2019.day03;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayThree extends DayBase {

    private static final String DAY_NR = "Three";

    public DayThree() {
        dayNr = DAY_NR;
        solution = new SolutionThree(DAY_NR);
        solution.setInput(Reader.readFromInput("2019/3.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionThree(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{
                "R75,D30,R83,U83,L12,D49,R71,U7,L72\n"
                        + "U62,R66,U55,R34,D71,R55,D58,R83",
                "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\n"
                        + "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        };
    }
}