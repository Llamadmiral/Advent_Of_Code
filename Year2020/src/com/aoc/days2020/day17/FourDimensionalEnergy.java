package com.aoc.days2020.day17;

public class FourDimensionalEnergy {

    final int[][] neighbourOffsets = new int[3 * 3 * 3 * 3 - 1][4];

    private boolean[][][][] pocketDimension;

    FourDimensionalEnergy(final String input) {
        final String[] rows = input.split("\n");
        pocketDimension = new boolean[rows.length][rows.length][rows.length][rows.length];
        for (int row = 0; row < rows.length; row++) {
            for (int column = 0; column < rows[row].length(); column++) {
                pocketDimension[rows.length / 2][rows.length / 2][row][column] = rows[row].charAt(column) == '#';
            }
        }
        int index = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        if (i != 0 || j != 0 || k != 0 || l != 0) {
                            neighbourOffsets[index++] = new int[]{i, j, k, l};
                        }
                    }
                }
            }
        }
    }


    void simulate() {
        final boolean[][][][] paddedDimension = pad(this.pocketDimension);
        final boolean[][][][] newDimension = new boolean[paddedDimension.length][paddedDimension.length][paddedDimension.length][paddedDimension.length];
        for (int i = 0; i < paddedDimension.length; i++) {
            for (int j = 0; j < paddedDimension[i].length; j++) {
                for (int k = 0; k < paddedDimension[i][j].length; k++) {
                    for (int l = 0; l < paddedDimension[i][j][k].length; l++) {
                        final int activeNeighbours = countActiveNeighbours(paddedDimension, i, j, k, l);
                        if (paddedDimension[i][j][k][l] && (activeNeighbours == 2 || activeNeighbours == 3)
                            || !paddedDimension[i][j][k][l] && activeNeighbours == 3) {
                            newDimension[i][j][k][l] = true;
                        }
                    }
                }
            }
        }
        this.pocketDimension = newDimension;
    }

    private int countActiveNeighbours(final boolean[][][][] dimension, final int i, final int j, final int k, final int l) {
        int count = 0;
        for (final int[] offsets : neighbourOffsets) {
            final boolean active = getCubeState(dimension, i + offsets[0], j + offsets[1], k + offsets[2], l + offsets[3]);
            if (active) {
                count++;
            }
        }
        return count;
    }


    private boolean getCubeState(final boolean[][][][] dimension, final int x, final int y, final int z, final int w) {
        return x >= 0 && x < dimension.length
            && y >= 0 && y < dimension[x].length
            && z >= 0 && z < dimension[x][y].length
            && w >= 0 && w < dimension[x][y][z].length
            && dimension[x][y][z][w];
    }

    private boolean[][][][] pad(final boolean[][][][] dimension) {
        final boolean[][][][] newDimension = new boolean[dimension.length + 2][dimension.length + 2][dimension.length + 2][dimension.length + 2];
        for (int i = 0; i < dimension.length; i++) {
            for (int j = 0; j < dimension[i].length; j++) {
                for (int k = 0; k < dimension[i][j].length; k++) {
                    for (int l = 0; l < dimension[i][j][k].length; l++) {
                        newDimension[i + 1][k + 1][j + 1][l + 1] = dimension[i][j][k][l];
                    }
                }
            }
        }
        return newDimension;
    }

    int countActiveCubes() {
        int count = 0;
        for (final boolean[][][] cube : this.pocketDimension) {
            for (final boolean[][] plane : cube) {
                for (final boolean[] row : plane) {
                    for (final boolean column : row) {
                        if (column) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
