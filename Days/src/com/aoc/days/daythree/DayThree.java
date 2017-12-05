package com.aoc.days.daythree;

import com.aoc.daybase.DayBase;

/**
 * @author maczaka
 */
public class DayThree extends DayBase {

    private static final String DAY_NUM = "Three";

    public DayThree() {
        dayNr = DAY_NUM;
        solution = new SolutionThree(dayNr);
    }

    @Override
    public void tests1() {
        SolutionThree test1 = new SolutionThree(DAY_NUM, 1);
        SolutionThree test2 = new SolutionThree(DAY_NUM, 12);
        SolutionThree test3 = new SolutionThree(DAY_NUM, 23);
        SolutionThree test4 = new SolutionThree(DAY_NUM, 1024);
        test1.getPartOne();
        test2.getPartOne();
        test3.getPartOne();
        test4.getPartOne();
    }
}
