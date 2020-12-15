package com.aoc.days2020.day14;

import java.util.ArrayList;
import java.util.List;

class Instruction {
    private String mask;
    private List<Long> addresses = new ArrayList<>();
    private List<char[]> values = new ArrayList<>();

    Instruction(final String mask) {
        this.mask = mask;
    }

    static char[] toBits(final long value) {
        final char[] result = new char[36];
        long r = value;
        for (int i = 35; i >= 0; i--) {
            result[i] = ((r % 2) == 1) ? '1' : '0';
            r = r / 2;
            if (r == 0) {
                break;
            }
        }
        return result;
    }

    void put(final String address, final String value) {
        this.addresses.add(Long.valueOf(address));
        this.values.add(toBits(Long.valueOf(value)));
    }

    int size() {
        return this.values.size();
    }

    long getAddress(final int i) {
        return this.addresses.get(i);
    }

    char[] getMaskedValue(final int i) {
        final char[] result = new char[36];
        final char[] value = this.values.get(i);
        for (int j = 0; j < mask.length(); j++) {
            if (mask.charAt(j) == 'X') {
                result[j] = value[j];
            } else {
                result[j] = mask.charAt(j);
            }
        }
        return result;
    }

    char[] getMask() {
        return this.mask.toCharArray();
    }

    char[] getValue(final int i) {
        return this.values.get(i);
    }
}
