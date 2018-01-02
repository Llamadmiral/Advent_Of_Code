package com.aoc.yearbase;

import com.aoc.daybase.DayBase;
import com.aoc.util.log.Logger;

/**
 * I'm not sure about this whole holder-class thing, but eh.
 *
 * @author maczaka.
 */
public abstract class YearBase {
    private static final String START_LINE = "\t---------- Day %s ----------";
    private static final int START_LINE_LENGTH = START_LINE.length() - 3;
    private static final Logger LOG = new Logger();

    protected int year;

    protected static void printDay(final DayBase base) {
        final String dayNr = base.getDayNr();
        LOG.log(String.format(START_LINE, dayNr));
        base.finalSolution();
        LOG.log("\t" + new String(new char[START_LINE_LENGTH + dayNr.length()]).replaceAll("\0", "-"));
    }

    public static void testDay(final DayBase base) {
        base.test();
    }

    public void testDay() {
        //no test
    }

    public void printYear() {
        final long startTime = System.nanoTime();
        LOG.log(String.format("---------- Year %s ----------", year));
        printDays();
        LOG.log("------------------------------");
        LOG.log(String.format("The whole computation took %s ms", (System.nanoTime() - startTime) / 1000000));
    }

    protected abstract void printDays();
}
