package com.aoc.days2020.day11;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEleven extends SolutionBase {

    private static final int[][] NEIGHBOUR_MATRIX = new int[][]{
        new int[]{-1, -1},
        new int[]{-1, 0},
        new int[]{-1, 1},
        new int[]{0, -1},
        new int[]{0, 1},
        new int[]{1, -1},
        new int[]{1, 0},
        new int[]{1, 1},
    };
    private boolean changed = true;
    private char[][] originalLayout;
    private char[][] layout;

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        layout = new char[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            final String row = rows[i];
            for (int column = 0; column < row.length(); column++) {
                layout[i][column] = row.charAt(column);
            }
        }
        originalLayout = layout;
    }

    @Override
    protected void solvePartOne() {
        while (changed) {
            changed = false;
            layout = simulatePartOne();
        }
        final int count = countSeats();
        setSolutionOne(count);
    }

    private int countSeats() {
        int count = 0;
        for (final char[] row : layout) {
            for (final char tile : row) {
                if (tile == '#') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    protected void solvePartTwo() {
        layout = originalLayout;
        changed = true;
        while (changed) {
            changed = false;
            layout = simulatePartTwo();
        }
        final int count = countSeats();
        setSolutionTwo(count);
    }

    private char[][] simulatePartTwo() {
        final char[][] newLayout = new char[layout.length][layout[0].length];
        for (int row = 0; row < layout.length; row++) {
            for (int column = 0; column < layout[row].length; column++) {
                final char tile = layout[row][column];
                char newTile = '.';
                if (tile == '#') {
                    final int takenSeats = countSeenSeats(row, column);
                    if (takenSeats >= 5) {
                        newTile = 'L';
                    } else {
                        newTile = '#';
                    }
                } else if (tile == 'L') {
                    final int takenSeats = countSeenSeats(row, column);
                    if (takenSeats == 0) {
                        newTile = '#';
                    } else {
                        newTile = 'L';
                    }
                }
                newLayout[row][column] = newTile;
                if (!changed && tile != newTile) {
                    changed = true;
                }
            }
        }
        return newLayout;
    }

    private char[][] simulatePartOne() {
        final char[][] newLayout = new char[layout.length][layout[0].length];
        for (int row = 0; row < layout.length; row++) {
            for (int column = 0; column < layout[row].length; column++) {
                final char tile = layout[row][column];
                char newTile = '.';
                if (tile == '#') {
                    final int takenSeats = countTakenNeighbours(row, column);
                    if (takenSeats >= 4) {
                        newTile = 'L';
                    } else {
                        newTile = '#';
                    }
                } else if (tile == 'L') {
                    final int takenSeats = countTakenNeighbours(row, column);
                    if (takenSeats == 0) {
                        newTile = '#';
                    } else {
                        newTile = 'L';
                    }
                }
                newLayout[row][column] = newTile;
                if (!changed && tile != newTile) {
                    changed = true;
                }
            }
        }
        return newLayout;
    }

    private int countSeenSeats(final int row, final int column) {
        int count = 0;
        for (final int[] offset : NEIGHBOUR_MATRIX) {
            int i = 0;
            char tile = '.';
            while (tile == '.' && count < 5) {
                i++;
                tile = getTile(row + offset[0] * i, column + offset[1] * i);
                if (tile == '#') {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private int countTakenNeighbours(final int row, final int column) {
        int count = 0;
        for (final int[] offset : NEIGHBOUR_MATRIX) {
            final char tile = getTile(row + offset[0], column + offset[1]);
            if (tile == '#') {
                count++;
            }
        }
        return count;
    }

    private char getTile(final int row, final int column) {
        return row >= 0 && row < layout.length && column >= 0 && column < layout[row].length ? layout[row][column] : '\0';
    }
}