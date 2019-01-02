package com.aoc.days2018.day19;

/**
 * @author maczaka.
 */
class Program {
    private String type;
    private int[] instruction;

    Program(final String[] data) {
        this.instruction = new int[]{
            Integer.parseInt(data[1]),
            Integer.parseInt(data[2]),
            Integer.parseInt(data[3])
        };
        this.type = data[0];
    }

    String getType() {
        return type;
    }

    int[] getInstruction() {
        return instruction;
    }
}
