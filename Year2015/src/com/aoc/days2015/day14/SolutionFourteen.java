package com.aoc.days2015.day14;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionFourteen extends SolutionBase {

    private static final int RACE_LENGTH = 2503;
    private final Map<String, Reindeer> reindeers = new HashMap<>();
    private final Map<String, Integer> points = new HashMap<>();

    SolutionFourteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll(" can fly ", " ")
            .replaceAll(" km/s for ", " ")
            .replaceAll(" seconds, but then must rest for ", " ")
            .replaceAll(" seconds\\.", " ");
        for (final String row : input.split("\n")) {
            final String[] parts = row.split(" ");
            reindeers.put(parts[0], new Reindeer(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3])));
        }
    }

    @Override
    protected void solvePartOne() {
        for (int i = 0; i < RACE_LENGTH; i++) {
            for (final Reindeer reindeer : reindeers.values()) {
                reindeer.race();
            }
        }
        final String firstReindeer = searchForFirstDeers().iterator().next();
        setSolutionOne(reindeers.get(firstReindeer).getTraveled());
    }

    @Override
    protected void solvePartTwo() {
        for (final Map.Entry<String, Reindeer> entry : reindeers.entrySet()) {
            points.put(entry.getKey(), 0);
            entry.getValue().reset();
        }
        for (int i = 0; i < RACE_LENGTH; i++) {
            for (final Reindeer reindeer : reindeers.values()) {
                reindeer.race();
            }
            final Set<String> firstPlaces = searchForFirstDeers();
            for (final String name : firstPlaces) {
                points.put(name, points.get(name) + 1);
            }
        }
        int maxPoint = 0;
        for (final Map.Entry<String, Integer> entry : points.entrySet()) {
            if (maxPoint < entry.getValue()) {
                maxPoint = entry.getValue();
            }
        }
        setSolutionTwo(maxPoint);
    }

    private Set<String> searchForFirstDeers() {
        final Set<String> firstPlace = new HashSet<>();
        int max = 0;
        for (final Map.Entry<String, Reindeer> entry : reindeers.entrySet()) {
            final Reindeer reindeer = entry.getValue();
            if (max < reindeer.getTraveled()) {
                max = reindeer.getTraveled();
                firstPlace.clear();
                firstPlace.add(entry.getKey());
            } else if (max == reindeer.getTraveled()) {
                firstPlace.add(entry.getKey());
            }
        }
        return firstPlace;
    }
}