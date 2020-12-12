package com.aoc.days2020.day03;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionThree extends SolutionBase {

    private static final char TREE = '#';

    private char[][] map;

    SolutionThree(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        map = new char[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                map[i][j] = rows[i].charAt(j);
            }
        }
    }

    @Override
    protected void solvePartOne() {
        final int treeCount = getNumberOfTreesHit(3, 1);
        setSolutionOne(treeCount);
    }

    @Override
    protected void solvePartTwo() {
        final int[][] offsets = new int[][]{
            new int[]{1, 1},
            new int[]{3, 1},
            new int[]{5, 1},
            new int[]{7, 1},
            new int[]{1, 2},
        };
        int multipliedTreesHit = 1;
        for (final int[] offset : offsets) {
            final int treesHit = getNumberOfTreesHit(offset[0], offset[1]);
            multipliedTreesHit *= treesHit;
        }
        setSolutionTwo(multipliedTreesHit);
    }

    private int getNumberOfTreesHit(final int columnOffset, final int rowOffset) {
        int treeCount = 0;
        int column = 0;
        for (int i = 0; i < map.length; i = i + rowOffset) {
            final boolean hitTree = map[i][column] == TREE;
            if (hitTree) {
                treeCount++;
            }
            column = (column + columnOffset) % map[i].length;
        }
        return treeCount;
    }

}