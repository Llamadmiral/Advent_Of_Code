package com.aoc.days2018.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
public class Node {
    private static final char[] ABC = "ABCDEFGHIJKLM".toCharArray();
    private static int count = 0;
    private int[] entries;
    private List<Node> children = new ArrayList<>();
    private int numberOfEntires;
    private int numberOfChilds;
    //to be removed
    private int id;

    public Node() {
        id = count;
        count++;
    }

    public static int getSumOfArray(int[] entires) {
        int sum = 0;
        for (int entire : entires) {
            sum += entire;
        }
        return sum;
    }

    public int[] getEntries() {
        return entries;
    }

    public void setEntries(final int[] entries) {
        this.entries = entries;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(final Node node) {
        this.children.add(node);
    }

    public int getNumberOfEntires() {
        return numberOfEntires;
    }

    public void setNumberOfEntires(final int numberOfEntires) {
        this.numberOfEntires = numberOfEntires;
    }

    public int getNumberOfChilds() {
        return numberOfChilds;
    }

    public void setNumberOfChilds(final int numberOfChilds) {
        this.numberOfChilds = numberOfChilds;
    }

    public int getSumOfAllEntries() {
        int sum = getSumOfArray(this.getEntries());
        for (final Node node : children) {
            sum += node.getSumOfAllEntries();
        }
        return sum;
    }

    public int getValue() {
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
