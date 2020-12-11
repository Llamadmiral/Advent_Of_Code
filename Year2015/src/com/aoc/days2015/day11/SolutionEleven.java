package com.aoc.days2015.day11;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEleven extends SolutionBase {

    private static final String ABC = "abcdefghijklmnopqrstuvwxyz";
    private static final int CONFUSING_I = ABC.indexOf("i");
    private static final int CONFUSING_O = ABC.indexOf("o");
    private static final int CONFUSING_L = ABC.indexOf("l");


    private int[] passwordOne;

    SolutionEleven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int[] password = toPassword(input);
        boolean passwordValid = false;
        while (!passwordValid) {
            incrementPassword(password);
            passwordValid = isPasswordValid(password);
        }
        this.passwordOne = password;
        setSolutionOne(fromPassword(password));
    }

    @Override
    protected void solvePartTwo() {
        boolean passwordValid = false;
        int[] password = this.passwordOne;
        while (!passwordValid) {
            incrementPassword(password);
            passwordValid = isPasswordValid(password);
        }
        setSolutionTwo(fromPassword(password));
    }

    private void incrementPassword(final int[] password) {
        int remainder = 1;
        for (int i = password.length - 1; i >= 0; i--) {
            password[i] += remainder;
            if (password[i] == 26) {
                password[i] = 0;
                remainder = 1;
            } else {
                break;
            }
        }
    }

    private boolean isPasswordValid(final int[] password) {
        boolean incrementingThree = false;
        boolean confusingLetters = false;
        boolean oneOverlap = false;
        boolean twoOverlap = false;
        boolean waitedOne = false;
        for (int i = 0; i < password.length; i++) {
            if (i < password.length - 3 && password[i] == password[i + 1] - 1 && password[i] == password[i + 2] - 2) {
                incrementingThree = true;
            }
            if (password[i] == CONFUSING_I || password[i] == CONFUSING_O || password[i] == CONFUSING_L) {
                confusingLetters = true;
                break;
            }
            if (i <= password.length - 2 && password[i] == password[i + 1]) {
                if (!oneOverlap) {
                    oneOverlap = true;
                } else if (waitedOne) {
                    twoOverlap = true;
                }
            } else if (oneOverlap) {
                waitedOne = true;
            }
        }
        return incrementingThree && !confusingLetters && twoOverlap;
    }

    private int[] toPassword(final String pass) {
        final int[] password = new int[pass.length()];
        for (int i = 0; i < pass.length(); i++) {
            password[i] = ABC.indexOf(pass.charAt(i));
        }
        return password;
    }

    private String fromPassword(final int[] password) {
        final StringBuilder builder = new StringBuilder();
        for (final int letter : password) {
            builder.append(ABC.charAt(letter));
        }
        return builder.toString();
    }
}