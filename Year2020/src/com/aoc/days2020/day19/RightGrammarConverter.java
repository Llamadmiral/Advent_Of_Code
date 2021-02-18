package com.aoc.days2020.day19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RightGrammarConverter {

    private String input;
    private List<RightGrammarRule> rightGrammarRules = new ArrayList<>();
    private int maxId = 0;

    RightGrammarConverter(final String input) {
        this.input = input;
    }

    void convert() {
        for (final String row : input.split("\n")) {
            final String[] split = row.split(": ");
            final int id = Integer.parseInt(split[0]);
            for (final String ruleblock : split[1].split(" \\| ")) {
                this.rightGrammarRules.add(new RightGrammarRule(id, ruleblock));
            }
            if (id > maxId) {
                maxId = id;
            }
        }

        removeDuplications();
    }

    private void removeDuplications() {
        RightGrammarRule duplicate = getFirstDuplicate();
        while (duplicate != null) {
            replaceDuplicate(duplicate);
            duplicate = getFirstDuplicate();
        }
    }

    private void replaceDuplicate(final RightGrammarRule duplicate) {
        final int originalId = duplicate.getId();
        maxId = maxId + 1;
        duplicate.setId(maxId);

    }

    private RightGrammarRule getFirstDuplicate() {
        final Set<Integer> ids = new HashSet<>();
        RightGrammarRule duplicate = null;
        for (final RightGrammarRule rule : this.rightGrammarRules) {
            if (ids.contains(rule.getId())) {
                duplicate = rule;
                break;
            }
            ids.add(rule.getId());
        }
        return duplicate;
    }

}
