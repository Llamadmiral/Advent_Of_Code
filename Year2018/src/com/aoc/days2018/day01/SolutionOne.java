package com.aoc.days2018.day01;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionOne extends SolutionBase {
    private List<Integer> frequencies = new ArrayList<>();

    SolutionOne(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        int sum = 0;
        for (final Integer frequency : frequencies) {
            sum += frequency;
        }
        this.setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        int sum = 0;
        final Set<Integer> integers = new HashSet<>();
        integers.add(0);
        boolean found = false;
        int i = 0;
        while (!found) {
            sum += frequencies.get(i);
            if (integers.contains(sum)) {
                found = true;
                setSolutionTwo(sum);
            }
            integers.add(sum);
            i++;
            if (i == frequencies.size()) {
                i = 0;
            }
        }

    }

    private void prepareInput() {
        for (final String row : input.split("\n")) {
            frequencies.add(Integer.parseInt(row));
        }
    }


}