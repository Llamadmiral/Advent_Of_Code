package com.aoc.days2016.day10;

/**
 * @author maczaka.
 */
public class Bot {
    private Integer low = null;
    private Integer high = null;
    private int id;

    Bot(final int newId) {
        this.id = newId;
    }

    void addValue(final int value) {
        if (low == null) {
            if (high == null || high > value) {
                low = value;
            } else {
                low = high;
                high = value;
            }
        } else {
            if (low > value) {
                high = low;
                low = value;
            } else {
                high = value;
            }
        }
    }

    int getHigh() {
        int newHigh = high;
        high = null;
        return newHigh;
    }

    int getLow() {
        int newLow = low;
        low = null;
        return newLow;
    }

    boolean canGive() {
        return low != null && high != null;
    }

    boolean hasNumbers(final Integer a, final Integer b) {
        return a.equals(low) && b.equals(high);
    }

    int getId() {
        return id;
    }
}
