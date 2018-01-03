package com.aoc.days2016.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka
 */
class Room {
    private Map<Character, Integer> characters = new HashMap<>();
    private String originalName;
    private int sectorId;
    private char[] checksum = new char[5];

    Room(final String input) {
        final String[] sectorAndCheck = (input.substring(input.lastIndexOf('-') + 1, input.length() - 1)).split("\\[");
        sectorId = Integer.parseInt(sectorAndCheck[0]);
        for (int i = 0; i < 5; i++) {
            checksum[i] = sectorAndCheck[1].charAt(i);
        }
        for (int i = 0; i < input.lastIndexOf('-'); i++) {
            final char c = input.charAt(i);
            if (c != '-') {
                final Integer counter = characters.get(c);
                if (counter == null) {
                    characters.put(c, 1);
                } else {
                    characters.put(c, counter + 1);
                }
            }
        }
        originalName = input.substring(0, input.lastIndexOf('-'));
    }

    private List<Character> getOrderedCharacters() {
        final List<Character> orderedName = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            char maxChar = '\0';
            int maxAmount = 0;
            for (final Map.Entry<Character, Integer> entry : characters.entrySet()) {
                final int value = entry.getValue();
                final char c = entry.getKey();
                if (!orderedName.contains(c)) {
                    if (maxAmount == 0 || maxAmount < value) {
                        maxChar = c;
                        maxAmount = value;
                    } else if (maxAmount == value && maxChar > c) {
                        maxChar = c;
                    }
                }
            }
            orderedName.add(maxChar);
        }
        return orderedName;
    }

    boolean isRealRoom() {
        final List<Character> orderedCharacters = getOrderedCharacters();
        int i = 0;
        if (orderedCharacters.size() == 5) {
            while (i < 5 && checksum[i] == orderedCharacters.get(i)) {
                i++;
            }
        }
        return i == 5;
    }

    private char shift(final char charToShift) {
        return (char) ((((charToShift - 97) + sectorId) % 26) + 97);
    }


    int getSectorId() {
        return sectorId;
    }

    String getShiftedName() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < originalName.length(); i++) {
            final char c = originalName.charAt(i);
            builder.append(c == '-' ? c : shift(c));
        }
        return builder.toString();
    }
}
