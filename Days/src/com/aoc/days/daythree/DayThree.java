package com.aoc.days.daythree;

import com.aoc.daybase.DayBase;

/**
 * @author Llamadmiral
 */
public class DayThree extends DayBase {

    private static final String DAY_NUM = "Three";

    public DayThree() {
        dayNr = DAY_NUM;
        solution = new SolutionThree(dayNr);
        solution.setInput(289326);
    }

    @Override
    public void tests1() {
        SolutionThree test1 = new SolutionThree(DAY_NUM);
        test1.setInput(1);
        SolutionThree test2 = new SolutionThree(DAY_NUM);
        test2.setInput(12);
        SolutionThree test3 = new SolutionThree(DAY_NUM);
        test3.setInput(23);
        SolutionThree test4 = new SolutionThree(DAY_NUM);
        test4.setInput(1024);
        test1.getPartOne();
        test2.getPartOne();
        test3.getPartOne();
        test4.getPartOne();
    }

    @Override
    public void tests2() {
        SolutionThree test1 = new SolutionThree(DAY_NUM);
        test1.setInput(1);
        SolutionThree test2 = new SolutionThree(DAY_NUM);
        test2.setInput(12);
        SolutionThree test3 = new SolutionThree(DAY_NUM);
        test3.setInput(23);
        SolutionThree test4 = new SolutionThree(DAY_NUM);
        test4.setInput(1024);
        test1.getPartTwo();
        test2.getPartTwo();
        test3.getPartTwo();
        test4.getPartTwo();
    }
}
