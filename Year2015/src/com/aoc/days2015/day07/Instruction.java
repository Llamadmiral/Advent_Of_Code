package com.aoc.days2015.day07;

import java.util.Map;

class Instruction {

    private String sourceOne;
    private String sourceTwo;
    private Signal signalOne;
    private Signal signaltwo;
    private String target;
    private String type;
    private Integer shiftValue;
    private boolean done;


    Integer getShiftValue() {
        return shiftValue;
    }

    void setShiftValue(final Integer shiftValue) {
        this.shiftValue = shiftValue;
    }


    void setSourceOne(final String sourceOne) {
        this.sourceOne = sourceOne;
    }


    void setSourceTwo(final String sourceTwo) {
        this.sourceTwo = sourceTwo;
    }

    String getTarget() {
        return target;
    }

    void setTarget(final String target) {
        this.target = target;
    }

    String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    boolean getDone() {
        return done;
    }

    void setDone(final boolean done) {
        this.done = done;
    }

    Signal getSignalOne(final Map<String, Signal> wires) {
        return this.signalOne == null ? wires.get(this.sourceOne) : signalOne;
    }

    void setSignalOne(final Signal signalOne) {
        this.signalOne = signalOne;
    }

    Signal getSignaltwo(final Map<String, Signal> wires) {
        return this.signaltwo == null ? wires.get(this.sourceTwo) : signaltwo;
    }

    void setSignaltwo(final Signal signaltwo) {
        this.signaltwo = signaltwo;
    }
}
