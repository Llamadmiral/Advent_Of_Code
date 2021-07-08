package com.aoc.util.assembunny;

public class Instruction {
    private String type;
    private char pointerA;
    private char pointerB;
    private int valueA;
    private int valueB;
    private boolean aIsPointer = false;
    private boolean bIsPointer = false;

    public Instruction(final String row) {
        final String[] data = row.split(" ");
        this.type = data[0];
        final String columnA = data[1];
        if (columnA.length() == 1 && Character.isAlphabetic(columnA.charAt(0))) {
            pointerA = columnA.charAt(0);
            aIsPointer = true;
        } else {
            valueA = Integer.parseInt(columnA);
        }
        if (data.length > 2) {
            final String columnB = data[2];
            if (columnB.length() == 1 && Character.isAlphabetic(columnB.charAt(0))) {
                pointerB = columnB.charAt(0);
                bIsPointer = true;
            } else {
                valueB = Integer.parseInt(columnB);
            }
        }
    }

    public String getType() {
        return type;
    }
    public char getPointerA() {
        return pointerA;
    }
    public char getPointerB() {
        return pointerB;
    }
    public int getValueA() {
        return valueA;
    }
    public int getValueB() {
        return valueB;
    }
    public boolean isAIsPointer() {
        return aIsPointer;
    }
    public boolean isbIsPointer() {
        return bIsPointer;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "type='" + type + '\'' +
                ", pointerA=" + pointerA +
                ", pointerB=" + pointerB +
                ", valueA=" + valueA +
                ", valueB=" + valueB +
                ", aIsPointer=" + aIsPointer +
                ", bIsPointer=" + bIsPointer +
                '}';
    }
}