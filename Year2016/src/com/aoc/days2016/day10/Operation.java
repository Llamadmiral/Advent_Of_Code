package com.aoc.days2016.day10;

/**
 * @author maczaka.
 */
public class Operation {
    private int lowTo;
    private int highTo;
    private int giver;
    private boolean lowToOutput = false;
    private boolean highToOutput = false;

    Operation(final String[] input) {
        giver = Integer.parseInt(input[1]);
        lowToOutput = "output".equals(input[5]);
        lowTo = Integer.parseInt(input[6]);
        highToOutput = "output".equals(input[10]);
        highTo = Integer.parseInt(input[11]);
    }

    int getLowTo() {
        return lowTo;
    }

    int getHighTo() {
        return highTo;
    }

    int getGiver() {
        return giver;
    }

    boolean isLowToOutput() {
        return lowToOutput;
    }

    boolean isHighToOutput() {
        return highToOutput;
    }
}
