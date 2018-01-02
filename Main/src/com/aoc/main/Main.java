package com.aoc.main;


import com.aoc.util.log.Logger;
import com.aoc.util.modulefactory.ModuleException;
import com.aoc.util.modulefactory.ModuleFactory;

/**
 * @author Llamadmiral.
 */
public class Main {

    private static final Logger LOG = new Logger();

    public static void main(String[] args) {
        try {
            ModuleFactory.createModuleForYear(2016);
        } catch (ModuleException e) {
            e.printStackTrace();
        }
//        final Year2017 year2017 = new Year2017();
//        year2017.printYear();
    }


}
