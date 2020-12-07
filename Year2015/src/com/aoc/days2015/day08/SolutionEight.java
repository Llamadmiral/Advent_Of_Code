package com.aoc.days2015.day08;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEight extends SolutionBase {
    SolutionEight(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int totalCharacters = 0;
        int totalMemory = 0;
        for (final String row : input.split("\n")) {
            int characters = 0;
            int memory = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '\\') {
                    if (row.charAt(i + 1) == 'x') {
                        memory++;
                        i += 3;
                        characters += 4;
                    } else {
                        memory++;
                        i += 1;
                        characters += 2;
                    }
                } else if (row.charAt(i) == '"') {
                    characters++;
                } else {
                    characters++;
                    memory++;
                }
            }
            totalCharacters += characters;
            totalMemory += memory;
        }
        setSolutionOne(totalCharacters - totalMemory);
    }

    @Override
    protected void solvePartTwo() {
        int totalCharacters = 0;
        int totalOriginalCharacters = 0;
        for (final String row : input.split("\n")) {
            int characters = 2;
            int originalCharacters = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '\\') {
                    if (row.charAt(i + 1) == 'x') {
                        i += 3;
                        characters += 5;
                        originalCharacters += 4;
                    } else {
                        i += 1;
                        characters += 4;
                        originalCharacters += 2;
                    }
                } else if (row.charAt(i) == '"') {
                    characters += 2;
                    originalCharacters++;
                } else {
                    characters++;
                    originalCharacters++;
                }
            }
            totalCharacters += characters;
            totalOriginalCharacters += originalCharacters;
        }
        setSolutionTwo(totalCharacters - totalOriginalCharacters);
    }

}