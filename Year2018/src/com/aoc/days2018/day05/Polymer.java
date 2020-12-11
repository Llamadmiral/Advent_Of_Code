package com.aoc.days2018.day05;

/**
 * @author maczaka.
 */
class Polymer {
    private char unit;
    private Polymer previous;
    private Polymer next;

    Polymer(final char aUnit, final Polymer aPrevious) {
        this.unit = aUnit;
        this.previous = aPrevious;
        this.previous.next = this;
    }

    Polymer(final char aUnit) {
        this.unit = aUnit;
    }

    char getUnit() {
        return unit;
    }

    Polymer getPrevious() {
        return previous;
    }

    Polymer getNext() {
        return next;
    }

    @Override
    public String toString() {
        return String.valueOf(unit);
    }
}
