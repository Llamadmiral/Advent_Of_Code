package com.aoc.days2018.day12;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwelve extends DayBase {

    private static final String DAY_NR = "Twelve";

    public DayTwelve() {
        dayNr = DAY_NR;
        solution = new SolutionTwelve(DAY_NR);
        //solution.setInput(Reader.readFromInput("2018/12.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwelve(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"initial state: ##....#.#.#...#.#..#.#####.#.#.##.#.#.#######...#.##....#..##....#.#..##.####.#..........#..#...#\n"
            + "\n"
            + "..#.# => #\n"
            + ".#### => #\n"
            + "#.... => .\n"
            + "####. => #\n"
            + "...## => .\n"
            + ".#.#. => .\n"
            + "..#.. => .\n"
            + "##.#. => .\n"
            + "#.#.# => #\n"
            + "..... => .\n"
            + "#.#.. => .\n"
            + "....# => .\n"
            + ".#..# => .\n"
            + "###.# => #\n"
            + "#..#. => .\n"
            + "##### => .\n"
            + "...#. => #\n"
            + "#.##. => #\n"
            + ".#.## => #\n"
            + "#..## => #\n"
            + ".##.. => #\n"
            + "##.## => .\n"
            + "..### => .\n"
            + "###.. => .\n"
            + "##..# => #\n"
            + ".#... => #\n"
            + ".###. => #\n"
            + "#.### => .\n"
            + ".##.# => .\n"
            + "#...# => #\n"
            + "##... => .\n"
            + "..##. => ."};
    }
}