package com.aoc.days2020.day17;

class DimensionalEnergy {

    private int dimension;
    private boolean[] cubes;
    private int[][] neighbourOffsets;
    private int[] positionedNeighbourOffsets;
    private int neighbourIndex = 0;
    private int len;


    DimensionalEnergy(final String input, final int dimension) {
        this.dimension = dimension;
        this.neighbourOffsets = new int[(int) Math.pow(3, dimension) - 1][dimension];
        this.positionedNeighbourOffsets = new int[neighbourOffsets.length];
        final String[] rows = input.split("\n");
        this.len = rows.length;
        this.cubes = new boolean[(int) Math.pow(rows.length, dimension)];
        int index = 0;
        for (final String row : rows) {
            for (int column = 0; column < row.length(); column++) {
                this.cubes[index++] = row.charAt(column) == '#';
            }
        }
        generateNeighbourOffsets(new int[this.dimension], this.dimension, false);
        regeneratePositionedNeighbourOffsets();
    }

    /**
     * After the padding, this always have to be recalculated, so we can tell how far apart neighbours are.
     * Huge cheat with this one, since it is possible to get not real neighbours if the cube is on the "edge".
     * However, since the edge is always inactive because of the padding, it does not matter.
     */
    private void regeneratePositionedNeighbourOffsets() {
        for (int i = 0; i < neighbourOffsets.length; i++) {
            int result = 0;
            for (int j = 0; j < neighbourOffsets[i].length; j++) {
                result += neighbourOffsets[i][j] * Math.pow(this.len, this.dimension - j - 1);
            }
            positionedNeighbourOffsets[i] = result;
        }
    }

    int countActiveCubes() {
        int count = 0;
        for (final boolean cube : this.cubes) {
            if (cube) {
                count++;
            }
        }
        return count;
    }

    void simulate() {
        pad();
        regeneratePositionedNeighbourOffsets();
        final boolean[] newCubes = new boolean[this.cubes.length];
        for (int i = 0; i < this.cubes.length; i++) {
            final int activeNeighbours = countActiveNeighbours(i);
            newCubes[i] = (this.cubes[i] && (activeNeighbours == 2 || activeNeighbours == 3) || (!this.cubes[i] && activeNeighbours == 3));
        }
        this.cubes = newCubes;
    }

    private int countActiveNeighbours(final int position) {
        int count = 0;
        for (final int positionOffset : positionedNeighbourOffsets) {
            final int neighbourPosition = position + positionOffset;
            if (neighbourPosition >= 0 && neighbourPosition < this.cubes.length && this.cubes[neighbourPosition]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Surrounds the n-dimensional cube with inactive cubes.
     */
    private void pad() {
        final int newLen = this.len + 2;
        final boolean[] result = new boolean[(int) Math.pow(newLen, dimension)];
        int neighbourOffset = 0;
        for (int i = 0; i < this.dimension; i++) {
            neighbourOffset += Math.pow(newLen, this.dimension - i - 1);
        }
        for (int i = 1; i < this.dimension; i++) {
            neighbourOffset -= 2 * Math.pow(newLen, i - 1);
        }
        for (int i = 0; i < this.cubes.length; i++) {
            for (int j = 1; j < this.dimension; j++) {
                if (i % Math.pow(this.len, j) == 0) {
                    neighbourOffset += 2 * Math.pow(newLen, j - 1);
                }
            }
            result[i + neighbourOffset] = this.cubes[i];
        }
        this.cubes = result;
        this.len = newLen;
    }

    /**
     * Recursively generates the original offsets for getting the neighbour cubes.
     * So for dimension = 2 it generates [[0,1],[0,-1],[1,0],[1,0],[1,-1],[-1,1],[-1,0],[-1,-1]]
     */
    private void generateNeighbourOffsets(final int[] subResult, final int currentIteration, final boolean addedNonZero) {
        if (currentIteration == 0) {
            if (addedNonZero) {
                neighbourOffsets[neighbourIndex] = subResult;
                neighbourIndex++;
            }
        } else {
            for (int i = -1; i < 2; i++) {
                final int[] newSubResult = new int[subResult.length];
                System.arraycopy(subResult, 0, newSubResult, 0, this.dimension);
                newSubResult[this.dimension - currentIteration] = i;
                generateNeighbourOffsets(newSubResult, currentIteration - 1, addedNonZero || i != 0);
            }
        }
    }

    void log() {
        final String separator = new String(new char[this.dimension]).replace("\0", "-");
        final StringBuilder builder = new StringBuilder(separator).append("\n");
        for (int i = 0; i < cubes.length; i++) {
            for (int j = 1; j < this.dimension; j++) {
                if (i % Math.pow(this.len, j) == 0) {
                    builder.append("\n");
                }
            }
            builder.append(cubes[i] ? '#' : '.');
        }
        builder.append("\n").append(separator);
        System.out.println(builder);
    }

}
