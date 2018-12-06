package com.aoc.days2018.day06;

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
class SolutionSix extends SolutionBase {

    private static final int SIZE = 400;
    private static final int THRESHOLD = 10000;
    private static final String ABC = "abcdefghijklmn";

    private int[][] map = new int[SIZE][SIZE];
    private int[][] distanceMap = new int[SIZE][SIZE];
    private List<int[]> coordinates = new ArrayList<>();

    SolutionSix(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        prepareMap();
        final int largestArea = getLargestFiniteArea();
        setSolutionOne(largestArea);
    }

    @Override
    protected void solvePartTwo() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final int distanceSum = getDistanceToAllPoints(i, j);
                distanceMap[i][j] = distanceSum;
            }
        }
        int regions = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (distanceMap[i][j] < THRESHOLD) {
                    regions++;
                }
            }
        }
        setSolutionTwo(regions);
    }

    private int getDistanceToAllPoints(final int x, final int y) {
        int sum = 0;
        for (final int[] coords : coordinates) {
            sum += getDistance(x, y, coords);
        }
        return sum;
    }

    private int getLargestFiniteArea() {
        final Set<Integer> blacklist = getBlacklist();
        blacklist.add(-1);
        final Map<Integer, Integer> areaSizes = new HashMap<>();
        for (int i = 1; i < SIZE - 1; i++) {
            for (int j = 1; j < SIZE - 1; j++) {
                final int currentLocation = map[i][j];
                if (!blacklist.contains(currentLocation)) {
                    if (!areaSizes.containsKey(currentLocation)) {
                        areaSizes.put(currentLocation, 0);
                    }
                    areaSizes.put(currentLocation, areaSizes.get(currentLocation) + 1);
                }
            }
        }
        int maxSize = 0;
        for (final int size : areaSizes.values()) {
            if (size > maxSize) {
                maxSize = size;
            }
        }
        return maxSize;
    }

    private Set<Integer> getBlacklist() {
        final Set<Integer> blaclList = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            blaclList.add(map[i][0]);
        }
        for (int i = 0; i < SIZE; i++) {
            blaclList.add(map[0][i]);
        }
        for (int i = 0; i < SIZE; i++) {
            blaclList.add(map[i][SIZE - 1]);
        }
        for (int i = 0; i < SIZE; i++) {
            blaclList.add(map[SIZE - 1][i]);
        }
        return blaclList;
    }

    private void prepareMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = getClosestObject(i, j);
            }
        }
    }

    private int getClosestObject(final int x, final int y) {
        boolean multiple = false;
        int closest = 0;
        int minDist = getDistance(x, y, coordinates.get(0));
        for (int i = 1; i < coordinates.size(); i++) {
            final int[] coords = coordinates.get(i);
            final int currentDistance = getDistance(x, y, coords);
            if (currentDistance == minDist) {
                multiple = true;
            } else if (currentDistance < minDist) {
                minDist = currentDistance;
                multiple = false;
                closest = i;
            }
        }
        return multiple ? -1 : closest;
    }

    private int getDistance(final int x1, final int y1, final int[] coords) {
        return Math.abs(x1 - coords[0]) + Math.abs(y1 - coords[1]);
    }

    private void prepareInput() {
        for (final String row : input.split("\n")) {
            final String[] coords = row.split(", ");
            coordinates.add(new int[]{Integer.parseInt(coords[1]), Integer.parseInt(coords[0])});
        }
    }

    private void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] == -1 ? "." : ABC.charAt(map[i][j]));
            }
            System.out.println();
        }
    }
}