package com.aoc.days2015.day03;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionThree extends SolutionBase {

    private final List<int[]> positions = new ArrayList<>();

    private int positionX = 0;
    private int positionY = 0;
    private int roboPositionX = 0;
    private int roboPositionY = 0;

    SolutionThree(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        positions.add(new int[]{0, 0});
        for (final char direction : input.toCharArray()) {
            step(direction, false);
            if (!checkIfContains(positionX, positionY)) {
                positions.add(new int[]{positionX, positionY});
            }
        }
        this.setSolutionOne(positions.size());
    }

    @Override
    protected void solvePartTwo() {
        positions.clear();
        positions.add(new int[]{0, 0});
        positionX = 0;
        positionY = 0;
        boolean isRoboSantasStep = false;
        for (final char direction : input.toCharArray()) {
            step(direction, isRoboSantasStep);
            if (isRoboSantasStep) {
                if (!checkIfContains(roboPositionX, roboPositionY)) {
                    positions.add(new int[]{roboPositionX, roboPositionY});
                }
            } else if (!checkIfContains(positionX, positionY)) {
                positions.add(new int[]{positionX, positionY});
            }
            isRoboSantasStep = !isRoboSantasStep;
        }
        this.setSolutionTwo(positions.size());
    }

    private void step(final char direction, final boolean isRoboSantaStepping) {
        switch (direction) {
            case '^':
                if (isRoboSantaStepping) {
                    roboPositionY--;
                } else {
                    positionY--;
                }
                break;
            case 'v':
                if (isRoboSantaStepping) {
                    roboPositionY++;
                } else {
                    positionY++;
                }
                break;
            case '>':
                if (isRoboSantaStepping) {
                    roboPositionX++;
                } else {
                    positionX++;
                }
                break;
            case '<':
                if (isRoboSantaStepping) {
                    roboPositionX--;
                } else {
                    positionX--;
                }
                break;
            default:
                System.out.println("Unexpected character: " + direction);
                break;
        }
    }

    private boolean checkIfContains(final int x, final int y) {
        boolean contains = false;
        for (final int[] position : positions) {
            if (position[0] == x && position[1] == y) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}