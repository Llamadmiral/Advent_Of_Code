package com.aoc.days2016.day07;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionSeven extends SolutionBase {
    private List<Address> addresses = new ArrayList<>();

    SolutionSeven(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        int supportsTSL = 0;
        for (final Address address : addresses) {
            if (doesAddressSupportTLS(address)) {
                supportsTSL++;
            }
        }
        setSolutionOne(supportsTSL);
    }

    @Override
    protected void solvePartTwo() {
        int supportsTSL = 0;
        for (final Address address : addresses) {
            if (doesAddressSupportSSL(address)) {
                supportsTSL++;
            }
        }
        setSolutionTwo(supportsTSL);
    }

    private boolean doesAddressSupportSSL(final Address address) {
        boolean supportsIt = false;
        final List<char[]> outerAbas = new ArrayList<>();
        final List<char[]> innerAbas = new ArrayList<>();
        for (final String outerPart : address.getOuterIPs()) {
            outerAbas.addAll(getABAs(outerPart));
        }
        if (!outerAbas.isEmpty()) {
            for (final String innerPart : address.getInnerIPs()) {
                innerAbas.addAll(getABAs(innerPart));
            }
            for (final char[] innerAba : innerAbas) {
                boolean foundMatch = false;
                for (final char[] outerAba : outerAbas) {
                    foundMatch = outerAba[0] == innerAba[1] && outerAba[1] == innerAba[0];
                    if (foundMatch) {
                        break;
                    }
                }
                if (foundMatch) {
                    supportsIt = true;
                    break;
                }
            }
        }
        return supportsIt;
    }

    private List<char[]> getABAs(final String part) {
        final List<char[]> abas = new ArrayList<>();
        for (int i = 2; i < part.length(); i++) {
            final char c1 = part.charAt(i - 2);
            final char c2 = part.charAt(i - 1);
            final char c3 = part.charAt(i);
            if (c1 == c3 && c1 != c2) {
                abas.add(new char[]{c1, c2, c3});
            }
        }
        return abas;
    }

    private boolean doesAddressSupportTLS(final Address address) {
        boolean doesSupportTsl = true;
        for (final String innerIP : address.getInnerIPs()) {
            if (hasABBA(innerIP)) {
                doesSupportTsl = false;
                break;
            }
        }
        if (doesSupportTsl) {
            boolean found = false;
            for (final String outerIP : address.getOuterIPs()) {
                if (hasABBA(outerIP)) {
                    found = true;
                    break;
                }
            }
            doesSupportTsl = found;
        }
        return doesSupportTsl;
    }

    private boolean hasABBA(final String input) {
        boolean hasABBA = false;
        int i = 3;
        while (i < input.length() && !hasABBA) {
            hasABBA = checkIfAbba(input.charAt(i - 3), input.charAt(i - 2), input.charAt(i - 1), input.charAt(i));
            i++;
        }
        return hasABBA;
    }

    private boolean checkIfAbba(final char c1, final char c2, final char c3, final char c4) {
        return c1 == c4 && c2 == c3 && c1 != c2;
    }

    private void parseInput() {
        final String[] rows = input.split("\n");
        for (final String row : rows) {
            addresses.add(new Address(row));
        }
    }
}