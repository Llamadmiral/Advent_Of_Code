package com.aoc.years.year2017.days.dayeighteen;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayEighteen extends DayBase {

    private static final String DAY_NR = "Eighteen";

    public DayEighteen() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionEighteen(DAY_NR);
        this.solution.setInput(Reader.readFromInput("18.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionEighteen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"snd 1\n" +
                "snd 2\n" +
                "snd p\n" +
                "rcv a\n" +
                "rcv b\n" +
                "rcv c\n" +
                "rcv d",
                "set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a -2"};
    }
}
