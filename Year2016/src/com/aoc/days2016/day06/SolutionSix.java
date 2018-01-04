package com.aoc.days2016.day06;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionSix extends SolutionBase {

    private final List<Map<Character, Integer>> charactersByRows = new ArrayList<>();
    private Integer maxCount = null;
    private char maxChar = '\0';
    private StringBuilder builder = new StringBuilder();
    private int length = 0;

    SolutionSix(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        for (int i = 0; i < length; i++) {
            for (final Map.Entry<Character, Integer> entry : charactersByRows.get(i).entrySet()) {
                final Integer value = entry.getValue();
                if (maxCount == null || value > maxCount) {
                    maxCount = value;
                    maxChar = entry.getKey();
                }
            }
            builder.append(maxChar);
            maxCount = null;
        }
        setSolutionOne(builder.toString());
    }

    @Override
    protected void solvePartTwo() {
        builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (final Map.Entry<Character, Integer> entry : charactersByRows.get(i).entrySet()) {
                final Integer value = entry.getValue();
                if (maxCount == null || value < maxCount) {
                    maxCount = value;
                    maxChar = entry.getKey();
                }
            }
            builder.append(maxChar);
            maxCount = null;
        }
        setSolutionTwo(builder.toString());
    }

    private void parseInput() {
        final String[] rows = input.split("\n");
        length = rows[0].length();
        boolean createdList = false;
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < length; j++) {
                if (!createdList) {
                    charactersByRows.add(new HashMap<>());
                }
                final char c = rows[i].charAt(j);
                Integer count = charactersByRows.get(j).get(c);
                if (count == null) {
                    count = 0;
                }
                charactersByRows.get(j).put(c, count + 1);
            }
            createdList = true;
        }
    }
}