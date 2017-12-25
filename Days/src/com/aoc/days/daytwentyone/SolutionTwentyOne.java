package com.aoc.days.daytwentyone;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aoc.days.daytwentyone.MatrixHelper.copyMatrixBlocks;
import static com.aoc.days.daytwentyone.MatrixHelper.getDeterminantOfMatrix;

/**
 * @author maczaka
 */
class SolutionTwentyOne extends SolutionBase {

    private static final String STARTING_POSITION = ".#./" +
            "..#/" +
            "###";

    private static final int[][] DETERMINANT_TEST = new int[][]{
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1},
            new int[]{1, 0, 0, 1,1, 0, 0, 1,1, 0, 0, 1}
    };

    private final Map<Pattern, Pattern> ruleBook = new HashMap<>();
    private Pattern art;


    SolutionTwentyOne(String day) {
        super(day);
    }


    @Override
    protected void solvePartOne() {
//        System.out.println(getDeterminantOfMatrix(DETERMINANT_TEST));
        parseInput();
        art = new Pattern(STARTING_POSITION);
        for (int i = 0; i < 5; i++) {
            enhance(art);
        }
        setSolutionOne(art.getCount());
    }

    @Override
    protected void solvePartTwo() {

    }


    private void enhance(final Pattern matrix) {
        List<int[][]> splittedMatrixes = splitMatrix(matrix.getMatrix());
        List<int[][]> newMatrixSplitted = new ArrayList<>();
        for (final int[][] splittedMatrix : splittedMatrixes) {
            for (final Map.Entry<Pattern, Pattern> rule : ruleBook.entrySet()) {
                if (rule.getKey().matrixEqualsWith(splittedMatrix)) {
                    newMatrixSplitted.add(rule.getValue().getMatrix());
                    break;
                }
            }
        }
        this.art.setMatrix(glueMatrixesTogether(newMatrixSplitted));
    }

    private int[][] glueMatrixesTogether(final List<int[][]> matrixes) {
        int[][] newMatrix;
        if (matrixes.size() != 1) {
            final int size = matrixes.get(0).length;
            final int limit = matrixes.size() % 2 == 0 ? 2 : 3;
            final int newSize = (matrixes.size() / limit) * size;
            newMatrix = new int[newSize][newSize];
            for (int i = 0; i < matrixes.size(); i++) {
                final int[][] subMatrix = matrixes.get(i);
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        newMatrix[(i + j) % newSize][(i + k) % newSize] = subMatrix[j][k];
                    }
                }
            }
        } else {
            newMatrix = matrixes.get(0);
        }
        return newMatrix;
    }

    private List<int[][]> splitMatrix(final int[][] matrix) {
        final List<int[][]> splittedMatrix = new ArrayList<>();
        final int size = matrix.length;
        final int limit = size % 2 == 0 ? 2 : 3;
        for (int i = 0; i < size / limit; i++) {
            for (int j = 0; j < size / limit; j++) {
                splittedMatrix.add(copyMatrixBlocks(limit, i * limit, j * limit, matrix));
            }
        }
        return splittedMatrix;
    }


    private void parseInput() {
        final String[] rules = ((String) input).split("\n");
        for (final String rule : rules) {
            final String[] ruleParts = rule.split(" => ");
            ruleBook.put(new Pattern(ruleParts[0]), new Pattern(ruleParts[1]));
        }
    }
}
