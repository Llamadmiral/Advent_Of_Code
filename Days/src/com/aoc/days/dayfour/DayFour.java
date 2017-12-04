package com.aoc.days.dayfour;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayFour extends DayBase {

    @Override
    public String getDayNr() {
        return "Four";
    }

    @Override
    public void finalSolution() {
        final String file = Reader.readFromInput("3.txt");
        Solution solution = new Solution(dayNr, file);
        solution.getPartOne();
    }

    @Override
    public void tests1() {
        Solution test1 = new Solution(dayNr);
        test1.setInput("aa bb cc dd ee");
        test1.getPartOne();
        Solution test2 = new Solution(dayNr);
        test2.setInput("aa bb cc dd aa");
        test2.getPartOne();
        Solution test3 = new Solution(dayNr);
        test3.setInput("aa bb cc dd aaa");
        test3.getPartOne();
    }

    @Override
    public void tests2() {
        Solution test1 = new Solution(dayNr, "abcde fghij");
        Solution test2 = new Solution(dayNr, "abcde xyz ecdab");
        Solution test3 = new Solution(dayNr, "a ab abc abd abf abj");
        Solution test4 = new Solution(dayNr, "iiii oiii ooii oooi oooo");
        Solution test5 = new Solution(dayNr, "oiii ioii iioi iiio is");
        test1.getPartTwo();
        test2.getPartTwo();
        test3.getPartTwo();
        test4.getPartTwo();
        test5.getPartTwo();
    }
}
