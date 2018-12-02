package com.aoc.days2018.day02;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionTwo extends SolutionBase {
    private int allTwos = 0;
    private int allTrees = 0;
    private Set<char[]> text = new HashSet<>();

    SolutionTwo(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        for (final char[] word : text) {
            checkIds(word);
        }
        setSolutionOne(allTwos * allTrees);
    }

    @Override
    protected void solvePartTwo() {
        boolean found = false;
        for (final char[] word1 : text) {
            for (final char[] word2 : text) {
                final String sameLetters = createSolution(word1, word2);
                if (sameLetters != null) {
                    setSolutionTwo(sameLetters);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }

    private String createSolution(final char[] word1, final char[] word2) {
        String sameLetters = null;
        final int difference = getDifference(word1, word2);
        if (difference == 1) {
            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word1.length; i++) {
                if (word1[i] == word2[i]) {
                    builder.append(word1[i]);
                }
            }
            sameLetters = builder.toString();
        }
        return difference != 1 ? null : sameLetters;
    }

    private int getDifference(final char[] word1, final char[] word2) {
        int sum = 0;
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                sum++;
            }
        }
        return sum;
    }

    private void checkIds(final char[] word) {
        final char[] cache = new char[27];
        boolean foundThree = false;
        boolean foundTwo = false;
        for (final char letter : word) {
            if (cache[letter - 97] == 0) {
                cache[letter - 97] = 0;
                final int sum = countLetters(word, letter);
                if (sum == 2 && !foundTwo) {
                    foundTwo = true;
                    allTwos++;
                } else if (sum == 3 && !foundThree) {
                    foundThree = true;
                    allTrees++;
                }
                if (foundTwo && foundThree) {
                    break;
                }
            }
        }
    }

    private int countLetters(final char[] word, final char c) {
        int sum = 0;
        for (char letter : word) {
            if (letter == c) {
                sum++;
            }
        }
        return sum;
    }

    private void prepareInput() {
        for (final String word : input.split("\n")) {
            text.add(word.toCharArray());
        }
    }
}