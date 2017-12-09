package com.aoc.days.daynine;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author maczaka
 */
class SolutionNine extends SolutionBase {
    SolutionNine(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        calculateScore((String) input);
    }

    @Override
    protected void solvePartTwo() {
        //no need
    }

    /**
     * I guess if I made some sort of Class doing the same operationt,
     * but splitted up into different methods, then I could reduce the cognitive complexity below 15,
     * but since the code is well-readable, and I just don't think it would worth the time.
     */
    private void calculateScore(final String dirtyInput) {
        boolean inGarbage = false;
        boolean toSkip = false;
        int level = 0;
        int score = 0;
        int allChars = 0;
        for (int i = 0; i < dirtyInput.length(); i++) {
            if (!toSkip) {
                if (inGarbage) {
                    switch (dirtyInput.charAt(i)) {
                        case '!':
                            toSkip = true;
                            break;
                        case '>':
                            inGarbage = false;
                            break;
                        default:
                            allChars++;
                            break;
                    }
                } else {
                    switch (dirtyInput.charAt(i)) {
                        case '<':
                            inGarbage = true;
                            break;
                        case '{':
                            level++;
                            score += level;
                            break;
                        case '}':
                            level--;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                toSkip = false;
            }
        }
        setSolutionOne(score);
        setSolutionTwo(allChars);
    }
}
