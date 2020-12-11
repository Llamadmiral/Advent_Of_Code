package com.aoc.days2018.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
class Node {
    private static final char[] ABC = "ABCDEFGHIJKLM".toCharArray();
    private static int count = 0;
    private int[] entries;
    private List<Node> children = new ArrayList<>();
    private int numberOfEntires;
    private int numberOfChilds;
    //to be removed
    private int id;

    Node() {
        id = count;
        count++;
    }

    private static int getSumOfArray(int[] entires) {
        int sum = 0;
        for (int entire : entires) {
            sum += entire;
        }
        return sum;
    }

    private int[] getEntries() {
        return entries;
    }

    void setEntries(final int[] entries) {
        this.entries = entries;
    }

    void addChild(final Node node) {
        this.children.add(node);
    }

    private int getNumberOfEntires() {
        return numberOfEntires;
    }

    void setNumberOfEntires(final int numberOfEntires) {
        this.numberOfEntires = numberOfEntires;
    }

    private int getNumberOfChilds() {
        return numberOfChilds;
    }

    void setNumberOfChilds(final int numberOfChilds) {
        this.numberOfChilds = numberOfChilds;
    }

    int getSumOfAllEntries() {
        int sum = getSumOfArray(this.getEntries());
        for (final Node node : children) {
            sum += node.getSumOfAllEntries();
        }
        return sum;
    }

    int getValue() {
        int value = 0;
        if (this.getNumberOfChilds() == 0) {
            value = this.getSumOfAllEntries();
        } else {
            for (int i = 0; i < this.getNumberOfEntires(); i++) {
                if (this.getNumberOfChilds() > this.entries[i] - 1) {
                    value += children.get(entries[i] - 1).getValue();
                }
            }
        }
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(ABC[id]);
    }
}
