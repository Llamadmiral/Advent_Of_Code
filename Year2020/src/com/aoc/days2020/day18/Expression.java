package com.aoc.days2020.day18;

public class Expression {

    private Part startingPart;

    Expression(final String input) {
        final String[] parts = input.replace("(", "( ").replace(")", " )").split(" ");
        startingPart = new Part();
        startingPart.setValue(1);
        Part currentPart = new Part();
        currentPart.setOperand('*');
        startingPart.setNext(currentPart);
        currentPart.setBefore(startingPart);
        for (final String part : parts) {
            final Part newPart = new Part();
            currentPart.setNext(newPart);
            newPart.setBefore(currentPart);
            currentPart = newPart;
            if (Character.isDigit(part.charAt(0))) {
                currentPart.setValue(Long.parseLong(part));
            } else {
                currentPart.setOperand(part.charAt(0));
            }
        }
    }

    void evaluate() {
        while (startingPart.getNext() != null) {
            Part currentPart = startingPart;
            Part partToExecute = startingPart;
            while (currentPart.getNext() != null) {
                if (currentPart.getOperand() == '(') {
                    partToExecute = currentPart.getNext();
                }
                currentPart = currentPart.getNext();
            }
            if (partToExecute.getNext() != null) {
                partToExecute.execute();
            } else {
                startingPart = partToExecute;
            }
        }
    }

    void evaluatePartTwo() {
        Part parenthesisMember = findLastParenthesisMember(startingPart);
        while (parenthesisMember != null) {
            final Part plusPart = findPlusPart(parenthesisMember);
            if (plusPart == null) {
                parenthesisMember.execute();
            } else {
                plusPart.execute();
            }
            parenthesisMember = findLastParenthesisMember(startingPart);
        }
        boolean searchForPlus = true;
        while (startingPart.getNext() != null) {
            if (searchForPlus) {
                final Part plusPart = findPlusPart(startingPart);
                if (plusPart == null) {
                    searchForPlus = false;
                } else {
                    plusPart.execute();
                }
            } else {
                startingPart.execute();
            }
        }
    }

    private Part findPlusPart(final Part startingPart) {
        Part plusPart = null;
        Part currentPart = startingPart;
        while (currentPart != null && currentPart.getOperand() != ')') {
            if (currentPart.getOperand() == '+') {
                plusPart = currentPart.getBefore();
                break;
            }
            currentPart = currentPart.getNext();
        }
        return plusPart;
    }

    private Part findLastParenthesisMember(final Part startingPart) {
        Part parenthesisPart = null;
        Part currentPart = startingPart;
        while (currentPart != null) {
            if (currentPart.getOperand() == '(') {
                parenthesisPart = currentPart.getNext();
            }
            currentPart = currentPart.getNext();
        }
        return parenthesisPart;
    }

    long getResult() {
        return startingPart.getValue();
    }
}
