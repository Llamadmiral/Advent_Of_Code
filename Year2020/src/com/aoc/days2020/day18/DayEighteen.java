package com.aoc.days2020.day18;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayEighteen extends DayBase {

    private static final String DAY_NR = "Eighteen";

    public DayEighteen() {
        dayNr = DAY_NR;
        solution = new SolutionEighteen(DAY_NR);
        //solution.setInput(Reader.readFromInput("2020/18.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEighteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}