package com.aoc.days.daytwentyfive;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka.
 */
class SolutionTwentyFive extends SolutionBase {
    private final Map<Character, State> states = new HashMap<>();
    private char beginState;
    private int checksumAfter;
    private char nextState;
    private TapeValue currentValue = new TapeValue();

    SolutionTwentyFive(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        nextState = beginState;
        for (int i = 0; i < checksumAfter; i++) {
            calculateCurrentValue();
        }
        setSolutionOne(countTapeValues());
    }

    @Override
    protected void solvePartTwo() {
        //not yet done
    }

    private int countTapeValues() {
        int value = 0;
        TapeValue tapeValue = TapeValue.getMostLeftValue();
        while (tapeValue.getRightValue() != null) {
            if (tapeValue.getValue()) {
                value++;
            }
            tapeValue = tapeValue.getRightValue();
        }
        if (tapeValue.getValue()) {
            value++;
        }
        return value;
    }

    private void calculateCurrentValue() {
        final State state = states.get(nextState);
        state.setOutput(currentValue.getValue());
        currentValue.setValue(state.getNextValue());
        currentValue = state.nextDirection() == -1 ? currentValue.getPreviousValue() : currentValue.getNextValue();
        nextState = state.getNextState();
    }

    private void parseInput() {
        final String[] rows = ((String) input).split("\n");
        beginState = rows[0].charAt(rows[0].length() - 2);
        checksumAfter = Integer.parseInt(rows[1].split(" ")[5]);
        final String[] stateDefinition = new String[9];
        int i = 3;
        int j = 0;
        while (i < rows.length) {
            final char stateId = rows[i].charAt(rows[i].length() - 2);
            while (j < 9) {
                stateDefinition[j] = rows[i];
                i++;
                j++;
            }
            states.put(stateId, new State(stateDefinition));
            j = 0;
            i++;
        }
    }
}
