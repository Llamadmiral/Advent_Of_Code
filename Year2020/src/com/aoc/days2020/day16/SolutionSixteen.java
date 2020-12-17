package com.aoc.days2020.day16;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionSixteen extends SolutionBase {

    private final List<Rule> rules = new ArrayList<>();
    private final List<int[]> nearbyTickets = new ArrayList<>();
    private final List<Rule> unsolvedRule = new ArrayList<>();
    private Map<String, Integer> solvedList = new HashMap<>();

    private int[] myTicket;

    SolutionSixteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        int index = 0;
        while (!rows[index].isEmpty()) {
            final Rule rule = new Rule(rows[index]);
            rules.add(rule);
            unsolvedRule.add(rule);
            index++;
        }
        index += 2;
        myTicket = SolutionHelper.inputToIntArray(rows[index], ",");
        index += 3;
        while (index < rows.length) {
            final int[] nums = SolutionHelper.inputToIntArray(rows[index], ",");
            nearbyTickets.add(nums);
            index++;
        }
    }

    @Override
    protected void solvePartOne() {
        final List<Integer> invalidNumbers = new ArrayList<>();
        for (Iterator<int[]> iterator = nearbyTickets.iterator(); iterator.hasNext(); ) {
            final int[] nearbyTicket = iterator.next();
            final Integer invalidNumber = getInvalidNumber(nearbyTicket);
            if (invalidNumber != null) {
                invalidNumbers.add(invalidNumber);
                iterator.remove();
            }
        }
        int sum = 0;
        for (final int value : invalidNumbers) {
            sum += value;
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        while (unsolvedRule.size() != solvedList.size()) {
            placeRule();
        }
    }

    private void placeRule() {
        for (final Rule rule : unsolvedRule) {
            if (!solvedList.containsKey(rule.getName())) {
                int counter = 0;
                int index = -1;
                for (int i = 0; i < myTicket.length; i++) {
                    if (!solvedList.containsValue(i)) {
                        final boolean fits = allFits(rule, i);
                        if (!fits) {
                            counter++;
                        } else {
                            index = i;
                        }
                    }
                }
                if (counter == unsolvedRule.size() - 1 - solvedList.size()) {
                    solvedList.put(rule.getName(), index);
                }
            }
        }
        long sum = 1;
        for (final String key : solvedList.keySet()) {
            if (key.startsWith("departure")) {
                sum *= myTicket[solvedList.get(key)];
            }
        }
        setSolutionTwo(sum);
    }

    private Integer getInvalidNumber(final int[] ticket) {
        Integer result = null;
        for (final int value : ticket) {
            boolean valid = false;
            for (final Rule rule : rules) {
                if (rule.valueIsValid(value)) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                result = value;
                break;
            }
        }
        return result;
    }

    private boolean allFits(final Rule rule, final int index) {
        boolean fits = false;
        for (final int[] ticket : nearbyTickets) {
            fits = rule.valueIsValid(ticket[index]);
            if (!fits) {
                break;
            }
        }
        return fits;
    }
}