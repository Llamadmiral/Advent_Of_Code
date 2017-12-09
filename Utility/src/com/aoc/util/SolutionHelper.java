package com.aoc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Llamadmiral.
 */
public final class SolutionHelper {

    private static final String BASE_DELIMITER = "\t";

    private SolutionHelper() {

    }

    public static Integer charToInt(final Character character) {
        if (Character.isDigit(character)) {
            return Character.getNumericValue(character);
        } else {
            throw new NumberFormatException("Not a number: " + character);
        }
    }

    public static List<List<Integer>> createIntegerMatrix(final List<String> rows) {
        return createIntegerMatrix(rows, BASE_DELIMITER);
    }

    public static List<List<Integer>> createIntegerMatrix(final List<String> rows, final String delimiter) {
        return rows.stream().map(row -> splitStringsToNumbers(row, delimiter)).collect(Collectors.toList());
    }

    public static List<Integer> splitStringsToNumbers(final String row, final String delimiter) {
        final List<Integer> integers = new ArrayList<>();
        final String[] strings = row.split(delimiter);
        for (final String string : strings) {
            integers.add(new Integer(string));
        }
        return integers;
    }

}
