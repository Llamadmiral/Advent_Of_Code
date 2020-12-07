package com.aoc.days2015.day09;

public class CityDistance {

    private String start;
    private String end;
    private int distance;

    CityDistance(final String start, final String end, final int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public String getStart() {
        return start;
    }

    public void setStart(final String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(final String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.start + " to " + this.end + " = " + this.distance;
    }
}
