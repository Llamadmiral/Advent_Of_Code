package com.aoc.days.dayten;

/**
 * I know this isn't optimal, but I don't want to increase the visibility of a Solution.
 *
 * @author maczaka
 */
public class KnotHashGenerator {
    public static String getKnotHashForInput(final String input) {
        final SolutionTen ten = new SolutionTen("TEN");
        ten.setInput(input);
        return ten.initKnotHashGeneration();
    }
}
