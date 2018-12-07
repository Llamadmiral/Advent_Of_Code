package com.aoc.days2018.day07;

import java.util.HashSet;
import java.util.Set;

/**
 * @author maczaka.
 */
public class Step {
    private char letter;
    private Set<Step> prequisites = new HashSet<>();
    private boolean done = false;
    private boolean preqFilled = false;
    private boolean assigned = false;

    public Step(final char letter) {
        this.letter = letter;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(final boolean assigned) {
        this.assigned = assigned;
    }

    public void addToPrequisites(final Step step) {
        this.prequisites.add(step);
    }

    public char getLetter() {
        return letter;
    }

    public boolean prequisitesFulfilled() {
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

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Step{" +
            "letter=" + letter +
            '}';
    }

    public void setPreqFilled(final boolean preqFilled) {
        this.preqFilled = preqFilled;
    }
}
