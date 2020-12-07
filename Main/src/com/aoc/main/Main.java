package com.aoc.main;


import com.aoc.Year2015;
import com.aoc.Year2017;
import com.aoc.Year2018;
import com.aoc.util.log.Logger;
import com.aoc.util.modulefactory.ModuleException;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger();

    public static void main(String[] args) throws ModuleException {
        final Year2015 year2015 = new Year2015();
        year2015.printDay();

    }

    public static void solvedYear() {
        final Year2015 year2015 = new Year2015();
        year2015.printYear();
    }


}