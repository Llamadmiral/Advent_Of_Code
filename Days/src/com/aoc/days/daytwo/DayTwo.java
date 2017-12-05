package com.aoc.days.daytwo;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
public class DayTwo extends DayBase {

    private static final List<String> TEST = new ArrayList<>();

    static {
        TEST.add("5\t1\t9\t5");
        TEST.add("7\t5\t3");
        TEST.add("2\t4\t6\t8");
    }


    public DayTwo() {
        final List<String> inputs = Reader.readFileIntoList("2.txt");
        dayNr = "Two";
        solution = new SolutionTwo(inputs, dayNr);
    }

    @Override
    public void tests1() {
        SolutionTwo test1 = new SolutionTwo(TEST, dayNr);
        test1.getPartOne();
    }
}
