package com.aoc.days.dayeleven;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka.
 */
class SolutionEleven extends SolutionBase {

    private static final String[] DIRECTION_NAMES = new String[]{"n", "ne", "se", "s", "sw", "nw"};
    private static final Map<String, Direction> DIRECTIONS = new HashMap<>();

    private final List<String> inputDirections = new ArrayList<>();

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        init();
        initInputDirections();
        setSolutionOne(inputDirections.size());
    }

    @Override
    protected void solvePartTwo() {

    }

    private void initInputDirections() {
        final String[] directions = ((String) input).split(",");
        for (final String direction : directions) {
            String toRemove = null;
            String toAdd = null;
            for (final String savedDirection : inputDirections) {
                if (!direction.equals(savedDirection)) {
                    final int distance = getDistanceBetweenTwoDirections(direction, savedDirection);
                    if (distance == 3) {
                        toRemove = savedDirection;
                        break;
                    } else if (distance == 2) {
                        toAdd = getBetweenDirection(direction, savedDirection);
                        toRemove = savedDirection;
                        break;
                    }
                }
            }
            if (toRemove != null) {
                inputDirections.remove(toRemove);
            }
            if (toAdd != null) {
                inputDirections.add(toAdd);
            }
            if (toRemove == null && toAdd == null) {
                inputDirections.add(direction);
            }
        }
    }

    private String getBetweenDirection(final String directionOne, final String directionTwo) {
        return DIRECTIONS.get(directionOne).getNextDirection().equals(DIRECTIONS.get(directionTwo).getPreviousDirection())
            ? DIRECTIONS.get(directionOne).getNextDirection().getDirection()
            : DIRECTIONS.get(directionOne).getPreviousDirection().getDirection();
    }


    private int getDistanceBetweenTwoDirections(final String directionOne, final String directionTwo) {
        int lofasz = 0;
        try {
            lofasz = DIRECTIONS.get(directionOne).getDistance(directionTwo);
        } catch (Exception e) {
            System.out.println("Fuck you");
        }
        return lofasz;
    }

    private void init() {
        Direction head = null;
        Direction prevDirection = null;
        for (int i = 0; i < 6; i++) {
            if (head == null) {
                head = new Direction(DIRECTION_NAMES[i]);
                prevDirection = head;
                DIRECTIONS.put(DIRECTION_NAMES[i], head);
            } else {
                final Direction newDir = new Direction(DIRECTION_NAMES[i]);
                prevDirection.setNextDirection(newDir);
                newDir.setPreviousDirection(prevDirection);
                prevDirection = newDir;
                DIRECTIONS.put(DIRECTION_NAMES[i], newDir);
            }
        }
        head.setPreviousDirection(prevDirection);
        prevDirection.setNextDirection(head);
    }


}
