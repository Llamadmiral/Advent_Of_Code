package com.aoc.days.daytwentytwo;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka.
 */
class SolutionTwentyTwo extends SolutionBase {

    private final Map<Coordinate, Boolean> NODE_MAP = new HashMap<>();
    private final Map<Coordinate, Integer> FLAG_MAP = new HashMap<>();

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
        final int center = (int) Math.sqrt(NODE_MAP.size()) / 2;
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
        NODE_MAP.clear();
        FLAG_MAP.clear();
        final String[] rows = ((String) input).split("\n");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                final boolean infected = rows[i].charAt(j) == '#';
                final Coordinate newCoordinate = new Coordinate(i, j);
                NODE_MAP.put(newCoordinate, infected);
                FLAG_MAP.put(newCoordinate, infected ? 2 : 0);
            }
        }
    }

    //change values as we go, but burst with the old one
    private boolean getInfectedStatusByCoordinate(final Coordinate coordinate) {
        Boolean infected = NODE_MAP.get(coordinate);
        if (infected == null) {
            infected = false;
            NODE_MAP.put(coordinate, true);
        } else {
            NODE_MAP.put(coordinate, !infected);
        }
        return infected;
    }

    //change value as we go, but burst with the old one
    private Integer getFlagByCoordinate(final Coordinate coordinate) {
        Integer flag = FLAG_MAP.get(coordinate);
        if (flag == null) {
            flag = 0;
            FLAG_MAP.put(coordinate, 1);
        } else {
            FLAG_MAP.put(coordinate, (flag + 1) % 4);
        }
        return flag;
    }


}
