package com.aoc.days.daytwentythree;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka
 */
class SolutionTwentyThree extends SolutionBase {

    private static final Map<Character, Long> REGISTRY = new HashMap<>();
    private final List<Operation> operations = new ArrayList<>();
    private int pointer;
    private int mulCalled = 0;

    SolutionTwentyThree(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        initRegister();
        initOperations();
        doOperations();
        setSolutionOne(mulCalled);
    }

    @Override
    protected void solvePartTwo() {
        initRegister();
        REGISTRY.put('a', 1L);
        doOperations();
        setSolutionTwo(REGISTRY.get('h'));
    }

    private void doOperations() {
        pointer = 0;
        final int size = operations.size();
        while (pointer < size) {
            doOperation(operations.get(pointer));
        }
    }

    private void initOperations() {
        final String[] rows = ((String) input).split("\n");
        for (final String row : rows) {
            operations.add(new Operation(row));
        }
    }

    private void doOperation(final Operation operation) {
        switch (operation.type) {
            case "set":
                REGISTRY.put(operation.x, getY(operation));
                pointer++;
                break;
            case "sub":
                REGISTRY.put(operation.x, REGISTRY.get(operation.x) - getY(operation));
                pointer++;
                break;
            case "mul":
                REGISTRY.put(operation.x, REGISTRY.get(operation.x) * getY(operation));
                pointer++;
                mulCalled++;
                break;
            case "jnz":
                if (getX(operation) != 0L) {
                    pointer += getY(operation);
                } else {
                    pointer++;
                }
                break;
        }
    }

    private void initRegister() {
        final String registerNames = "abcdefgh";
        for (int i = 0; i < registerNames.length(); i++) {
            REGISTRY.put(registerNames.charAt(i), 0L);
        }
    }


    private long getX(final Operation operation) {
        final long valueX;
        if (operation.xIsDigit) {
            valueX = operation.valX;
        } else {
            valueX = REGISTRY.get(operation.x);
        }
        return valueX;
    }

    private long getY(final Operation operation) {
        final long valueY;
        if (operation.yIsDigit) {
            valueY = operation.valY;
        } else {
            valueY = REGISTRY.get(operation.y);
        }
        return valueY;
    }

    private class Operation {
        private String type;
        private int valX;
        private char x;
        private boolean xIsDigit = false;
        private int valY;
        private char y;
        private boolean yIsDigit = false;

        Operation(final String input) {
            final String[] data = input.split(" ");
            type = data[0];
            if (Character.isAlphabetic(data[1].charAt(0))) {
                x = data[1].charAt(0);
            } else {
                valX = Integer.parseInt(data[1]);
                xIsDigit = true;
            }
            if (Character.isAlphabetic(data[2].charAt(0))) {
                y = data[2].charAt(0);
            } else {
                valY = Integer.parseInt(data[2]);
                yIsDigit = true;
            }
        }
    }

}
