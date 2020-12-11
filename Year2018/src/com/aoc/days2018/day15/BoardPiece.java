package com.aoc.days2018.day15;

import static com.aoc.days2018.day15.BoardConstants.ELF;
import static com.aoc.days2018.day15.BoardConstants.EMPTY;
import static com.aoc.days2018.day15.BoardConstants.GOBLIN;
import static com.aoc.days2018.day15.BoardConstants.WALL;

public class BoardPiece {

    private String type;
    private char tile;
    private int health = 200;
    private int attackPower = 3;
    private boolean alreadyActed = false;
    private boolean canAct;

    private int row;
    private int column;


    BoardPiece(final int row, final int column, final char tile) {
        this.row = row;
        this.column = column;
        this.tile = tile;
        if (tile == 'G') {
            this.canAct = true;
            this.type = GOBLIN;
        } else if (tile == 'E') {
            this.canAct = true;
            this.type = ELF;
        } else if (tile == '.') {
            this.type = EMPTY;
        } else if (tile == '#') {
            this.type = WALL;
        }
    }

    boolean canAct() {
        return this.canAct && !this.alreadyActed;
    }

    @Override
    public String toString() {
        return "[" + this.type + ":" + this.row + "," + this.column + "]";
    }

    int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }

    String getType() {
        return this.type;
    }

    char getTile() {
        return this.tile;
    }
}
