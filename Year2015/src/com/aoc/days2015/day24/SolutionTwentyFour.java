package com.aoc.days2015.day24;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyFour extends SolutionBase {

    private int[] packages;
    private int sum;
    private long smallestSize;
    private long smallestQuantumEntanglement = 0;

    SolutionTwentyFour(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        packages = new int[rows.length];
        for (int i = 0, rowsLength = rows.length; i < rowsLength; i++) {
            final String row = rows[i];
            final int value = Integer.valueOf(row);
            packages[i] = value;
            sum += value;
        }
        smallestSize = packages.length;
    }

    @Override
    protected void solvePartOne() {
        getSum(0, 0, new ArrayList<>(), 3);
        setSolutionOne(smallestQuantumEntanglement);
    }


    @Override
    protected void solvePartTwo() {
        smallestSize = packages.length;
        smallestQuantumEntanglement = 0;
        getSum(0, 0, new ArrayList<>(), 4);
        setSolutionTwo(smallestQuantumEntanglement);
    }

    private void getSum(final int from, final int subSum, final List<Integer> usedPackages, final int numberOfCompartments) {
        for (int i = from; i < packages.length; i++) {
            final int current = packages[i];
            final int newSubsum = subSum + current;
            if (newSubsum > sum || usedPackages.size() + 1 > smallestSize) {
                break;
            }
            if (newSubsum == sum / numberOfCompartments) {
                final List<Integer> used = new ArrayList<>(usedPackages);
                used.add(current);
                checkPossibleSolution(used);
            } else {
                final List<Integer> used = new ArrayList<>(usedPackages);
                used.add(current);
                getSum(i + 1, subSum + current, used, numberOfCompartments);
            }
        }
    }

    private void checkPossibleSolution(final List<Integer> weights) {
        if (weights.size() < smallestSize) {
            smallestSize = weights.size();
            long quantumEntanglement = 1;
            for (final Integer weight : weights) {
                quantumEntanglement *= weight;
            }
            smallestQuantumEntanglement = quantumEntanglement;
        } else if (weights.size() == smallestSize) {
            long quantumEntanglement = 1;
            for (final Integer weight : weights) {
                quantumEntanglement *= weight;
            }
            if (smallestQuantumEntanglement == 0 || smallestQuantumEntanglement > quantumEntanglement) {
                smallestQuantumEntanglement = quantumEntanglement;
            }
        }
    }

}