package com.aoc.days2019.day04;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {

    SolutionFour(final String day) {
        super(day);
    }

    private int min;
    private int max;

    private int firstCounter = 0;
    private int secondCounter = 0;

    @Override
    public void init() {
        String[] range = input.split("-");
        min = Integer.parseInt(range[0]);
        max = Integer.parseInt(range[1]);
    }

    @Override
    protected void solvePartOne() {
        int diff = max - min;
        int[] number = toArray(min);
        for (int i = 0; i < diff; i++) {
            boolean valid = valid(number, false);
            if (valid) {
                firstCounter++;
            }
            if (valid && valid(number, true)) {
                secondCounter++;
            }
            increase(number);
        }
        setSolutionOne(firstCounter);
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(secondCounter);
    }

    private boolean valid(int[] number, boolean strict) {
        boolean hasSameAdjacent = false;
        boolean decreases = false;
        for (int i = 0; i < number.length - 1; i++) {
            int current = number[i];
            int next = number[i + 1];
            if (!hasSameAdjacent && current == next) {
                if (strict) {
                    boolean largerGroup = (i > 0 && number[i - 1] == current)
                            || (i + 2 <= number.length - 1 && number[i + 2] == next);
                    hasSameAdjacent = !largerGroup;
                } else {
                    hasSameAdjacent = true;
                }
            }
            if (current > next) {
                decreases = true;
                break;
            }
        }
        return hasSameAdjacent && !decreases;
    }

    private void increase(int[] number) {
        for (int i = number.length - 1; i >= 0; i--) {
            int n = number[i] + 1;
            if (n == 10) {
                number[i] = 0;
            } else {
                number[i] = n;
                break;
            }
        }
    }

    private int[] toArray(int number) {
        String sNum = String.valueOf(number);
        int[] arr = new int[sNum.length()];
        for (int i = 0; i < sNum.length(); i++) {
            arr[i] = sNum.charAt(i) - '0';
        }
        return arr;
    }
}