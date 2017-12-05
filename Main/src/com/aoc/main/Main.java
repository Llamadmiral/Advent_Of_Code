package com.aoc.main;

import com.aoc.daybase.DayBase;
import com.aoc.days.dayfive.DayFive;
import com.aoc.days.dayfour.DayFour;
import com.aoc.days.dayone.DayOne;
import com.aoc.days.daythree.DayThree;
import com.aoc.days.daytwo.DayTwo;

/**
 * @author maczaka.
 */
public class Main {

    private static final String START_LINE = "---------- Day %s ----------";
    private static final String END_LINE = "-----------------------------";

    public static void main(String[] args) {
        printDay(new DayThree());
    }

    private static void printDay(final DayBase base) {
        System.out.println(String.format(START_LINE, base.getDayNr()));
        base.finalSolution();
        System.out.println(END_LINE);

    }

    private static void solved() {
        final long startTime = System.nanoTime();
        printDay(new DayOne());
        printDay(new DayTwo());
        printDay(new DayThree());
        printDay(new DayFour());
        printDay(new DayFive());
        System.out.println(String.format("The whole computation took %s ms", (System.nanoTime() - startTime) / 100000));
    }
}
