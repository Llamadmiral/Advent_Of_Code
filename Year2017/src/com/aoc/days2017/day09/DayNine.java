package com.aoc.days2017.day09;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka
 */
public class DayNine extends DayBase {
    private static final String DAY_NR = "Nine";

    public DayNine() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionNine(DAY_NR);
        this.solution.setInput(Reader.readFromInput("2017/9.txt"));

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
