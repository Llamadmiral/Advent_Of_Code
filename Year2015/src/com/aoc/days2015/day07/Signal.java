package com.aoc.days2015.day07;

public class Signal {

    private boolean[] bytes = new boolean[16];

    public Signal(final Integer value) {
        int r = value;
        for (int i = 15; i >= 0; i--) {
            bytes[i] = r % 2 == 1;
            r = r / 2;
            if (r == 0) {
                break;
            }
        }
    }

    public Signal(final boolean[] bytes) {
        this.bytes = bytes;
    }

    public boolean[] getBytes() {
        return bytes;
    }

    public Signal leftShift(final int shiftValue) {
        final boolean[] newBytes = new boolean[16];
        System.arraycopy(bytes, shiftValue, newBytes, 0, 16 - shiftValue);
        return new Signal(newBytes);
    }

    public Signal rightShift(final int shiftValue) {
        final boolean[] newBytes = new boolean[16];
        for (int i = 15; i >= shiftValue; i--) {
            newBytes[i] = this.bytes[i - shiftValue];
        }
        return new Signal(newBytes);
    }

    public Signal or(final Signal otherSignal) {
        final boolean[] newBytes = new boolean[16];
        for (int i = 0; i < 16; i++) {
            newBytes[i] = this.bytes[i] || otherSignal.bytes[i];
        }
        return new Signal(newBytes);
    }

    public Signal and(final Signal otherSignal) {
        final boolean[] newBytes = new boolean[16];
        for (int i = 0; i < 16; i++) {
            newBytes[i] = this.bytes[i] && otherSignal.bytes[i];
        }
        return new Signal(newBytes);
    }

    public Signal not() {
        final boolean[] newBytes = new boolean[16];
        for (int i = 0; i < 16; i++) {
            newBytes[i] = !this.bytes[i];
        }
        return new Signal(newBytes);
    }

    public int toInteger() {
        int value = 0;
        for (int i = 15; i >= 0; i--) {
            value += bytes[i] ? Math.pow(2, 15 - i) : 0;
        }
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(toInteger());
    }
}
