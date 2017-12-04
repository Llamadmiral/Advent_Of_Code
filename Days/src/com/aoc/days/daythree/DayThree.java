package com.aoc.days.daythree;

import com.aoc.daybase.DayBase;

/**
 * @author maczaka
 */
public class DayThree extends DayBase {

    public DayThree() {
        dayNr = "Three";
        solution = new Solution(dayNr);
    }

    @Override
    public void tests1() {
        Solution test1 = new Solution("Three", 1);
        Solution test2 = new Solution("Three", 12);
        Solution test3 = new Solution("Three", 23);
        Solution test4 = new Solution("Three", 1024);
        test1.getPartOne();
        test2.getPartOne();
        test3.getPartOne();
        test4.getPartOne();
    }
}
