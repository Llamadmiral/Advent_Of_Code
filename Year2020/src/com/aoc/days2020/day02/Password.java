package com.aoc.days2020.day02;

class Password {

    private int min;
    private int max;
    private char mustCharacter;
    private String pass;

    Password(final int min, final int max, final char mustCharacter, final String pass) {
        this.min = min;
        this.max = max;
        this.mustCharacter = mustCharacter;
        this.pass = pass;
    }


    boolean isValidForOldPolicy() {
        int count = 0;
        for (int i = 0; i < this.pass.length(); i++) {
            if (this.pass.charAt(i) == this.mustCharacter) {
                count++;
                if (count > this.max) {
                    break;
                }
            }
        }
        return this.min <= count && count <= max;
    }

    boolean isValidForNewPolicy() {
        final char firstPosition = this.pass.charAt(this.min - 1);
        final char lastPosition = this.pass.charAt(this.max - 1);
        return firstPosition != lastPosition && (firstPosition == this.mustCharacter || lastPosition == this.mustCharacter);
    }
}
