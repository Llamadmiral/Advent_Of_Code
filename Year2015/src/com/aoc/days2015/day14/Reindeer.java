package com.aoc.days2015.day14;

class Reindeer {

    private int speed;
    private int travelTime;
    private int restTime;
    private int currentRestTime;
    private int currentTravelTime;
    private int traveled;
    private boolean resting;

    Reindeer(final int speed, final int travelTime, final int restTime) {
        this.speed = speed;
        this.travelTime = travelTime;
        this.restTime = restTime;
    }

    int getTraveled() {
        return traveled;
    }


    private void rest() {
        this.currentRestTime++;
        if (this.currentRestTime == this.restTime) {
            this.resting = false;
            this.currentRestTime = 0;
        }
    }

    private void fly() {
        this.currentTravelTime++;
        this.traveled += this.speed;
        if (this.currentTravelTime == this.travelTime) {
            this.resting = true;
            this.currentTravelTime = 0;
        }
    }

    void race() {
        if (this.resting) {
            this.rest();
        } else {
            this.fly();
        }
    }

    void reset() {
        this.currentTravelTime = 0;
        this.currentRestTime = 0;
        this.traveled = 0;
        this.resting = false;
    }
}
