package com.aoc.days2018.day15;

/**
 * @author maczaka.
 */
public class Sample {
    private int[] before;
    private int[] operation;
    private int[] after;

    Sample(final String before, final String operation, final String after) {
        final String[] dBefore = before.split(", ");
        final String[] dOperation = operation.split(" ");
        final String[] dAfter = after.split(", ");
        this.before = new int[]{Integer.parseInt(dBefore[0].substring(9, dBefore[0].length())),
            Integer.parseInt(dBefore[1]),
            Integer.parseInt(dBefore[2]),
            Integer.parseInt(dBefore[3].substring(0, dBefore[3].length() - 1))
        };
        this.operation = new int[]{
            Integer.parseInt(dOperation[0]),
            Integer.parseInt(dOperation[1]),
            Integer.parseInt(dOperation[2]),
            Integer.parseInt(dOperation[3])
        };

        this.after = new int[]{Integer.parseInt(dAfter[0].substring(9, dAfter[0].length())),
            Integer.parseInt(dAfter[1]),
            Integer.parseInt(dAfter[2]),
            Integer.parseInt(dAfter[3].substring(0, dAfter[3].length() - 1))
        };
    }

    public int[] getBefore() {
        return before;
    }

    public int[] getOperation() {
        return operation;
    }

    public int[] getAfter() {
        return after;
    }
}
