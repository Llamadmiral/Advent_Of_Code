package com.aoc.main;

import com.aoc.daybase.DayBase;
import com.aoc.days.dayfour.DayFour;
import com.aoc.days.dayone.DayOne;
import com.aoc.days.daytwo.DayTwo;

/**
 * @author maczaka.
 */
public class main {

    private static final String START_LINE = "---------- Day %s ----------";
    private static final String END_LINE = "-----------------------------";

    public static void main(String[] args) {
        DayFour four = new DayFour();
        four.tests2();
    }

    private static void printDay(final DayBase base) {
        System.out.println(String.format(START_LINE, base.getDayNr()));
        base.finalSolution();
        System.out.println(END_LINE);

    }

    public static void solved(){
        printDay(new DayOne());
        printDay(new DayTwo());
    }
}
