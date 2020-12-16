package com.aoc.days2020.day15;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionFifteen extends SolutionBase {

    private static final int GAME_END_TURN = 2020;
    private final Map<Integer, SpokenNumber> memory = new HashMap<>();
    private int lastSpokenNumber;

    private int index = 0;

    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int lastNumber = getLastSpokenNumber(2020);
        setSolutionOne(lastNumber);
    }

    @Override
    protected void solvePartTwo() {
        final int lastNumber = getLastSpokenNumber(30000000);
        setSolutionTwo(lastNumber);
    }

    private void setupMemory() {
        final String[] numbers = input.split(",");
        for (final String number : numbers) {
            final int value = Integer.parseInt(number);
            memory.put(value, new SpokenNumber(index));
            lastSpokenNumber = value;
            index++;
        }
    }

    private int getLastSpokenNumber(final int turns) {
        index = 0;
        memory.clear();
        setupMemory();
        for (int i = index; i < turns; i++) {
            lastSpokenNumber = sayNumber(lastSpokenNumber, i);
        }
        return lastSpokenNumber;
    }

    private int sayNumber(final int number, final int position) {
        int nextNumber = 0;
        final SpokenNumber spokenNumber = memory.get(number);
        if (spokenNumber.getAlreadySaid()) {
            nextNumber = spokenNumber.getCurrentPosition() - spokenNumber.getLastPosition();
        }
        final SpokenNumber saidNumber = memory.get(nextNumber);
        if (saidNumber == null) {
            memory.put(nextNumber, new SpokenNumber(position));
        } else {
            saidNumber.say(position);
        }
        return nextNumber;
    }


}