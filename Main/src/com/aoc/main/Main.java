package com.aoc.main;


import com.aoc.Year2015;
import com.aoc.Year2016;
import com.aoc.Year2017;
import com.aoc.days2016.day05.DayFive;
import com.aoc.util.log.Logger;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger();

    public static void main(String[] args) {
        final Year2016 year2016 = new Year2016();
        year2016.printDay();
    }

    public static void solvedYear() {
        final Year2015 year2015 = new Year2015();
        final Year2017 year2017 = new Year2017();
        year2015.printYear();
        year2017.printYear();
    }


}