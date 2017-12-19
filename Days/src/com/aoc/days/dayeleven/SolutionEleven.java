package com.aoc.days.dayeleven;

import com.aoc.solutionbase.SolutionBase;

import java.util.*;

/**
 * @author maczaka.
 */
class SolutionEleven extends SolutionBase {

    private static final List<String> DIRECTIONS = new ArrayList<>();
    private static final Map<String, Integer> DISTANCE = new HashMap<>();
    private static final Random rnd = new Random();

    static {
        DIRECTIONS.add("n");
        DIRECTIONS.add("ne");
        DIRECTIONS.add("se");
        DIRECTIONS.add("s");
        DIRECTIONS.add("sw");
        DIRECTIONS.add("nw");
    }

    private final List<String> inputDirections = new ArrayList<>();
    private final Map<String, Integer> directionalDistance = new HashMap<>();
    private String currentDirection;
    private Integer distance = 1;

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getDistanceBetweenDirections(DIRECTIONS.get(rnd.nextInt(6)), DIRECTIONS.get(rnd.nextInt(6))));
        }
//        getDistanceBetweenDirections("nw", "sw");
    }

    @Override
    protected void solvePartTwo() {

    }

    private void getNextDirection(final String newDirection) {
        final int distanceBetweenDirections =
                Math.abs(DIRECTIONS.indexOf(currentDirection) - DIRECTIONS.indexOf(newDirection));
        if (distanceBetweenDirections != 3) {
            if (distanceBetweenDirections == 2) {

            }
        }
    }

    private int getDistanceBetweenDirections(final String startDirection, final String directionToFind) {
        return Integer.min((DIRECTIONS.indexOf(startDirection) - DIRECTIONS.indexOf(directionToFind)) % 6,
                (DIRECTIONS.indexOf(directionToFind) - DIRECTIONS.indexOf(startDirection)) % 6);
    }


    void init() {
        inputDirections.addAll(Arrays.asList(((String) input).split(",")));
        currentDirection = inputDirections.get(0);
    }

    private void addToDistance(final String direction) {
        directionalDistance.put(direction, DISTANCE.get(direction) + directionalDistance.get(direction));
    }

    private void calculateDistance() {

    }


}
