package com.aoc.main;


import com.aoc.Year2016;
import com.aoc.Year2017;
import com.aoc.util.log.Logger;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger();

    public static void main(String[] args) {
        final Year2016 year2016 = new Year2016();
        year2016.testDay();
    }

    public static void solvedYear() {
        final Year2017 year2017 = new Year2017();
        year2017.printYear();
    }


}
