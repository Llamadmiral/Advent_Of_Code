package com.aoc.days.dayseven;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * I hate string formatting in Java, its so clunky :(.
 *
 * @author maczaka.
 */
class SolutionSeven extends SolutionBase {

    final Map<String, Program> names = new HashMap<>();
    private Program headProgram;

    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        Program program = names.entrySet().iterator().next().getValue();
        while (program.getParent() != null) {
            program = program.getParent();
        }
        headProgram = program;
        setSolutionOne(headProgram.getName());
    }

    @Override
    protected void solvePartTwo() {
        buildWeightMap(headProgram);
        parseWeightMap(headProgram);
    }

    private void parseWeightMap(final Program parentProgram) {
        Program faultyLine = null;
        if (!parentProgram.getChildren().isEmpty()) {
            final Integer correctValue = parentProgram.getChildrenWeight() / parentProgram.getChildren().size();
            faultyLine = findOddOne(parentProgram.getChildren(), correctValue);
        } else {
            setSolutionTwo(parentProgram.getWeight());
        }
        if (faultyLine != null) {
            parseWeightMap(faultyLine);
        } else {
            setSolutionTwo(parentProgram.getWeight());
        }
    }

    private Program findOddOne(final Map<Program, Integer> programIntegerMap, final Integer value) {
        Program oddOne = null;
        if (!programIntegerMap.isEmpty()) {
            switch (programIntegerMap.size()) {
                case 0:
                    break;
                case 1:
                    oddOne = programIntegerMap.keySet().iterator().next();
                    break;
                case 2:
                    final Iterator<Program> programIterator = programIntegerMap.keySet().iterator();
                    final Program programOne = programIterator.next();
                    final Program programTwo = programIterator.next();
                    final Integer minValueOne = value - programOne.getChildrenWeight();
                    final Integer minValueTwo = value - programTwo.getChildrenWeight();
                    oddOne = minValueOne > minValueTwo ? programTwo : programOne;
                    break;
                default:
                    findOddOneFromGroup(programIntegerMap);
                    break;
            }
        }
        return oddOne;
    }

    private Program findOddOneFromGroup(final Map<Program, Integer> programIntegerMap) {
        Program oddOne = null;
        final Map<Integer, Integer> countMap = new HashMap<>();
        Integer correctValue = null;
        for (final Map.Entry<Program, Integer> programIntegerEntry : programIntegerMap.entrySet()) {
            final Program program = programIntegerEntry.getKey();
            final Integer childrenWeight = program.getChildrenWeight();
            if (countMap.containsKey(childrenWeight)) {
                if (countMap.get(childrenWeight) > 1) {
                    correctValue = childrenWeight;
                } else {
                    countMap.put(childrenWeight, countMap.get(childrenWeight) + 1);
                }
            } else {
                countMap.put(childrenWeight, 1);
            }
        }
        final Integer fuckYouStream = correctValue;
        final Optional<Map.Entry<Program, Integer>> program = programIntegerMap
            .entrySet()
            .stream()
            .filter(programIntegerEntry -> !programIntegerEntry.getKey().getChildrenWeight().equals(fuckYouStream))
            .findFirst();
        if (program.isPresent()) {
            oddOne = program.get().getKey();
        }
        return oddOne;
    }

    private Integer buildWeightMap(final Program program) {
        Integer allWeight = program.getWeight();
        for (final Map.Entry<Program, Integer> children : program.getChildren().entrySet()) {
            final Program childrenProgram = children.getKey();
            final Integer childrenWeight = buildWeightMap(childrenProgram);
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
        if (names.containsKey(name)) {
            newProgram = names.get(name);
        } else {
            newProgram = new Program(name);
            names.put(name, newProgram);
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
