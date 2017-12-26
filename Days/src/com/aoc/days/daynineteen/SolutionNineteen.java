package com.aoc.days.daynineteen;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * IntelliJ decided to trim the input for some reason... so do not open the input in editor...
 *
 * @author maczaka
 */
class SolutionNineteen extends SolutionBase {
    private static final Map<Character, int[]> DIRECTION_STEPS = new HashMap<>();
    private static final char[] DIRECTIONS = new char[]{'u', 'l', 'r', 'd'};

    static {
        DIRECTION_STEPS.put('u', new int[]{-1, 0});
        DIRECTION_STEPS.put('d', new int[]{1, 0});
        DIRECTION_STEPS.put('l', new int[]{0, -1});
        DIRECTION_STEPS.put('r', new int[]{0, 1});
    }

    private int[] position;
    private char[][] maze;
    private char direction = 'd';
    private StringBuilder builder = new StringBuilder();
    private int steps = 1;

    SolutionNineteen(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        setStartingCoordinates();
        parseMaze();
        setSolutionOne(builder.toString());
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(steps);
    }

    private void parseMaze() {
        boolean stepped = true;
        while (stepped) {
            stepped = step();
        }
    }

    private boolean step() {
        boolean stepped = false;
        if (setNewDirection()) {
            final char tile = maze[position[0]][position[1]];
            if (Character.isAlphabetic(tile)) {
                builder.append(tile);
            }
            stepped = true;
        }
        return stepped;
    }

    private boolean setNewDirection() {
        boolean couldSetNewDirection = false;
        if (!setNewCoordinates(direction)) {
            for (int i = 0; i < 4; i++) {
                final char newDirection = DIRECTIONS[i];
                if (!isOpposite(newDirection) && setNewCoordinates(newDirection)) {
                    couldSetNewDirection = true;
                    direction = newDirection;
                    break;
                }
            }
        } else {
            couldSetNewDirection = true;
        }
        return couldSetNewDirection;
    }

    private boolean isOpposite(final char newDirection) {
        final int[] currDiff = DIRECTION_STEPS.get(newDirection);
        final int[] otherDiff = DIRECTION_STEPS.get(direction);
        return currDiff[0] + otherDiff[0] == 0 && currDiff[1] + otherDiff[1] == 0;
    }


    private boolean setNewCoordinates(final char newDirection) {
        boolean couldSetNewCoordinates = false;
        final int[] directionalDifference = DIRECTION_STEPS.get(newDirection);
        final int x = position[0] + directionalDifference[0];
        final int y = position[1] + directionalDifference[1];
        if (x > -1 && x < maze.length && y > -1 && y < maze[0].length && maze[x][y] != ' ') {
            steps++;
            position[0] = x;
            position[1] = y;
            couldSetNewCoordinates = true;
        }
        return couldSetNewCoordinates;
    }

    private void setStartingCoordinates() {
        for (int i = 0; i < maze[0].length; i++) {
            if (maze[0][i] != ' ') {
                position = new int[]{0, i};
                break;
            }
        }
    }

    private void parseInput() {
        final String[] inp = ((String) input).split("\n");
        maze = new char[inp.length][inp[0].length()];
        for (int i = 0; i < inp.length; i++) {
            final String row = inp[i];
            for (int j = 0; j < inp[i].length(); j++) {
                maze[i][j] = row.charAt(j);
            }
        }
    }
}
