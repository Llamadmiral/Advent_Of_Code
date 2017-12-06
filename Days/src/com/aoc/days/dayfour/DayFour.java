package com.aoc.days.dayfour;

import com.aoc.daybase.DayBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFour extends DayBase {

    public DayFour() {
        this.dayNr = "Four";
        this.solution = new SolutionFour(dayNr, Reader.readFromInput("4.txt"));

    }

    @Override
    public String getDayNr() {
        return "Four";
    }


    @Override
    public void tests1() {
        SolutionFour test1 = new SolutionFour(dayNr);
        test1.setInput("aa bb cc dd ee");
        test1.getPartOne();
        SolutionFour test2 = new SolutionFour(dayNr);
        test2.setInput("aa bb cc dd aa");
        test2.getPartOne();
        SolutionFour test3 = new SolutionFour(dayNr);
        test3.setInput("aa bb cc dd aaa");
        test3.getPartOne();
    }

    @Override
    public void tests2() {
        SolutionFour test1 = new SolutionFour(dayNr, "abcde fghij");
        SolutionFour test2 = new SolutionFour(dayNr, "abcde xyz ecdab");
        SolutionFour test3 = new SolutionFour(dayNr, "a ab abc abd abf abj");
        SolutionFour test4 = new SolutionFour(dayNr, "iiii oiii ooii oooi oooo");
        SolutionFour test5 = new SolutionFour(dayNr, "oiii ioii iioi iiio is");
        test1.getPartTwo();
        test2.getPartTwo();
        test3.getPartTwo();
        test4.getPartTwo();
        test5.getPartTwo();
    }
}
