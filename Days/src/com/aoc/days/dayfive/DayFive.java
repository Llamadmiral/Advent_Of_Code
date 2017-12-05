package com.aoc.days.dayfive;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayFive extends DayBase {
    private static final String TEST_CASE = "0\n3\n0\n1\n-3\n";

    public DayFive() {
        dayNr = "Five";
        solution = new Solution(dayNr);
       // solution.setInput(Reader.readFromInput("5.txt"));
        solution.setInput(TEST_CASE);
    }

    @Override
    public void tests1() {
        final Solution solution = new Solution("Five");
        solution.setInput(TEST_CASE);
        solution.getPartOne();
    }


}
