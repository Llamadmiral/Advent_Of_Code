package com.aoc.days2020.day08;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayEight extends DayBase {

    private static final String DAY_NR = "Eight";

    public DayEight() {
        dayNr = DAY_NR;
        solution = new SolutionEight(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/8.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEight(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"nop +0\n"
            + "acc +1\n"
            + "jmp +4\n"
            + "acc +3\n"
            + "jmp -3\n"
            + "acc -99\n"
            + "acc +1\n"
            + "jmp -4\n"
            + "acc +6"};
    }
}