package com.aoc.days2020.day06;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionSix extends SolutionBase {

    private List<String[]> groups = new ArrayList<>();

    SolutionSix(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("\n\n", "\t").replaceAll("\n", " ").replaceAll("\t", "\n");
        final String[] rows = input.split("\n");
        for (final String row : rows) {
            final String[] group = row.split(" ");
            this.groups.add(group);
        }
    }

    @Override
    protected void solvePartOne() {
        int sum = 0;
        for (final String[] group : groups) {
            final Set<Character> uniqueAnswers = new HashSet<>();
            for (final String person : group) {
                for (int i = 0; i < person.length(); i++) {
                    uniqueAnswers.add(person.charAt(i));
                }
            }
            sum += uniqueAnswers.size();
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        int count = 0;
        for (final String[] group : groups) {
            for (int i = 0; i < group[0].length(); i++) {
                final char question = group[0].charAt(i);
                boolean questionAsnweredByAll = true;
                for (int j = 1; j < group.length; j++) {
                    if (group[j].indexOf(question) == -1) {
                        questionAsnweredByAll = false;
                    }
                }
                if (questionAsnweredByAll) {
                    count++;
                }
            }
        }
        setSolutionTwo(count);
    }

    private int countCharacters(final String group, final char c) {
        int count = 0;
        for (int i = 0; i < group.length(); i++) {
            if (group.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}