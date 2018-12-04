package com.aoc.days2018.day04;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayFour extends DayBase {

    private static final String DAY_NR = "Four";

    public DayFour() {
        dayNr = DAY_NR;
        solution = new SolutionFour(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/4.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"[1518-11-01 00:00] Guard #10 begins shift\n"
            + "[1518-11-01 00:05] falls asleep\n"
            + "[1518-11-01 00:25] wakes up\n"
            + "[1518-11-01 00:30] falls asleep\n"
            + "[1518-11-01 00:55] wakes up\n"
            + "[1518-11-01 23:58] Guard #99 begins shift\n"
            + "[1518-11-02 00:40] falls asleep\n"
            + "[1518-11-02 00:50] wakes up\n"
            + "[1518-11-03 00:05] Guard #10 begins shift\n"
            + "[1518-11-03 00:24] falls asleep\n"
            + "[1518-11-03 00:29] wakes up\n"
            + "[1518-11-04 00:02] Guard #99 begins shift\n"
            + "[1518-11-04 00:36] falls asleep\n"
            + "[1518-11-04 00:46] wakes up\n"
            + "[1518-11-05 00:03] Guard #99 begins shift\n"
            + "[1518-11-05 00:45] falls asleep\n"
            + "[1518-11-05 00:55] wakes up"};
    }
}