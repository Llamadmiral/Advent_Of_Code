package com.aoc.days2018.day16;

/**
 * @author maczaka.
 */
class Operation {
    static int addr(final int[] registry, final int[] operation) {
        return registry[operation[1]] + registry[operation[2]];
    }

    static int addi(final int[] registry, final int[] operation) {
        return registry[operation[1]] + operation[2];
    }

    static int mulr(final int[] registry, final int[] operation) {
        return registry[operation[1]] * registry[operation[2]];
    }

    static int muli(final int[] registry, final int[] operation) {
        return registry[operation[1]] * operation[2];
    }

    static int banr(final int[] registry, final int[] operation) {
        return registry[operation[1]] & registry[operation[2]];
    }

    static int bani(final int[] registry, final int[] operation) {
        return registry[operation[1]] & operation[2];
    }

    static int borr(final int[] registry, final int[] operation) {
        return registry[operation[1]] | registry[operation[2]];
    }

    static int bori(final int[] registry, final int[] operation) {
        return registry[operation[1]] | operation[2];
    }

    static int setr(final int[] registry, final int[] operation) {
        return registry[operation[1]];
    }

    static int seti(final int[] registry, final int[] operation) {
        return operation[1];
    }

    static int gtir(final int[] registry, final int[] operation) {
        return operation[1] > registry[operation[2]] ? 1 : 0;
    }

    static int gtri(final int[] registry, final int[] operation) {
        return registry[operation[1]] > operation[2] ? 1 : 0;
    }

    static int gtrr(final int[] registry, final int[] operation) {
        return registry[operation[1]] > registry[operation[2]] ? 1 : 0;
    }

    static int eqir(final int[] registry, final int[] operation) {
        return operation[1] == registry[operation[2]] ? 1 : 0;
    }

    static int eqri(final int[] registry, final int[] operation) {
        return registry[operation[1]] == operation[2] ? 1 : 0;
    }

    static int eqrr(final int[] registry, final int[] operation) {
        return registry[operation[1]] == registry[operation[2]] ? 1 : 0;
    }
}
