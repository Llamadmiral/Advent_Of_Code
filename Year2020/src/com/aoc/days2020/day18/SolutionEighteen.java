package com.aoc.days2020.day18;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionEighteen extends SolutionBase {

    SolutionEighteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        long sum = 0;
        for (final String row : input.split("\n")) {
            final Expression expression = new Expression(row);
            expression.evaluate();
            sum += expression.getResult();
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        long sum = 0;
        for (final String row : input.split("\n")) {
            final Expression expression = new Expression(row);
            expression.evaluatePartTwo();
            sum += expression.getResult();
        }
        setSolutionTwo(sum);
    }
}