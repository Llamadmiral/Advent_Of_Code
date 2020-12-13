package com.aoc.days2020.day08;

import java.util.ArrayList;
import java.util.List;

class HaltingDetecter {

    static final String NOP = "nop";
    static final String JMP = "jmp";
    static final String ACC = "acc";

    private int accumulator = 0;
    private int pointer = 0;
    private boolean instructionsHalt;


    private List<Integer> visitedPointers = new ArrayList<>();

    void detectHalting(final List<Instruction> instructions) {
        while (!visitedPointers.contains(pointer) && pointer < instructions.size()) {
            visitedPointers.add(pointer);
            performInstruction(instructions.get(pointer));
        }
        instructionsHalt = pointer < instructions.size();
    }

    public boolean getInstructionsHalt() {
        return instructionsHalt;
    }

    int getAccumulator() {
        return accumulator;
    }

    void reset() {
        this.accumulator = 0;
        this.visitedPointers.clear();
        this.pointer = 0;
    }

    private void performInstruction(final Instruction instruction) {
        final String type = instruction.getType();
        switch (type) {
            case NOP:
                pointer++;
                break;
            case JMP:
                pointer += instruction.getOffset();
                break;
            case ACC:
                accumulator += instruction.getOffset();
                pointer++;
                break;
        }
    }

}
