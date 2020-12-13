package com.aoc.days2020.day09;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionNine extends SolutionBase {

    private static final int PRE_AMBLE_LENGTH = 25;

    private long[] numbers;
    private long invalidNumber = 0;

    SolutionNine(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] split = input.split("\n");
        numbers = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Long.parseLong(split[i]);
        }
    }

    @Override
    protected void solvePartOne() {
        boolean isSum;
        for (int i = PRE_AMBLE_LENGTH; i < numbers.length; i++) {
            isSum = isSumOfPrevious(i);
            if (!isSum) {
                invalidNumber = numbers[i];
                break;
            }
        }
        setSolutionOne(invalidNumber);
    }

    @Override
    protected void solvePartTwo() {
        final long sum = getSumOfContigousList();
        setSolutionTwo(sum);
    }

    private boolean isSumOfPrevious(final int index) {
        boolean isSum = false;
        for (int i = index - PRE_AMBLE_LENGTH; i < index; i++) {
            for (int j = index - PRE_AMBLE_LENGTH; j < index; j++) {
                if (i != j && numbers[i] + numbers[j] == numbers[index]) {
                    isSum = true;
                    break;
                }
            }
            if (isSum) {
                break;
            }
        }
        return isSum;
    }

    private long getSumOfContigousList() {
        long result = 0;
        for (int i = 0; i < numbers.length; i++) {
            long min = numbers[i];
            long max = numbers[i];
            long currentCount = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                min = Long.min(numbers[j], min);
                max = Long.max(numbers[j], max);
                currentCount += numbers[j];
                if (currentCount > invalidNumber) {
                    break;
                } else if (currentCount == invalidNumber) {
                    result = min + max;
                    break;
                }
            }
            if (result != 0) {
                break;
            }
        }
        return result;
    }

}