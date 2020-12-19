package com.aoc.days2020.day18;

class Part {

    private char operand = '\0';
    private long value;
    private Part before;
    private Part next;

    char getOperand() {
        return operand;
    }

    void setOperand(final char operand) {
        this.operand = operand;
    }

    long getValue() {
        return value;
    }

    void setValue(final long value) {
        this.value = value;
    }

    Part getBefore() {
        return before;
    }

    void setBefore(final Part before) {
        this.before = before;
    }

    Part getNext() {
        return next;
    }

    void setNext(final Part next) {
        this.next = next;
    }

    void execute() {
        final Part operand = this.getNext();
        final Part otherPart = operand.getNext();
        if (operand.getOperand() == ')') {
            this.before.remove();
            operand.remove();
        } else {
            if (operand.getOperand() == '+') {
                this.value += otherPart.getValue();
            } else {
                this.value *= otherPart.getValue();
            }
            otherPart.remove();
            operand.remove();
        }
    }

    private void remove() {
        if (this.before != null) {
            this.before.next = this.next;
        }
        if (this.next != null) {
            this.next.before = this.before;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.operand == '\0' ? this.value : String.valueOf(this.operand));
    }
}
