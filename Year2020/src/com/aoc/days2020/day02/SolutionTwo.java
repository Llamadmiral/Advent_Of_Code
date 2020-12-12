package com.aoc.days2020.day02;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwo extends SolutionBase {

    private List<Password> passwords = new ArrayList<>();


    SolutionTwo(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("-", " ").replaceAll(":", "");
        for (final String row : input.split("\n")) {
            final String[] parts = row.split(" ");
            passwords.add(new Password(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                parts[2].charAt(0),
                parts[3]));
        }
    }

    @Override
    protected void solvePartOne() {
        int validPasswords = 0;
        for (final Password password : passwords) {
            if (password.isValidForOldPolicy()) {
                validPasswords++;
            }
        }
        setSolutionOne(validPasswords);
    }

    @Override
    protected void solvePartTwo() {
        int validPasswords = 0;
        for (final Password password : passwords) {
            if (password.isValidForNewPolicy()) {
                validPasswords++;
            }
        }
        setSolutionTwo(validPasswords);
    }
}