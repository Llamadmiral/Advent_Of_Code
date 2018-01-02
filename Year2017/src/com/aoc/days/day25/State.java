package com.aoc.days.day25;

/**
 * @author maczaka.
 */
class State {
    private char[] nextState = new char[2];
    private boolean[] nextValue = new boolean[2];
    private int[] nextDirection = new int[2];
    private boolean currentValue;

    //h means it was the word "right", so direction is +1.
    State(final String[] input) {
        nextValue[0] = input[2].charAt(input[2].length() - 2) == '1';
        nextValue[1] = input[6].charAt(input[6].length() - 2) == '1';
        nextDirection[0] = input[3].charAt(input[3].length() - 3) == 'h' ? 1 : -1;
        nextDirection[1] = input[7].charAt(input[7].length() - 3) == 'h' ? 1 : -1;
        nextState[0] = input[4].charAt(input[4].length() - 2);
        nextState[1] = input[8].charAt(input[8].length() - 2);
    }

    void setOutput(final boolean currentValue) {
        this.currentValue = currentValue;
    }

    char getNextState() {
        return currentValue ? nextState[1] : nextState[0];
    }

    boolean getNextValue() {
        return currentValue ? nextValue[1] : nextValue[0];
    }

    int nextDirection() {
        return currentValue ? nextDirection[1] : nextDirection[0];
    }
}
