package com.aoc.days2018.day05;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionFive extends SolutionBase {

    private Set<Character> characters = new HashSet<>();

    SolutionFive(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        Polymer first = doReaction(input);
        final int length = countLength(first);
        setSolutionOne(length);
    }

    private void prepareInput() {
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c > 'Z' && !characters.contains(c)) {
                characters.add(c);
            }
        }
    }

    @Override
    protected void solvePartTwo() {
        prepareInput();
        int minLength = -1;
        for (char c : characters) {
            final String currentChain = removePolymers(input, c);
            final Polymer polymer = doReaction(currentChain);
            final int newLength = countLength(polymer);
            if (minLength == -1 || newLength < minLength) {
                minLength = newLength;
            }
        }
        setSolutionTwo(minLength);
    }

    private boolean doReact(final char a, final char b) {
        return a - 32 == b || a + 32 == b;
    }

    private String removePolymers(final String chain, final char toRemove) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < chain.length(); i++) {
            char current = chain.charAt(i);
            if (current != toRemove && current != (toRemove - 32)) {
                result.append(current);
            }
        }
        return result.toString();
    }

    private Polymer doReaction(final String chain) {
        Polymer current = null;
        Polymer first = null;
        for (int i = 0; i < chain.length(); i++) {
            char unit = chain.charAt(i);
            if (current == null) {
                current = new Polymer(unit);
                first = current;
            } else {
                if (!doReact(current.getUnit(), unit)) {
                    current = new Polymer(unit, current);
                } else {
                    current = current.getPrevious();
                }
            }
        }
        return first;
    }

    private int countLength(final Polymer polymer) {
        Polymer first = polymer;
        int i = 0;
        if (first != null) {
            i = 1;
            while (first.getNext() != null) {
                first = first.getNext();
                i++;
            }
        }
        return i;
    }

}