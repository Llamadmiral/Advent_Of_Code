package com.aoc.days2015.day02;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwo extends SolutionBase {

    private final List<int[]> boxes = new ArrayList<>();

    SolutionTwo(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        initBoxes();
        int total = 0;
        for (final int[] box : boxes) {
            final int length = box[0];
            final int width = box[1];
            final int height = box[2];
            final int smallestSize = getSmallestArea(length, width, height);
            total += 2 * length * width + 2 * width * height + 2 * height * length + smallestSize;
        }
        setSolutionOne(total);
    }

    @Override
    protected void solvePartTwo() {
        int total = 0;
        for (final int[] box : boxes) {
            final int length = box[0];
            final int width = box[1];
            final int height = box[2];
            final int sizeOfRibbon = getSizeOfRibbon(length, width, height);
            total += sizeOfRibbon + length * width * height;
        }
        setSolutionTwo(total);
    }

    private int getSizeOfRibbon(final int... sizes) {
        int positionOfSmallest = -1;
        int smallest = -1;
        for (int i = 0; i < sizes.length; i++) {
            final int size = sizes[i];
            if (smallest == -1 || smallest > size) {
                smallest = size;
                positionOfSmallest = i;
            }
        }
        int secondSmallest = -1;
        for (int i = 0; i < sizes.length; i++) {
            final int size = sizes[i];
            if (i != positionOfSmallest && (secondSmallest == -1 || secondSmallest > size)) {
                secondSmallest = size;
            }
        }
        return 2 * smallest + 2 * secondSmallest;
    }

    private void initBoxes() {
        for (final String row : input.split("\n")) {
            final String[] data = row.split("x");
            boxes.add(new int[]{Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2])
            });
        }
    }

    private int getSmallestArea(final int... sizes) {
        int smallestSize = -1;
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes.length; j++) {
                final int size = sizes[i] * sizes[j];
                if (i != j && (smallestSize == -1 || smallestSize > size)) {
                    smallestSize = size;
                }
            }
        }
        return smallestSize;
    }
}