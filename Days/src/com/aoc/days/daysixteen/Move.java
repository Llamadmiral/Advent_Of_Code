package com.aoc.days.daysixteen;

/**
 * @author maczaka.
 */
class Move {
    private char type;
    private int amount;
    private int from;
    private int to;
    private char who;
    private char with;

    Move(final String move) {
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

    int getAmount() {
        return amount;
    }

    char getType() {
        return type;
    }

    int getFrom() {
        return from;
    }

    int getTo() {
        return to;
    }

    void setTo(final int to) {
        this.to = to;
    }

    char getWho() {
        return who;
    }

    char getWith() {
        return with;
    }
}
