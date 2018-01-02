package com.aoc.days2016.day01;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionOne extends SolutionBase {
    private int[] visitedTwice = new int[]{};
    private String[] directions;
    private int currentDirection = 0; //0:n, 1:e, 2:s, 3:w
    private int[] currentLocation = new int[]{0, 0};
    private boolean partTwoSolved = false;
    private List<int[]> pastPositions = new ArrayList<>();

    SolutionOne(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        for (final String direction : directions) {
            setNewDirection(direction.charAt(0));
            final int distance = Integer.parseInt((direction.substring(1, direction.length())));
            move(distance);
        }
        setSolutionOne(Math.abs(currentLocation[0]) + Math.abs(currentLocation[1]));
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(Math.abs(visitedTwice[0]) + Math.abs(visitedTwice[1]));
    }

    private void move(final int distance) {
        if (partTwoSolved) {
            if (currentDirection > 1) {
                currentLocation[currentDirection % 2] -= distance;
            } else {
                currentLocation[currentDirection % 2] += distance;
            }
        } else {
            for (int i = 0; i < distance; i++) {
                if (currentDirection > 1) {
                    currentLocation[currentDirection % 2]--;
                } else {
                    currentLocation[currentDirection % 2]++;
                }
                if (!pastPositionContains()) {
                    pastPositions.add(new int[]{currentLocation[0], currentLocation[1]});
                } else {
                    partTwoSolved = true;
                    visitedTwice = new int[]{currentLocation[0], currentLocation[1]};
                }
            }
        }
    }

    private boolean pastPositionContains() {
        boolean contains = false;
        for (final int[] pastLocation : pastPositions) {
            if (pastLocation[0] == currentLocation[0] && pastLocation[1] == currentLocation[1]) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    private void setNewDirection(final char orientation) {
        currentDirection = (currentDirection + (orientation == 'R' ? 1 : -1)) % 4;
        if (currentDirection < 0) {
            currentDirection = 3;
        }
    }

    private void parseInput() {
        directions = input.split(", ");
        pastPositions.add(new int[]{0, 0});
    }
}