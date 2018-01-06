package com.aoc.days2016.day09;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionNine extends SolutionBase {
    SolutionNine(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int size = input.length();
        final char[] compressed = input.toCharArray();
        int fullSize = 0;
        int i = 0;
        while (i < size) {
            final char c = compressed[i];
            if (c == '(') {
                int compressStart = i + 1;
                char x = compressed[compressStart];
                while (x != 'x') {
                    compressStart++;
                    x = compressed[compressStart];
                }
                int nextNChar = Integer.parseInt(input.substring(i + 1, compressStart));
                int compressEnd = compressStart + 1;
                while (x != ')') {
                    compressEnd++;
                    x = compressed[compressEnd];
                }
                int timesN = Integer.parseInt(input.substring(compressStart + 1, compressEnd));
                if (compressed[compressEnd + 1] != '(') {
                    i = compressEnd + nextNChar;
                    fullSize += (nextNChar * timesN) - nextNChar;
                } else {
                    int toSkip = compressEnd;
                    boolean toBreak = false;
                    while (!toBreak) {
                        final char c2 = compressed[toSkip];
                        toBreak = c2 != 'x' && Character.isAlphabetic(c2);
                        toSkip++;
                    }
                    i = toSkip;
                }
            } else {
                i++;
                fullSize++;
            }
        }
        setSolutionOne(fullSize);
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }
}