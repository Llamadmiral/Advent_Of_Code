package com.aoc.days2015.day09;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionNine extends SolutionBase {
    private final List<CityDistance> cityDistances = new ArrayList<>();
    private final List<String> cityNames = new ArrayList<>();

    SolutionNine(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll(" to ", " ").replaceAll(" = ", " ");
        for (final String row : input.split("\n")) {
            final String[] descriptor = row.split(" ");
            boolean hasAlreadyDescriptor = false;
            for (final CityDistance cityDistance : cityDistances) {
                if (cityDistance.getStart().equals(descriptor[0]) && cityDistance.getEnd().equals(descriptor[1])) {
                    hasAlreadyDescriptor = true;
                    break;
                }
            }
            if (!hasAlreadyDescriptor) {
                cityDistances.add(new CityDistance(descriptor[0], descriptor[1], Integer.valueOf(descriptor[2])));
                cityDistances.add(new CityDistance(descriptor[1], descriptor[0], Integer.valueOf(descriptor[2])));
            }
            if (!cityNames.contains(descriptor[0])) {
                cityNames.add(descriptor[0]);
            }

            if (!cityNames.contains(descriptor[1])) {
                cityNames.add(descriptor[1]);
            }
        }
    }

    @Override
    protected void solvePartOne() {
        final String[] cityArray = cityNames.toArray(new String[0]);
        final List<String[]> result = new ArrayList<>();
        SolutionHelper.doPermutations(result, cityArray, new String[0]);
        int min = generateDistance(result.get(0));
        int max = 0;
        for (int i = 1; i < result.size(); i++) {
            final String[] row = result.get(i);
            int distance = generateDistance(row);
            if (distance < min) {
                min = distance;
            }
            if (distance > max) {
                max = distance;
            }
        }
        setSolutionOne(min);
        setSolutionTwo(max);
    }

    @Override
    protected void solvePartTwo() {
    }

    private int generateDistance(final String[] cities) {
        int distance = 0;
        for (int i = 0; i < cities.length - 1; i++) {
            final String start = cities[i];
            final String end = cities[i + 1];
            final CityDistance cityDistance = findCity(start, end);
            distance += cityDistance.getDistance();
        }
        return distance;
    }

    private CityDistance findCity(final String start, final String end) {
        CityDistance distance = null;
        for (final CityDistance cityDistance : cityDistances) {
            if (cityDistance.getStart().equals(start) && cityDistance.getEnd().equals(end)) {
                distance = cityDistance;
                break;
            }
        }
        return distance;
    }
}