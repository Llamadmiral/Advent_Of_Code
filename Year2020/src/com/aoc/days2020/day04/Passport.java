package com.aoc.days2020.day04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Passport {

    private static final Set<String> VALID_EYE_COLOURS = new HashSet<>();

    static {
        VALID_EYE_COLOURS.add("amb");
        VALID_EYE_COLOURS.add("blu");
        VALID_EYE_COLOURS.add("grn");
        VALID_EYE_COLOURS.add("gry");
        VALID_EYE_COLOURS.add("brn");
        VALID_EYE_COLOURS.add("hzl");
        VALID_EYE_COLOURS.add("oth");
    }

    private final Map<String, String> values = new HashMap<>();

    Passport(final String row) {
        final String[] parts = row.split(" ");
        for (final String part : parts) {
            final String[] keyAndValue = part.split(":");
            values.put(keyAndValue[0], keyAndValue[1]);
        }
    }

    boolean fieldPresent(final String field) {
        return values.get(field) != null;
    }

    boolean fieldValid(final String key) {
        boolean valid = false;
        final String value = values.get(key);
        if (value != null) {
            switch (key) {
                case "byr":
                    valid = birthYearValid(value);
                    break;
                case "iyr":
                    valid = issueYearValid(value);
                    break;
                case "eyr":
                    valid = expirationYearValid(value);
                    break;
                case "hgt":
                    valid = heightValid(value);
                    break;
                case "hcl":
                    valid = hairColorValid(value);
                    break;
                case "ecl":
                    valid = eyeColorValid(value);
                    break;
                case "pid":
                    valid = passportIdValid(value);
                    break;
            }
        }
        return valid;
    }

    private boolean birthYearValid(final String value) {
        return valueBetween(1920, 2002, value);
    }

    private boolean issueYearValid(final String value) {
        return valueBetween(2010, 2020, value);
    }

    private boolean expirationYearValid(final String value) {
        return valueBetween(2020, 2030, value);
    }

    private boolean heightValid(final String value) {
        boolean valid;
        final String num = value.substring(0, value.length() - 2);
        if (value.endsWith("cm")) {
            valid = valueBetween(150, 193, num);
        } else if (value.endsWith("in")) {
            valid = valueBetween(59, 76, num);
        } else {
            valid = false;
        }
        return valid;
    }

    private boolean hairColorValid(final String value) {
        boolean valid = true;
        if (value.length() == 7 && value.startsWith("#")) {
            for (int i = 1; i < value.length(); i++) {
                final char current = value.charAt(i);
                if ((current < '0' || current > '9') && (current < 'a' || current > 'f')) {
                    valid = false;
                    break;
                }
            }
        } else {
            valid = false;
        }
        return valid;
    }

    private boolean eyeColorValid(final String value) {
        return VALID_EYE_COLOURS.contains(value);
    }

    private boolean passportIdValid(final String value) {
        boolean valid = value.length() == 9;
        if (valid) {
            for (int i = 0; i < value.length(); i++) {
                final char current = value.charAt(i);
                if ('0' > current || current > '9') {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }

    private boolean valueBetween(final int min, final int max, final String value) {
        final int num = Integer.parseInt(value);
        return min <= num && num <= max;
    }


}
