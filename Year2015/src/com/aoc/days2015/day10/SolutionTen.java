package com.aoc.days2015.day10;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionTen extends SolutionBase {

    SolutionTen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final String fortyGeneration = generateLookSaySequence(input, 40);
        setSolutionOne(fortyGeneration.length());
    }

    @Override
    protected void solvePartTwo() {
        final String fiftyGenerations = generateLookSaySequence(input, 50);
        setSolutionTwo(fiftyGenerations.length());
    }

    private String generateLookSaySequence(final String input, final int sequencesToGenerate) {
        String current = input;
        for (int i = 0; i < sequencesToGenerate; i++) {
            current = generateLookSay(current);
        }
        return current;
    }

    private String generateLookSay(final String input) {
        final StringBuilder builder = new StringBuilder();
        int count = 1;
        char currentCharacter = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == currentCharacter) {
                count++;
            } else {
                builder.append(count).append(currentCharacter);
                currentCharacter = c;
                count = 1;
            }
        }
        builder.append(count).append(currentCharacter);
        return builder.toString();
    }
}