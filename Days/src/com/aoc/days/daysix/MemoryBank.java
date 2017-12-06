package com.aoc.days.daysix;

/**
 * @author maczaka.
 */
class MemoryBank {
    private int memory;
    private MemoryBank nextBank;

    MemoryBank(final int memory) {
        this.memory = memory;
    }


    int getMemory() {

        return memory;
    }

    void setMemory(final int memory) {
        this.memory = memory;
    }

    MemoryBank getNextBank() {
        return nextBank;
    }

    void setNextBank(final MemoryBank nextBank) {
        this.nextBank = nextBank;
    }

    void incrementMemory() {
        this.memory++;
    }
}
