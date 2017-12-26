package com.aoc.days.daytwentyfive;

/**
 * @author maczaka.
 */
class TapeValue {

    private static TapeValue mostLeftValue = null;
    private TapeValue previousValue = null;
    private TapeValue nextValue = null;
    private boolean value = false;

    static TapeValue getMostLeftValue() {
        return mostLeftValue;
    }

    TapeValue getPreviousValue() {
        if (this.previousValue == null) {
            previousValue = new TapeValue();
            mostLeftValue = previousValue;
            previousValue.nextValue = this;

        }
        return previousValue;
    }

    TapeValue getNextValue() {
        if (this.nextValue == null) {
            nextValue = new TapeValue();
            nextValue.previousValue = this;
        }
        return nextValue;
    }

    boolean getValue() {
        return value;
    }

    void setValue(final boolean value) {
        this.value = value;
    }

    TapeValue getLeftValue() {
        return previousValue;
    }

    TapeValue getRightValue() {
        return nextValue;
    }
}
