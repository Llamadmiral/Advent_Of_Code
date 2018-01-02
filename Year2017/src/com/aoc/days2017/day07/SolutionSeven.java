package com.aoc.days2017.day07;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * I hate string formatting in Java, its so clunky :(.
 *
 * @author maczaka.
 */
class SolutionSeven extends SolutionBase {
    private Map<String, Program> programMap = new HashMap<>();
    private Program randomProgram;
    private List<Program> unbalancedPrograms = new ArrayList<>();

    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        findHeadProgram();
        setSolutionOne(randomProgram.getName());
    }

    @Override
    protected void solvePartTwo() {
        filterUnbalancedPrograms();
        setLastProgramFromUnbalancedTowers();
        pickOddOneOut();
    }

    //A little cheat here, because my suspicion is that an unbalanced program will always have atleast 3 subtowers.
    private void pickOddOneOut() {
        final List<Program> childrenPrograms = randomProgram.getChildrenPrograms();
        int correctValue;
        final int possibleValueOne = childrenPrograms.get(0).getSubTowerWeight();
        final int possibleValueTwo = childrenPrograms.get(1).getSubTowerWeight();
        if (possibleValueOne == possibleValueTwo) {
            correctValue = possibleValueOne;
        } else {
            correctValue = childrenPrograms.get(2).getSubTowerWeight() == possibleValueOne ? possibleValueOne : possibleValueTwo;
        }
        for (final Program subPrograms : childrenPrograms) {
            final int subWeight = subPrograms.getSubTowerWeight();
            if (subWeight != correctValue) {
                setSolutionTwo(subPrograms.getOwnWeight() + (correctValue - subWeight));
                break;
            }
        }
    }

    private void setLastProgramFromUnbalancedTowers() {
        boolean found = false;
        for (final Program program : unbalancedPrograms) {
            for (final Program subProgram : unbalancedPrograms) {
                if (program != subProgram && !program.getChildrenPrograms().contains(subProgram)) {
                    randomProgram = program;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }

    private void filterUnbalancedPrograms() {
        for (final Map.Entry<String, Program> programEntry : programMap.entrySet()) {
            final Program program = programEntry.getValue();
            if (!isSubtowerEquals(program)) {
                unbalancedPrograms.add(program);
            }
        }
    }

    private boolean isSubtowerEquals(final Program program) {
        final List<Program> childrenPrograms = program.getChildrenPrograms();
        boolean equals = true;
        int subValue = -1;
        int i = 0;
        while (equals && i < childrenPrograms.size()) {
            if (subValue == -1) {
                subValue = childrenPrograms.get(i).getSubTowerWeight();
            } else {
                equals = childrenPrograms.get(i).getSubTowerWeight() == subValue;
            }
            i++;
        }
        return equals;
    }

    private void findHeadProgram() {
        while (randomProgram.getParentProgram() != null) {
            randomProgram = randomProgram.getParentProgram();
        }
    }

    private void parseInput() {
        final String[] rows = ((String) input).split("\n");
        for (final String row : rows) {
            final String[] data = row.split(" ");
            final Program program = getProgramFromMap(data[0]);
            program.setOwnWeight(data[1]);
            if (data.length > 2) {
                for (int i = 3; i < data.length; i++) {
                    final Program childrenProgram = getProgramFromMap(data[i]);
                    program.addToChildren(childrenProgram);
                }
            }
            randomProgram = program;
        }
    }

    private Program getProgramFromMap(final String name) {
        final String newName = name.contains(",") ? name.substring(0, name.length() - 1) : name;
        Program program = programMap.get(newName);
        if (program == null) {
            program = new Program(newName);
            programMap.put(newName, program);
        }
        return program;
    }

}
