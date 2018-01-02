package com.aoc.days2016.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka
 */
class Room {
    private List<Character> name = new ArrayList<>();
    private String originalName;
    private int sectorId;
    private char[] checksum = new char[5];

    Room(final String input) {
        final String[] data = input.split("-");
        final String sectorAndCheck[] = data[data.length - 1].split("\\[");
        sectorId = Integer.parseInt(sectorAndCheck[0]);
        for (int i = 0; i < 5; i++) {
            checksum[i] = sectorAndCheck[1].charAt(i);
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length - 1; i++) {
            builder.append(data[i]);
        }
        originalName = builder.toString();
    }

    private char[] getOrderedCharacters(final boolean shift) {
        final char[] orderedName = shift ? shift() : originalName.toCharArray();
        int i = 1;
        while (i < originalName.length()) {
            char x = orderedName[i];
            int j = i - 1;
            while (j >= 0 && orderedName[j] > x) {
                orderedName[j + 1] = orderedName[j];
                j--;
            }
            orderedName[j + 1] = x;
            i++;
        }
        return orderedName;
    }

    boolean isRealRoom(final boolean shift) {
        final char[] orderedCharacters = getOrderedCharacters(shift);
        int i = 0;
        int j = 0;
        while (i < checksum.length && checksum[i] == orderedCharacters[j]) {
            while (j < orderedCharacters.length && checksum[i] == orderedCharacters[j]) {
                j++;
            }
            i++;
        }
        return i == checksum.length;
    }

    private char[] shift() {
        final char[] shiftedName = new char[originalName.length()];
        for (int i = 0; i < originalName.length(); i++) {
            shiftedName[i] = (char) (97 + ((originalName.charAt(i) + sectorId) % 27));
        }
        return shiftedName;
    }
}
