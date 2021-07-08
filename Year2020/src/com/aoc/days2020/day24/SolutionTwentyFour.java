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

    private final Map<String, Boolean> tiles = new HashMap<>();

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
        Map<String, Boolean> currentTiles = tiles;
        /*for (final Map.Entry<String, Boolean> entry : currentTiles.entrySet()) {
            currentTiles.put(entry.getKey(), true);
        }*/
        //System.out.println(countBlackNeighbours(0, 0, currentTiles));
        for (int i = 0; i < 100; i++) {
            //  System.out.println("Day " + (i + 1) + ": " + countFlippedTiles(currentTiles));
            final Map<String, Boolean> newTiles = new HashMap<>(currentTiles);
            for (final Map.Entry<String, Boolean> tileEntry : currentTiles.entrySet()) {
                final String[] xes = tileEntry.getKey().split("x");
                final int x = Integer.parseInt(xes[0]);
                final int y = Integer.parseInt(xes[1]);
                final int count = countBlackNeighbours(x, y, newTiles);
                if (tileEntry.getValue()) {
                    if (count == 0 || count > 2) {
                        set(x, y, newTiles, false);
                    } else {
                        set(x, y, newTiles, true);
                    }
                } else if (count == 2) {
                    set(x, y, newTiles, true);
                }
            }
            currentTiles = newTiles;
        }
        setSolutionTwo(countFlippedTiles(currentTiles));
    }

    private int countBlackNeighbours(final int x, final int y, final Map<String, Boolean> newTiles) {
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

    private int countFlippedTiles(final Map<String, Boolean> newTiles) {
        int count = 0;
        for (final Boolean tile : newTiles.values()) {
            if (tile) {
                count++;
            }
        }
        return count;
    }

    private void flip(final int x, final int y) {
        final String key = x + "x" + y;
        Boolean tile = tiles.get(key);
        if (tile == null) {
            tiles.put(key, true);
        } else {
            tiles.put(key, !tile);
        }
    }

    private boolean get(final int x, final int y, final Map<String, Boolean> newTiles) {
        return newTiles.computeIfAbsent(x + "x" + y, k -> false);
    }

    private void set(final int x, final int y, final Map<String, Boolean> newTiles, final boolean value) {
        newTiles.put(x + "x" + y, value);
    }

}