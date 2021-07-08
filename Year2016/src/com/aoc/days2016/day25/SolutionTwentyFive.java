package com.aoc.days2016.day25;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.assembunny.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyFive extends SolutionBase {

    private final List<Instruction> instructions = new ArrayList<>();
    private final List<Integer> outputMemory = new ArrayList<>();
    private Integer output;
    private final Map<Character, Integer> registry = new HashMap<>();
    private Integer pointer = 0;
    private boolean stopCurrentSimulation = false;
    private Integer possibleValue = null;


    SolutionTwentyFive(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        for (final String row : rows) {
            final Instruction instruction = new Instruction(row);
            instructions.add(instruction);
        }
        registry.put('a', 0);
        registry.put('b', 0);
        registry.put('c', 0);
        registry.put('d', 0);
    }

    @Override
    protected void solvePartOne() {
        for (int i = 0; i < 100000000; i++) {
            simulate(i);
            if (possibleValue != null) {
                break;
            }
        }
        setSolutionOne(possibleValue);
    }

    private void simulate(final int i) {
        output = null;
        outputMemory.clear();
        stopCurrentSimulation = false;
        pointer = 0;
        registry.put('a', i);
        registry.put('b', 0);
        registry.put('c', 0);
        registry.put('d', 0);
        int counter = 0;
        while (counter < 100000) {
            step();
            counter++;
            if (stopCurrentSimulation) {
                break;
            }
        }
        if (!stopCurrentSimulation) {
            possibleValue = i;
        }
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }


    private void step() {
        final Instruction instruction = instructions.get(pointer);
        switch (instruction.getType()) {
            case "cpy":
                final Integer value;
                if (instruction.isAIsPointer()) {
                    value = registry.get(instruction.getPointerA());
                } else {
                    value = instruction.getValueA();
                }
                registry.put(instruction.getPointerB(), value);
                pointer++;
                break;
            case "inc":
                registry.put(instruction.getPointerA(), registry.get(instruction.getPointerA()) + 1);
                pointer++;
                break;
            case "dec":
                registry.put(instruction.getPointerA(), registry.get(instruction.getPointerA()) - 1);
                pointer++;
                break;
            case "jnz":
                final int offset = instruction.getValueB();
                Integer nullCheck;
                if (instruction.isAIsPointer()) {
                    nullCheck = registry.get(instruction.getPointerA());
                } else {
                    nullCheck = instruction.getValueA();
                }
                if (nullCheck != 0) {
                    pointer += offset;
                } else {
                    pointer++;
                }
                break;
            case "out":
                final int outputValue = registry.get(instruction.getPointerA());
                outputMemory.add(outputValue);
                setOutput(outputValue);
                pointer++;
                break;
        }
    }

    private void setOutput(final int value) {
        if (output == null) {
            output = value;
        } else if (output == value) {
            stopCurrentSimulation = true;
        } else {
            output = value;
        }
    }
}