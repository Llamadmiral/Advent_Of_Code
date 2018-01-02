package com.aoc.days2017.day25;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author maczaka.
 */
public class DayTwentyFive extends DayBase {

    private static final String DAY_NR = "TwentyFive";

    public DayTwentyFive() {
        this.dayNr = DAY_NR;
        this.solution = new SolutionTwentyFive(DAY_NR);
        this.solution.setInput(Reader.readFromInput("2017/25.txt"));
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"Begin in state A.\n"
            + "Perform a diagnostic checksum after 6 steps.\n"
            + "\n"
            + "In state A:\n"
            + "  If the current value is 0:\n    - Write the value 1.\n"
            + "    - Move one slot to the right.\n"
            + "    - Continue with state B.\n"
            + "  If the current value is 1:\n"
            + "    - Write the value 0.\n"
            + "    - Move one slot to the left.\n"
            + "    - Continue with state B.\n"
            + "\n"
            + "In state B:\n"
            + "  If the current value is 0:\n    - Write the value 1.\n"
            + "    - Move one slot to the left.\n"
            + "    - Continue with state A.\n"
            + "  If the current value is 1:\n    - Write the value 1.\n"
            + "    - Move one slot to the right.\n"
            + "    - Continue with state A."};
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFive(DAY_NR);
    }
}
