package com.aoc.days2020.day08;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

import static com.aoc.days2020.day08.HaltingDetecter.JMP;
import static com.aoc.days2020.day08.HaltingDetecter.NOP;

/**
 * @author Llamadmiral.
 */
class SolutionEight extends SolutionBase {


    private List<Instruction> instructions = new ArrayList<>();

    SolutionEight(final String day) {
        super(day);
    }

    @Override
    public void init() {
        for (final String row : input.split("\n")) {
            final String[] parts = row.split(" ");
            instructions.add(new Instruction(parts[0], Integer.valueOf(parts[1])));
        }
    }

    @Override
    protected void solvePartOne() {
        final HaltingDetecter haltingDetecter = new HaltingDetecter();
        haltingDetecter.detectHalting(instructions);
        final int accumulator = haltingDetecter.getAccumulator();
        setSolutionOne(accumulator);
    }

    @Override
    protected void solvePartTwo() {
        int accumulator = 0;
        final HaltingDetecter haltingDetecter = new HaltingDetecter();
        for (final Instruction instruction : instructions) {
            if (instruction.getType().equals(NOP) || instruction.getType().equals(JMP)) {
                switchInstruction(instruction);
                haltingDetecter.reset();
                haltingDetecter.detectHalting(instructions);
                final boolean instructionsHalt = haltingDetecter.getInstructionsHalt();
                if (instructionsHalt) {
                    switchInstruction(instruction);
                } else {
                    accumulator = haltingDetecter.getAccumulator();
                    break;
                }
            }
        }
        setSolutionTwo(accumulator);
    }

    private void switchInstruction(final Instruction instruction) {
        if (instruction.getType().equals(NOP)) {
            instruction.setType(JMP);
        } else if (instruction.getType().equals(JMP)) {
            instruction.setType(NOP);
        }
    }


}