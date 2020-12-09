package com.aoc.days2015.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MoleculeGenerator {

    private Map<String, List<String>> rules;
    private String molecule;


    MoleculeGenerator(final Map<String, List<String>> rules, final String molecule) {
        this.rules = rules;
        this.molecule = molecule;
    }

    List<String> generateUniqueMolecules() {
        final List<String> molecules = new ArrayList<>();
        for (int i = 0; i < this.molecule.length(); i++) {
            for (final String key : this.rules.keySet()) {
                if (this.molecule.startsWith(key, i)) {
                    final boolean added = generateMolecules(key, i, molecules);
                    if (added) {
                        i += key.length() - 1;
                    }
                }
            }
        }
        return molecules;
    }

    private boolean generateMolecules(final String key, final int i, final List<String> molecules) {
        boolean added = false;
        for (final String value : this.rules.get(key)) {
            final String newMolecule = this.molecule.substring(0, i) + value + this.molecule.substring(i + key.length());
            if (!molecules.contains(newMolecule)) {
                molecules.add(newMolecule);
                added = true;
            }
        }
        return added;
    }
}
