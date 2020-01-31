package com.aoc.days2018.day23;

/**
 * @author maczaka.
 */
public class Cube {
    private int minX;
    private int minY;
    private int minZ;
    private int maxX;
    private int maxY;
    private int maxZ;

    public Cube(final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMinZ() {
        return minZ;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMaxZ() {
        return maxZ;
    }

    @Override
    public String toString() {
        return "Cube{" +
            "minX=" + minX +
            ", minY=" + minY +
            ", minZ=" + minZ +
            ", maxX=" + maxX +
            ", maxY=" + maxY +
            ", maxZ=" + maxZ +
            '}';
    }
}
