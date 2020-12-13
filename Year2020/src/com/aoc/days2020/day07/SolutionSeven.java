package com.aoc.days2020.day07;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionSeven extends SolutionBase {

    private static final String BAG_TO_LOOK_FOR = "shiny gold";

    private List<Rule> rules = new ArrayList<>();
    private Map<String, Integer> bagContainment = new HashMap<>();


    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("\\.", "").replaceAll(" bags", "").replaceAll(" bag", "");
        for (final String row : input.split("\n")) {
            final String[] parts = row.split("contain ");
            rules.add(new Rule(parts[0], parts[1]));
        }
    }

    @Override
    protected void solvePartOne() {
        final Set<String> uniqueBags = getAllowedBags(BAG_TO_LOOK_FOR, new HashSet<>());
        int previousSize = 0;
        int currentSize = uniqueBags.size();
        while (previousSize != currentSize) {
            previousSize = currentSize;
            final Set<String> bags = new HashSet<>();
            for (final String bag : uniqueBags) {
                bags.addAll(getAllowedBags(bag, uniqueBags));
            }
            uniqueBags.addAll(bags);
            currentSize = uniqueBags.size();
        }
        setSolutionOne(uniqueBags.size());
    }

    @Override
    protected void solvePartTwo() {
        initBagContainment();
        while (bagContainment.size() != rules.size()) {
            for (final Rule rule : rules) {
                if (!bagContainment.containsKey(rule.getBag())) {
                    final Map<String, Integer> holdingRule = rule.getHoldingRule();
                    boolean allIsFound = true;
                    int count = 0;
                    for (final String bag : holdingRule.keySet()) {
                        if (!bagContainment.containsKey(bag)) {
                            allIsFound = false;
                            break;
                        } else {
                            count += (bagContainment.get(bag) * holdingRule.get(bag)) + holdingRule.get(bag);
                        }
                    }
                    if (allIsFound) {
                        bagContainment.put(rule.getBag(), count);
                    }
                }
            }
        }
        setSolutionTwo(bagContainment.get(BAG_TO_LOOK_FOR));
    }

    private Set<String> getAllowedBags(final String bagName, final Set<String> uniqueBags) {
        final Set<String> bags = new HashSet<>();
        for (final Rule rule : rules) {
            if (!uniqueBags.contains(rule.getBag()) && rule.canContain(bagName)) {
                bags.add(rule.getBag());
            }
        }
        return bags;
    }

    private void initBagContainment() {
        for (final Rule rule : rules) {
            if (rule.getHoldingRule().isEmpty()) {
                bagContainment.put(rule.getBag(), 0);
            }
        }
    }
}