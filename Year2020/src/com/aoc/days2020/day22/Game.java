package com.aoc.days2020.day22;

import java.util.List;

class Game {

    private static int gameCounter = 0;

    private int roundCounter = 1;
    private int id;
    private Player first;
    private Player second;

    Game(final String firstDeck, final String secondDeck) {
        gameCounter++;
        this.id = gameCounter;
        this.first = new Player(1, firstDeck);
        this.second = new Player(2, secondDeck);

    }

    private Game(final List<Integer> firstDeck, final Integer firstCard, final List<Integer> secondDeck, final Integer secondCard) {
        gameCounter++;
        this.id = gameCounter;
        this.first = new Player(1, firstDeck, firstCard);
        this.second = new Player(2, secondDeck, secondCard);
    }

    int simulateRecursiveCombat() {
        return simulateBattle(true);
    }

    void simulateSimpleBattle() {
        simulateBattle(false);
    }

    private int simulateBattle(final boolean recursiveCombat) {
        //log("=== Game " + this.id + " ===\n");
        while (!first.hasLost() && !second.hasLost()) {
            if (!recursiveCombat) {
                simpleBattle();
            } else {
                recursiveCombat();
            }
            this.roundCounter++;
        }
        boolean firstWon = !first.hasLost();
        //log("The winner of Game " + this.id + " is player " + (firstWon ? 1 : 2) + "!\n");
        return firstWon ? 1 : 2;
    }

    private void recursiveCombat() {
        //log("-- Round " + this.roundCounter + " (Game " + this.id + ") --");
        final boolean infiniteLoop = checkInfiniteLoop();
        if (infiniteLoop) {
            second.lost();
            //log("Player 1 won due to being stuck in an infinite loop!");
        } else {
            //log(first);
            //log(second);
            final Integer firstCard = first.pop();
            final Integer secondCard = second.pop();
            //log("Player 1 plays: " + firstCard);
            //log("Player 2 plays: " + secondCard);
            if (first.getDeck().size() >= firstCard && second.getDeck().size() >= secondCard) {
                //log("Playing a sub-game to determine the winner...");
                final Game game = new Game(first.getDeck(), firstCard, second.getDeck(), secondCard);
                final int wonPlayer = game.simulateRecursiveCombat();
                if (wonPlayer == 1) {
                    first.add(firstCard, secondCard);
                } else {
                    second.add(secondCard, firstCard);
                }
                //log("...anyway, back to game " + this.id + ".");
            } else {
                if (firstCard > secondCard) {
                    first.add(firstCard, secondCard);
                    //log("Player 1 wins round " + this.roundCounter + " of Game " + this.id + "!\n");
                } else {
                    //log("Player 2 wins round " + this.roundCounter + " of Game " + this.id + "!\n");
                    second.add(secondCard, firstCard);
                }
            }
        }
    }

    private boolean checkInfiniteLoop() {
        return first.checkInfiniteLoop() && second.checkInfiniteLoop();
    }

    private void simpleBattle() {
        //log("-- Round " + this.roundCounter + " --");
        //log(first);
        //log(second);
        final Integer firstCard = first.pop();
        final Integer secondCard = second.pop();
        //log("Player 1 plays: " + firstCard);
        //log("Player 2 plays: " + secondCard);
        if (firstCard > secondCard) {
            first.add(firstCard, secondCard);
            //log("Player 1 wins the round!\n");
        } else {
            //log("Player 2 wins the round!\n");
            second.add(secondCard, firstCard);
        }
    }

    int countPoints() {
        final Player player = first.hasLost() ? second : first;
        final List<Integer> deck = player.getDeck();
        int counter = 0;
        for (int i = 0; i < deck.size(); i++) {
            counter += deck.get(i) * (deck.size() - (i));
        }
        return counter;
    }


    private void log(final Object msg) {
        //System.out.println(msg);
    }


}
