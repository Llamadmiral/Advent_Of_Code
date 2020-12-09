package com.aoc.days2015.day19;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Llamadmiral.
 */
class SolutionNineteen extends SolutionBase {

    private final Map<String, List<String>> rules = new HashMap<>();
    private final Map<String, String> reverseRulebook = new TreeMap<>((s, t1) -> {
        int comparison = t1.length() - s.length();
        if (comparison == 0) {
            comparison = t1.compareTo(s);
        }
        return comparison;
    });

    private String starting = "";
    private boolean foundIt;

    SolutionNineteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll(" => ", " ");
        boolean readingStarting = false;
        for (final String row : input.split("\n")) {
            if (readingStarting) {
                starting = row;
            } else if (row.isEmpty()) {
                readingStarting = true;
            } else {
                final String[] parts = row.split(" ");
                final String from = parts[0];
                final String to = parts[1];
                if (!rules.containsKey(parts[0])) {
                    rules.put(from, new ArrayList<>());
                }
                rules.get(from).add(to);
                reverseRulebook.put(to, from);
            }
        }
    }

    @Override
    protected void solvePartOne() {
        final MoleculeGenerator generator = new MoleculeGenerator(rules, starting);
        final List<String> molecules = generator.generateUniqueMolecules();
        setSolutionOne(molecules.size());
    }

    @Override
    protected void solvePartTwo() {
        reverseEngineerMolecule(starting, 0);
    }

    private void reverseEngineerMolecule(final String molecule, final int i) {
        for (final Map.Entry<String, String> entry : reverseRulebook.entrySet()) {
            if (!foundIt) {
                final String changedMolecule = generateSingleChange(entry.getKey(), entry.getValue(), molecule);
                if (changedMolecule != null && !"e".equals(changedMolecule)) {
                    reverseEngineerMolecule(changedMolecule, i + 1);
                } else if ("e".equals(changedMolecule)) {
                    setSolutionTwo(i);
                    foundIt = true;
                    break;
                }
            }
        }
    }

    private String generateSingleChange(final String ruleFrom, final String ruleTo, final String molecule) {
        String newMolecule = null;
        if (molecule.contains(ruleFrom)) {
            final int i = molecule.indexOf(ruleFrom);
            newMolecule = molecule.substring(0, i) + ruleTo + molecule.substring(i + ruleFrom.length());
        }
        return newMolecule;
    }


}