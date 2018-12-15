package com.aoc.days2018.day12;

/**
 * @author maczaka.
 */
public class Pot {
    private boolean plant = false;
    private int id;
    private Pot next;
    private Pot previous;

    public Pot(final char plant, final int id) {
        this.plant = plant == '#';
        this.id = id;
    }

    private Pot(final int id) {
        this.id = id;
    }

    public boolean hasPlant() {
        return plant;
    }

    public void setPlant(final boolean hasPlant) {
        this.plant = hasPlant;
    }

    public int getId() {
        return id;
    }

    public Pot getNext() {
        return next;
    }

    public void setNext(final Pot next) {
        this.next = next;
    }

    public Pot getOrCreateNext() {
        if (this.next == null) {
            createNext();
        }
        return next;
    }

    public Pot getPrevious() {
        return previous;
    }

    public void setPrevious(final Pot previous) {
        this.previous = previous;
    }

    public Pot getOrCreatePrevious() {
        if (this.previous == null) {
            createPrevious();
        }
        return previous;
    }

    public void createPrevious() {
        this.setPrevious(new Pot(this.id - 1));
    }

    public void createNext() {
        this.setNext(new Pot(this.id + 1));
    }

    public boolean matchesRule(final boolean[] rule, final int index) {
        return this.hasPlant() == rule[2]
            && this.getOrCreatePrevious().hasPlant() == rule[1] && this.getOrCreatePrevious().getOrCreatePrevious().hasPlant() == rule[0]
            && this.getOrCreateNext().hasPlant() == rule[3] && this.getOrCreateNext().getOrCreateNext().hasPlant() == rule[4];
    }

    public int getCount() {
        return getLeftCount() + getRightCount() + 1;
    }

    private int getRightCount() {
        return 1 + (next == null ? 0 : next.getRightCount());
    }

    private int getLeftCount() {
        return 1 + (previous == null ? 0 : previous.getLeftCount());
    }


}
