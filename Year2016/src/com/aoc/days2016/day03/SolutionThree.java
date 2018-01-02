package com.aoc.days2016.day03;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionThree extends SolutionBase {

    private int[][] triangles;

    SolutionThree(final String day) {
        super(day);
    }

    private static boolean isTriangleValid(final int side0, final int side1, final int side2) {
        return (side0 + side1 > side2) && (side1 + side2 > side0) && (side2 + side0 > side1);
    }

    @Override
    public void init() {
        parseInput();
    }

    @Override
    protected void solvePartOne() {
        int validTriangles = 0;
        for (final int[] sides : triangles) {
            if (isTriangleValid(sides[0], sides[1], sides[2])) {
                validTriangles++;
            }
        }
        setSolutionOne(validTriangles);
    }

    @Override
    protected void solvePartTwo() {
        int validTriangles = 0;
        for (int i = 0; i < triangles.length; i += 3) {
            for (int j = 0; j < 3; j++) {
                if (isTriangleValid(triangles[i][j], triangles[i + 1][j], triangles[i + 2][j])) {
                    validTriangles++;
                }
            }
        }
        setSolutionTwo(validTriangles);
    }

    private void parseInput() {
        final String[] rows = input.split("\n");
        triangles = new int[rows.length][3];
        for (int i = 0; i < rows.length; i++) {
            final String[] stringSides = rows[i].trim().replaceAll(" +", " ").split(" ");
            final int[] sides = new int[]{
                    Integer.parseInt(stringSides[0]),
                    Integer.parseInt(stringSides[1]),
                    Integer.parseInt(stringSides[2]),
            };
            triangles[i] = sides;
        }
    }
}