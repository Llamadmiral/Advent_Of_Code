package com.aoc.days2015.day12;

import java.util.HashSet;
import java.util.Set;

public class Block {

    private StringBuilder block = new StringBuilder();
    private Set<Block> children = new HashSet<>();

    public StringBuilder getBlock() {
        return block;
    }

    public Set<Block> getChildren() {
        return children;
    }

}
