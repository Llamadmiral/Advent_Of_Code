package com.aoc.days.day07;


import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
class Program {
    private String name;
    private int ownWeight;
    private List<Program> childrenPrograms = new ArrayList<>();
    private Program parentProgram;
    private int childrenWeight = -1;

    Program(final String name) {
        this.name = name;
    }

    int getSubTowerWeight() {
        if (childrenWeight == -1) {
            childrenWeight = ownWeight;
            for (final Program childrenProgram : childrenPrograms) {
                childrenWeight += childrenProgram.getSubTowerWeight();
            }
        }
        return childrenWeight;
    }

    void addToChildren(final Program program) {
        program.setParentProgram(this);
        this.childrenPrograms.add(program);
    }

    Program getParentProgram() {
        return parentProgram;
    }

    void setParentProgram(final Program parentProgram) {
        this.parentProgram = parentProgram;
    }

    String getName() {
        return name;
    }

    List<Program> getChildrenPrograms() {
        return childrenPrograms;
    }

    @Override
    public String toString() {
        return name + ":" + childrenPrograms.size();
    }

    public int getOwnWeight() {
        return ownWeight;
    }

    void setOwnWeight(final String weight) {
        this.ownWeight = Integer.parseInt(weight.substring(1, weight.length() - 1));
    }
}
