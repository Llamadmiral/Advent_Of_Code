package com.aoc.days2020.day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Rule {
    private List<Rule[]> rules = new ArrayList<>();
    private List<String> values = new ArrayList<>();
    private boolean resolved = false;
    private Integer id;

    Rule(final Integer id) {
        this.id = id;
    }

    Rule(final int id, final Rule[] ruleblock) {
        this.id = id;
        this.rules.add(ruleblock);
    }

    public void setValue(final String value) {
        this.values.add(value);
        this.resolved = true;
    }

    public boolean getResolved() {
        return resolved;
    }

    void addRules(final Rule[] rulesToAdd) {
        this.rules.add(rulesToAdd);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(this.id + ": ");
        if (this.resolved) {
            builder.append("\"").append(this.values.get(0)).append("\"");
        } else {
            boolean addedLine = false;
            for (final Rule[] ruleBlocks : this.rules) {
                boolean addedSapce = false;
                for (final Rule rule : ruleBlocks) {
                    builder.append(rule.id).append(" ");
                    if (!addedSapce) {
                        addedSapce = true;
                    }
                }
                if (this.rules.size() > 1 && !addedLine) {
                    builder.append("| ");
                    addedLine = true;
                }
            }
        }
        return builder.toString();
    }

    void resolve(final List<String> messages) {
        if (!this.resolved) {
            boolean allResolved = true;
            for (final Rule[] ruleBlock : this.rules) {
                for (final Rule rule : ruleBlock) {
                    if (!rule.getResolved()) {
                        allResolved = false;
                        break;
                    }
                }
                if (!allResolved) {
                    break;
                }
            }
            if (allResolved) {
                for (final Rule[] ruleblock : this.rules) {
                    generateValues(ruleblock);
                    //removeUnnecessaryValues(messages);
                }
                this.resolved = true;
            }
        }
    }

    private void removeUnnecessaryValues(final List<String> messages) {
        for (Iterator<String> iterator = this.values.iterator(); iterator.hasNext(); ) {
            final String value = iterator.next();
            boolean found = false;
            for (final String message : messages) {
                if (message.contains(value)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                iterator.remove();
            }
        }
    }

    private void generateValues(final Rule[] ruleblock) {
        if (ruleblock.length == 1) {
            this.values.addAll(ruleblock[0].getValues());
        } else if (ruleblock.length == 2) {
            for (final String valueOne : ruleblock[0].values) {
                for (final String valueTwo : ruleblock[1].values) {
                    this.values.add(valueOne + valueTwo);
                }
            }
        } else if (ruleblock.length == 3) {
            for (final String valueOne : ruleblock[0].values) {
                for (final String valueTwo : ruleblock[1].values) {
                    for (final String valueThree : ruleblock[2].values) {
                        this.values.add(valueOne + valueTwo + valueThree);
                    }
                }
            }
        }
    }

    List<String> getValues() {
        return this.values;
    }

    boolean contains(final String value) {
        return this.values.contains(value);
    }

    List<Rule[]> getRules() {
        return this.rules;
    }
}
