package com.aoc.days.dayfourteen;

import com.aoc.days.dayten.KnotHashGenerator;
import com.aoc.solutionbase.SolutionBase;

/**
 * Proud that the second part only tooks about 15ms.
 *
 * @author maczaka
 */
class SolutionFourteen extends SolutionBase {

    private static final String DICTIONARY = "0123456789abcdef";
    private static final int[][] NEIGHBOURS = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    };
    private int nrOfSquares = 0;
    private int regions = 0;
    private char[][] disk = new char[128][128];

    SolutionFourteen(String day) {
        super(day);
    }


    @Override
    protected void solvePartOne() {
        for (int i = 0; i < 128; i++) {
            final String knotHash = KnotHashGenerator.getKnotHashForInput(input + "-" + i);
            for (int j = 0; j < 32; j++) {
                final char[] binary = hexToBinary(knotHash.charAt(j));
                System.arraycopy(binary, 0, disk[i], j * 4, 4);
                nrOfSquares += countSquares(binary);
            }
        }
        setSolutionOne(nrOfSquares);
    }

    @Override
    protected void solvePartTwo() {
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++) {
                if (disk[i][j] == '1') {
                    regions++;
                    nullifyRegion(i, j);
                }
            }
        }
        setSolutionTwo(regions);
    }

    private void nullifyRegion(final int x, final int y) {
        if (x >= 0 && y >= 0 && x < 128 && y < 128 && disk[x][y] == '1') {
            disk[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                nullifyRegion(x + NEIGHBOURS[i][0], y + NEIGHBOURS[i][1]);
            }
        }
    }


    private char[] hexToBinary(final char hex) {
        int number = DICTIONARY.indexOf(hex);
        int remainder;
        int position = 3;
        final char[] bin = new char[]{'0', '0', '0', '0'};
        while (number != 0) {
            remainder = number % 2;
            number /= 2;
            bin[position] = (char) (remainder + 48);
            position--;
        }
        return bin;
    }

    private int countSquares(final char[] array) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (array[i] == '1') {
                count++;
            }
        }
        return count;
    }

}
