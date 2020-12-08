package com.aoc.days2015.day12;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionTwelve extends SolutionBase {

    private int index = 0;

    SolutionTwelve(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final int amount = sumBlock(input);
        setSolutionOne(amount);
    }

    @Override
    protected void solvePartTwo() {
        final Block block = new Block();
        createBlockTree(block);
        final int amount = calculateBlockTree(block.getChildren().iterator().next());
        setSolutionTwo(amount);
    }

    private int calculateBlockTree(final Block block) {
        int amount = 0;
        final String layer = block.getBlock().toString();
        if (layer.charAt(0) != '{' || !layer.contains(":\"red\"")) {
            amount += sumBlock(layer);
            for (final Block child : block.getChildren()) {
                amount += calculateBlockTree(child);
            }
        }
        return amount;
    }

    private void createBlockTree(final Block block) {
        while (this.index < input.length()) {
            final char current = input.charAt(index);
            if (current == '{' || current == '[') {
                final Block child = new Block();
                child.getBlock().append(current);
                block.getChildren().add(child);
                this.index++;
                createBlockTree(child);
            } else if (current == '}' || current == ']') {
                block.getBlock().append(current);
                this.index++;
                break;
            } else {
                block.getBlock().append(current);
                this.index++;
            }
        }
    }

    private int sumBlock(final String block) {
        StringBuilder storage = new StringBuilder();
        boolean inNumber = false;
        int amount = 0;
        for (int i = 0; i < block.length(); i++) {
            final char c = block.charAt(i);
            if (c == '-' || (c >= '0' && c <= '9')) {
                storage.append(c);
                inNumber = true;
            } else if (inNumber) {
                amount += Integer.valueOf(storage.toString());
                storage = new StringBuilder();
                inNumber = false;
            }
        }
        return amount;
    }


}