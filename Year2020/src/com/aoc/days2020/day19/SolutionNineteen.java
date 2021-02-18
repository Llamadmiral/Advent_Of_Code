package com.aoc.days2020.day19;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionNineteen extends SolutionBase {

    private final Map<Integer, Rule> rules = new HashMap<>();
    private List<String> rawRules = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    SolutionNineteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] inputParts = input.replace("\"", "").split("\n\n");
        rawRules.addAll(Arrays.asList(inputParts[0].split("\n")));
        messages.addAll(Arrays.asList(inputParts[1].split("\n")));

        rawRules.sort(Comparator.comparing(s -> Integer.valueOf(s.split(":")[0])));

        for (int i = 0; i < rawRules.size(); i++) {
            rules.put(i, new Rule(i));
        }

        for (final String rawRule : rawRules) {
            final Integer id = Integer.valueOf(rawRule.split(": ")[0]);
            final Rule ruleToModify = rules.get(id);
            final String rules = rawRule.split(": ")[1];
            if ("ab".contains(rules)) {
                ruleToModify.setValue(rules);
            } else {
                if (rules.contains("|")) {
                    final String[] parts = rules.split(" \\| ");
                    final String[] firstRules = parts[0].split(" ");
                    final String[] secondRules = parts[1].split(" ");
                    initiateRule(ruleToModify, firstRules);
                    initiateRule(ruleToModify, secondRules);
                } else {
                    initiateRule(ruleToModify, rules.split(" "));
                }
            }
        }
    }

    private void initiateRule(final Rule rule, final String[] ids) {
        final Rule[] rulesToAdd = new Rule[ids.length];
        for (int i = 0; i < ids.length; i++) {
            final String id = ids[i];
            rulesToAdd[i] = rules.get(Integer.parseInt(id));
        }
        rule.addRules(rulesToAdd);
    }

    private void flattenRules() {
        removeMultipleRoutes();
    }

    private void removeMultipleRoutes() {
        boolean same = false;
        while (!same) {
            same = true;
            for (final Rule rule : rules.values()) {
                if (rule.getRules().size() > 1) {
                    for (int i = 1; i < rule.getRules().size(); i++) {
                        createNewRuleAndReplaceOlds(rule.getRules().get(i));
                    }
                }
            }
        }
    }

    private void createNewRuleAndReplaceOlds(final Rule[] ruleblock) {
        final int newId = rules.size();
        rules.put(newId, new Rule(newId, ruleblock));
        for (final Rule rule : rules.values()) {

        }
    }

    @Override
    protected void solvePartOne() {
        while (!rules.get(0).getResolved()) {
            for (final Rule rule : rules.values()) {
                rule.resolve(messages);
            }
        }
        final Rule rule = rules.get(0);
        int count = 0;
        for (final String value : rule.getValues()) {
            final int i = messages.indexOf(value);
            if (i > -1) {
                count++;
                messages.remove(i);
            }
        }
        /*for (final String message : messages) {
            for (final String value : rule.getValues()) {
                if (value.equals(message)) {
                    count++;
                    break;
                }
            }
        }*/
        System.out.println(rule.getValues().size());
        setSolutionOne(count);
    }

    @Override
    protected void solvePartTwo() {
        //not yet solved
    }
}