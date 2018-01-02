package com.aoc.days.day09;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayNine extends DayBase {

    private static final String INPUT = Reader.readFromInput("9.txt");

    private static final String DAY_NR = "Nine";

    public DayNine() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionNine(DAY_NR);
        this.solution.setInput(INPUT);

    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionNine(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"{}",
            "{{{}}}",
            "{{},{}}",
            "{{{},{},{{}}}}",
            "{<a>,<a>,<a>,<a>}",
            "{{<ab>},{<ab>},{<ab>},{<ab>}}",
            "{{<!!>},{<!!>},{<!!>},{<!!>}}",
            "{{<a!>},{<a!>},{<a!>},{<ab>}}"};
    }
}
