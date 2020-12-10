package com.aoc.days2015.day23;

class Instruction {

    static final String HLF = "hlf";
    static final String TPL = "tpl";
    static final String INC = "inc";
    static final String JMP = "jmp";
    static final String JIE = "jie";
    static final String JIO = "jio";

    private String type;
    private char registryName;
    private int value;

    Instruction(final String type, final char registryName) {
        this.type = type;
        this.registryName = registryName;
    }

    Instruction(final String type, final char registryName, final int value) {
        this.type = type;
        this.registryName = registryName;
        this.value = value;
    }

    Character getRegistryName() {
        return this.registryName;
    }

    String getType() {
        return this.type;
    }

    int getValue() {
        return this.value;
    }
}
