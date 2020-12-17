package com.aoc.days2020.day17;

class ThreeDimensionalEnergy {

    private boolean[][][] pocketDimension;

    ThreeDimensionalEnergy(final String input) {
        final String[] rows = input.split("\n");
        pocketDimension = new boolean[rows.length][rows.length][rows.length];
        for (int row = 0; row < rows.length; row++) {
            for (int column = 0; column < rows[row].length(); column++) {
                pocketDimension[rows.length / 2][row][column] = rows[row].charAt(column) == '#';
            }
        }
    }


    void simulate() {
        final boolean[][][] paddedDimension = pad(this.pocketDimension);
        final boolean[][][] newDimension = new boolean[paddedDimension.length][paddedDimension.length][paddedDimension.length];
        for (int i = 0; i < paddedDimension.length; i++) {
            for (int j = 0; j < paddedDimension[i].length; j++) {
                for (int k = 0; k < paddedDimension[i][j].length; k++) {
                    final int activeNeighbours = countActiveNeighbours(paddedDimension, i, j, k);
                    if (paddedDimension[i][j][k] && (activeNeighbours == 2 || activeNeighbours == 3)
                        || !paddedDimension[i][j][k] && activeNeighbours == 3) {
                        newDimension[i][j][k] = true;
                    }
                }
            }
        }
        this.pocketDimension = newDimension;
    }

    private boolean[][][] pad(final boolean[][][] dimension) {
        final boolean[][][] newDimension = new boolean[dimension.length + 2][dimension.length + 2][dimension.length + 2];
        for (int i = 0; i < dimension.length; i++) {
            final boolean[][] plane = dimension[i];
            for (int j = 0; j < plane.length; j++) {
                final boolean[] row = plane[j];
                System.arraycopy(row, 0, newDimension[i + 1][j + 1], 1, row.length);
            }
        }
        return newDimension;
    }

    private boolean getCubeState(final boolean[][][] dimension, final int plane, final int row, final int column) {
        return plane >= 0 && plane < dimension.length
            && row >= 0 && row < dimension[plane].length
            && column >= 0 && column < dimension[plane][row].length
            && dimension[plane][row][column];
    }

    private int countActiveNeighbours(final boolean[][][] dimension, final int z, final int x, final int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    if (i != 0 || j != 0 || k != 0) {
                        final boolean cubeState = getCubeState(dimension, z + i, x + j, y + k);
                        if (cubeState) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    int countActiveCubes() {
        int count = 0;
        for (final boolean[][] plane : this.pocketDimension) {
            for (final boolean[] row : plane) {
                for (final boolean column : row) {
                    if (column) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
