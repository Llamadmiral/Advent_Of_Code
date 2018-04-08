package com.aoc.days2016.day15;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionFifteen extends SolutionBase {

    private List<Disk> disks = new ArrayList<>();

    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        for (final String row : input.split("\n")) {
            disks.add(new Disk(row));
        }
        boolean foundCorrectTIme = false;
        int timeWaited = -1;
        while (!foundCorrectTIme) {
            timeWaited++;
            foundCorrectTIme = doFallLogic(timeWaited);
        }
        this.setSolutionOne(timeWaited);
    }

    @Override
    protected void solvePartTwo() {
        boolean foundCorrectTIme = false;
        disks.add(new Disk("Disc #7 has 11 positions; at time=0, it is at position 0."));
        int timeWaited = -1;
        while (!foundCorrectTIme) {
            timeWaited++;
            foundCorrectTIme = doFallLogic(timeWaited);
        }
        this.setSolutionTwo(timeWaited);
    }


    private boolean doFallLogic(final int timeWaited) {
        int currentTime = timeWaited;
        boolean couldFallThrough = true;
        for (final Disk disk : disks) {
            currentTime++;
            final int currentPosition = (disk.getStartingPosition() + currentTime) % disk.getNumberOfPositions();
            if (currentPosition != 0) {
                couldFallThrough = false;
                break;
            }
        }
        return couldFallThrough;
    }

    private static class Disk {
        private int id;
        private int numberOfPositions;
        private int startingPosition;

        Disk(final String row) {
            final String[] data = row.split(" ");
            this.id = Integer.parseInt(data[1].substring(1, data[1].length()));
            this.numberOfPositions = Integer.parseInt(data[3]);
            this.startingPosition = Integer.parseInt(data[11].substring(0, data[11].length() - 1));
        }

        int getId() {
            return id;
        }

        int getNumberOfPositions() {
            return numberOfPositions;
        }

        public int getStartingPosition() {
            return startingPosition;
        }
    }

}