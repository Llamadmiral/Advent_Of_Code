package com.aoc.days2020.day12;

class Instruction {

    private char action;
    private int value;

    Instruction(final char action, final int value) {
        this.action = action;
        this.value = value;
    }

    public char getAction() {
        return action;
    }

    public int getValue() {
        return value;
    }
}
