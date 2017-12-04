package com.aoc.days.dayfour;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka.
 */
public class Solution extends SolutionBase {

    Solution(final String day, final String input) {
        super(day);
        this.input = input;
    }

    Solution(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final String inp = (String) input;
        int sum = 0;
        final String[] rows = inp.split("\n");
        for (final String row : rows) {
            final String[] phrases = row.split(" ");
            if (isValidPassPhraseLowerSecurity(phrases)) {
                sum++;
            }
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        final String inp = (String) input;
        int sum = 0;
        final String[] rows = inp.split("\n");
        for (final String row : rows) {
            final String[] phrases = row.split(" ");
            if (isValidPassPhraseHigherSecurity(phrases)) {
                sum++;
            }
        }
        setSolutionTwo(sum);
    }

    private boolean isValidPassPhraseHigherSecurity(final String[] list) {
        boolean isValid = true;
        for (int i = 0; i < list.length; i++) {
            String key = list[i];
            for (int j = 0, listLength = list.length; j < listLength; j++) {
                if (i != j) {
                    String otherKey = list[j];
                    if (isAnagram(key, otherKey)) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }

    private boolean isValidPassPhraseLowerSecurity(final String[] list) {
        boolean isValid = true;
        for (int i = 0; i < list.length; i++) {
            String key = list[i];
            for (int j = 0, listLength = list.length; j < listLength; j++) {
                if (i != j) {
                    String otherKey = list[j];
                    if (otherKey.equals(key)) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }

    private boolean isAnagram(final String one, final String two) {
        boolean isAnagram = false;
        if (one.length() == two.length()) {
            int sameLetters = 0;
            for (int i = 0; i < one.length(); i++) {
                if (two.contains(Character.toString(one.charAt(i)))) {
                    sameLetters++;
                }
            }
            if (Integer.valueOf(one.length()).equals(sameLetters)) {
                isAnagram = true;
            }
        }
        return isAnagram;
    }
}
