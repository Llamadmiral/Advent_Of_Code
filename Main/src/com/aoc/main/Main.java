package com.aoc.main;

import com.aoc.daybase.DayBase;
import com.aoc.days.dayeight.DayEight;
import com.aoc.days.dayfive.DayFive;
import com.aoc.days.dayfour.DayFour;
import com.aoc.days.daynine.DayNine;
import com.aoc.days.dayone.DayOne;
import com.aoc.days.daysix.DaySix;
import com.aoc.days.dayten.DayTen;
import com.aoc.days.daythree.DayThree;
import com.aoc.days.daytwelve.DayTwelve;
import com.aoc.days.daytwo.DayTwo;
import com.aoc.util.log.Logger;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger(Main.class);

    private static final String START_LINE = "---------- Day %s ----------";
    private static final String END_LINE = "-----------------------------";

    public static void main(String[] args) {
        solved();
    }

    private static void printDay(final DayBase base) {
        LOG.log(String.format(START_LINE, base.getDayNr()));
        base.finalSolution();
        LOG.log(END_LINE);
    }

    private static void solved() {
        final long startTime = System.nanoTime();
        printDay(new DayOne());
        printDay(new DayTwo());
        printDay(new DayThree());
        printDay(new DayFour());
        printDay(new DayFive());
        printDay(new DaySix());
        printDay(new DayEight());
        printDay(new DayNine());
        printDay(new DayTen());
        printDay(new DayTwelve());
        LOG.log(String.format("The whole computation took %s ms", (System.nanoTime() - startTime) / 100000));
    }
}
