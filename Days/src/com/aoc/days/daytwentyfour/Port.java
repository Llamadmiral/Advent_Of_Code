package com.aoc.days.daytwentyfour;

/**
 * @author maczaka.
 */
class Port {
    private int in;
    private int out;
    private boolean used;
    private boolean inIsUsed;

    Port(final String input) {
        final String[] portNumbers = input.split("/");
        in = Integer.parseInt(portNumbers[0]);
        out = Integer.parseInt(portNumbers[1]);
        used = false;
    }

    boolean isUsed() {
        return used;
    }

    void setUsed(final boolean used, final int pinType) {
        this.used = used;
        if (pinType == in) {
            inIsUsed = used;
        }
    }

    int getStrength() {
        return in + out;
    }

    @Override
    public String toString() {
        return in + "/" + out;
    }

    boolean isConnecting(final int otherOut) {
        return in == otherOut || out == otherOut;
    }

    int getUnusedPin() {
        return inIsUsed ? out : in;
    }
}
