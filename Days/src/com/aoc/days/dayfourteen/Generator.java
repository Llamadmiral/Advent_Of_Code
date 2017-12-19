package com.aoc.days.dayfourteen;

/**
 * @author maczaka.
 */
public class Generator {

    private static final int MODULO = Integer.MAX_VALUE;

    private long previousValue;
    private long factor;
    private int criteria;

    public Generator(final int factor) {
        this.factor = factor;
    }

    public int nextValue() {
        previousValue = (previousValue * factor) % MODULO;
        return (int) previousValue;
    }

    public void setPreviousValue(final int previousValue) {
        this.previousValue = previousValue;
    }

    public void setCriteria(final int criteria) {
        this.criteria = criteria;
    }

    public int nextValueWithCriteria() {
        int currValue = nextValue();
        while (currValue % criteria != 0) {
            currValue = nextValue();
        }
        return currValue;
    }
}
