package com.aoc.util;

import java.lang.reflect.Array;
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
            integers.add(Integer.valueOf(string));
        }
        return integers;
    }

    @SuppressWarnings("unchecked")
    public static <T> void doPermutations(final List<T[]> finalResult, final T[] starting, final T[] subResult, final Class<T> clazz) {
        if (starting.length == 0) {
            finalResult.add(subResult);
        } else {
            for (int i = 0; i < starting.length; i++) {
                final T[] newStarting = (T[]) Array.newInstance(clazz, starting.length - 1);
                final T[] newSubResult = (T[]) Array.newInstance(clazz, subResult.length + 1);
                int k = 0;
                for (int j = 0; j < starting.length; j++) {
                    if (j != i) {
                        newStarting[k++] = starting[j];
                    }
                }
                System.arraycopy(subResult, 0, newSubResult, 0, subResult.length);
                newSubResult[newSubResult.length - 1] = starting[i];
                doPermutations(finalResult, newStarting, newSubResult, clazz);
            }
        }
    }

    public static int[] inputToIntArray(final String input, final String c) {
        final String[] split = input.split(c);
        final int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

}
