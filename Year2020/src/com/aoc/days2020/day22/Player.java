package com.aoc.days2020.day22;

import java.util.ArrayList;
import java.util.List;

class Player {
    private int id;
    private List<Integer> deck = new ArrayList<>();
    private List<List<Integer>> previousDecks = new ArrayList<>();
    private boolean lost = false;

    Player(final int id, final String cards) {
        this.id = id;
        boolean first = true;
        for (final String card : cards.split("\n")) {
            if (!first) {
                final Integer value = Integer.valueOf(card);
                this.deck.add(value);
            } else {
                first = false;
            }
        }
    }

    Player(final int id, final List<Integer> deck, final Integer cardValue) {
        this.id = id;
        for (int i = 0; i < cardValue; i++) {
            this.deck.add(deck.get(i));
        }
    }

    Integer pop() {
        return this.deck.remove(0);
    }

    void add(final Integer winningCard, final Integer losingCard) {
        this.deck.add(winningCard);
        this.deck.add(losingCard);
    }

    boolean hasLost() {
        return this.lost || this.deck.isEmpty();
    }

    List<Integer> getDeck() {
        return deck;
    }

    void lost() {
        this.lost = true;
    }

    boolean checkInfiniteLoop() {
        boolean loop = false;
        for (final List<Integer> previousDeck : this.previousDecks) {
            if (previousDeck.size() == this.deck.size()) {
                boolean same = true;
                for (int i = 0; i < previousDeck.size(); i++) {
                    if (!previousDeck.get(i).equals(this.deck.get(i))) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    loop = true;
                    break;
                }
            }
        }
        if (!loop) {
            saveCurrentDeck();
        }
        return loop;
    }

    private void saveCurrentDeck() {
        this.previousDecks.add(new ArrayList<>(this.deck));
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final Integer card : this.deck) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(card);
        }
        return "Player " + this.id + "'s deck: " + builder.toString();
    }
}
