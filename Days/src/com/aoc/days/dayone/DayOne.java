package com.aoc.days.dayone;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayOne extends DayBase {

    public DayOne() {
        final String input = Reader.readFromInput("1.txt");
        dayNr = "One";
        solution = new Solution(input, dayNr);
    }

    @Override
    public void finalSolution() {
        solution.getPartOne();
        solution.getPartTwo();
    }


    public void tests1() {
        Solution test1 = new Solution("1122", dayNr);
        Solution test2 = new Solution("1111", dayNr);
        Solution test3 = new Solution("1234", dayNr);
        Solution test4 = new Solution("91212129", dayNr);
        test1.getPartOne();
        test2.getPartOne();
        test3.getPartOne();
        test4.getPartOne();
    }

    public void tests2() {
        Solution test1 = new Solution("1212", dayNr);
        Solution test2 = new Solution("1221", dayNr);
        Solution test3 = new Solution("123425", dayNr);
        Solution test4 = new Solution("123123", dayNr);
        Solution test5 = new Solution("12131415", dayNr);
        test1.getPartTwo();
        test2.getPartTwo();
        test3.getPartTwo();
        test4.getPartTwo();
        test5.getPartTwo();
    }

}
