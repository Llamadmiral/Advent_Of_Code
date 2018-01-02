package com.aoc.years.year2017.days.daytwelve;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashSet;
import java.util.Set;

/**
 * This solution is not optimal, because it makes the assumption that in a n-sized list
 * the program ids are going from 0 to n.
 *
 * @author maczaka
 */
class SolutionTwelve extends SolutionBase {

    private Set<Set<Integer>> groups = new HashSet<>();

    SolutionTwelve(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        setSolutionOne(getGroupWithId(0).size());
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(groups.size());
    }

    private void parseInput() {
        final String[] rows = ((String) input).split("\n");
        initSet(rows.length);
        for (final String row : rows) {
            final String[] datas = row.split(" ");
            final Integer parentId = Integer.parseInt(datas[0]);
            for (int i = 2; i < datas.length; i++) {
                Integer id;
                if (datas[i].contains(",")) {
                    id = Integer.parseInt(datas[i].substring(0, datas[i].length() - 1));
                } else {
                    id = Integer.parseInt(datas[i]);
                }
                putIntoGroup(parentId, id);
            }
        }
    }

    private void putIntoGroup(final Integer parentId, final Integer childrenId) {
        final Set<Integer> parentGroup = getGroupWithId(parentId);
        final Set<Integer> childrenGroup = getGroupWithId(childrenId);
        joinGroups(parentGroup, childrenGroup);
    }

    private void joinGroups(final Set<Integer> first, final Set<Integer> second) {
        groups.remove(first);
        groups.remove(second);
        first.addAll(second);
        groups.add(first);
    }

    private void initSet(final Integer length) {
        for (int i = 0; i < length; i++) {
            final Set<Integer> ids = new HashSet<>();
            ids.add(i);
            groups.add(ids);
        }
    }

    private Set<Integer> getGroupWithId(final Integer id) {
        Set<Integer> group = new HashSet<>();
        for (final Set<Integer> integers : groups) {
            if (integers.contains(id)) {
                group = integers;
            }
        }
        return group;
    }

}
