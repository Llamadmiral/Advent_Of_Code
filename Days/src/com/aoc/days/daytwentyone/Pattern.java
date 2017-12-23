package com.aoc.days.daytwentyone;

import static com.aoc.days.daytwentyone.MatrixHelper.getCountOfMatrix;
import static com.aoc.days.daytwentyone.MatrixHelper.getDeterminantOfMatrix;

/**
 * @author maczaka
 */
class Pattern {
    private int[][] matrix;
    private int size;
    private int count = 0;
    private int determinant = 0;

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
        determinant = getDeterminantOfMatrix(matrix);
    }


    boolean matrixEqualsWith(final int[][] other) {
        return other.length == this.size
                && getCountOfMatrix(other) == this.count
                && getDeterminantOfMatrix(other) == this.determinant;
    }


    int[][] getMatrix() {
        return matrix;
    }

    void setMatrix(int[][] matrix) {
        this.size = matrix.length;
        this.matrix = matrix;
        this.count = getCountOfMatrix(matrix);
      //  this.determinant = getDeterminantOfMatrix(matrix);
    }

    int getSize() {
        return size;
    }

    int getCount() {
        return count;
    }
}
