package com.aoc.days2018.day08;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEight extends SolutionBase {

    private Node firstNode;
    private int readerIndex = 0;

    SolutionEight(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        setSolutionOne(firstNode.getSumOfAllEntries());
    }


    @Override
    protected void solvePartTwo() {
        setSolutionTwo(firstNode.getValue());
    }

    private void prepareInput() {
        final String[] split = input.split(" ");
        final int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        firstNode = createNodes(numbers);
    }

    private Node createNodes(final int[] numbers) {
        final Node node = new Node();
        final int numberOfChildren = numbers[readerIndex];
        final int numberOfEntires = numbers[readerIndex + 1];
        node.setNumberOfChilds(numberOfChildren);
        node.setNumberOfEntires(numberOfEntires);
        readerIndex += 2;
        if (numberOfChildren != 0) {
            for (int i = 0; i < numberOfChildren; i++) {
                final Node child = createNodes(numbers);
                node.addChild(child);
            }
        }
        final int[] entries = new int[numberOfEntires];
        System.arraycopy(numbers, readerIndex, entries, 0, numberOfEntires);
        node.setEntries(entries);
        readerIndex += numberOfEntires;
        return node;
    }

}