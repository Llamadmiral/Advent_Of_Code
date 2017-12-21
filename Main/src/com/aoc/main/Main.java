package com.aoc.main;

import com.aoc.daybase.DayBase;
import com.aoc.days.dayeight.DayEight;
import com.aoc.days.dayeighteen.DayEighteen;
import com.aoc.days.dayeleven.DayEleven;
import com.aoc.days.dayfifteen.DayFifteen;
import com.aoc.days.dayfive.DayFive;
import com.aoc.days.dayfour.DayFour;
import com.aoc.days.dayfourteen.DayFourteen;
import com.aoc.days.daynine.DayNine;
import com.aoc.days.dayone.DayOne;
import com.aoc.days.dayseventeen.DaySeventeen;
import com.aoc.days.daysix.DaySix;
import com.aoc.days.daysixteen.DaySixteen;
import com.aoc.days.dayten.DayTen;
import com.aoc.days.daythirteen.DayThirteen;
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
        printDay(new DayEighteen());
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
        printDay(new DayEleven());
        printDay(new DayTwelve());
        printDay(new DayThirteen());
        printDay(new DayFourteen());
        printDay(new DayFifteen());
        printDay(new DaySixteen());
        printDay(new DaySeventeen());
        LOG.log(String.format("The whole computation took %s ms", (System.nanoTime() - startTime) / 100000));
    }

    private static void test(final DayBase day) {
        day.test();
    }
}
