package com.aoc.days.daytwentytwo;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka.
 */
class SolutionTwentyTwo extends SolutionBase {

    private final Map<Coordinate, Boolean> nodeMap = new HashMap<>();
    private final Map<Coordinate, Integer> flagMap = new HashMap<>();

    SolutionTwentyTwo(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        setSolutionOne(simulateInfection(10000, false));
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(simulateInfection(10000000, true));
    }

    private int simulateInfection(final int cycleLimit, final boolean isPartTwo) {
        parseInput();
        final int center = (int) Math.sqrt(nodeMap.size()) / 2;
        final Carrier carrier = new Carrier(center, center);
        for (int i = 0; i < cycleLimit; i++) {
            if (!isPartTwo) {
                carrier.burst(getInfectedStatusByCoordinate(carrier.getCoordinates()));
            } else {
                carrier.burstTwo(getFlagByCoordinate(carrier.getCoordinates()));
            }
        }
        return carrier.getInfectedNodes();
    }

    private void parseInput() {
        nodeMap.clear();
        flagMap.clear();
        final String[] rows = ((String) input).split("\n");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                final boolean infected = rows[i].charAt(j) == '#';
                final Coordinate newCoordinate = new Coordinate(i, j);
                nodeMap.put(newCoordinate, infected);
                flagMap.put(newCoordinate, infected ? 2 : 0);
            }
        }
    }

    //change values as we go, but burst with the old one
    private boolean getInfectedStatusByCoordinate(final Coordinate coordinate) {
        Boolean infected = nodeMap.get(coordinate);
        if (infected == null) {
            infected = false;
            nodeMap.put(coordinate, true);
        } else {
            nodeMap.put(coordinate, !infected);
        }
        return infected;
    }

    //change value as we go, but burst with the old one
    private Integer getFlagByCoordinate(final Coordinate coordinate) {
        Integer flag = flagMap.get(coordinate);
        if (flag == null) {
            flag = 0;
            flagMap.put(coordinate, 1);
        } else {
            flagMap.put(coordinate, (flag + 1) % 4);
        }
        return flag;
    }


}
