package com.aoc.days2018.day04;

import com.aoc.solutionbase.SolutionBase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Llamadmiral.
 */
class SolutionFour extends SolutionBase {

    private static final Comparator<Entry> ENTRY_COMPARATOR = (o1, o2) -> {
        int result = Integer.compare(o1.getMonth(), o2.getMonth());
        if (result == 0) {
            result = Integer.compare(o1.getDay(), o2.getDay());
        }
        if (result == 0) {
            result = Integer.compare(o1.getHour(), o2.getHour());
        }
        if (result == 0) {
            result = Integer.compare(o1.getMinute(), o2.getMinute());
        }
        return result;
    };

    private Map<Integer, int[]> sleepSchedules = new HashMap<>();


    private Set<Entry> entries = new TreeSet<>(ENTRY_COMPARATOR);

    SolutionFour(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        searchForSleepiest();
    }

    @Override
    protected void solvePartTwo() {
        int guardId = -1;
        int maxTime = -1;
        int minute = -1;
        for (final Map.Entry<Integer, int[]> entry : sleepSchedules.entrySet()) {
            int[] value = entry.getValue();
            for (int i = 0; i < value.length; i++) {
                int sleepTime = value[i];
                if (sleepTime > maxTime) {
                    maxTime = sleepTime;
                    minute = i;
                    guardId = entry.getKey();
                }
            }
        }
        setSolutionTwo(guardId * minute);
    }

    private void searchForSleepiest() {
        fillSleepSchedule();
        int sleepiestGuard = -1;
        int max = -1;
        for (final Map.Entry<Integer, int[]> entry : sleepSchedules.entrySet()) {
            int sum = sum(entry.getValue());
            if (sum > max) {
                sleepiestGuard = entry.getKey();
                max = sum;
            }
        }
        final int max1 = max(sleepSchedules.get(sleepiestGuard));
        setSolutionOne(sleepiestGuard * max1);
    }

    private int max(final int[] minutes) {
        int max = minutes[0];
        int maxi = 0;
        for (int i = 1; i < minutes.length; i++) {
            if (max < minutes[i]) {
                max = minutes[i];
                maxi = i;
            }
        }
        return maxi;
    }

    private int sum(final int[] minutes) {
        int sum = 0;
        for (final int minute : minutes) {
            sum += minute;
        }
        return sum;
    }

    private void fillSleepSchedule() {
        int currentGuard = -1;
        for (Iterator<Entry> iterator = entries.iterator(); iterator.hasNext(); ) {
            Entry entry = iterator.next();
            if (entry.getGuardId() != -1) {
                currentGuard = entry.getGuardId();
            } else if (entry.getEvent() == Entry.Event.FALLS_ASLEEP) {
                fillSleepSchedule(entry, iterator.next(), currentGuard);
            }
        }
    }

    private void fillSleepSchedule(final Entry start, final Entry end, final int currentGuard) {
        int[] sleepSchedule = sleepSchedules.get(currentGuard);
        if (sleepSchedule == null) {
            sleepSchedule = new int[64];
            sleepSchedules.put(currentGuard, sleepSchedule);
        }
        for (int i = start.getMinute(); i < end.getMinute(); i++) {
            sleepSchedule[i]++;
        }
    }

    private void prepareInput() {
        for (final String row : input.split("\n")) {
            final Entry entry = Entry.make(row);
            entries.add(entry);
        }
    }
}