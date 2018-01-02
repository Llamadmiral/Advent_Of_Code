package com.aoc.yearbase;

import com.aoc.daybase.DayBase;
import com.aoc.util.log.Logger;

/**
 * I'm not sure about this whole holder-class thing, but eh.
 *
 * @author maczaka.
 */
public abstract class YearBase {
    private static final String START_LINE = "---------- Day %s ----------";
    private static final String END_LINE = "-----------------------------";
    private static final Logger LOG = new Logger();

    protected int year;

    protected static void printDay(final DayBase base) {
        LOG.log(String.format(START_LINE, base.getDayNr()));
        base.finalSolution();
        LOG.log(END_LINE);
    }

    public void printYear() {
        final long startTime = System.nanoTime();
        LOG.log(String.format("---------- Day %s ----------", year));
        printDays();
        LOG.log("------------------------------");
        LOG.log(String.format("The whole computation took %s ms", (System.nanoTime() - startTime) / 1000000));
    }

    protected abstract void printDays();
}
