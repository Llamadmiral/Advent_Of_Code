package com.aoc.days2019.day03;

import java.util.HashMap;
import java.util.Map;

class WireMap extends HashMap<Integer, Map<Integer, Integer>> {
    void addWire(int x, int y, int index) {
        Map<Integer, Integer> row = this.computeIfAbsent(x, k -> new HashMap<>());
        if (!row.containsKey(y)) {
            row.put(y, index);
        }
    }
}
