package com.aoc.days2020.day24;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwentyFour extends DayBase {

    private static final String DAY_NR = "TwentyFour";

    public DayTwentyFour() {
        dayNr = DAY_NR;
        solution = new SolutionTwentyFour(DAY_NR);
        solution.setInput(Reader.readFromInput("2020/24.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwentyFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"sesenwnenenewseeswwswswwnenewsewsw\n"
            + "neeenesenwnwwswnenewnwwsewnenwseswesw\n"
            + "seswneswswsenwwnwse\n"
            + "nwnwneseeswswnenewneswwnewseswneseene\n"
            + "swweswneswnenwsewnwneneseenw\n"
            + "eesenwseswswnenwswnwnwsewwnwsene\n"
            + "sewnenenenesenwsewnenwwwse\n"
            + "wenwwweseeeweswwwnwwe\n"
            + "wsweesenenewnwwnwsenewsenwwsesesenwne\n"
            + "neeswseenwwswnwswswnw\n"
            + "nenwswwsewswnenenewsenwsenwnesesenew\n"
            + "enewnwewneswsewnwswenweswnenwsenwsw\n"
            + "sweneswneswneneenwnewenewwneswswnese\n"
            + "swwesenesewenwneswnwwneseswwne\n"
            + "enesenwswwswneneswsenwnewswseenwsese\n"
            + "wnwnesenesenenwwnenwsewesewsesesew\n"
            + "nenewswnwewswnenesenwnesewesw\n"
            + "eneswnwswnwsenenwnwnwwseeswneewsenese\n"
            + "neswnwewnwnwseenwseesewsenwsweewe\n"
            + "wseweeenwnesenwwwswnew"};
    }
}