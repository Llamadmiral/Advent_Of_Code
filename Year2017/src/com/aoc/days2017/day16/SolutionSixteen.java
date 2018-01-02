package com.aoc.days2017.day16;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Unfortunately, this was a try and see solution. After much watching, I noticed that the generated list
 * was cyclic. I also made a small scribbling where I had to prove somehow if amount of generations % amount of unique
 * generations will be the last one.
 * Math is hard.
 *
 * @author maczaka.
 */
class SolutionSixteen extends SolutionBase {

    private static final int ONE_BILLION = 1000000000;
    private final List<String> cache = new ArrayList<>();
    private final char[] programList = "abcdefghijklmnop".toCharArray();
    private List<Move> moveList = new ArrayList<>();


    SolutionSixteen(final String day) {
        super(day);
    }

    private void initMoveList() {
        final String[] moves = ((String) input).split(",");
        for (final String move : moves) {
            moveList.add(new Move(move));
        }
    }

    @Override
    protected void solvePartOne() {
        initMoveList();
        for (final Move move : moveList) {
            transformProgramList(move);
        }
        setSolutionOne(new String(programList));
    }

    @Override
    protected void solvePartTwo() {
        System.arraycopy("abcdefghijklmnop".toCharArray(), 0, programList, 0, 16);
        int i;
        for (i = 0; i < ONE_BILLION; i++) {
            final String oldList = new String(programList);
            if (!cache.contains(oldList)) {
                for (final Move move : moveList) {
                    transformProgramList(move);
                }
            } else {
                break;
            }
            cache.add(oldList);
        }
        setSolutionTwo(cache.get(ONE_BILLION % cache.size()));
    }

    private void transformProgramList(final Move move) {
        switch (move.getType()) {
            case 's':
                spin(programList, move.getAmount());
                break;
            case 'x':
                exchange(programList, move.getFrom(), move.getTo());
                break;
            case 'p':
                partner(programList, move.getWho(), move.getWith());
                break;
            default:
                break;
        }
    }

    private void exchange(final char[] programs, final int positionOne, final int positionTwo) {
        char temp = programs[positionOne];
        programs[positionOne] = programs[positionTwo];
        programs[positionTwo] = temp;
    }

    private void partner(final char[] programs, final char programOne, final char programTwo) {
        exchange(programs, indexOfCharInArray(programs, programOne), indexOfCharInArray(programs, programTwo));
    }

    private void spin(final char[] programs, final int amount) {
        final int length = programs.length;
        final char[] emptyPrograms = new char[length];
        int startingPosition = -1;
        if (amount != 0 && amount != length) {
            for (int i = 0; i < length; i++) {
                if (i < length - amount) {
                    emptyPrograms[i + amount] = programs[i];
                } else {
                    if (startingPosition == -1) {
                        startingPosition = i;
                    }
                    emptyPrograms[i - startingPosition] = programs[i];
                }
            }
        }
        System.arraycopy(emptyPrograms, 0, programs, 0, emptyPrograms.length);
    }

    private int indexOfCharInArray(final char[] programs, final char program) {
        for (int i = 0; i < programs.length; i++) {
            if (programs[i] == program) {
                return i;
            }
        }
        return -1; // will never happen
    }
}
