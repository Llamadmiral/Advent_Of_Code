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
        solution = new SolutionOne(input, dayNr);
    }

    @Override
    public void finalSolution() {
        solution.getPartOne();
        solution.getPartTwo();
    }


    public void tests1() {
        SolutionOne test1 = new SolutionOne("1122", dayNr);
        SolutionOne test2 = new SolutionOne("1111", dayNr);
        SolutionOne test3 = new SolutionOne("1234", dayNr);
        SolutionOne test4 = new SolutionOne("91212129", dayNr);
        test1.getPartOne();
        test2.getPartOne();
        test3.getPartOne();
        test4.getPartOne();
    }

    public void tests2() {
        SolutionOne test1 = new SolutionOne("1212", dayNr);
        SolutionOne test2 = new SolutionOne("1221", dayNr);
        SolutionOne test3 = new SolutionOne("123425", dayNr);
        SolutionOne test4 = new SolutionOne("123123", dayNr);
        SolutionOne test5 = new SolutionOne("12131415", dayNr);
        test1.getPartTwo();
        test2.getPartTwo();
        test3.getPartTwo();
        test4.getPartTwo();
        test5.getPartTwo();
    }

}
