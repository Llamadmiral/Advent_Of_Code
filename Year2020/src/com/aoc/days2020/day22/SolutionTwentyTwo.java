package com.aoc.days2020.day22;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyTwo extends SolutionBase {


    SolutionTwentyTwo(final String day) {
        super(day);
    }

    @Override
    public void init() {
    }

    @Override
    protected void solvePartOne() {
        final String[] players = input.split("\n\n");
        final Game game = new Game(players[0], players[1]);
        game.simulateSimpleBattle();
        final int winningPoint = game.countPoints();
        setSolutionOne(winningPoint);
    }

    @Override
    protected void solvePartTwo() {
        final String[] players = input.split("\n\n");
        final Game game = new Game(players[0], players[1]);
        game.simulateRecursiveCombat();
        final int winningPoint = game.countPoints();
        setSolutionTwo(winningPoint);
    }


}