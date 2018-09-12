package com.aoc.days2015.day05;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionFive extends SolutionBase {

    private static final char[] vowels = "aeiou".toCharArray();
    private static final char[][] forbiddenCharacters = new char[][]{
            new char[]{'a', 'b'},
            new char[]{'c', 'd'},
            new char[]{'p', 'q'},
            new char[]{'x', 'y'}
    };

    SolutionFive(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int numberOfNiceStrings = 0;
        for (final String row : input.split("\n")) {
            if (isNiceStringPartOne(row)) {
                numberOfNiceStrings++;
            }
        }
        setSolutionOne(numberOfNiceStrings);
    }

    @Override
    protected void solvePartTwo() {
        int numberOfNiceStrings = 0;
        for (final String row : input.split("\n")) {
            if (isNiceStringPartTwo(row)) {
                numberOfNiceStrings++;
            }
        }
        setSolutionTwo(numberOfNiceStrings);
    }

    private boolean isNiceStringPartTwo(final String string) {
        final char[] chars = string.toCharArray();
        return hasRepeatedPartsWithoutOverlap(chars) && hasRepeatWithPause(chars);
    }

    private boolean hasRepeatedPartsWithoutOverlap(final char[] chars) {
        boolean hasRepeat = false;
        for (int i = 0; i < chars.length - 3; i++) {
            final char current = chars[i];
            final char next = chars[i + 1];
            for (int j = i + 2; j < chars.length - 1; j++) {
                if (current == chars[j] && next == chars[j + 1]) {
                    hasRepeat = true;
                    break;
                }
            }
            if (hasRepeat) {
                break;
            }
        }
        return hasRepeat;
    }

    private boolean hasRepeatWithPause(final char[] chars) {
        boolean hasRepeatWithPause = false;
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == chars[i + 2]) {
                hasRepeatWithPause = true;
                break;
            }
        }
        return hasRepeatWithPause;
    }

    private boolean isNiceStringPartOne(final String string) {
        int numberOfVowels = 0;
        boolean hasTwoSameLetter = false;
        boolean hasForbiddenPart = false;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            final char currentCharacter = charArray[i];
            final char nextCharacter = charArray[i + 1];
            if (numberOfVowels < 3) {
                if (isCharacterVowel(currentCharacter)) {
                    numberOfVowels++;
                }
            }
            hasTwoSameLetter |= nextCharacter == currentCharacter;
            if (isCharacterPairForbidden(currentCharacter, nextCharacter)) {
                hasForbiddenPart = true;
                break;
            }
        }
        if (isCharacterVowel(string.charAt(string.length() - 1))) {
            numberOfVowels++;
        }
        return numberOfVowels > 2 && hasTwoSameLetter && !hasForbiddenPart;
    }

    private boolean isCharacterPairForbidden(final char c1, final char c2) {
        boolean isForbidden = false;
        for (final char[] forbiddenPart : forbiddenCharacters) {
            if (forbiddenPart[0] == c1 && forbiddenPart[1] == c2) {
                isForbidden = true;
                break;
            }
        }
        return isForbidden;
    }

    private boolean isCharacterVowel(final char c) {
        boolean isVowel = false;
        for (final char vowel : vowels) {
            if (c == vowel) {
                isVowel = true;
                break;
            }
        }
        return isVowel;
    }
}