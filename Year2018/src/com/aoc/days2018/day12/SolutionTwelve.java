package com.aoc.days2018.day12;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {

    final private List<boolean[]> conversationRules = new ArrayList<>();
    private boolean[] currentState = null;
    private int centerPlant = 0;

    SolutionTwelve(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] split = input.split("\n");
        currentState = convertToState(split[0].substring(15));
        for (int i = 2; i < split.length; i++) {
            conversationRules.add(convertToRule(split[i]));
        }
    }

    @Override
    protected void solvePartOne() {
        printState();
        for (int i = 0; i < 20; i++) {
            doNextGeneration();
            printState();
        }
        final int score = countScore(centerPlant);
        setSolutionOne(score);
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }

    private void doNextGeneration() {
        final boolean[] nextGen = new boolean[currentState.length + 4];
        for (int i = 2; i < nextGen.length - 2; i++) {
            nextGen[i] = genPlantGrowth(i - 2);
        }
        currentState = cutOff(nextGen);
        if (genPlantGrowth(0) || genPlantGrowth(1)) {
            centerPlant++;
        }
    }

    private boolean[] cutOff(final boolean[] nextGen) {
        int start;
        int end;
        int i = 0;
        while (true) {
            if (nextGen[i]) {
                start = i;
                break;
            }
            i++;
        }
        i = nextGen.length - 1;
        while (true) {
            if (nextGen[i]) {
                end = i + 1;
                break;
            }
            i--;
        }
        final int newLength = end - start;
        final boolean[] cutoff = new boolean[newLength + 4];
        System.arraycopy(nextGen, start, cutoff, 2, newLength);
        return cutoff;
    }

    private boolean genPlantGrowth(final int index) {
        boolean plant = false;
        for (final boolean[] rule : conversationRules) {
            boolean matches;
            if (index == 0) {
                matches = !rule[0]
                    && !rule[1]
                    && rule[2] == currentState[0]
                    && rule[3] == currentState[1]
                    && rule[4] == currentState[2];
            } else if (index == 1) {
                matches = !rule[0]
                    && rule[1] == currentState[0]
                    && rule[2] == currentState[1]
                    && rule[3] == currentState[2]
                    && rule[4] == currentState[3];
            } else if (index == currentState.length - 2) {
                matches = rule[0] == currentState[index - 2]
                    && rule[1] == currentState[index - 1]
                    && rule[2] == currentState[index]
                    && rule[3] == currentState[index + 1]
                    && !rule[4];
            } else if (index == currentState.length - 1) {
                matches = rule[0] == currentState[index - 2]
                    && rule[1] == currentState[index - 1]
                    && rule[2] == currentState[index]
                    && !rule[3]
                    && !rule[4];
            } else {
                matches = rule[0] == currentState[index - 2]
                    && rule[1] == currentState[index - 1]
                    && rule[2] == currentState[index]
                    && rule[3] == currentState[index + 1]
                    && rule[4] == currentState[index + 2];
            }
            if (matches) {
                plant = rule[5];
                break;
            }
        }
        return plant;
    }

    private int countScore(final int offset) {
        int sum = 0;
        for (int i = 0; i < currentState.length; i++) {
            if (currentState[i]) {
                sum += i - offset;
            }
        }
        return sum;
    }

    private boolean[] convertToState(final String inputState) {
        final boolean[] state = new boolean[inputState.length()];
        char[] charArray = inputState.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            state[i] = charArray[i] == '#';
        }
        return state;
    }

    private boolean[] convertToRule(final String inputRule) {
        final String[] data = inputRule.split(" => ");
        return convertToState(data[0] + data[1]);
    }

    private void printState() {
        final StringBuilder builder = new StringBuilder();
        for (boolean pot : currentState) {
            builder.append(pot ? '#' : '.');
        }
        String result = builder.toString();
        System.out.println(result);
    }

}