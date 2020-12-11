package com.aoc.days2015.day04;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.md5.MD5Helper;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {

    private static final String SECRET_KEY = "bgvyzdsv";
    private int startingPos = 0;

    SolutionFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        int index = -1;
        boolean found = false;
        while (!found) {
            index++;
            final String md5AsHexString = MD5Helper.getMD5AsHexString(SECRET_KEY + index);
            found = md5AsHexString.startsWith("00000");
        }
        startingPos = index;
        setSolutionOne(index);
    }

    @Override
    protected void solvePartTwo() {
        int index = startingPos - 1;
        boolean found = false;
        while (!found) {
            index++;
            final String md5AsHexString = MD5Helper.getMD5AsHexString(SECRET_KEY + index);
            found = md5AsHexString.startsWith("000000");
        }
        setSolutionTwo(index);
    }
}