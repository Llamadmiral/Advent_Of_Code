package com.aoc.days2017.day10;

/**
 * I know this isn't optimal, but I don't want to increase the visibility of a Solution.
 *
 * @author maczaka
 */
public class KnotHashGenerator {

    private KnotHashGenerator() {
        //nope
    }

    public static String getKnotHashForInput(final String input) {
        final SolutionTen ten = new SolutionTen("TEN");
        ten.setInput(input);
        return ten.initKnotHashGeneration();
    }
}
