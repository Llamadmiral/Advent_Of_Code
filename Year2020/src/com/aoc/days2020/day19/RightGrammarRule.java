package com.aoc.days2020.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightGrammarRule {

    private int id;
    private List<String> rightGrammarRules = new ArrayList<>();

    RightGrammarRule(final int id, final String rules) {
        this.id = id;
        rightGrammarRules.addAll(Arrays.asList(rules.split(" ")));
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public List<String> getRightGrammarRules() {
        return rightGrammarRules;
    }
}
