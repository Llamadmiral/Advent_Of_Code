package com.aoc.days2020.day23;

class Cup {
    private Cup next;
    private Cup previous;
    private int value;

    Cup(final int value) {
        this.value = value;
        this.next = this;
        this.previous = this;
    }

    void remove() {
        this.next.previous = this.previous;
        this.previous.next = this.next;
        this.next = null;
        this.previous = null;
    }

    Cup getNext() {
        return next;
    }

    void setNext(final Cup next) {
        this.next = next;
    }

    Cup getPrevious() {
        return previous;
    }

    void setPrevious(final Cup previous) {
        this.previous = previous;
    }

    int getValue() {
        return value;
    }

    void setValue(final int value) {
        this.value = value;
    }

    void insertBefore(final Cup cup) {
        final Cup prev = this.getPrevious();
        prev.setNext(cup);
        this.setPrevious(cup);
        cup.setNext(this);
        cup.setPrevious(prev);
    }

    @Override
    public String toString() {
        return "Prev: " + this.previous.value + "; This: " + this.value + "; Next: " + this.next.value;
    }
}
