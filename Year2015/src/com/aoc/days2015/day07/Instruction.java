package com.aoc.days2015.day07;

import java.util.Map;

public class Instruction {

    private String sourceOne;
    private String sourceTwo;
    private Signal signalOne;
    private Signal signaltwo;
    private String target;
    private String type;
    private Integer shiftValue;
    private boolean done;

    public Instruction() {
    }

    public Integer getShiftValue() {
        return shiftValue;
    }

    public void setShiftValue(final Integer shiftValue) {
        this.shiftValue = shiftValue;
    }

    public String getSourceOne() {
        return sourceOne;
    }

    public void setSourceOne(final String sourceOne) {
        this.sourceOne = sourceOne;
    }

    public String getSourceTwo() {
        return sourceTwo;
    }

    public void setSourceTwo(final String sourceTwo) {
        this.sourceTwo = sourceTwo;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(final String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public Signal getSignalOne(final Map<String, Signal> wires) {
        return this.signalOne == null ? wires.get(this.sourceOne) : signalOne;
    }

    public void setSignalOne(final Signal signalOne) {
        this.signalOne = signalOne;
    }

    public Signal getSignaltwo(final Map<String, Signal> wires) {
        return this.signaltwo == null ? wires.get(this.sourceTwo) : signaltwo;
    }

    public void setSignaltwo(final Signal signaltwo) {
        this.signaltwo = signaltwo;
    }
}
