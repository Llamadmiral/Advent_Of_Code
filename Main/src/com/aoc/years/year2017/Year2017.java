package com.aoc.years.year2017;

import com.aoc.years.year2017.days.dayeight.DayEight;
import com.aoc.years.year2017.days.dayeighteen.DayEighteen;
import com.aoc.years.year2017.days.dayeleven.DayEleven;
import com.aoc.years.year2017.days.dayfifteen.DayFifteen;
import com.aoc.years.year2017.days.dayfive.DayFive;
import com.aoc.years.year2017.days.dayfour.DayFour;
import com.aoc.years.year2017.days.dayfourteen.DayFourteen;
import com.aoc.years.year2017.days.daynine.DayNine;
import com.aoc.years.year2017.days.daynineteen.DayNineteen;
import com.aoc.years.year2017.days.dayone.DayOne;
import com.aoc.years.year2017.days.dayseven.DaySeven;
import com.aoc.years.year2017.days.dayseventeen.DaySeventeen;
import com.aoc.years.year2017.days.daysix.DaySix;
import com.aoc.years.year2017.days.daysixteen.DaySixteen;
import com.aoc.years.year2017.days.dayten.DayTen;
import com.aoc.years.year2017.days.daythirteen.DayThirteen;
import com.aoc.years.year2017.days.daythree.DayThree;
import com.aoc.years.year2017.days.daytwelve.DayTwelve;
import com.aoc.years.year2017.days.daytwenty.DayTwenty;
import com.aoc.years.year2017.days.daytwentyfive.DayTwentyFive;
import com.aoc.years.year2017.days.daytwentyfour.DayTwentyFour;
import com.aoc.years.year2017.days.daytwentyone.DayTwentyOne;
import com.aoc.years.year2017.days.daytwentythree.DayTwentyThree;
import com.aoc.years.year2017.days.daytwentytwo.DayTwentyTwo;
import com.aoc.years.year2017.days.daytwo.DayTwo;
import com.aoc.yearbase.YearBase;

/**
 * @author maczaka.
 */
public class Year2017 extends YearBase {

    public Year2017() {
        this.year = 2017;
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
