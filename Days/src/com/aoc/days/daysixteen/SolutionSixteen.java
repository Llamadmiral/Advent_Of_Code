package com.aoc.days.daysixteen;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
class SolutionSixteen extends SolutionBase {

    private static final int ONE_BILLION = 1000000000;
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
        for (int i = 0; i < ONE_BILLION; i++) {
            for (final Move move : moveList) {
                transformProgramList(move);
            }
        }
        setSolutionTwo(new String(programList));
    }

    private void transformProgramList(final Move move) {
        final char moveType = move.getType();
        switch (moveType) {
            case 's':
                spin(programList, move.getAmount());
                break;
            case 'x':
                exchange(programList, move.getFrom(), move.getTo());
                break;
            case 'p':
                partner(programList, move.getWho(), move.getWith());
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
