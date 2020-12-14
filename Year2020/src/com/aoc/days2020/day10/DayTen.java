package com.aoc.days2020.day10;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTen extends DayBase {

    private static final String DAY_NR = "Ten";

    public DayTen() {
        dayNr = DAY_NR;
        solution = new SolutionTen(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/10.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"16\n"
            + "10\n"
            + "15\n"
            + "5\n"
            + "1\n"
            + "11\n"
            + "7\n"
            + "19\n"
            + "6\n"
            + "12\n"
            + "4",

            "28\n"
                + "33\n"
                + "18\n"
                + "42\n"
                + "31\n"
                + "14\n"
                + "46\n"
                + "20\n"
                + "48\n"
                + "47\n"
                + "24\n"
                + "23\n"
                + "49\n"
                + "45\n"
                + "19\n"
                + "38\n"
                + "39\n"
                + "11\n"
                + "1\n"
                + "32\n"
                + "25\n"
                + "35\n"
                + "8\n"
                + "17\n"
                + "7\n"
                + "9\n"
                + "4\n"
                + "2\n"
                + "34\n"
                + "10\n"
                + "3"
        };
    }
}