package com.aoc.years.year2017.days.dayeighteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka
 */
class Program {
    private List<Instruction> instructions = new ArrayList<>();
    private List<Long> queue = new ArrayList<>();
    private Map<Character, Long> registry = new HashMap<>();
    private int pointer = 0;
    private long messagesSent = 0L;
    private boolean waitingForInput = false;
    private boolean isPartTwo = false;
    private boolean programTerminated;
    private Program sibling;

    Program(final String input, final int id) {
        final String[] insts = input.split("\n");
        for (final String inst : insts) {
            final Program.Instruction instruction = new Instruction(inst);
            if (!instruction.isConstant()) {
                char x = instruction.getX();
                registry.putIfAbsent(x, x == 'p' ? id : 0L);
            }
            instructions.add(instruction);
        }
    }

    void setPartTwo(boolean partTwo) {
        isPartTwo = partTwo;
    }

    void update() {
        if (waitingForInput && !queue.isEmpty()) {
            waitingForInput = false;
        }
        while (!waitingForInput) {
            if (pointer < 0 || pointer > instructions.size()) {
                programTerminated = true;
            } else {
                processInstruction(instructions.get(pointer));
            }
        }
    }

    public void solvePartOne() {
        final int size = instructions.size();
        while (pointer > -1 && pointer < size && !programTerminated) {
            processInstruction(instructions.get(pointer));
        }
    }

    private void processInstruction(final Instruction instruction) {
        switch (instruction.getOperation()) {
            case "snd":
                if (!isPartTwo) {
                    messagesSent = registry.get(instruction.getX());
                } else {
                    messagesSent++;
                    sibling.queue.add(instruction.getRegistryX());
                }
                pointer++;
                break;
            case "set":
                registry.put(instruction.getX(), instruction.getY());
                pointer++;
                break;
            case "add":
                registry.put(instruction.getX(), registry.get(instruction.getX()) + instruction.getY());
                pointer++;
                break;
            case "mul":
                registry.put(instruction.getX(), registry.get(instruction.getX()) * instruction.getY());
                pointer++;
                break;
            case "mod":
                registry.put(instruction.getX(), registry.get(instruction.getX()) % instruction.getY());
                pointer++;
                break;
            case "rcv":
                if (!isPartTwo && instruction.getRegistryX() != 0) {
                    programTerminated = true;
                } else {
                    if (queue.isEmpty()) {
                        waitingForInput = true;
                    } else {
                        waitingForInput = false;
                        registry.put(instruction.getX(), queue.remove(0));
                        pointer++;
                    }
                }
                break;
            case "jgz":
                if (instruction.getRegistryX() > 0) {
                    pointer += instruction.getY();
                } else {
                    pointer++;
                }
                break;
            default:
                break;
        }
    }

    boolean isWaitingForInput() {
        return queue.isEmpty();
    }

    boolean inDeadlockOrTerminated() {
        return (queue.isEmpty()
                && waitingForInput
                && sibling.queue.isEmpty()
                && sibling.waitingForInput) || (programTerminated || sibling.programTerminated);
    }

    long getMessagesSent() {
        return messagesSent;
    }

    void setSibling(Program sibling) {
        this.sibling = sibling;
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
