package com.aoc.main;


import com.aoc.Year2015;
import com.aoc.Year2017;
import com.aoc.Year2019;

/**
 * @author Llamadmiral.
 */
public class Main {

    public static void main(String[] args) {
        final Year2019 year = new Year2019();
        year.printDay();
    }

    public static void solvedYear() {
        final Year2015 year2015 = new Year2015();
        final Year2017 year2017 = new Year2017();
        year2015.printYear();
        year2017.printYear();
    }


}