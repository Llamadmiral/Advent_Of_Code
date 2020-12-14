package com.aoc.days2020.day10;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTen extends SolutionBase {

    private int maximumAdapter;
    private int[] differences = new int[3];
    private List<Integer> adapters = new ArrayList<>();
    private List<Integer> longestChain = new ArrayList<>();

    SolutionTen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        adapters.add(0);
        final int[] ints = SolutionHelper.inputToIntArray(input, "\n");
        for (final int i : ints) {
            if (i > maximumAdapter) {
                maximumAdapter = i;
            }
            adapters.add(i);
        }
        maximumAdapter = maximumAdapter + 3;
        adapters.add(maximumAdapter);
        Collections.sort(adapters);
        longestChain.addAll(adapters);
    }

    @Override
    protected void solvePartOne() {
        int currentAdapter = getClosestAdapter(adapters, 0);
        while (currentAdapter != 0) {
            currentAdapter = getClosestAdapter(adapters, currentAdapter);
        }
        setSolutionOne(differences[0] * differences[2]);
    }

    @Override
    protected void solvePartTwo() {
        final List<List<Integer>> subLists = new ArrayList<>();
        for (int i = 0; i < longestChain.size(); i++) {
            final List<Integer> sublist = getSublist(i, longestChain);
            i += sublist.size() - 1;
            subLists.add(sublist);
        }
        long count = 1;
        for (final List<Integer> subList : subLists) {
            final long possibleArrangments = countDifferentAdapters(subList, subList.get(0), 0);
            count *= possibleArrangments;
        }
        setSolutionTwo(count);
    }

    private int getClosestAdapter(final List<Integer> adapterList, final int currentAdapter) {
        int index = adapterList.indexOf(currentAdapter);
        int closestAdapter = 0;
        if (index != adapterList.size() - 1) {
            closestAdapter = adapterList.get(index + 1);
            differences[closestAdapter - currentAdapter - 1]++;
        }
        return closestAdapter;
    }

    private int getUpperClosestAdapters(final List<Integer> adapterList, final int index) {
        int size = 0;
        if (index >= 0 && index < adapterList.size()) {
            final int currentAdapter = adapterList.get(index);
            for (int i = index + 1; i < Integer.min(index + 4, adapterList.size()); i++) {
                final int adapter = adapterList.get(i);
                if (adapter <= currentAdapter + 3) {
                    size++;
                }
            }
        }
        return size;
    }

    private int getLowerClosestAdapters(final List<Integer> adapterList, final int index) {
        int size = 0;
        if (index >= 0 && index < adapterList.size()) {
            final int currentAdapter = adapterList.get(index);
            for (int i = index - 1; i >= Integer.max(index - 3, 0); i--) {
                final int adapter = adapterList.get(i);
                if (adapter + 3 >= currentAdapter) {
                    size++;
                }
            }
        }
        return size;
    }

    private int countDifferentAdapters(final List<Integer> adapterList, final int currentAdapter, final int currentCount) {
        int index = adapterList.indexOf(currentAdapter);
        boolean added = false;
        int count = 0;
        for (int i = index + 1; i < Integer.min(index + 4, adapterList.size()); i++) {
            final int adapter = adapterList.get(i);
            if (adapter <= currentAdapter + 3) {
                count += countDifferentAdapters(adapterList, adapter, currentCount + 1);
                added = true;
            }
        }
        if (!added) {
            count++;
        }
        return count;
    }

    private List<Integer> getSublist(final int startIndex, final List<Integer> adapterList) {
        final List<Integer> sublist = new ArrayList<>();
        for (int i = startIndex; i < adapterList.size(); i++) {
            final Integer adapter = adapterList.get(i);
            final int upper = getUpperClosestAdapters(adapterList, i);
            final int lower = getLowerClosestAdapters(adapterList, i + 1);
            if (upper == 1 && lower == 1) {
                sublist.add(adapter);
                break;
            } else {
                sublist.add(adapter);
            }
        }
        return sublist;
    }


}