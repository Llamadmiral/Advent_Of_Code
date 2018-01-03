package com.aoc.util.stringutil;

/**
 * @author maczaka.
 */
public class StringUtils {
    public static String join(final String separator, final String... strings) {
        final StringBuilder builder = new StringBuilder();
        for (final String string : strings) {
            if (builder.length() != 0) {
                builder.append(separator);
            }
            builder.append(string);
        }
        return builder.toString();
    }
}
