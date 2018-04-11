package com.aoc.main;


import com.aoc.Year2016;
import com.aoc.Year2017;
import com.aoc.util.log.Logger;
import com.aoc.util.modulefactory.ModuleException;

import static com.aoc.util.modulefactory.ModuleFactory.createModuleForYear;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger();

    public static void main(String[] args) throws ModuleException {
        createModuleForYear(2015);
    }

    public static void solvedYear() {
        final Year2017 year2017 = new Year2017();
        year2017.printYear();
    }


}
