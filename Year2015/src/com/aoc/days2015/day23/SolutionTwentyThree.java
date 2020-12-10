package com.aoc.days2015.day23;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aoc.days2015.day23.Instruction.HLF;
import static com.aoc.days2015.day23.Instruction.INC;
import static com.aoc.days2015.day23.Instruction.JIE;
import static com.aoc.days2015.day23.Instruction.JIO;
import static com.aoc.days2015.day23.Instruction.JMP;
import static com.aoc.days2015.day23.Instruction.TPL;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyThree extends SolutionBase {

    private final Map<Character, Integer> registry = new HashMap<>();
    private final List<Instruction> instructions = new ArrayList<>();
    private int index = 0;

    SolutionTwentyThree(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll(",", "");
        for (final String row : input.split("\n")) {
            final String[] parts = row.split(" ");
            final String type = parts[0];
            switch (type) {
                case HLF:
                case TPL:
                case INC: {
                    final char registryName = parts[1].charAt(0);
                    instructions.add(new Instruction(type, registryName));
                    break;
                }
                case JMP:
                    instructions.add(new Instruction(type, '\0', Integer.valueOf(parts[1])));
                    break;
                case JIO:
                case JIE: {
                    final char registryName = parts[1].charAt(0);
                    instructions.add(new Instruction(type, registryName, Integer.valueOf(parts[2])));
                    break;
                }
            }
            registry.put('a', 0);
            registry.put('b', 0);
        }
    }

    @Override
    protected void solvePartOne() {
        simulate();
        setSolutionOne(registry.get('b'));
    }

    @Override
    protected void solvePartTwo() {
        registry.put('a', 1);
        registry.put('b', 0);
        index = 0;
        simulate();
        setSolutionTwo(registry.get('b'));
    }

    private void simulate() {
        while (index < instructions.size()) {
            final Instruction instruction = instructions.get(index);
            performInstruction(instruction);
        }
    }

    private void performInstruction(final Instruction instruction) {
        final String type = instruction.getType();
        if (type.equals(HLF)) {
            registry.put(instruction.getRegistryName(), registry.get(instruction.getRegistryName()) / 2);
        } else if (type.equals(TPL)) {
            registry.put(instruction.getRegistryName(), registry.get(instruction.getRegistryName()) * 3);
        } else if (type.equals(INC)) {
            registry.put(instruction.getRegistryName(), registry.get(instruction.getRegistryName()) + 1);
        } else if (type.equals(JMP)) {
            index += instruction.getValue() - 1;
        } else if (type.equals(JIE) && registry.get(instruction.getRegistryName()) % 2 == 0) {
            index += instruction.getValue() - 1;
        } else if (type.equals(JIO) && registry.get(instruction.getRegistryName()) == 1) {
            index += instruction.getValue() - 1;
        }
        index++;
    }

}