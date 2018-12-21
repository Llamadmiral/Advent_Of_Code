package com.aoc.days2018.day18;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionEighteen extends SolutionBase {


    private static final char OPEN = '.';
    private static final char LUMBERYARD = '#';
    private static final char TREE = '|';

    private static final int ONE_BILLION = 1000000000;
    private static final int[][] OFFSETS = new int[][]{
        new int[]{-1, -1},
        new int[]{-1, 0},
        new int[]{-1, 1},
        new int[]{0, -1},
        new int[]{0, 1},
        new int[]{1, 1},
        new int[]{1, 0},
        new int[]{1, -1},
    };
    private final Map<Integer, Set<SavedMap>> simulatedFields = new HashMap<>();
    private char[][] map;
    private char[][] originalMap;

    SolutionEighteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] split = input.split("\n");
        final List<char[]> rows = new ArrayList<>();
        int rowNum = 0;
        for (; rowNum < split.length; rowNum++) {
            rows.add(split[rowNum].toCharArray());
        }
        map = new char[rows.size()][split[0].length()];
        for (int i = 0; i < rows.size(); i++) {
            map[i] = rows.get(i);
        }
        originalMap = map;
    }

    @Override
    protected void solvePartOne() {
        for (int i = 0; i < 10; i++) {
            simulate();
        }
        setSolutionOne(countScore());
    }

    @Override
    protected void solvePartTwo() {
        map = originalMap;
        boolean inLoop = false;
        boolean loopFinished = false;
        final List<SavedMap> savedMaps = new ArrayList<>();
        int i = 0;
        while (!loopFinished) {
            simulate();
            if (!inLoop) {
                final int score = countScore();
                if (checkEquality(score)) {
                    inLoop = true;
                    savedMaps.add(new SavedMap(map));
                } else {
                    saveMap(score);
                }
            } else {
                loopFinished = !savedMaps.isEmpty() && checkMapEquality(savedMaps.get(0).getMap());
                if (!loopFinished) {
                    savedMaps.add(new SavedMap(map));
                }
            }
            i++;
        }
        map = savedMaps.get((ONE_BILLION - i) % savedMaps.size()).getMap();
        setSolutionTwo(countScore());
    }

    private void saveMap(final int score) {
        if (simulatedFields.containsKey(score)) {
            simulatedFields.get(score).add(new SavedMap(map));
        } else {
            final Set<SavedMap> savedMaps = new HashSet<>();
            savedMaps.add(new SavedMap(map));
            simulatedFields.put(score, savedMaps);
        }
    }

    private boolean checkEquality(final int score) {
        boolean equals = false;
        if (simulatedFields.containsKey(score)) {
            for (final SavedMap otherMap : simulatedFields.get(score)) {
                equals = checkMapEquality(otherMap.getMap());
                if (equals) {
                    break;
                }
            }
        }
        return equals;
    }

    private boolean checkMapEquality(final char[][] otherMap) {
        boolean equals = true;
        for (int y = 0; y < map.length && equals; y++) {
            for (int x = 0; x < map[y].length && equals; x++) {
                equals = otherMap[y][x] == map[y][x];
            }
        }
        return equals;
    }

    private int countScore() {
        int sumOfTrees = 0;
        int sumOfLumberyards = 0;
        for (final char[] row : map) {
            for (final char c : row) {
                if (c == '#') {
                    sumOfLumberyards++;
                } else if (c == '|') {
                    sumOfTrees++;
                }
            }
        }
        return sumOfTrees * sumOfLumberyards;
    }

    private void simulate() {
        final char[][] newMap = new char[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                simulate(y, x, newMap);
            }
        }
        map = newMap;
    }

    private void simulate(final int y, final int x, final char[][] newMap) {
        final char current = map[y][x];
        switch (current) {
            case OPEN:
                if (countType(y, x, TREE, 3)) {
                    newMap[y][x] = TREE;
                } else {
                    newMap[y][x] = OPEN;
                }
                break;
            case TREE:
                if (countType(y, x, LUMBERYARD, 3)) {
                    newMap[y][x] = LUMBERYARD;
                } else {
                    newMap[y][x] = TREE;
                }
                break;
            case LUMBERYARD:
                if (countType(y, x, LUMBERYARD, 1) && countType(y, x, TREE, 1)) {
                    newMap[y][x] = LUMBERYARD;
                } else {
                    newMap[y][x] = OPEN;
                }
                break;
            default:
                break;
        }
    }

    private boolean countType(final int y, final int x, final char type, final int neededAmount) {
        int sum = 0;
        for (final int[] offset : OFFSETS) {
            if (checkBoundaries(y + offset[0], x + offset[1]) && map[y + offset[0]][x + offset[1]] == type) {
                sum++;
                if (sum == neededAmount) {
                    break;
                }
            }
        }
        return sum == neededAmount;
    }

    private boolean checkBoundaries(final int y, final int x) {
        return y >= 0 && y < map.length && x >= 0 && x < map[y].length;
    }
}