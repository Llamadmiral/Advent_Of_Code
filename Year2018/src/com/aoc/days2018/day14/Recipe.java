package com.aoc.days2018.day14;

/**
 * @author maczaka.
 */
public class Recipe {
    private static int count = 0;


    private Recipe previous;
    private Recipe next;
    private int score;
    private long id;

    public Recipe(final Recipe previous, final int score) {
        if (previous == null) {
            this.previous = this;
            this.next = this;
        } else {
            this.next = previous.next;
            this.previous = previous;
            this.previous.next = this;
            this.next.previous = this;
        }
        this.score = score;
        this.id = count;
        count++;
    }

    public long getId() {
        return id;
    }

    public Recipe step(int n) {
        return n == 0 ? this : this.getNext().step(n - 1);
    }

    public Recipe getPrevious() {
        return previous;
    }


    public Recipe getNext() {
        return next;
    }

    public int getScore() {
        return score;
    }

    String printRecipes(final StringBuilder builder, final int starterId, final int blockAmount, final int amount) {
        if (blockAmount == 0 && amount != 0) {
            builder.append(this.getScore());
        }
        return (this.next.getId() == starterId || amount == 0)
            ? builder.toString()
            : this.next.printRecipes(builder, starterId, blockAmount != 0 ? blockAmount - 1 : 0, blockAmount == 0 ? amount - 1 : amount);
    }

}
