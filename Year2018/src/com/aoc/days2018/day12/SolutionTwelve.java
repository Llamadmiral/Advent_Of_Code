package com.aoc.days2018.day12;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {

    private static final int NUMBER_OF_GEN = 20;
    private static final long NUMBER_OF_LONG_GEN = 50000000000L;

    private List<boolean[]> rules = new ArrayList<>();
    private List<boolean[]> pastGenerations = new ArrayList<>();
    private boolean[] currentState;
    private long startIndex;
    private int currentGenIndex = 1;

    private boolean[] startingState;

    SolutionTwelve(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] data = input.split("\n");
        final String initState = data[0].split(" ")[2];
        currentState = new boolean[initState.length() + 4];
        for (int i = 0; i < initState.length(); i++) {
            currentState[i + 2] = initState.charAt(i) == '#';
        }
        startIndex = 2;

        for (int i = 2; i < data.length; i++) {
            final boolean[] rule = new boolean[6];
            for (int j = 0; j < 5; j++) {
                rule[j] = data[i].charAt(j) == '#';
            }
            rule[5] = data[i].charAt(9) == '#';
            rules.add(rule);
        }

        startingState = currentState;
    }

    @Override
    protected void solvePartOne() {
        /*for (int i = 0; i < NUMBER_OF_GEN; i++) {
            doGeneration();
        }
        setSolutionOne(getScore());*/
    }

    private long getScore() {
        long score = 0;
        for (int i = 0; i < currentState.length; i++) {
            score += (currentState[i] ? 1 : 0) * (i - startIndex);
        }
        return score;
    }

    private void doGeneration() {
        final boolean[] appendedState = new boolean[currentState.length + 4];
        System.arraycopy(currentState, 0, appendedState, 2, currentState.length);
        final boolean[] newState = new boolean[appendedState.length];
        for (int i = 2; i < appendedState.length - 2; i++) {
            newState[i] = findAndApplyRule(i, appendedState);
        }
        int firstTrue = findFirstPotWithPlant(newState);
        currentState = trimState(newState);
        int afterTrimFirstTrue = findFirstPotWithPlant(currentState);
        startIndex += afterTrimFirstTrue - firstTrue + 2;
        System.out.println(startIndex);
        printState();
    }

    private int findFirstPotWithPlant(final boolean[] newState) {
        int i = 0;
        while (!newState[i]) {
            i++;
        }
        return i;
    }

    private boolean[] trimState(final boolean[] newState) {
        int start = 0;
        int end = newState.length;
        for (int i = 0; i < newState.length; i++) {
            if (newState[i]) {
                start = i - 2;
                break;
            }
        }
        for (int i = newState.length - 1; i > 0; i--) {
            if (newState[i]) {
                end = i + 3;
                break;
            }
        }
        final boolean[] result = new boolean[end - start];
        System.arraycopy(newState, start, result, 0, end - start);
        return result;
    }

    private boolean findAndApplyRule(final int from, final boolean[] newState) {
        boolean result = false;
        for (final boolean[] rule : rules) {
            result = rule[0] == newState[from - 2];
            result &= rule[1] == newState[from - 1];
            result &= rule[2] == newState[from];
            result &= rule[3] == newState[from + 1];
            result &= rule[4] == newState[from + 2];
            if (result) {
                result = rule[5];
                break;
            }
        }
        return result;
    }


    @Override
    protected void solvePartTwo() {
        boolean foundRepeat = false;
        currentState = startingState;
        while (!foundRepeat) {
            pastGenerations.add(currentState);
            doGeneration();
            foundRepeat = checkRepeat();
            currentGenIndex++;
        }
        printState();

        final long scoreOne = getScore();
        doGeneration();
        final long scoreTwo = getScore();
        final long diff = scoreTwo - scoreOne;
        currentGenIndex += 2;
        final long generationsRemaining = NUMBER_OF_LONG_GEN - currentGenIndex;
        final long finalScore = scoreTwo + (diff * generationsRemaining);

        setSolutionTwo(finalScore);
    }

    private boolean checkRepeat() {
        boolean hasMatch = false;
        for (boolean[] pastGen : pastGenerations) {
            boolean matching = true;
            for (int i = 0; i < currentState.length; i++) {
                if (currentState[i] != pastGen[i]) {
                    matching = false;
                    break;
                }
            }
            if (matching) {
                hasMatch = true;
                break;
            }
        }
        return hasMatch;
    }

    private void printState() {
        System.out.printf("Length: " + currentState.length + " : ");
        for (boolean b : currentState) {
            System.out.printf(b ? "#" : ".");
        }
        System.out.println();
    }


}