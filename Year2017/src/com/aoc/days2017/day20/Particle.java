package com.aoc.days2017.day20;

import java.util.Arrays;

/**
 * @author maczaka.
 */
class Particle {
    private static int count = 0;
    private int[] position = new int[3];
    private int[] velocity = new int[3];
    private int[] acceleration = new int[3];
    private int id;
    private boolean removed = false;

    Particle(final String data) {
        final String[] attributes = data.split(", ");
        fillArray(attributes[0], position);
        fillArray(attributes[1], velocity);
        fillArray(attributes[2], acceleration);
        id = count;
        count++;
    }

    void update() {
        addArrayElementsToArrayNTimes(acceleration, velocity, 1);
        addArrayElementsToArrayNTimes(velocity, position, 1);
    }

    private void fillArray(final String data, final int[] arrayToFill) {
        final String trimmedData = (data.substring(3, data.length() - 1)).trim();
        final String[] numbers = trimmedData.split(",");
        for (int i = 0; i < 3; i++) {
            arrayToFill[i] = Integer.parseInt(numbers[i]);
        }
    }

    boolean getPositionEquals(final Particle particle) {
        int i = 0;
        while (i < 3 && this.position[i] == particle.position[i]) {
            i++;
        }
        return i == 3;
    }

    private void addArrayElementsToArrayNTimes(final int[] arrayToAdd, final int[] arrayToAddTo, final int n) {
        for (int i = 0; i < 3; i++) {
            arrayToAddTo[i] += arrayToAdd[i] * n;
        }
    }

    int getManhattanAcceleration() {
        return Math.abs(acceleration[0]) + Math.abs(acceleration[1]) + Math.abs(acceleration[2]);
    }

    int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Particle{" +
            "position=" + Arrays.toString(position) +
            ", velocity=" + Arrays.toString(velocity) +
            ", acceleration=" + Arrays.toString(acceleration) +
            '}';
    }

    boolean isRemoved() {
        return removed;
    }

    public void remove() {
        this.removed = true;
    }
}
