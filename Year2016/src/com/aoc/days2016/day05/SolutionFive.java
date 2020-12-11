package com.aoc.days2016.day05;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.md5.MD5Helper;

/**
 * This is really bad.
 *
 * @author Llamadmiral.
 */
class SolutionFive extends SolutionBase {
    private static final String CODE = "cxdnnyjw";
    private static final char[] hexArray = "0123456789abcdef".toCharArray();
    private Integer startFrom = null;

    SolutionFive(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final char[] builder = new char[8];
        int k = 0;
        int i = 0;
        while (k < 8) {
            final byte[] bytes = MD5Helper.md5(CODE + i);
            if (bytes[0] == 0 && bytes[1] == 0 && (bytes[2] & 0xFF) >>> 4 == 0) {
                builder[k] = hexArray[(bytes[2] & 0xFF) & 0x0F];
                if (startFrom == null) {
                    startFrom = i;
                }
                k++;
            }
            i++;
        }
        setSolutionOne(new String(builder));
    }

    @Override
    protected void solvePartTwo() {
        final char[] builder = new char[8];
        int k = 0;
        int i = startFrom;
        while (k < 8) {
            final byte[] bytes = MD5Helper.md5(CODE + i);
            if (bytes[0] == 0 && bytes[1] == 0 && (bytes[2] & 0xFF) >>> 4 == 0) {
                final char c = hexArray[(bytes[2] & 0xFF) & 0x0F];
                if (c >= '0' && c <= '7' && builder[c - 48] == '\0') {
                    builder[c - 48] = hexArray[(bytes[3] & 0xFF) >>> 4];
                    k++;
                }
            }
            i++;
        }
        setSolutionTwo(new String(builder));
    }
}