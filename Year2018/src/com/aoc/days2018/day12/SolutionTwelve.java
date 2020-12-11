package com.aoc.days2018.day12;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {


    private static final long LOT_OF_GEN = 50000000000L;

    private final Map<String, Character> rulebook = new HashMap<>();
    private final List<String> alreadyGenerated = new ArrayList<>();
    private String initialState;
    private long firstPlantNumber = 0;

    SolutionTwelve(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("initial state: ", "");
        final String[] rows = input.split("\n");
        initialState = rows[0];
        for (int i = 2; i < rows.length; i++) {
            final String[] parts = rows[i].split(" => ");
            rulebook.put(parts[0], parts[1].charAt(0));
        }
    }

    @Override
    protected void solvePartOne() {
        String generation = "...." + initialState + "....";
        for (int i = 0; i < 20; i++) {
            generation = generateNextRow(generation);
        }
        final long sumOfIndexes = sumPlantIndexes(generation);
        setSolutionOne(sumOfIndexes);
    }

    @Override
    protected void solvePartTwo() {
        String generation = "...." + initialState + "....";
        firstPlantNumber = 0;
        int count = 0;
        while (!alreadyGenerated.contains(generation)) {
            count++;
            alreadyGenerated.add(generation);
            generation = generateNextRow(generation);
        }
        firstPlantNumber += LOT_OF_GEN - count;
        final long sumOfIndexes = sumPlantIndexes(generation);
        setSolutionTwo(sumOfIndexes);
    }

    private long sumPlantIndexes(final String generation) {
        final String plantStart = generation.substring(generation.indexOf("#"));
        long potNumber = firstPlantNumber;
        long sum = 0;
        for (int i = 0; i < plantStart.length(); i++) {
            if (plantStart.charAt(i) == '#') {
                sum += potNumber;
            }
            potNumber++;
        }
        return sum;
    }

    private String generateNextRow(final String previous) {
        final StringBuilder builder = new StringBuilder("....");
        boolean checkFirstPlace = true;
        final int firstPlantIndex = previous.indexOf("#");
        for (int i = 2; i < previous.length() - 2; i++) {
            final String rule = previous.substring(i - 2, i + 3);
            final Character nextPlant = rulebook.get(rule);
            if (nextPlant == null) {
                builder.append('.');
            } else {
                builder.append(nextPlant);
                if (nextPlant == '#' && checkFirstPlace) {
                    int difference = firstPlantIndex - i;
                    checkFirstPlace = false;
                    firstPlantNumber -= difference;
                }
            }
        }
        builder.append("....");
        return trim(builder.toString());
    }

    private String trim(final String generation) {
        int sliceStart = 0;
        int sliceEnd = 0;
        int i = 0;
        while (i < generation.length()) {
            final char plant = generation.charAt(i);
            if (plant == '#') {
                if (sliceStart == 0) {
                    sliceStart = i;
                }
                sliceEnd = i;
            }
            i++;
        }
        sliceStart -= 4;
        sliceEnd += 4;
        return generation.substring(sliceStart, sliceEnd);
    }


}