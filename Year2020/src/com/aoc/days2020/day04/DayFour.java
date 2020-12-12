package com.aoc.days2020.day04;

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
        solution.setInput(Reader.readFromInput("2020/4.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionFour(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n"
            + "hcl:#623a2f\n"
            + "\n"
            + "eyr:2029 ecl:blu cid:129 byr:1989\n"
            + "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n"
            + "\n"
            + "hcl:#888785\n"
            + "hgt:164cm byr:2001 iyr:2015 cid:88\n"
            + "pid:545766238 ecl:hzl\n"
            + "eyr:2022\n"
            + "\n"
            + "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"};
    }
}