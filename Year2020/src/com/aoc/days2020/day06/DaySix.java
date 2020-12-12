package com.aoc.days2020.day06;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySix extends DayBase {

    private static final String DAY_NR = "Six";

    public DaySix() {
        dayNr = DAY_NR;
        solution = new SolutionSix(DAY_NR);
        //solution.setInput(Reader.readFromInput("2020/6.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSix(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}