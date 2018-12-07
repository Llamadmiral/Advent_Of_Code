package com.aoc.days2018.day07;

/**
 * @author maczaka.
 */
public class Worker {
    private static int BASE_COMPLETION_TIME = 60;

    private Step currentStep;
    private int remainingTime;
    private boolean free = true;

    public void update() {
        remainingTime--;
        if (remainingTime == 0) {
            this.setFree(true);
            this.currentStep.setDone(true);
        }
    }

    public void setCurrentStep(final Step currentStep) {
        this.currentStep = currentStep;
        this.remainingTime = currentStep.getLetter() - 64 + BASE_COMPLETION_TIME;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(final boolean free) {
        this.free = free;
    }
}
