package com.aoc.days2016.day02;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTwo extends SolutionBase {

    private static final char[][] SIMPLE_KEYPAD = new char[][]{
            new char[]{'1', '2', '3'},
            new char[]{'4', '5', '6'},
            new char[]{'7', '8', '9'}
    };
    private static final char[][] HARD_KEYPAD = new char[][]{
            new char[]{'\0', '\0', '1', '\0', '\0'},
            new char[]{'\0', '2', '3', '4', '\0'},
            new char[]{'5', '6', '7', '8', '9'},
            new char[]{'\0', 'A', 'B', 'C', '\0'},
            new char[]{'\0', '\0', 'D', '\0', '\0'}
    };
    private static final Map<Character, int[]> DIRECTIONS = new HashMap<>();

    static {
        DIRECTIONS.put('U', new int[]{-1, 0});
        DIRECTIONS.put('L', new int[]{0, -1});
        DIRECTIONS.put('D', new int[]{1, 0});
        DIRECTIONS.put('R', new int[]{0, 1});
    }

    private int[] currentPosition = new int[]{1, 1};
    private String[] rows;
    private StringBuilder builder = new StringBuilder();

    SolutionTwo(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        rows = input.split("\n");
        for (final String row : rows) {
            for (int i = 0; i < row.length(); i++) {
                move(row.charAt(i), SIMPLE_KEYPAD);
            }
            builder.append(SIMPLE_KEYPAD[currentPosition[0]][currentPosition[1]]);
        }
        setSolutionOne(builder.toString());
    }

    @Override
    protected void solvePartTwo() {
        currentPosition = new int[]{2, 0};
        builder = new StringBuilder();
        rows = input.split("\n");
        for (final String row : rows) {
            for (int i = 0; i < row.length(); i++) {
                move(row.charAt(i), HARD_KEYPAD);
            }
            builder.append(HARD_KEYPAD[currentPosition[0]][currentPosition[1]]);
        }
        setSolutionTwo(builder.toString());
    }

    private void move(final char direction, final char[][] keypad) {
        final int[] directionalOffset = DIRECTIONS.get(direction);
        final int[] newPosition = new int[]{currentPosition[0] + directionalOffset[0],
                currentPosition[1] + directionalOffset[1]};
        if (newPosition[0] > -1 && newPosition[0] < keypad.length
                && newPosition[1] > -1 && newPosition[1] < keypad[newPosition[0]].length
                && keypad[newPosition[0]][newPosition[1]] != '\0') {
            currentPosition = newPosition;
        }
    }
}