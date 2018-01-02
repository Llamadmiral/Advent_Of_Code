package com.aoc.days.day15;

/**
 * @author maczaka.
 */
class Generator {

    private static final int MODULO = Integer.MAX_VALUE;

    private long previousValue;
    private long factor;
    private int criteria;

    Generator(final int factor) {
        this.factor = factor;
    }

    int nextValue() {
        previousValue = (previousValue * factor) % MODULO;
        return (int) previousValue;
    }

    void setPreviousValue(final int previousValue) {
        this.previousValue = previousValue;
    }

    void setCriteria(final int criteria) {
        this.criteria = criteria;
    }

    int nextValueWithCriteria() {
        int currValue = nextValue();
        while (currValue % criteria != 0) {
            currValue = nextValue();
        }
        return currValue;
    }
}
