package com.aoc.days2020.day23;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyThree extends SolutionBase {

    SolutionTwentyThree(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final Cup cup = playCrabgame(input.length(), 100, false);
        final StringBuilder builder = new StringBuilder();
        for (Cup current = cup.getNext(); current.getValue() != 1; current = current.getNext()) {
            builder.append(current.getValue());
        }
        setSolutionOne(builder.toString());
    }

    @Override
    protected void solvePartTwo() {
        final Cup cup = playCrabgame(1000000, 10000000, true);
        final Cup left = cup.getNext();
        final Cup right = left.getNext();
        setSolutionTwo(((long) left.getValue()) * ((long) right.getValue()));
    }

    private Cup playCrabgame(final int numberOfCups, final int numberOfRounds, final boolean includeMoreCups) {
        final Cup[] cups = new Cup[numberOfCups];
        int maxIndex = 0;
        final String[] split = input.split("");
        Cup head = new Cup(Integer.valueOf(split[0]));
        cups[head.getValue() - 1] = head;
        for (int i = 1; i < split.length; i++) {
            final String s = split[i];
            final Cup cup = new Cup(Integer.valueOf(s));
            head.insertBefore(cup);
            cups[cup.getValue() - 1] = cup;
            if (cup.getValue() > maxIndex) {
                maxIndex = cup.getValue();
            }
        }
        if (includeMoreCups) {
            for (int i = 10; i <= 1000000; i++) {
                final Cup cup = new Cup(i);
                head.insertBefore(cup);
                cups[cup.getValue() - 1] = cup;
            }
        }
        maxIndex = numberOfCups;
        Cup currentCup = head;
        for (int i = 0; i < numberOfRounds; i++) {
            final Cup left = currentCup.getNext();
            final Cup middle = left.getNext();
            final Cup right = middle.getNext();
            int destinationIndex = currentCup.getValue();
            boolean foundDestinationIndex = false;
            while (!foundDestinationIndex) {
                destinationIndex--;
                if (destinationIndex == 0) {
                    destinationIndex = maxIndex;
                }
                if (left.getValue() != destinationIndex && middle.getValue() != destinationIndex && right.getValue() != destinationIndex) {
                    foundDestinationIndex = true;
                }
            }
            final Cup destinationCup = cups[(destinationIndex - 1)];
            left.getPrevious().setNext(right.getNext());
            right.getNext().setPrevious(left.getPrevious());
            right.setNext(destinationCup.getNext());
            destinationCup.getNext().setPrevious(right);
            left.setPrevious(destinationCup);
            destinationCup.setNext(left);
            currentCup = currentCup.getNext();
        }
        return cups[0];
    }

}