package com.aoc.days2017.day11;

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

    private List<String> inputDirections = new ArrayList<>();
    private int maxDistance = 0;

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        simplifyList();
        setSolutionOne(inputDirections.size());
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(maxDistance);
    }

    /**
     * We have to prioritize removing the opposite directions.
     * So if there is a direction which is opposite to the new direction, we ought to remove that first,
     * then if we cannot find one, replace (to whatever position) the almost-opposite direction.
     * If none found, just add the new direction.
     * Since replacing does not increase the current distance, we ought to increment it only if a new element is added,
     * or decrease it when an opposite direction is discovered.
     */
    private void simplifyList() {
        final String[] newDirections = ((String) input).split(",");
        int currentDistance = 0;
        final List<String> finalPath = new ArrayList<>();
        for (final String newDirection : newDirections) {
            boolean foundReplacement = false;
            String dist2Away = null;
            for (final String savedDirection : finalPath) {
                final int dist = getDistanceBetweenTwoDirections(newDirection, savedDirection);
                if (dist == 3) {
                    finalPath.remove(savedDirection);
                    currentDistance--;
                    foundReplacement = true;
                    break;
                }
                if (dist == 2 && dist2Away == null) {
                    dist2Away = savedDirection;
                }
            }
            if (!foundReplacement) {
                if (dist2Away != null) {
                    finalPath.remove(dist2Away);
                    finalPath.add(getBetweenDirection(newDirection, dist2Away));
                } else {
                    currentDistance++;
                    if (currentDistance > maxDistance) {
                        maxDistance = currentDistance;
                    }
                    finalPath.add(newDirection);
                }
            }
        }
        inputDirections = finalPath;
    }

    private String getBetweenDirection(final String dirOne, final String dirTwo) {
        return DIRECTIONS.get(dirOne).getNextDirection().equals(DIRECTIONS.get(dirTwo).getPreviousDirection())
            ? DIRECTIONS.get(dirOne).getNextDirection().getDirectionName()
            : DIRECTIONS.get(dirOne).getPreviousDirection().getDirectionName();
    }

    private int getDistanceBetweenTwoDirections(final String directionOne, final String directionTwo) {
        return DIRECTIONS.get(directionOne).getDistance(directionTwo);
    }

}
