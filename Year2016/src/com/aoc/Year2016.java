package com.aoc;

import com.aoc.days2016.day01.DayOne;
import com.aoc.days2016.day02.DayTwo;
import com.aoc.days2016.day03.DayThree;
import com.aoc.days2016.day04.DayFour;
import com.aoc.days2016.day05.DayFive;
import com.aoc.days2016.day06.DaySix;
import com.aoc.days2016.day07.DaySeven;
import com.aoc.days2016.day08.DayEight;
import com.aoc.days2016.day09.DayNine;
import com.aoc.days2016.day10.DayTen;
import com.aoc.days2016.day11.DayEleven;
import com.aoc.days2016.day12.DayTwelve;
import com.aoc.days2016.day13.DayThirteen;
import com.aoc.days2016.day14.DayFourteen;
import com.aoc.days2016.day15.DayFifteen;
import com.aoc.days2016.day16.DaySixteen;
import com.aoc.days2016.day17.DaySeventeen;
import com.aoc.days2016.day18.DayEighteen;
import com.aoc.days2016.day19.DayNineteen;
import com.aoc.days2016.day20.DayTwenty;
import com.aoc.days2016.day21.DayTwentyOne;
import com.aoc.days2016.day22.DayTwentyTwo;
import com.aoc.days2016.day23.DayTwentyThree;
import com.aoc.days2016.day24.DayTwentyFour;
import com.aoc.days2016.day25.DayTwentyFive;
import com.aoc.yearbase.YearBase;

/**
 * @author Llamadmiral.
 */
public class Year2016 extends YearBase {

    public Year2016() {
        this.year = 2016;
    }

    @Override
    public void testDay() {
        printDay(new DayFour());
    }

    @Override
    protected void printDays() {
        printDay(new DayOne());
        printDay(new DayTwo());
        printDay(new DayThree());
        printDay(new DayFour());
        printDay(new DayFive());
        printDay(new DaySix());
        printDay(new DaySeven());
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
        printDay(new DayEighteen());
        printDay(new DayNineteen());
        printDay(new DayTwenty());
        printDay(new DayTwentyOne());
        printDay(new DayTwentyTwo());
        printDay(new DayTwentyThree());
        printDay(new DayTwentyFour());
        printDay(new DayTwentyFive());
    }
}
