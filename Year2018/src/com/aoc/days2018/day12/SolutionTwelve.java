package com.aoc.days2018.day12;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {

    final List<boolean[]> conversationRules = new ArrayList<>();
    boolean[] initialState = null;

    SolutionTwelve(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] split = input.split("\n");
        initialState = convertToState(split[0].substring(16, split[0].length()));
        for (int i = 2; i < split.length; i++) {
            conversationRules.add(convertToRule(split[i]));
        }
    }

    @Override
    protected void solvePartOne() {
        //not yet solved
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }

    private void doNextGeneration(final boolean[] currentState, final int n) {
        for (final boolean[] rule : conversationRules) {

        }
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

}