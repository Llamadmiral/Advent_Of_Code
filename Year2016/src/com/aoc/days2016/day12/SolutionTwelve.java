package com.aoc.days2016.day12;

import com.aoc.solutionbase.SolutionBase;
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

    void doLogic(final Instruction instruction) {
        switch (instruction.getType()) {
            case "cpy":
                registry.put(instruction.getPointerB(),
                    instruction.isaIsPointer()
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
                if (instruction.isaIsPointer()) {
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

    private static class Instruction {
        private String type;
        private char pointerA;
        private char pointerB;
        private int valueA;
        private int valueB;
        private boolean aIsPointer = false;
        private boolean bIsPointer = false;

        Instruction(final String row) {
            final String[] data = row.split(" ");
            this.type = data[0];
            final String columnA = data[1];
            if (columnA.length() == 1 && Character.isAlphabetic(columnA.charAt(0))) {
                pointerA = columnA.charAt(0);
                aIsPointer = true;
            } else {
                valueA = Integer.parseInt(columnA);
            }
            if (data.length > 2) {
                final String columnB = data[2];
                if (columnB.length() == 1 && Character.isAlphabetic(columnB.charAt(0))) {
                    pointerB = columnB.charAt(0);
                    bIsPointer = true;
                } else {
                    valueB = Integer.parseInt(columnB);
                }
            }
        }

        String getType() {
            return type;
        }

        char getPointerA() {
            return pointerA;
        }

        char getPointerB() {
            return pointerB;
        }

        int getValueA() {
            return valueA;
        }

        int getValueB() {
            return valueB;
        }

        boolean isaIsPointer() {
            return aIsPointer;
        }

        public boolean isbIsPointer() {
            return bIsPointer;
        }
    }

}