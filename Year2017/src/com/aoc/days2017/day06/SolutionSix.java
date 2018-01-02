package com.aoc.days2017.day06;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * If I would use some sort of sorted implementation of the states, searching them through would be much quicker.
 * However, I am proud of how with my implementation, solving the second issue was no problem.
 *
 * @author Llamadmiral.
 */
class SolutionSix extends SolutionBase {

    private static final List<Integer[]> STATES = new ArrayList<>();
    private static final List<MemoryBank> BANKS = new ArrayList<>();
    private int sorts = 0;

    SolutionSix(final String day) {
        super(day);
    }

    private void initBanks() {
        final String inp = (String) input;
        final String[] baseValues = inp.split("\t");
        MemoryBank firstBank = null;
        MemoryBank prevBank = null;
        MemoryBank newBank = null;
        for (final String value : baseValues) {
            final int memory = Integer.parseInt(value);
            newBank = new MemoryBank(memory);
            if (firstBank == null) {
                firstBank = newBank;
            }
            if (prevBank == null) {
                prevBank = newBank;
            } else {
                prevBank.setNextBank(newBank);
                prevBank = newBank;
            }
            BANKS.add(newBank);
        }
        if (newBank != null) {
            newBank.setNextBank(firstBank);
        }
    }

    @Override
    protected void solvePartOne() {
        initBanks();
        sort();
        setSolutionOne(sorts);
    }

    @Override
    protected void solvePartTwo() {
        //no need
    }

    private void sort() {
        while (!saveState()) {
            sorts++;
            final MemoryBank biggestBank = findBiggestBank();
            if (biggestBank != null) {
                MemoryBank bank = biggestBank.getNextBank();
                int biggestMemory = biggestBank.getMemory();
                biggestBank.setMemory(0);
                while (biggestMemory > 0) {
                    bank.incrementMemory();
                    biggestMemory--;
                    bank = bank.getNextBank();
                }
            }
        }
    }

    private boolean checkContains(final Integer[] newState) {
        boolean contains = false;
        for (int i = 0; i < STATES.size(); i++) {
            Integer[] state = STATES.get(i);
            if (Arrays.equals(newState, state)) {
                setSolutionTwo(STATES.size() - i);
                contains = true;
                break;
            }
        }
        return contains;
    }

    private MemoryBank findBiggestBank() {
        MemoryBank biggestBank = null;
        for (final MemoryBank bank : BANKS) {
            if (biggestBank == null || biggestBank.getMemory() < bank.getMemory()) {
                biggestBank = bank;
            }
        }
        return biggestBank;
    }

    private boolean saveState() {
        final Integer[] newState = new Integer[BANKS.size()];
        for (int i = 0; i < BANKS.size(); i++) {
            final MemoryBank bank = BANKS.get(i);
            newState[i] = bank.getMemory();
        }

        boolean stateExistedBefore = false;

        if (checkContains(newState)) {
            stateExistedBefore = true;
            STATES.add(newState);
        } else {
            STATES.add(newState);
        }
        return stateExistedBefore;
    }

}
