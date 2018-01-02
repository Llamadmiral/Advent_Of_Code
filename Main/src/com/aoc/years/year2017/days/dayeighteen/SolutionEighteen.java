package com.aoc.years.year2017.days.dayeighteen;

import com.aoc.solutionbase.SolutionBase;

/**
 * How the hell does this even works.
 *
 * @author maczaka.
 */
class SolutionEighteen extends SolutionBase {


    SolutionEighteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final Program program = new Program((String) input, 0);
        program.solvePartOne();
        setSolutionOne(program.getMessagesSent());
    }

    @Override
    protected void solvePartTwo() {
        final Program programZero = new Program((String) input, 0);
        final Program programOne = new Program((String) input, 1);
        programZero.setSibling(programOne);
        programOne.setSibling(programZero);
        programZero.setPartTwo(true);
        programOne.setPartTwo(true);
        boolean over = false;
        while (!over) {
            programZero.update();
            programOne.update();
            if (programOne.inDeadlockOrTerminated()) {
                over = true;
            } else {
                if (programZero.isWaitingForInput()) {
                    programOne.update();
                }
                if (programOne.isWaitingForInput()) {
                    programZero.update();
                }
            }
        }
        setSolutionTwo(programOne.getMessagesSent());
    }


}
