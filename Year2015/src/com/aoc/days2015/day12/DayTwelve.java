package com.aoc.days2015.day12;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwelve extends DayBase {

    private static final String DAY_NR = "Twelve";

    public DayTwelve() {
        dayNr = DAY_NR;
        solution = new SolutionTwelve(DAY_NR);
        solution.setInput(Reader.readFromInput("2015/12.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwelve(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"[1,2,3]",
            "{\"a\":2,\"b\":4}",
            "[[[3]]]",
            "{\"a\":{\"b\":4},\"c\":-1}",
            "{\"a\":[-1,1]}",
            "[-1,{\"a\":1}]",
            "[1,{\"c\":\"red\",\"b\":2},3]",
            "{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}",
            "[1,\"red\",5]"};
    }
}