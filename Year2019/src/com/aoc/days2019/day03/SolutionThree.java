package com.aoc.days2019.day03;

import com.aoc.solutionbase.SolutionBase;

import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionThree extends SolutionBase {

    private static final Map<Character, int[]> OFFSET = Map.of(
            'U', new int[]{0, -1},
            'R', new int[]{1, 0},
            'D', new int[]{0, 1},
            'L', new int[]{-1, 0}
    );
    private WireMap first;
    private WireMap second;

    SolutionThree(final String day) {
        super(day);
    }

    @Override
    public void init() {
        String[] paths = input.split("\n");
        first = layWires(paths[0]);
        second = layWires(paths[1]);
    }

    @Override
    protected void solvePartOne() {
        Integer minDistance = null;
        for (int x : first.keySet()) {
            Map<Integer, Integer> row = second.get(x);
            if (row != null) {
                for (int y : first.get(x).keySet()) {
                    Integer counter = row.get(y);
                    if (counter != null) {
                        int distance = manhattanDistance(x, y);
                        if (minDistance == null || distance < minDistance) {
                            minDistance = distance;
                        }
                    }
                }
            }
        }
        setSolutionOne(minDistance);
    }

    @Override
    protected void solvePartTwo() {
        Integer minSum = null;
        for (int x : first.keySet()) {
            Map<Integer, Integer> row = second.get(x);
            if (row != null) {
                for (int y : first.get(x).keySet()) {
                    Integer secondSteps = row.get(y);
                    if (secondSteps != null) {
                        Integer firstSteps = first.get(x).get(y);
                        int sum = firstSteps + secondSteps;
                        if (minSum == null || sum < minSum) {
                            minSum = sum;
                        }
                    }
                }
            }
        }
        setSolutionTwo(minSum);
    }

    private WireMap layWires(String fullPath) {
        WireMap wireMap = new WireMap();
        String[] wirepaths = fullPath.split(",");
        int x = 0;
        int y = 0;
        int index = 1;
        for (String path : wirepaths) {
            char direction = path.charAt(0);
            int amount = Integer.parseInt(path.substring(1));
            int[] offset = OFFSET.get(direction);
            for (int i = 0; i < amount; i++) {
                x += offset[0];
                y += offset[1];
                wireMap.addWire(x, y, index);
                index++;
            }
        }
        return wireMap;
    }

    private int manhattanDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}