package com.aoc.days.day24;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
class SolutionTwentyFour extends SolutionBase {

    private final List<Port> ports = new ArrayList<>();
    private int maxStrength = 0;
    private int maxDepth = 0;
    private int maxStrengthWithDepth = 0;

    SolutionTwentyFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        generateBridge(0, 0, 0);
        setSolutionOne(maxStrength);
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(maxStrengthWithDepth);
    }

    private void generateBridge(final int in, int currentStrength, final int currentDepth) {
        final List<Port> subPortList = getPortsWithIn(in);
        if (subPortList.isEmpty()) {
            if (maxStrength < currentStrength) {
                maxStrength = currentStrength;
            }
            if (maxDepth < currentDepth) {
                maxDepth = currentDepth;
                maxStrength = currentStrength;
            } else if (maxDepth == currentDepth && maxStrengthWithDepth < currentStrength) {
                maxStrengthWithDepth = currentStrength;
            }
        } else {
            for (final Port port : subPortList) {
                port.setUsed(true, in);
                generateBridge(port.getUnusedPin(), currentStrength + port.getStrength(), currentDepth + 1);
                port.setUsed(false, in);
            }
        }
    }

    private List<Port> getPortsWithIn(final int otherOut) {
        final List<Port> subPortList = new ArrayList<>();
        for (final Port port : ports) {
            if (!port.isUsed() && port.isConnecting(otherOut)) {
                subPortList.add(port);
            }
        }
        return subPortList;
    }

    private void parseInput() {
        final String[] rows = ((String) input).split("\n");
        for (final String row : rows) {
            ports.add(new Port(row));
        }
    }
}
