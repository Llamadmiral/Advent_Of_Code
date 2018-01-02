package com.aoc.days.day21;

/**
 * @author maczaka
 */
class Pattern {
    private int[][] matrix;
    private int size;
    private int count = 0;

    Pattern(final String input) {
        matrix = MatrixHelper.convertPatternToMatrix(input);
        count = MatrixHelper.getCountOfMatrix(matrix);
        size = matrix.length;
    }


    boolean matrixEqualsWith(final int[][] other) {
        return other.length == this.size
            && MatrixHelper.getCountOfMatrix(other) == this.count
            && MatrixHelper.ruleMatchesWith(other, matrix);
    }


    int[][] getMatrix() {
        return matrix;
    }

    void setMatrix(int[][] matrix) {
        this.size = matrix.length;
        this.matrix = matrix;
        this.count = MatrixHelper.getCountOfMatrix(matrix);
    }

    int getSize() {
        return size;
    }

    int getCount() {
        return count;
    }
}
