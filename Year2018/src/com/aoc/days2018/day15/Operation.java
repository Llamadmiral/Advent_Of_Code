package com.aoc.days2018.day15;

/**
 * @author maczaka.
 */
public class Operation {
    public static int addr(final int[] registry, final int[] operation) {
        return registry[operation[1]] + registry[operation[2]];
    }

    public static int addi(final int[] registry, final int[] operation) {
        return registry[operation[1]] + operation[2];
    }

    public static int mulr(final int[] registry, final int[] operation) {
        return registry[operation[1]] * registry[operation[2]];
    }

    public static int muli(final int[] registry, final int[] operation) {
        return registry[operation[1]] * operation[2];
    }

    public static int banr(final int[] registry, final int[] operation) {
        return registry[operation[1]] & registry[operation[2]];
    }

    public static int bani(final int[] registry, final int[] operation) {
        return registry[operation[1]] & operation[2];
    }

    public static int borr(final int[] registry, final int[] operation) {
        return registry[operation[1]] | registry[operation[2]];
    }

    public static int bori(final int[] registry, final int[] operation) {
        return registry[operation[1]] | operation[2];
    }

    public static int setr(final int[] registry, final int[] operation) {
        return registry[operation[1]];
    }

    public static int seti(final int[] registry, final int[] operation) {
        return operation[1];
    }

    public static int gtir(final int[] registry, final int[] operation) {
        return operation[1] > registry[operation[2]] ? 1 : 0;
    }

    public static int gtri(final int[] registry, final int[] operation) {
        return registry[operation[1]] > operation[2] ? 1 : 0;
    }

    public static int gtrr(final int[] registry, final int[] operation) {
        return registry[operation[1]] > registry[operation[2]] ? 1 : 0;
    }

    public static int eqir(final int[] registry, final int[] operation) {
        return operation[1] == registry[operation[2]] ? 1 : 0;
    }

    public static int eqri(final int[] registry, final int[] operation) {
        return registry[operation[1]] == operation[2] ? 1 : 0;
    }

    public static int eqrr(final int[] registry, final int[] operation) {
        return registry[operation[1]] == registry[operation[2]] ? 1 : 0;
    }
}
