package com.aoc.days2016.day18;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEighteen extends SolutionBase {

    private static final int PART_ONE_ROWNUM = 40;
    private static final int PART_TWO_ROWNUM = 400000;

    SolutionEighteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        this.setSolutionOne(getNumberOfSafeTiles(PART_ONE_ROWNUM));
    }

    @Override
    protected void solvePartTwo() {
        this.setSolutionTwo(getNumberOfSafeTiles(PART_TWO_ROWNUM));
    }

    private int getNumberOfSafeTiles(final int rowNumber) {
        boolean[] tiles = getTiles();
        int numberOfSafeTiles = addSafeTiles(tiles);
        int i = 0;
        while (i < rowNumber - 1) {
            tiles = getNextRow(tiles);
            numberOfSafeTiles += addSafeTiles(tiles);
            i++;
        }
        return numberOfSafeTiles;
    }

    private boolean[] getNextRow(final boolean[] currentRow) {
        final int n = currentRow.length;
        final boolean[] nextRow = new boolean[n];
        for (int i = 0; i < n; i++) {
            final boolean a = (i > 0) && currentRow[i - 1];
            final boolean b = currentRow[i];
            final boolean c = (i < n - 1) && currentRow[i + 1];
            nextRow[i] = tileIsTrap(a, b, c);
        }
        return nextRow;
    }

    private boolean tileIsTrap(final boolean a, final boolean b, final boolean c) {
        return (a && b && !c) || (!a && b && c) || (a && !b && !c) || (!a && !b && c);
    }

    private int addSafeTiles(final boolean[] tiles) {
        int numberOfSafeTiles = 0;
        for (final boolean b : tiles) {
            if (!b) {
                numberOfSafeTiles++;
            }
        }
        return numberOfSafeTiles;
    }

    private boolean[] getTiles() {
        final boolean[] firstRow = new boolean[input.length()];
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            firstRow[i] = c == '^';
        }
        return firstRow;
    }


}