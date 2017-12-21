package com.aoc.days.dayeighteen;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka.
 */
class SolutionEighteen extends SolutionBase {

    private List<Instruction> instructions = new ArrayList<>();
    private Map<Character, Long> registry = new HashMap<>();
    private long lastPlayedSound;
    private long recoveredSound;
    private int pointer = 0;
    private boolean pointerChanged = false;
    private boolean isRecovered = false;

    SolutionEighteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        final int size = instructions.size();
        while (pointer > -1 && pointer < size && !isRecovered) {
            processInstruction(instructions.get(pointer));
            if (!pointerChanged) {
                pointer++;
            } else {
                pointerChanged = false;
            }
        }
        setSolutionOne(recoveredSound);
    }

    @Override
    protected void solvePartTwo() {

    }

    private void processInstruction(final Instruction instruction) {
        switch (instruction.getOperation()) {
            case "snd":
                lastPlayedSound = registry.get(instruction.getX());
                break;
            case "set":
                registry.put(instruction.getX(), instruction.getY());
                break;
            case "add":
                registry.put(instruction.getX(), registry.get(instruction.getX()) + instruction.getY());
                break;
            case "mul":
                registry.put(instruction.getX(), registry.get(instruction.getX()) * instruction.getY());
                break;
            case "mod":
                registry.put(instruction.getX(), registry.get(instruction.getX()) % instruction.getY());
                break;
            case "rcv":
                if (instruction.getRegistryX() != 0) {
                    recoveredSound = lastPlayedSound;
                    isRecovered = true;
                }
                break;
            case "jgz":
                if (instruction.getRegistryX() > 0) {
                    pointer += instruction.getY();
                    pointerChanged = true;
                }
                break;
            default:
                System.out.println("Dunno: " + instruction.getOperation());
        }
    }

    private void parseInput() {
        final String[] insts = ((String) input).split("\n");
        for (final String inst : insts) {
            final Instruction instruction = new Instruction(inst);
            if (!instruction.isConstant()) {
                registry.putIfAbsent(instruction.getX(), 0L);
            }
            instructions.add(instruction);
        }
    }

    private class Instruction {
        private String operation;
        private String stringRepresentation;
        private char x;
        private long valX;
        private char y;
        private long valY;
        private boolean isPointer = false;
        private boolean isConstant = false;

        Instruction(final String row) {
            stringRepresentation = row;
            final String[] data = row.split(" ");
            this.operation = data[0];
            switch (this.operation) {
                case "snd":
                case "rcv":
                    setupX(data[1]);
                    break;
                default:
                    setupX(data[1]);
                    if ((data[2].length() == 1 && !Character.isDigit(data[2].charAt(0)))) {
                        this.y = data[2].charAt(0);
                        this.isPointer = true;
                    } else {
                        this.valY = Integer.parseInt(data[2]);
                        this.isPointer = false;
                    }
            }
        }

        void setupX(final String data) {
            if (Character.isDigit(data.charAt(0))) {
                this.valX = Integer.parseInt(data);
                this.isConstant = true;
            } else {
                this.x = data.charAt(0);
            }
        }

        String getOperation() {
            return operation;
        }

        char getX() {
            return x;
        }

        Long getY() {
            return isPointer ? registry.get(y) : valY;
        }

        Long getRegistryX() {
            return isConstant ? valX : registry.get(x);
        }

        @Override
        public String toString() {
            return stringRepresentation + " is " + operation + " " + x + " " + (isPointer ? y : valY);
        }

        boolean isConstant() {
            return isConstant;
        }
    }
}
