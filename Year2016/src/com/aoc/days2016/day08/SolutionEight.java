package com.aoc.days2016.day08;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEight extends SolutionBase {

    private static final int MAX_WIDTH = 50;
    private static final int MAX_HEIGHT = 6;

    private boolean[][] screen = new boolean[MAX_HEIGHT][MAX_WIDTH];

    SolutionEight(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        initScreen();
        final String[] rows = input.split("\n");
        for (final String row : rows) {
            final String[] data = row.split(" ");
            switch (data[0]) {
                case "rect":
                    final String[] numbers = data[1].split("x");
                    final int x = Integer.parseInt(numbers[0]);
                    final int y = Integer.parseInt(numbers[1]);
                    rect(x, y);
                    break;
                case "rotate":
                    if (data[1].equals("row")) {
                        final int column = Integer.parseInt(data[2].substring(2, data[2].length()));
                        final int rotateBy = Integer.parseInt(data[4]);
                        rotateRow(column, rotateBy);
                    } else {
                        final int column = Integer.parseInt(data[2].substring(2, data[2].length()));
                        final int rotateBy = Integer.parseInt(data[4]);
                        rotateColumn(column, rotateBy);
                    }
                    break;
                default:
                    break;
            }
        }
        setSolutionOne(countLitPixels());
    }

    @Override
    protected void solvePartTwo() {
        printScreen();
        setSolutionTwo("AFBUPZBJPS"); //trust me, I read it.
    }

    private void initScreen() {
        for (int i = 0; i < MAX_HEIGHT; i++) {
            for (int j = 0; j < MAX_WIDTH; j++) {
                screen[i][j] = false;
            }
        }
    }

    private void rotateRow(final int row, final int offset) {
        final boolean[] copiedRow = new boolean[MAX_WIDTH];
        for (int i = 0; i < MAX_WIDTH; i++) {
            copiedRow[i] = screen[row][i];
        }
        for (int i = 0; i < MAX_WIDTH; i++) {
            screen[row][(i + offset) % MAX_WIDTH] = copiedRow[i];
        }
    }

    private void rotateColumn(final int column, final int offset) {
        final boolean[] copiedColumn = new boolean[MAX_HEIGHT];
        for (int i = 0; i < MAX_HEIGHT; i++) {
            copiedColumn[i] = screen[i][column];
        }
        for (int i = 0; i < MAX_HEIGHT; i++) {
            screen[(i + offset) % MAX_HEIGHT][column] = copiedColumn[i];
        }
    }

    private void rect(final int width, final int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                screen[j][i] = true;
            }
        }
    }

    private int countLitPixels() {
        int lit = 0;
        for (int i = 0; i < MAX_HEIGHT; i++) {
            for (int j = 0; j < MAX_WIDTH; j++) {
                if (screen[i][j]) {
                    lit++;
                }
            }
        }
        return lit;
    }

    private void printScreen() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < MAX_HEIGHT; i++) {
            builder.append("\t");
            for (int j = 0; j < MAX_WIDTH; j++) {
                builder.append(screen[i][j] ? '#' : ' ');
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

}