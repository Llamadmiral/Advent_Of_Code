package com.aoc.days2018.day07;

import java.util.HashSet;
import java.util.Set;

/**
 * @author maczaka.
 */
class Step {
    private char letter;
    private Set<Step> prequisites = new HashSet<>();
    private boolean done = false;
    private boolean preqFilled = false;
    private boolean assigned = false;

    Step(final char letter) {
        this.letter = letter;
    }

    boolean isAssigned() {
        return assigned;
    }

    void setAssigned(final boolean assigned) {
        this.assigned = assigned;
    }

    void addToPrequisites(final Step step) {
        this.prequisites.add(step);
    }

    char getLetter() {
        return letter;
    }

    boolean prequisitesFulfilled() {
        boolean allDone = true;
        if (!preqFilled) {
            for (final Step step : prequisites) {
                if (!step.isDone()) {
                    allDone = false;
                    break;
                }
            }
            if (allDone) {
                preqFilled = true;
            }
        }

        return allDone;
    }

    boolean isDone() {
        return done;
    }

    void setDone(final boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Step{" +
            "letter=" + letter +
            '}';
    }

    void setPreqFilled() {
        this.preqFilled = false;
    }
}
