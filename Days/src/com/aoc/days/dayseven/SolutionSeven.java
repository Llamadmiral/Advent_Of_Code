package com.aoc.days.dayseven;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * I hate string formatting in Java, its so clunky :(.
 *
 * @author maczaka.
 */
class SolutionSeven extends SolutionBase {

    final Map<String, Program> NAMES = new HashMap<>();
    private Program headProgram;

    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        Program program = NAMES.entrySet().iterator().next().getValue();
        while (program.getParent() != null) {
            program = program.getParent();
        }
        headProgram = program;
        setSolutionOne(headProgram.getName());
    }

    @Override
    protected void solvePartTwo() {

    }

    private void parseWeightMap(final Program program) {

    }

    private Integer getWeightOfChildren(final Program program) {
        Integer allWeight = program.getWeight();
        for (final Map.Entry<Program, Integer> children : program.getChildren().entrySet()) {
            final Program childrenProgram = children.getKey();
            final Integer childrenWeight = getWeightOfChildren(childrenProgram);
            program.setChildrenWeight(childrenProgram, childrenWeight);
            allWeight += childrenWeight;
        }
        return allWeight;
    }

    private void parseInput() {
        final List<String> rows = (List<String>) input;
        for (final String row : rows) {
            final String[] datas = row.split(" ");
            final Program parentProgram = createProgram(datas[0]);
            parentProgram.setWeight(getWeight(datas[1]));
            if (datas.length > 2) {
                for (int i = 3; i < datas.length; i++) {
                    final Program childProgram = createProgram(splitComma(datas[i]));
                    childProgram.setParent(parentProgram);
                    parentProgram.addChildren(childProgram);
                }
            }
        }
    }

    private Program createProgram(final String name) {
        Program newProgram;
        if (NAMES.containsKey(name)) {
            newProgram = NAMES.get(name);
        } else {
            newProgram = new Program(name);
            NAMES.put(name, newProgram);
        }
        return newProgram;
    }


    private String splitComma(final String string) {
        String newString = string;
        if (string.contains(",")) {
            newString = newString.substring(0, newString.length() - 1);
        }
        return newString;
    }

    private Integer getWeight(final String string) {
        return Integer.parseInt(string.substring(1, string.length() - 1));
    }
}
