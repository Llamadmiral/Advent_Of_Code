package com.aoc.days2018.day09;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionNine extends SolutionBase {

    private final Map<Integer, Long> scoreMap = new HashMap<>();
    private int numberOfPlayers = 9;
    private int lastScore = 25;
    private Marble current;

    SolutionNine(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] data = input.split(" ");
        this.numberOfPlayers = Integer.parseInt(data[0]);
        this.lastScore = Integer.parseInt(data[6]);
    }

    @Override
    protected void solvePartOne() {
        placeMarbles();
        final long highestScore = getHighestScore();
        setSolutionOne(highestScore);
    }

    @Override
    protected void solvePartTwo() {
        reset();
        lastScore *= 100;
        placeMarbles();
        final long highestScore = getHighestScore();
        setSolutionTwo(highestScore);
    }

    private void reset() {
        scoreMap.clear();
        current = null;
    }

    private void placeMarbles() {
        current = new Marble(0);
        current.setNext(current);
        current.setPrevious(current);
        int currentPlayer = 0;
        for (int i = 1; i < lastScore + 1; i++) {
            if (i % 23 == 0) {
                final Marble toRemove = current.remove(7);
                registerScore(currentPlayer, toRemove.getScore() + i);
                current = toRemove.getNext();
            } else {
                current = current.addMarble(i);
            }
            currentPlayer = (currentPlayer + 1) % numberOfPlayers;
        }
    }

    private long getHighestScore() {
        long max = 0;
        for (long score : scoreMap.values()) {
            if (max < score) {
                max = score;
            }
        }
        return max;
    }

    private void registerScore(final int playerNo, final int score) {
        Long currentScore = scoreMap.get(playerNo);
        if (currentScore == null) {
            currentScore = (long) score;
        } else {
            currentScore += score;
        }
        scoreMap.put(playerNo, currentScore);
    }

}