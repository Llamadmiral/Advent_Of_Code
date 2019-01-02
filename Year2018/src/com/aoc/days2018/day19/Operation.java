package com.aoc.days2018.day19;

/**
 * @author maczaka.
 */
class Operation {
    static int addr(final int[] registry, final int[] operation) {
        return registry[operation[0]] + registry[operation[1]];
    }

    static int addi(final int[] registry, final int[] operation) {
        return registry[operation[0]] + operation[1];
    }

    static int mulr(final int[] registry, final int[] operation) {
        return registry[operation[0]] * registry[operation[1]];
    }

    static int muli(final int[] registry, final int[] operation) {
        return registry[operation[0]] * operation[1];
    }

    static int banr(final int[] registry, final int[] operation) {
        return registry[operation[0]] & registry[operation[1]];
    }

    static int bani(final int[] registry, final int[] operation) {
        return registry[operation[0]] & operation[1];
    }

    static int borr(final int[] registry, final int[] operation) {
        return registry[operation[0]] | registry[operation[1]];
    }

    static int bori(final int[] registry, final int[] operation) {
        return registry[operation[0]] | operation[1];
    }

    static int setr(final int[] registry, final int[] operation) {
        return registry[operation[0]];
    }

    static int seti(final int[] registry, final int[] operation) {
        return operation[0];
    }

    static int gtir(final int[] registry, final int[] operation) {
        return operation[0] > registry[operation[1]] ? 1 : 0;
    }

    static int gtri(final int[] registry, final int[] operation) {
        return registry[operation[0]] > operation[1] ? 1 : 0;
    }

    static int gtrr(final int[] registry, final int[] operation) {
        return registry[operation[0]] > registry[operation[1]] ? 1 : 0;
    }

    static int eqir(final int[] registry, final int[] operation) {
        return operation[0] == registry[operation[1]] ? 1 : 0;
    }

    static int eqri(final int[] registry, final int[] operation) {
        return registry[operation[0]] == operation[1] ? 1 : 0;
    }

    static int eqrr(final int[] registry, final int[] operation) {
        return registry[operation[0]] == registry[operation[1]] ? 1 : 0;
    }
}
