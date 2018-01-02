package com.aoc.days2017.day06;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
public class DaySix extends DayBase {

    private static final String DAY_NR = "Six";

    private static final String BASE_INPUT = "2\t8\t8\t5\t4\t2\t3\t1\t5\t5\t1\t2\t15\t13\t5\t14";
    private static final String TEST_INPUT = "0\t2\t7\t0";

    public DaySix() {
        dayNr = DAY_NR;
        this.solution = new SolutionSix(DAY_NR);
        this.solution.setInput(BASE_INPUT);
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSix(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{TEST_INPUT};
    }
}
