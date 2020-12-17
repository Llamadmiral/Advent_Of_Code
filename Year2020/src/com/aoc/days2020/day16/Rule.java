package com.aoc.days2020.day16;

class Rule {

    private String name;
    private int lowerLow;
    private int lowerHigh;
    private int higherLow;
    private int higherHigh;

    Rule(final String input) {
        final String[] parts = input.split(": ");
        this.name = parts[0];
        final String[] borders = parts[1].split(" or ");
        final String[] lowers = borders[0].split("-");
        final String[] highers = borders[1].split("-");
        this.lowerLow = Integer.parseInt(lowers[0]);
        this.lowerHigh = Integer.parseInt(lowers[1]);
        this.higherLow = Integer.parseInt(highers[0]);
        this.higherHigh = Integer.parseInt(highers[1]);
    }

    boolean valueIsValid(final int value) {
        return (this.lowerLow <= value && value <= this.lowerHigh) || (this.higherLow <= value && value <= this.higherHigh);
    }

    String getName() {
        return this.name;
    }
}
