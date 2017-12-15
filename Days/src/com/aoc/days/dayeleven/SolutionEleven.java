package com.aoc.days.dayeleven;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka.
 */
class SolutionEleven extends SolutionBase {

    private static final Map<String, Integer> DISTANCE = new HashMap<>();

    static {
        DISTANCE.put("n", 1);
        DISTANCE.put("ne", 1);
        DISTANCE.put("se", 1);
        DISTANCE.put("s", -1);
        DISTANCE.put("sw", -1);
        DISTANCE.put("nw", -1);
    }

    private final List<String> directions = new ArrayList<>();
    private final Map<String, Integer> directionalDistance = new HashMap<>();

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        init();
        directions.forEach(this::addToDistance);
        calculateDistance();
    }

    @Override
    protected void solvePartTwo() {

    }

    void init() {
        directions.addAll(Arrays.asList(((String) input).split(",")));
        directionalDistance.put("n", 0);
        directionalDistance.put("ne", 0);
        directionalDistance.put("se", 0);
        directionalDistance.put("s", 0);
        directionalDistance.put("sw", 0);
        directionalDistance.put("nw", 0);
    }

    private void addToDistance(final String direction) {
        directionalDistance.put(direction, DISTANCE.get(direction) + directionalDistance.get(direction));
    }

    private void calculateDistance() {
        final Integer n = directionalDistance.get("n") + directionalDistance.get("s");
        final Integer ne = directionalDistance.get("ne") + directionalDistance.get("sw");
        final Integer se = directionalDistance.get("se") + directionalDistance.get("nw");
        setSolutionOne(n + ne + se);
    }


}
