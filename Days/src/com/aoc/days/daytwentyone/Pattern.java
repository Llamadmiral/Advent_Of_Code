package com.aoc.days.daytwentyone;

import static com.aoc.days.daytwentyone.MatrixHelper.getCountOfMatrix;

/**
 * @author maczaka
 */
class Pattern {
    private int[][] matrix;
    private int size;
    private int count = 0;

    Pattern(final String input) {
        final String[] rows = input.split("/");
        matrix = new int[rows.length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                final int element = rows[i].charAt(j) == '#' ? 1 : 0;
                matrix[i][j] = element;
                count += element;
            }
        }
        size = matrix.length;
    }


    boolean matrixEqualsWith(final int[][] other) {
        return other.length == this.size
                && getCountOfMatrix(other) == this.count && MatrixHelper.ruleMatchesWith(other, matrix);
    }


    int[][] getMatrix() {
        return matrix;
    }

    void setMatrix(int[][] matrix) {
        this.size = matrix.length;
        this.matrix = matrix;
        this.count = getCountOfMatrix(matrix);
    }

    int getSize() {
        return size;
    }

    int getCount() {
        return count;
    }
}
