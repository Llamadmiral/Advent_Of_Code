package com.aoc.days2018.day12;

/**
 * @author maczaka.
 */
public class Generation {
    private Pot zeroPot = null;

    public void createInitialState(final String input) {
        zeroPot = new Pot(input.charAt(0), 0);
        Pot current = zeroPot;
        for (int i = 1; i < input.length(); i++) {
            final Pot pot = new Pot(input.charAt(i), i);
            current.setNext(pot);
            pot.setPrevious(pot);
            current = pot;
        }
    }

    
}
