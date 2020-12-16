package com.aoc.days2020.day15;

class SpokenNumber {

    private int currentPosition;
    private int lastPosition;

    SpokenNumber(final int currentPosition) {
        this.currentPosition = currentPosition;
        this.lastPosition = currentPosition;
    }

    void say(final int position) {
        this.lastPosition = this.currentPosition;
        this.currentPosition = position;
    }

    boolean getAlreadySaid() {
        return this.currentPosition != this.lastPosition;
    }

    int getCurrentPosition() {
        return currentPosition;
    }

    int getLastPosition() {
        return lastPosition;
    }
}
