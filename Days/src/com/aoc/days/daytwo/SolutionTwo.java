package com.aoc.days.daytwo;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwo extends SolutionBase {

    protected SolutionTwo(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int sum = 0;
        List<List<Integer>> matrix = SolutionHelper.createIntegerMatrix((List<String>) input);
        for (final List<Integer> integers : matrix) {
            int min = integers.get(0);
            int max = integers.get(0);
            for (int i = 1, integersSize = integers.size(); i < integersSize; i++) {
                final Integer curr = integers.get(i);
                if (min > curr) {
                    min = curr;
                }
                if (max < curr) {
                    max = curr;
                }
            }
            sum += max - min;
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        int sum = 0;
        List<List<Integer>> matrix = SolutionHelper.createIntegerMatrix((List<String>) input);
        for (final List<Integer> integers : matrix) {
            sum += getDividedNumber(integers);
        }
        setSolutionTwo(sum);
    }

    private int getDividedNumber(final List<Integer> integers) {
        int divided = 0;
        for (final Integer one : integers) {
            for (final Integer two : integers) {
                boolean needBreak = false;
                if (!one.equals(two)) {
                    if (one % two == 0) {
                        divided = one / two;
                        needBreak = true;
                    } else if (two % one == 0) {
                        divided = two / one;
                        needBreak = true;
                    }
                }
                if (needBreak) {
                    break;
                }
            }
        }
        return divided;
    }
}
