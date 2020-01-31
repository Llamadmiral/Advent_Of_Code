package com.aoc.days2018.day12;

/**
 * @author maczaka.
 */
public class Pot {
    public static final Pot EMPTY_POT = new Pot();
    
    private boolean plant = false;
    private Pot next;
    private Pot previous;

    public Pot(final char plant) {
        this.plant = plant == '#';
    }
    
    private Pot(){
        this.next = this;
        this.previous = this;
    }

    public boolean isPlant() {
        return plant;
    }

    public void setPlant(final boolean plant) {
        this.plant = plant;
    }

    public Pot getNext() {
        return next;
    }

    public void setNext(final Pot next) {
        this.next = next;
    }

    public Pot getPrevious() {
        return previous;
    }

    public void setPrevious(final Pot previous) {
        this.previous = previous;
    }
}
