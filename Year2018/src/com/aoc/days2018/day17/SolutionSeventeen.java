package com.aoc.days2018.day17;

import com.aoc.solutionbase.SolutionBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Llamadmiral.
 */
class SolutionSeventeen extends SolutionBase {

    private static final Comparator<int[]> WATER_COMPARATOR = (o1, o2) ->
        o1[1] > o2[1]
            ? -1
            : o1[1] != o2[1]
            ? 1
            : o1[0] > o2[0]
            ? -1
            : o1[0] == o2[0]
            ? 0
            : 1;


    private final Set<int[]> waters = new TreeSet<>(WATER_COMPARATOR);
    private int maxX = 0;
    private int maxY = 0;
    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int[][][] scans = null;
    private char[][] map;
    private int dryWater = 0;


    SolutionSeventeen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] row = input.split("\n");
        scans = new int[row.length][2][2];
        for (int i = 0; i < row.length; i++) {
            scans[i] = convertRow(row[i]);
        }
        normalize();
        fillMap();
    }

    @Override
    protected void solvePartOne() {
        for (int i = 0; i < 3500; i++) {
            moveWatersDown();
            spreadWater();
            addWater();
            stopStuckWater();
        }
        setSolutionOne(countWaters());
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(dryWater);
    }


    private void stopStuckWater() {
        Set<int[]> intervalsToRemove = new HashSet<>();
        for (final int[] water : waters) {
            if (!isBottom(water) && !belowIsFlowingWater(water) && !freeToFall(water)) {
                int startX = water[0];
                int x = startX + 1;
                int y = water[1];
                boolean stop = false;
                boolean leftBlocked = false;
                boolean rightBlocked = false;
                while (!stop) {
                    if (map[y + 1][x] != '#' && map[y + 1][x] != '~') {
                        stop = true;
                    } else if (map[y][x + 1] == '#') {
                        leftBlocked = true;
                        stop = true;
                    } else if (map[y][x + 1] == '|') {
                        x++;
                    } else {
                        stop = true;
                    }
                }
                stop = false;
                int endX = x + 1;
                x = startX - 1;
                while (!stop) {
                    if (map[y + 1][x] != '#' && map[y + 1][x] != '~') {
                        stop = true;
                    } else if (map[y][x - 1] == '#') {
                        rightBlocked = true;
                        stop = true;
                    } else if (map[y][x - 1] == '|') {
                        x--;
                    } else {
                        stop = true;
                    }
                }
                if (leftBlocked && rightBlocked) {
                    intervalsToRemove.add(new int[]{x, endX, y});
                }
            }
        }
        for (int[] toRemove : intervalsToRemove) {
            for (int i = toRemove[0]; i < toRemove[1]; i++) {
                removeByCoordinate(i, toRemove[2]);
            }
        }
    }

    private void removeByCoordinate(final int x, final int y) {
        for (Iterator<int[]> iterator = waters.iterator(); iterator.hasNext(); ) {
            int[] water = iterator.next();
            if (water[0] == x && water[1] == y) {
                iterator.remove();
                map[y][x] = '~';
                break;
            }
        }
    }

    private void moveWatersDown() {
        for (final int[] water : waters) {
            if (!isBottom(water) && freeToFall(water)) {
                map[water[1] + 1][water[0]] = '|';
                map[water[1]][water[0]] = '.';
                water[1]++;
            }
        }
    }

    private int countWaters() {
        int sum = 0;
        for (int y = minY; y < maxY + 1; y++) {
            for (int x = 0; x < map[y].length; x++) {
                char c = map[y][x];
                if (c == '|') {
                    sum++;
                } else if (c == '~') {
                    dryWater++;
                    sum++;
                }
            }
        }
        return sum;
    }

    private void addWater() {
        map[1][500 - minX] = '|';
        waters.add(new int[]{500 - minX, 1});
    }

    private void spreadWater() {
        final Set<int[]> watersToAdd = new HashSet<>();
        for (Iterator<int[]> iterator = waters.iterator(); iterator.hasNext(); ) {
            final int[] water = iterator.next();
            if (!isBottom(water) && !freeToFall(water) && !belowIsFlowingWater(water)) {
                if (canSpill(water)) {
                    final Set<int[]> spill = spill(water);
                    if (spill.isEmpty()) {
                        map[water[1]][water[0]] = '~';
                        iterator.remove();
                    } else {
                        watersToAdd.addAll(spill);
                    }
                } else if (surrounded(water)) {
                    map[water[1]][water[0]] = '~';
                    iterator.remove();
                }
            }
        }
        waters.addAll(watersToAdd);
    }

    private boolean surrounded(final int[] water) {
        return map[water[1]][water[0] + 1] == '#' && map[water[1]][water[0] - 1] == '#';
    }

    private boolean canSpill(final int[] water) {
        return map[water[1]][water[0] + 1] == '.' || map[water[1]][water[0] - 1] == '.';
    }

    private Set<int[]> spill(final int[] water) {
        final Set<int[]> watersToAdd = new HashSet<>();
        int startX = water[0];
        int y = water[1];
        boolean leftBlocked = false;
        boolean rightBlocked = false;
        int x = startX + 1;
        boolean stop = false;
        while (!stop) {
            if (map[y][x] != '|') {
                if ((map[y][x] == '.' && map[y + 1][x] == '|') || map[y + 1][x] == '.') {
                    stop = true;
                    watersToAdd.add(new int[]{x, y});
                } else if (map[y][x] == '#') {
                    stop = true;
                    rightBlocked = true;
                } else {
                    watersToAdd.add(new int[]{x, y});
                    x++;
                }
            } else {
                stop = true;
            }
        }
        x = startX - 1;
        stop = false;
        while (!stop) {
            if (map[y][x] != '|') {
                if ((map[y][x] == '.' && map[y + 1][x] == '|') || map[y + 1][x] == '.') {
                    stop = true;
                    watersToAdd.add(new int[]{x, y});
                } else if (map[y][x] == '#') {
                    stop = true;
                    leftBlocked = true;
                } else {
                    watersToAdd.add(new int[]{x, y});
                    x--;
                }
            } else {
                stop = true;
            }
        }
        final boolean inPool = leftBlocked && rightBlocked;
        fillCoordinates(watersToAdd, inPool ? '~' : '|');
        return inPool ? Collections.emptySet() : watersToAdd;
    }

    private void fillCoordinates(final Set<int[]> toFill, final char type) {
        for (final int[] water : toFill) {
            map[water[1]][water[0]] = type;
        }
    }

    private boolean belowIsFlowingWater(final int[] water) {
        return map[water[1] + 1][water[0]] == '|';
    }

    private boolean isBottom(final int[] water) {
        return water[1] == map.length - 1;
    }

    private boolean freeToFall(final int[] water) {
        return map[water[1] + 1][water[0]] == '.';
    }

    private void fillMap() {
        map = new char[maxY + 4][maxX - minX + 3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '.';
            }
        }
        map[0][500 - minX] = '+';
        for (final int[][] coordinates : scans) {
            for (int y = coordinates[1][0]; y <= coordinates[1][1]; y++) {
                for (int x = coordinates[0][0]; x <= coordinates[0][1]; x++) {
                    map[y][x] = '#';
                }
            }
        }
    }

    /**
     * Creates a "scan". E.g.: [[a, b],[c, c]]
     */
    private int[][] convertRow(final String row) {
        final String[] data = row.split(", ");
        final int[][] result = row.charAt(0) == 'x'
            ? new int[][]{
            convertCoordinate(data[0]),
            convertCoordinate(data[1])}
            : new int[][]{
            convertCoordinate(data[1]),
            convertCoordinate(data[0])};
        checkMaxAndMinCoordinates(result);
        return result;
    }

    /**
     * Creates an array with coordinates. If input contains only one, it will be [a, a], if it contains 2 it will be [a, b].
     */
    private int[] convertCoordinate(final String coordinate) {
        final int[] result = new int[2];
        if (coordinate.contains("..")) {
            final String[] split = coordinate.split("\\.\\.");
            result[0] = Integer.parseInt(split[0].substring(2, split[0].length()));
            result[1] = Integer.parseInt(split[1]);
        } else {
            final int coord = Integer.parseInt(coordinate.substring(2, coordinate.length()));
            result[0] = coord;
            result[1] = coord;
        }
        return result;
    }

    private void checkMaxAndMinCoordinates(final int[][] result) {
        if (result[0][0] > maxX) {
            maxX = result[0][0];
        }
        if (result[0][1] > maxX) {
            maxX = result[0][1];
        }
        if (result[0][0] < minX) {
            minX = result[0][0];
        }
        if (result[0][1] < minX) {
            minX = result[0][1];
        }
        if (result[1][0] > maxY) {
            maxY = result[1][0];
        }
        if (result[1][1] > maxY) {
            maxY = result[1][1];
        }
        if (result[1][0] < minY) {
            minY = result[1][0];
        }
        if (result[1][1] < minY) {
            minY = result[0][1];
        }
    }

    private void normalize() {
        for (final int[][] coordinates : scans) {
            coordinates[0][0] = (coordinates[0][0] - minX) + 1;
            coordinates[0][1] = (coordinates[0][1] - minX) + 1;
        }
    }

    private void printMap() {
        final StringBuilder builder = new StringBuilder();
        for (final char[] row : map) {
            for (final char c : row) {
                builder.append(c);
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

}