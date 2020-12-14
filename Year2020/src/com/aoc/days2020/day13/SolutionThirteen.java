package com.aoc.days2020.day13;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionThirteen extends SolutionBase {

    private int departureTime;
    private List<Integer> buses = new ArrayList<>();
    private List<Integer> differences = new ArrayList<>();

    SolutionThirteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        departureTime = Integer.parseInt(rows[0]);
        int difference = 0;
        for (final String possibleBuses : rows[1].split(",")) {
            if (!possibleBuses.equals("x")) {
                differences.add(difference);
                buses.add(Integer.valueOf(possibleBuses));
            }
            difference++;
        }
        differences.remove(0);
    }

    @Override
    protected void solvePartOne() {
        int closestDepartureTime = 0;
        int busToChoose = 0;
        for (final Integer bus : buses) {
            final Integer nextDepartureTime = ((this.departureTime / bus) + 1) * bus;
            if (closestDepartureTime == 0 || nextDepartureTime < closestDepartureTime) {
                closestDepartureTime = nextDepartureTime;
                busToChoose = bus;
            }
        }
        setSolutionOne(busToChoose * (closestDepartureTime - departureTime));
    }

    @Override
    protected void solvePartTwo() {
        long offset = buses.get(0);
        long previousTimestamp = 0;
        for (int i = 0; i < buses.size() - 1; i++) {
            final Integer currentBus = buses.get(i + 1);
            final long timestamp = getSubsequentTimestamp(currentBus, differences.get(i), previousTimestamp, offset);
            offset *= currentBus;
            previousTimestamp = timestamp;
        }
        setSolutionTwo(previousTimestamp);
    }

    private long getSubsequentTimestamp(final int secondBus, final int difference, final long start, final long offset) {
        long i = start;
        boolean found = false;
        while (!found) {
            i += offset;
            found = (i + difference) % secondBus == 0;
        }
        return i;
    }

}