package com.aoc.days2015.day17;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionSeventeen extends SolutionBase {

    private static final int MAX_EGGNOG = 150;

    private int[] containers;
    private int numberOfMinimalContainerGroups = 0;

    SolutionSeventeen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] split = input.split("\n");
        containers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            final String row = split[i];
            containers[i] = Integer.parseInt(row);
        }
    }

    @Override
    protected void solvePartOne() {
        boolean[] inUse = new boolean[containers.length];
        int diff = 0;
        int minAmountOfContainers = inUse.length;
        while (!allTrue(inUse)) {
            final int sum = calculateLiter(inUse);
            if (sum == MAX_EGGNOG) {
                diff++;
                final int count = countContainers(inUse);
                if (minAmountOfContainers > count) {
                    numberOfMinimalContainerGroups = 1;
                    minAmountOfContainers = count;
                } else if (minAmountOfContainers == count) {
                    numberOfMinimalContainerGroups++;
                }
            }
            increment(inUse);
        }
        setSolutionOne(diff);
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(numberOfMinimalContainerGroups);
    }

    private int calculateLiter(final boolean[] inUse) {
        int sum = 0;
        for (int i = 0; i < inUse.length; i++) {
            if (inUse[i]) {
                sum += containers[i];
                if (sum > MAX_EGGNOG) {
                    sum = 0;
                    break;
                }
            }
        }
        return sum;
    }

    private int countContainers(final boolean[] inUse) {
        int count = 0;
        for (final boolean used : inUse) {
            if (used) {
                count++;
            }
        }
        return count;
    }

    private void increment(final boolean[] inUse) {
        boolean b = true;
        for (int i = inUse.length - 1; i >= 0; i--) {
            inUse[i] = !inUse[i];
            if (inUse[i]) {
                b = false;
            }
            if (!b) {
                break;
            }
        }
    }

    private boolean allTrue(final boolean[] inUse) {
        boolean b = true;
        for (final boolean used : inUse) {
            if (!used) {
                b = false;
                break;
            }
        }
        return b;
    }
}