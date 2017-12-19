package com.aoc.days.daysixteen;

/**
 * @author maczaka.
 */
public class Move {
    private char type;
    private int amount;
    private int from;
    private int to;
    private char who;
    private char with;

    public Move(final String move) {
        type = move.charAt(0);
        switch (type) {
            case 's':
                amount = Integer.parseInt(move.substring(1, move.length()));
                break;
            case 'x':
                final String[] positions = (move.substring(1, move.length())).split("/");
                from = Integer.parseInt(positions[0]);
                to = Integer.parseInt(positions[1]);
                break;
            case 'p':
                who = move.charAt(1);
                with = move.charAt(3);
                break;
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public char getType() {
        return type;
    }

    public void setType(final char type) {
        this.type = type;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(final int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(final int to) {
        this.to = to;
    }

    public char getWho() {
        return who;
    }

    public void setWho(final char who) {
        this.who = who;
    }

    public char getWith() {
        return with;
    }

    public void setWith(final char with) {
        this.with = with;
    }
}
