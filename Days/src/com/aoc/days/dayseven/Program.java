package com.aoc.days.dayseven;


import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka.
 */
class Program {
    private String name;
    private Program parent;
    private Map<Program, Integer> children = new HashMap<>();
    private Integer weight;

    Program(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Program getParent() {
        return parent;
    }

    void setParent(final Program parent) {
        this.parent = parent;
    }

    Integer getWeight() {
        return weight;
    }

    void setWeight(final Integer weight) {
        this.weight = weight;
    }

    Map<Program, Integer> getChildren() {
        return children;
    }

    void addChildren(final Program childrenProgram) {
        this.children.put(childrenProgram, 0);
    }

    void setChildrenWeight(final Program childrenProgram, final Integer allChildrenWeight) {
        this.children.put(childrenProgram, allChildrenWeight);
    }


}
