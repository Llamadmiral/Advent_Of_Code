package com.aoc.main;


import com.aoc.Year2015;
import com.aoc.util.log.Logger;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger();

    public static void main(String[] args) {
        final Year2015 year2015 = new Year2015();
        year2015.printDay();

    }

    public static void solvedYear() {
        final Year2015 year2015 = new Year2015();
        year2015.printYear();
    }


}