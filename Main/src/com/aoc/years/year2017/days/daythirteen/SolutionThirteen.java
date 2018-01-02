package com.aoc.years.year2017.days.daythirteen;

import com.aoc.solutionbase.SolutionBase;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author maczaka
 */
class SolutionThirteen extends SolutionBase {

    private final Map<Integer, Integer> scanners = new TreeMap<>();

    SolutionThirteen(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        final Integer severity = calculateSeverity(0, false);
        setSolutionOne(severity);
    }

    @Override
    protected void solvePartTwo() {
        int delay = 1;
        while (calculateSeverity(delay, true) != 0) {
            delay++;
        }
        setSolutionTwo(delay);
    }

    private int calculateSeverity(final int startCycle, final boolean exitUponSeverity) {
        int severity = 0;
        int cycles = startCycle;
        int prevScannerPosition = 0;
        for (final Map.Entry<Integer, Integer> scanner : scanners.entrySet()) {
            final int scannerPosition = scanner.getKey();
            final int scannerLength = scanner.getValue();
            cycles += scannerPosition - prevScannerPosition;
            prevScannerPosition = scannerPosition;
            if (getPositionOfScanner(scannerLength - 1, cycles) == 0) {
                severity += scannerPosition * scannerLength;
                if (exitUponSeverity) {
                    return -1;
                }
            }
        }
        return severity;
    }

    private void parseInput() {
        final String[] rows = ((String) input).split("\n");
        for (final String scanner : rows) {
            final String[] datas = scanner.split(": ");
            scanners.put(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]));
        }
    }


    /**
     * If cycles / length is odd, it means that the scanner is returning to its starting position (0),
     * else it is going down.
     */
    private int getPositionOfScanner(final int length, final int cycles) {
        if (cycles == 0) {
            return 0;
        }
        return (cycles / length) % 2 == 0 ? cycles % length : length - (cycles % length);
    }


}
