package com.aoc.days2020.day07;

import java.util.HashMap;
import java.util.Map;

class Rule {

    private String bag;
    private Map<String, Integer> holdingRule = new HashMap<>();

    Rule(final String bag, final String rules) {
        this.bag = bag.substring(0, bag.length() - 1);
        if (!rules.equals("no other")) {
            final String[] parts = rules.split(", ");
            for (final String part : parts) {
                final int amount = Integer.parseInt(part.substring(0, part.indexOf(" ")));
                final String bagName = part.substring(part.indexOf(" ") + 1);
                this.holdingRule.put(bagName, amount);
            }
        }
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(this.bag);
        builder.append(" contain ");
        if (!this.holdingRule.isEmpty()) {
            boolean first = true;
            for (final Map.Entry<String, Integer> entry : holdingRule.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append(entry.getValue()).append(" ").append(entry.getKey());
            }
        } else {
            builder.append("no other bags");
        }
        return builder.toString();
    }

    boolean canContain(final String bagName) {
        return this.holdingRule.containsKey(bagName);
    }

    String getBag() {
        return bag;
    }

    Map<String, Integer> getHoldingRule() {
        return holdingRule;
    }
}
