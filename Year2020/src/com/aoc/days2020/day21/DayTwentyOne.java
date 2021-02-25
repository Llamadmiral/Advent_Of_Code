package com.aoc.days2020.day21;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyOne extends DayBase {

    private static final String DAY_NR = "TwentyOne";

    public DayTwentyOne() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyOne(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/21.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyOne(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"mxmxvkd kfcds sqjhc nhms (contains dairy, fish)\n"
            + "trh fvjkl sbzzf mxmxvkd (contains dairy)\n"
            + "sqjhc fvjkl (contains soy)\n"
            + "sqjhc mxmxvkd sbzzf (contains fish)"};
    }
}