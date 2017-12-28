package com.aoc.days.daytwentyone;

/**
 * @author maczaka
 */
final class MatrixHelper {

    private MatrixHelper() {
        //nope
    }

    static int[][] copyMatrixBlocks(final int limit, final int fromX, final int fromY, final int[][] matrix) {
        final int[][] subMatrix = new int[limit][limit];
        for (int j = 0; j < limit; j++) {
            System.arraycopy(matrix[fromX + j], fromY, subMatrix[j], 0, limit);
        }
        return subMatrix;
    }

    static int getCountOfMatrix(final int[][] matrix) {
        int count = 0;
        for (final int[] row : matrix) {
            for (final int element : row) {
                count += element;
            }
        }
        return count;
    }

    private static int[][] rotateMatrix(final int[][] matrix) {
        final int size = matrix.length;
        final int[][] rotatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedMatrix[j][size - i - 1] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static int[][] flipMatrix(final int[][] matrix) {
        final int size = matrix.length;
        final int[][] flippedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                flippedMatrix[i][size - j - 1] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }

    private static boolean matrixEquals(final int[][] matrixOne, final int[][] matrixTwo) {
        boolean equals = true;
        final int size = matrixOne.length;
        int i = 0;
        int j = 0;
        while (i < size && equals) {
            while (j < size && equals) {
                equals = matrixOne[i][j] == matrixTwo[i][j];
                j++;
            }
            j = 0;
            i++;
        }
        return equals;
    }

    private static int[][] deepCopyMatrix(final int[][] inputMatrix) {
        final int size = inputMatrix.length;
        final int[][] copiedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(inputMatrix[i], 0, copiedMatrix[i], 0, size);
        }
        return copiedMatrix;
    }

    static boolean ruleMatchesWith(final int[][] inputMatrix, final int[][] rule) {
        int[][] copiedMatrix = deepCopyMatrix(inputMatrix);
        boolean equals = matrixEquals(copiedMatrix, rule);
        if (!equals) {
            int i = 0;
            while (i < 3 && !equals) {
                copiedMatrix = rotateMatrix(copiedMatrix);
                equals = matrixEquals(copiedMatrix, rule);
                i++;
            }
            if (!equals) {
                copiedMatrix = flipMatrix(copiedMatrix);
                i = 0;
                while (i < 4 && !equals) {
                    copiedMatrix = rotateMatrix(copiedMatrix);
                    equals = matrixEquals(copiedMatrix, rule);
                    i++;
                }
            }
        }
        return equals;
    }

    static void printMatrix(final int[][] matrix) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                builder.append(" ").append(matrix[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

}
