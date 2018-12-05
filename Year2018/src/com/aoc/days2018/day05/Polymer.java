package com.aoc.days2018.day05;

/**
 * @author maczaka.
 */
public class Polymer {
    private char unit;
    private Polymer previous;
    private Polymer next;

    public Polymer(final char aUnit, final Polymer aPrevious) {
        this.unit = aUnit;
        this.previous = aPrevious;
        this.previous.next = this;
    }

    public Polymer(final char aUnit) {
        this.unit = aUnit;
    }

    public char getUnit() {
        return unit;
    }

    public Polymer getPrevious() {
        return previous;
    }

    public Polymer getNext() {
        return next;
    }

    @Override
    public String toString() {
        return String.valueOf(unit);
    }
}
