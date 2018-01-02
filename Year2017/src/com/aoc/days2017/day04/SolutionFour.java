package com.aoc.days2017.day04;

import com.aoc.solutionbase.SolutionBase;

import java.util.Arrays;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {

    SolutionFour(final String day, final String input) {
        super(day);
        this.input = input;
    }

    SolutionFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        solve(false);
    }

    @Override
    protected void solvePartTwo() {
        solve(true);
    }

    void solve(final boolean partTwo) {
        final String inp = (String) input;
        int sum = 0;
        final String[] rows = inp.split("\n");
        for (final String row : rows) {
            final String[] phrases = row.split(" ");
            if (partTwo) {
                if (isValidPassPhraseHigherSecurity(phrases)) {
                    sum++;
                }
            } else {
                if (isValidPassPhraseLowerSecurity(phrases)) {
                    sum++;
                }
            }
        }
        if (partTwo) {
            setSolutionTwo(sum);
        } else {
            setSolutionOne(sum);
        }
    }

    private boolean isValidPassPhraseHigherSecurity(final String[] list) {
        boolean isValid = true;
        for (int i = 0; i < list.length; i++) {
            String key = list[i];
            for (int j = 0; j < list.length; j++) {
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

    //this is very lazy
    private boolean isAnagram(final String one, final String two) {
        boolean isAnagram = false;
        if (one.length() == two.length()) {
            final String sortedOne = sortString(one);
            final String sortedTwo = sortString(two);
            isAnagram = sortedOne.equals(sortedTwo);
        }
        return isAnagram;
    }

    private String sortString(final String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
