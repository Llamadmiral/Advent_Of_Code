package com.aoc.days2015.day07;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionSeven extends SolutionBase {
    private static final String NOT = "NOT";
    private static final String OR = "OR";
    private static final String AND = "AND";
    private static final String LSHIFT = "LSHIFT";
    private static final String RSHIFT = "RSHIFT";
    private static final String COPY = "COPY";

    private final Map<String, Signal> wires = new HashMap<>();
    private final Set<Instruction> instructions = new HashSet<>();

    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    public void init() {
        for (final String row : input.split("\n")) {
            final String[] parts = row.split(" -> ");
            final String[] instructionParts = parts[0].split(" ");
            final String target = parts[1];
            final Instruction instruction = new Instruction();
            instruction.setTarget(target);
            if (instructionParts.length == 1) {
                instruction.setType(COPY);
                if (isDigit(instructionParts[0])) {
                    instruction.setSignalOne(new Signal(Integer.valueOf(instructionParts[0])));
                } else {
                    instruction.setSourceOne(instructionParts[0]);
                }
            } else if (instructionParts[0].equals(NOT)) {
                instruction.setType(NOT);
                if (isDigit(instructionParts[1])) {
                    instruction.setSignalOne(new Signal(Integer.valueOf(instructionParts[0])));
                } else {
                    instruction.setSourceOne(instructionParts[1]);
                }
            } else {
                if (isDigit(instructionParts[0])) {
                    instruction.setSignalOne(new Signal(Integer.valueOf(instructionParts[0])));
                } else {
                    instruction.setSourceOne(instructionParts[0]);
                }
                instruction.setType(instructionParts[1]);
                final String command = instructionParts[1];
                if (command.equals(LSHIFT) || command.equals(RSHIFT)) {
                    instruction.setShiftValue(Integer.valueOf(instructionParts[2]));
                } else {
                    if (isDigit(instructionParts[2])) {
                        instruction.setSignaltwo(new Signal(Integer.valueOf(instructionParts[2])));
                    } else {
                        instruction.setSourceTwo(instructionParts[2]);
                    }
                }
            }
            instructions.add(instruction);
        }
    }

    @Override
    protected void solvePartOne() {
        doInstructions();
        setSolutionOne(wires.get("a"));
    }

    @Override
    protected void solvePartTwo() {
        final Signal a = wires.get("a");
        wires.clear();
        wires.put("b", a);
        for (final Instruction instruction : instructions) {
            if (!instruction.getTarget().equals("b")) {
                instruction.setDone(false);
            }
        }
        doInstructions();
        setSolutionTwo(wires.get("a"));
    }

    private void doInstructions() {
        boolean hasMore = true;
        while (hasMore) {
            hasMore = false;
            for (final Instruction instruction : instructions) {
                if (!instruction.getDone()) {
                    hasMore = true;
                    final String type = instruction.getType();
                    if (NOT.equals(type)) {
                        final Signal signal = instruction.getSignalOne(wires);
                        if (signal != null) {
                            wires.put(instruction.getTarget(), signal.not());
                            instruction.setDone(true);
                        }
                    } else if (OR.equals(type)) {
                        final Signal a = instruction.getSignalOne(wires);
                        if (a != null) {
                            final Signal b = instruction.getSignaltwo(wires);
                            if (b != null) {
                                wires.put(instruction.getTarget(), a.or(b));
                                instruction.setDone(true);
                            }
                        }
                    } else if (AND.equals(type)) {
                        final Signal a = instruction.getSignalOne(wires);
                        if (a != null) {
                            final Signal b = instruction.getSignaltwo(wires);
                            if (b != null) {
                                wires.put(instruction.getTarget(), a.and(b));
                                instruction.setDone(true);
                            }
                        }
                    } else if (LSHIFT.equals(type)) {
                        final Signal a = instruction.getSignalOne(wires);
                        if (a != null) {
                            wires.put(instruction.getTarget(), a.leftShift(instruction.getShiftValue()));
                            instruction.setDone(true);
                        }
                    } else if (RSHIFT.equals(type)) {
                        final Signal a = instruction.getSignalOne(wires);
                        if (a != null) {
                            wires.put(instruction.getTarget(), a.rightShift(instruction.getShiftValue()));
                            instruction.setDone(true);
                        }
                    } else if (COPY.equals(type)) {
                        final Signal a = instruction.getSignalOne(wires);
                        if (a != null) {
                            wires.put(instruction.getTarget(), a);
                            instruction.setDone(true);
                        }
                    }
                }
            }
        }
    }

    private boolean isDigit(final String s) {
        boolean digit = true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                digit = false;
            }
        }
        return digit;
    }

}