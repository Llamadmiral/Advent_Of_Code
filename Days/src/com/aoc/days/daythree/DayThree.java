package com.aoc.days.daythree;

import com.aoc.daybase.DayBase;

/**
 * @author maczaka
 */
public class DayThree extends DayBase {

    public DayThree() {
        dayNr = "Three";
        solution = new SolutionThree(dayNr);
    }

    @Override
    public void tests1() {
        SolutionThree test1 = new SolutionThree("Three", 1);
        SolutionThree test2 = new SolutionThree("Three", 12);
        SolutionThree test3 = new SolutionThree("Three", 23);
        SolutionThree test4 = new SolutionThree("Three", 1024);
        test1.getPartOne();
        test2.getPartOne();
        test3.getPartOne();
        test4.getPartOne();
    }
}
