package com.aoc.days.day23;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maczaka
 */
class SolutionTwentyThree extends SolutionBase {

    private final Map<Character, Long> registry = new HashMap<>();
    private final List<Operation> operations = new ArrayList<>();
    private int pointer;
    private int mulCalled = 0;
    private boolean partTwo = false;

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
        registry.put('a', 1L);
        partTwo = true;
        doOperations();
        setSolutionTwo(registry.get('h'));
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
                registry.put(operation.x, getY(operation));
                pointer++;
                break;
            case "sub":
                registry.put(operation.x, registry.get(operation.x) - getY(operation));
                pointer++;
                break;
            case "mul":
                registry.put(operation.x, registry.get(operation.x) * getY(operation));
                pointer++;
                mulCalled++;
                break;
            case "jnz":
                if (getX(operation) != 0L) {
                    final long yValue = getY(operation);
                    if (!partTwo) {
                        pointer += getY(operation);
                    } else {
                        if (yValue == -8L) {
                            jnzMinusEight();
                        } else if (yValue == -13L) {
                            jnzMinusThirteen();
                        } else {
                            pointer += getY(operation);
                        }
                    }
                } else {
                    pointer++;
                }
                break;
            default:
                break;
        }
    }

    private void jnzMinusEight() {
        final long b = registry.get('b');
        final long d = registry.get('d');
        for (long e = 2; e < b; e++) {
            if (d * e == b) {
                registry.put('f', 0L);
                break;
            }
        }
        registry.put('e', registry.get('b'));
        registry.put('g', 0L);
        pointer++;
    }

    private void jnzMinusThirteen() {
        setF();
        registry.put('e', registry.get('b'));
        registry.put('g', 0L);
        registry.put('d', registry.get('b'));
        pointer++;
    }

    /**
     * While iterating through the jump -13 part, we are looking if
     * between d and (b / d) there is a value where d * e = b. (e = 2, e -> b) If there is such value, we set f to 0.
     */
    private void setF() {
        final long b = registry.get('b');
        for (long d = registry.get('d'); d < b / d; d++) {
            if (b % d == 0) {
                registry.put('f', 0L);
                break;
            }
        }
    }

    private void initRegister() {
        final String registerNames = "abcdefgh";
        for (int i = 0; i < registerNames.length(); i++) {
            registry.put(registerNames.charAt(i), 0L);
        }
    }


    private long getX(final Operation operation) {
        final long valueX;
        if (operation.xIsDigit) {
            valueX = operation.valX;
        } else {
            valueX = registry.get(operation.x);
        }
        return valueX;
    }

    private long getY(final Operation operation) {
        final long valueY;
        if (operation.yIsDigit) {
            valueY = operation.valY;
        } else {
            valueY = registry.get(operation.y);
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

        @Override
        public String toString() {
            return type + " " + (xIsDigit ? valX : Character.toString(x)) + " " + (yIsDigit ? valY : Character.toString(y));
        }
    }

}
