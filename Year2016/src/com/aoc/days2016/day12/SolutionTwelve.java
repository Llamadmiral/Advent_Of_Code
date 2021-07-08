package com.aoc.days2016.day12;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.assembunny.Instruction;
import com.aoc.util.log.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {

    private static final Logger LOG = new Logger();
    private List<Instruction> instructions = new ArrayList<>();
    private Map<Character, Integer> registry = new HashMap<>();
    private int line = 0;

    SolutionTwelve(final String day) {
        super(day);
    }

    private void doLogic(final Instruction instruction) {
        switch (instruction.getType()) {
            case "cpy":
                registry.put(instruction.getPointerB(),
                    instruction.isAIsPointer()
                        ? registry.get(instruction.getPointerA())
                        : instruction.getValueA()
                );
                line++;
                break;
            case "inc":
                inc(instruction.getPointerA());
                line++;
                break;
            case "dec":
                dec(instruction.getPointerA());
                line++;
                break;
            case "jnz":
                int valueA;
                if (instruction.isAIsPointer()) {
                    valueA = registry.get(instruction.getPointerA());
                } else {
                    valueA = instruction.getValueA();
                }
                if (valueA != 0) {
                    line += instruction.getValueB();
                } else {
                    line++;
                }
                break;
            default:
                LOG.log("Unknown type: " + instruction.getType());
                break;
        }
    }

    @Override
    protected void solvePartOne() {
        initValue(false);
        for (final String row : input.split("\n")) {
            instructions.add(new Instruction(row));
        }
        while (line >= 0 && line <= instructions.size() - 1) {
            doLogic(instructions.get(line));
        }
        setSolutionOne(registry.get('a'));
    }

    @Override
    protected void solvePartTwo() {
        initValue(true);
        line = 0;
        while (line >= 0 && line <= instructions.size() - 1) {
            doLogic(instructions.get(line));
        }
        setSolutionTwo(registry.get('a'));
    }

    private void inc(final char pointer) {
        registry.put(pointer, registry.get(pointer) + 1);
    }

    private void dec(final char pointer) {
        registry.put(pointer, registry.get(pointer) - 1);
    }

    private void initValue(final boolean partTwo) {
        registry.put('a', 0);
        registry.put('b', 0);
        registry.put('c', partTwo ? 1 : 0);
        registry.put('d', 0);
    }


}