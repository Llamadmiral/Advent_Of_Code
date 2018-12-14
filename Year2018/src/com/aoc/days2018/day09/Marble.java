package com.aoc.days2018.day09;

/**
 * @author maczaka.
 */
public class Marble {

    private Marble previous;
    private Marble next;
    private int score;

    public Marble(final int score) {
        this.score = score;
    }


    public Marble addMarble(final int score) {
        final Marble newMarble = new Marble(score);
        final Marble firstClockwise = this.getNext();
        final Marble secondClockwise = firstClockwise.getNext();
        firstClockwise.next = newMarble;
        secondClockwise.previous = newMarble;
        newMarble.setPrevious(firstClockwise);
        newMarble.setNext(secondClockwise);
        return newMarble;
    }

    final Marble remove(final int n) {
        Marble toRemove;
        if (n == 0) {
            this.getNext().setPrevious(this.getPrevious());
            this.getPrevious().setNext(this.getNext());
            toRemove = this;
        } else {
            toRemove = this.getPrevious().remove(n - 1);
        }
        return toRemove;
    }

    public Marble getPrevious() {
        return previous;
    }

    public void setPrevious(final Marble previous) {
        this.previous = previous;
    }

    public Marble getNext() {
        return next;
    }

    public void setNext(final Marble next) {
        this.next = next;
    }

    public int getScore() {
        return score;
    }
}
