package com.aoc.days2016.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maczaka.
 */
class Address {
    private List<String> outerIPs = new ArrayList<>();
    private List<String> innerIPs = new ArrayList<>();
    private int l = 0;

    Address(final String input) {
        int i = 0;
        int from = 0;
        boolean inInner = false;
        while (i < input.length()) {
            final char c = input.charAt(i);
            if (inInner) {
                if (c == ']') {
                    inInner = false;
                    final String part = input.substring(from, i);
                    innerIPs.add(part);
                    l += part.length();
                    from = i + 1;
                }
            } else {
                if (c == '[') {
                    inInner = true;
                    final String part = input.substring(from, i);
                    outerIPs.add(part);
                    l += part.length();
                    from = i + 1;
                }
            }
            i++;
        }
        outerIPs.add(input.substring(from, i));
        //System.out.println("diff: " + (input.length() - l));
    }

    public List<String> getOuterIPs() {
        return outerIPs;
    }

    public List<String> getInnerIPs() {
        return innerIPs;
    }
}
