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

    static {
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

    private Integer distance = null;
    private List<String> inputDirections = new ArrayList<>();

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
//        inputDirections.addAll(Arrays.asList(((String) input).split(",")));
//        boolean needsSimplifying = simplifyDirections();
//        while (needsSimplifying) {
//            needsSimplifying = simplifyDirections();
//        }
        simplifyListTwo();
        setSolutionOne(inputDirections.size());
        // setSolutionOne(inputDirections.size());
    }

    @Override
    protected void solvePartTwo() {
        //setSolutionTwo(distance);
    }

    private boolean simplifyDirections() {
        boolean needRestart = false;
        final List<String> newDirections = new ArrayList<>(inputDirections);
        int maxDistance = 0;
        for (int i = 0; i < inputDirections.size(); i++) {
            maxDistance++;
            String savedDirection = inputDirections.get(i);
            for (final String direction : newDirections) {
                final int distance = getDistanceBetweenTwoDirections(direction, savedDirection);
                if (distance == 3) {
                    newDirections.remove(direction);
                    newDirections.remove(savedDirection);
                    needRestart = true;
                    maxDistance--;
                } else if (distance == 2) {
                    newDirections.add(getBetweenDirection(direction, savedDirection));
                    newDirections.remove(direction);
                    newDirections.remove(savedDirection);
                    needRestart = true;
                }
                if (needRestart) {
                    break;
                }
            }
            if (needRestart) {
                inputDirections = newDirections;
            }
        }
        if (distance == null) {
            distance = maxDistance;
        }
        return needRestart;
    }

    private void simplifyListTwo() {
        final String[] newDirections = ((String) input).split(",");
        int currentDistance = 0;
        int maxDistance = 0;
        final List<String> finalPath = new ArrayList<>();
        for (final String newDirection : newDirections) {
            boolean foundReplacement = false;
            final String direction3Away = getDirectionWithNDistanceAway(finalPath, newDirection, 3);
            if (direction3Away != null) {
                finalPath.remove(direction3Away);
                currentDistance--;
                foundReplacement = true;
            } else {
                final String direction2Away = getDirectionWithNDistanceAway(finalPath, newDirection, 2);
                if (direction2Away != null) {
                    finalPath.remove(direction2Away);
                    finalPath.add(getBetweenDirection(newDirection, direction2Away));
                    foundReplacement = true;
                }
            }
            if (!foundReplacement) {
                currentDistance++;
                if (currentDistance > maxDistance) {
                    maxDistance = currentDistance;
                }
                finalPath.add(newDirection);
            }
        }
        inputDirections = finalPath;
        setSolutionTwo(maxDistance);
    }

    private String getDirectionWithNDistanceAway(final List<String> directions, final String direction, final int distance) {
        String directionWithNDistance = null;
        for (final String savedDirection : directions) {
            if (getDistanceBetweenTwoDirections(savedDirection, direction) == distance) {
                directionWithNDistance = savedDirection;
                break;
            }
        }
        return directionWithNDistance;
    }

    private String getBetweenDirection(final String dirOne, final String dirTwo) {
        return DIRECTIONS.get(dirOne).getNextDirection().equals(DIRECTIONS.get(dirTwo).getPreviousDirection())
            ? DIRECTIONS.get(dirOne).getNextDirection().getDirection()
            : DIRECTIONS.get(dirOne).getPreviousDirection().getDirection();
    }

    private int getDistanceBetweenTwoDirections(final String directionOne, final String directionTwo) {
        return DIRECTIONS.get(directionOne).getDistance(directionTwo);
    }

}
