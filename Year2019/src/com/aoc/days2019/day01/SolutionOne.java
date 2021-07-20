package com.aoc.days2019.day01;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionOne extends SolutionBase {

    final private List<Integer> fuelList = new ArrayList<>();

    SolutionOne(final String day) {
        super(day);
    }

    @Override
    public void init() {
        for (final String row : input.split("\n")) {
            fuelList.add(Integer.valueOf(row));
        }
    }

    @Override
    protected void solvePartOne() {
        int sum = 0;
        for (final Integer fuel : fuelList) {
            sum += calculateFuel(fuel);
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        int sum = 0;
        for (final Integer fuel : fuelList) {
            sum += calculateFuel(fuel, 0);
        }
        setSolutionTwo(sum);
    }

    private int calculateFuel(final int starterFuel, final int currentFuel) {
        final int requiredFuel = calculateFuel(starterFuel);
        if (requiredFuel > 0) {
            return calculateFuel(requiredFuel, currentFuel + requiredFuel);
        }
        return currentFuel;
    }

    private int calculateFuel(final int starterFuel) {
        return (starterFuel / 3) - 2;
    }
}