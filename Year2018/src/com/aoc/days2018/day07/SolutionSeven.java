package com.aoc.days2018.day07;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionSeven extends SolutionBase {

    private static final int AMOUNT_OF_WORKERS = 5;

    private final Map<Character, Step> steps = new HashMap<>();
    private final Set<Worker> workers = new HashSet<>();
    private StringBuilder resultOne = new StringBuilder();


    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        boolean allFulfilled = false;
        while (!allFulfilled) {
            final Set<Step> reqsFulfilledSteps = getReqsFulfilledSteps();
            solveFirst(reqsFulfilledSteps);
            allFulfilled = checkEnd();
        }
        setSolutionOne(resultOne.toString());
    }

    @Override
    protected void solvePartTwo() {
        reset();
        createWorkers();
        int time = 0;
        boolean allDone = false;
        while (!allDone) {
            assignJobToWorkers();
            updateWorkers();
            time++;
            allDone = checkEnd();
        }
        setSolutionTwo(time);
    }

    private void assignJobToWorkers() {
        for (final Worker worker : workers) {
            if (worker.isFree()) {
                final Set<Step> reqFulfilledSteps = getReqsFulfilledSteps();
                if (!reqFulfilledSteps.isEmpty()) {
                    final Step step = getFirstByAlphabet(reqFulfilledSteps);
                    step.setAssigned(true);
                    worker.setCurrentStep(step);
                    worker.setFree(false);
                } else {
                    break;
                }
            }
        }
    }

    private void updateWorkers() {
        for (final Worker worker : workers) {
            if (!worker.isFree()) {
                worker.update();
            }
        }
    }

    private void createWorkers() {
        for (int i = 0; i < AMOUNT_OF_WORKERS; i++) {
            workers.add(new Worker());
        }
    }

    private void solveFirst(final Set<Step> reqsFulfilledSteps) {
        final Step nextStep = getFirstByAlphabet(reqsFulfilledSteps);
        resultOne.append(nextStep.getLetter());
        nextStep.setDone(true);
        reqsFulfilledSteps.remove(nextStep);
    }

    private Step getFirstByAlphabet(final Set<Step> stepSet) {
        Step first = null;
        for (final Step step : stepSet) {
            if (first == null || step.getLetter() < first.getLetter()) {
                first = step;
            }
        }
        return first;
    }

    private Set<Step> getReqsFulfilledSteps() {
        final Set<Step> reqsFulfilledSteps = new HashSet<>();
        for (final Step step : steps.values()) {
            if (!step.isDone() && step.prequisitesFulfilled() && !step.isAssigned()) {
                reqsFulfilledSteps.add(step);
            }
        }
        return reqsFulfilledSteps;
    }

    private boolean checkEnd() {
        boolean allDone = true;
        for (final Step step : steps.values()) {
            if (!step.isDone()) {
                allDone = false;
                break;
            }
        }
        return allDone;
    }

    private void prepareInput() {
        for (final String row : input.split("\n")) {
            final String[] data = row.split(" ");
            final char requirement = data[1].charAt(0);
            final char nextStep = data[7].charAt(0);
            putInMap(requirement, nextStep);
        }
    }

    private void putInMap(final char req, final char next) {
        final Step requirement = createIfAbsent(req);
        final Step nextStep = createIfAbsent(next);
        nextStep.addToPrequisites(requirement);
    }

    private Step createIfAbsent(final char c) {
        Step step = steps.get(c);
        if (step == null) {
            step = new Step(c);
            steps.put(c, step);
        }
        return step;
    }

    private void reset() {
        for (final Step step : steps.values()) {
            step.setDone(false);
            step.setPreqFilled(false);
        }
    }


}