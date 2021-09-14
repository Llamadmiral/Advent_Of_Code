package com.aoc.days2020.day24;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyFour extends SolutionBase {

    private static final Map<String, int[]> OFFSET_MAP = new HashMap<>();

    static {
        OFFSET_MAP.put("nw", new int[]{-1, 1});
        OFFSET_MAP.put("ne", new int[]{0, 1});
        OFFSET_MAP.put("e", new int[]{1, 0});
        OFFSET_MAP.put("se", new int[]{1, -1});
        OFFSET_MAP.put("sw", new int[]{0, -1});
        OFFSET_MAP.put("w", new int[]{-1, 0});
    }

    private final Map<Integer, HashMap<Integer, Boolean>> tiles = new HashMap<>();

    SolutionTwentyFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        for (final String row : input.split("\n")) {
            final int[] coordinate = getCoordinate(row);
            int x = coordinate[0];
            int y = coordinate[1];
            flip(x, y);
        }
        final int amountOfFlippedTiles = countFlippedTiles(tiles);
        setSolutionOne(amountOfFlippedTiles);
    }

    @Override
    protected void solvePartTwo() {
        for (int i = 0; i < 100; i++) {
            final Map<Integer, HashMap<Integer, Boolean>> currentTiles = pad(tiles);
            for (final Map.Entry<Integer, HashMap<Integer, Boolean>> row : currentTiles.entrySet()) {
                for (final Map.Entry<Integer, Boolean> tileEntry : row.getValue().entrySet()) {
                    final Integer x = row.getKey();
                    final Integer y = tileEntry.getKey();
                    final int count = countBlackNeighbours(x, y, currentTiles);
                    if (tileEntry.getValue()) {
                        if (count == 0 || count > 2) {
                            set(x, y, false);
                        }
                    } else if (count == 2) {
                        set(x, y, true);
                    }
                }
            }
        }
        setSolutionTwo(countFlippedTiles(tiles));
    }

    private Map<Integer, HashMap<Integer, Boolean>> pad(final Map<Integer, HashMap<Integer, Boolean>> newTiles) {
        final Map<Integer, HashMap<Integer, Boolean>> paddedTiles = new HashMap<>();
        for (final Map.Entry<Integer, HashMap<Integer, Boolean>> row : newTiles.entrySet()) {
            for (final Map.Entry<Integer, Boolean> tile : row.getValue().entrySet()) {
                final int x = row.getKey();
                final int y = tile.getKey();
                for (final int[] offset : OFFSET_MAP.values()) {
                    putIfAbsent(x + offset[0], y + offset[1], paddedTiles);
                }
                final HashMap<Integer, Boolean> paddedRow = paddedTiles.get(x);
                paddedRow.put(y, tile.getValue());
            }
        }
        return paddedTiles;
    }

    private void putIfAbsent(final int x, final int y, final Map<Integer, HashMap<Integer, Boolean>> newTiles) {
        final HashMap<Integer, Boolean> row = newTiles.computeIfAbsent(x, k -> new HashMap<>());
        row.putIfAbsent(y, false);
    }

    private int countBlackNeighbours(final int x, final int y, final Map<Integer, HashMap<Integer, Boolean>> newTiles) {
        int count = 0;
        for (final int[] offset : OFFSET_MAP.values()) {
            final boolean black = get(x + offset[0], y + offset[1], newTiles);
            if (black) {
                count++;
            }
        }
        return count;
    }

    private int[] getCoordinate(final String row) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < row.length(); i++) {
            final char c = row.charAt(i);
            int[] offsets = OFFSET_MAP.get(String.valueOf(c));
            if (offsets == null) {
                offsets = OFFSET_MAP.get(c + String.valueOf(row.charAt(i + 1)));
                i++;
            }
            x += offsets[0];
            y += offsets[1];
        }
        return new int[]{x, y};
    }

    private int countFlippedTiles(final Map<Integer, HashMap<Integer, Boolean>> newTiles) {
        int count = 0;
        for (final HashMap<Integer, Boolean> yCoordinates : newTiles.values()) {
            for (final Boolean tile : yCoordinates.values()) {
                if (tile) {
                    count++;
                }
            }
        }
        return count;
    }

    private void flip(final int x, final int y) {
        HashMap<Integer, Boolean> yCoordinates = tiles.get(x);
        if (yCoordinates == null) {
            yCoordinates = new HashMap<>();
            yCoordinates.put(y, true);
            tiles.put(x, yCoordinates);
        } else {
            final Boolean tile = yCoordinates.get(y);
            yCoordinates.put(y, tile == null || !tile);
        }
    }

    private boolean get(final int x, final int y, final Map<Integer, HashMap<Integer, Boolean>> newTiles) {
        boolean ret = false;
        final HashMap<Integer, Boolean> row = newTiles.get(x);
        if (row != null) {
            final Boolean tile = row.get(y);
            ret = tile != null && tile;
        }
        return ret;
    }

    private void set(final int x, final int y, final boolean value) {
        HashMap<Integer, Boolean> yCoordinates = tiles.get(x);
        if (yCoordinates == null) {
            yCoordinates = new HashMap<>();
            yCoordinates.put(y, value);
            tiles.put(x, yCoordinates);
        } else {
            yCoordinates.put(y, value);
        }
    }

}