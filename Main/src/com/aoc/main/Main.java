package com.aoc.main;


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
        final Year2018 year2018 = new Year2018();
        year2018.testDay();
    }

    public static void solvedYear() {
        final Year2017 year2017 = new Year2017();
        year2017.printYear();
    }


}
