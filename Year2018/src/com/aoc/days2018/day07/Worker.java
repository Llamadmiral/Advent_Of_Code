package com.aoc.days2018.day07;

/**
 * @author maczaka.
 */
class Worker {

    private Step currentStep;
    private int remainingTime;
    private boolean free = true;

    void update() {
        remainingTime--;
        if (remainingTime == 0) {
            this.setFree(true);
            this.currentStep.setDone(true);
        }
    }

    void setCurrentStep(final Step currentStep) {
        this.currentStep = currentStep;
        final int BASE_COMPLETION_TIME = 60;
        this.remainingTime = currentStep.getLetter() - 64 + BASE_COMPLETION_TIME;
    }

    boolean isFree() {
        return free;
    }

    void setFree(final boolean free) {
        this.free = free;
    }
}
