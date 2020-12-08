package com.aoc.days2015.day16;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionSixteen extends SolutionBase {

    private static final Map<String, Integer> MY_SUE = new HashMap<>();

    static {
        MY_SUE.put("children", 3);
        MY_SUE.put("cats", 7);
        MY_SUE.put("samoyeds", 2);
        MY_SUE.put("pomeranians", 3);
        MY_SUE.put("akitas", 0);
        MY_SUE.put("vizslas", 0);
        MY_SUE.put("goldfish", 5);
        MY_SUE.put("trees", 3);
        MY_SUE.put("cars", 2);
        MY_SUE.put("perfumes", 1);
    }

    private final Map<Integer, Map<String, Integer>> sues = new HashMap<>();

    SolutionSixteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("Sue ", "")
            .replaceAll(": ", " ")
            .replaceAll(", ", " ");
        final String[] split = input.split("\n");
        for (int i = 0; i < split.length; i++) {
            final String row = split[i];
            final String[] parts = row.split(" ");
            final Map<String, Integer> attributes = new HashMap<>();
            for (int j = 1; j < parts.length - 1; j = j + 2) {
                attributes.put(parts[j], Integer.valueOf(parts[j + 1]));
            }
            sues.put(i + 1, attributes);
        }
    }

    @Override
    protected void solvePartOne() {
        int mySueId = 0;
        for (final Map.Entry<Integer, Map<String, Integer>> sue : sues.entrySet()) {
            boolean mismatch = false;
            for (final Map.Entry<String, Integer> entry : sue.getValue().entrySet()) {
                if (!MY_SUE.get(entry.getKey()).equals(entry.getValue())) {
                    mismatch = true;
                    break;
                }
            }
            if (!mismatch) {
                mySueId = sue.getKey();
                break;
            }
        }
        setSolutionOne(mySueId);
    }

    @Override
    protected void solvePartTwo() {
        int mySueId = 0;
        for (final Map.Entry<Integer, Map<String, Integer>> sue : sues.entrySet()) {
            boolean matches = true;
            for (final Map.Entry<String, Integer> entry : sue.getValue().entrySet()) {
                if (!precisionMatches(entry.getKey(), entry.getValue())) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                mySueId = sue.getKey();
                break;
            }
        }
        setSolutionTwo(mySueId);
    }

    private boolean precisionMatches(final String key, final Integer value) {
        boolean matches;
        final Integer mySueValue = MY_SUE.get(key);
        if (key.equals("cats") || key.equals("trees")) {
            matches = mySueValue < value;
        } else if (key.equals("pomeranians") || key.equals("goldfish")) {
            matches = mySueValue > value;
        } else {
            matches = mySueValue.equals(value);
        }
        return matches;
    }

}