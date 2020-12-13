package com.aoc.days2020.day08;

class Instruction {
    private String type;
    private int offset;

    Instruction(final String type, final int offset) {
        this.type = type;
        this.offset = offset;
    }

    String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    int getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return
            this.type + " " + this.offset;
    }
}
