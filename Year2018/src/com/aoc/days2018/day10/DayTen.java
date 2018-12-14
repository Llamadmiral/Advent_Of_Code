package com.aoc.days2018.day10;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTen extends DayBase {

    private static final String DAY_NR = "Ten";

    public DayTen() {
        dayNr = DAY_NR;
        solution = new SolutionTen(DAY_NR);
        solution.setInput(Reader.readFromInput("2018/10.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTen(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"position=< 9,  1> velocity=< 0,  2>\n"
            + "position=< 7,  0> velocity=<-1,  0>\n"
            + "position=< 3, -2> velocity=<-1,  1>\n"
            + "position=< 6, 10> velocity=<-2, -1>\n"
            + "position=< 2, -4> velocity=< 2,  2>\n"
            + "position=<-6, 10> velocity=< 2, -2>\n"
            + "position=< 1,  8> velocity=< 1, -1>\n"
            + "position=< 1,  7> velocity=< 1,  0>\n"
            + "position=<-3, 11> velocity=< 1, -2>\n"
            + "position=< 7,  6> velocity=<-1, -1>\n"
            + "position=<-2,  3> velocity=< 1,  0>\n"
            + "position=<-4,  3> velocity=< 2,  0>\n"
            + "position=<10, -3> velocity=<-1,  1>\n"
            + "position=< 5, 11> velocity=< 1, -2>\n"
            + "position=< 4,  7> velocity=< 0, -1>\n"
            + "position=< 8, -2> velocity=< 0,  1>\n"
            + "position=<15,  0> velocity=<-2,  0>\n"
            + "position=< 1,  6> velocity=< 1,  0>\n"
            + "position=< 8,  9> velocity=< 0, -1>\n"
            + "position=< 3,  3> velocity=<-1,  1>\n"
            + "position=< 0,  5> velocity=< 0, -1>\n"
            + "position=<-2,  2> velocity=< 2,  0>\n"
            + "position=< 5, -2> velocity=< 1,  2>\n"
            + "position=< 1,  4> velocity=< 2,  1>\n"
            + "position=<-2,  7> velocity=< 2, -2>\n"
            + "position=< 3,  6> velocity=<-1, -1>\n"
            + "position=< 5,  0> velocity=< 1,  0>\n"
            + "position=<-6,  0> velocity=< 2,  0>\n"
            + "position=< 5,  9> velocity=< 1, -2>\n"
            + "position=<14,  7> velocity=<-2,  0>\n"
            + "position=<-3,  6> velocity=< 2, -1>"};
    }
}