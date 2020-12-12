package com.aoc.days2020.day04;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {

    private static final List<String> REQUIRED_FIELDS = new ArrayList<>();

    static {
        REQUIRED_FIELDS.add("byr");
        REQUIRED_FIELDS.add("iyr");
        REQUIRED_FIELDS.add("eyr");
        REQUIRED_FIELDS.add("hgt");
        REQUIRED_FIELDS.add("hcl");
        REQUIRED_FIELDS.add("ecl");
        REQUIRED_FIELDS.add("pid");
    }

    private final List<Passport> passports = new ArrayList<>();

    SolutionFour(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("\n\n", "\t").replaceAll("\n", " ").replaceAll("\t", "\n");
        for (final String row : input.split("\n")) {
            passports.add(new Passport(row));
        }
    }

    @Override
    protected void solvePartOne() {
        int validPassports = 0;
        for (final Passport passport : passports) {
            boolean valid = true;
            for (final String requiredField : REQUIRED_FIELDS) {
                final boolean fieldPresent = passport.fieldPresent(requiredField);
                if (!fieldPresent) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                validPassports++;
            }
        }
        setSolutionOne(validPassports);
    }

    @Override
    protected void solvePartTwo() {
        int validPassports = 0;
        for (final Passport passport : passports) {
            boolean valid = true;
            for (final String requiredField : REQUIRED_FIELDS) {
                final boolean fieldPresent = passport.fieldValid(requiredField);
                if (!fieldPresent) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                validPassports++;
            }
        }
        setSolutionTwo(validPassports);
    }
}