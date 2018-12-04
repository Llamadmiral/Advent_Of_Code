package com.aoc.days2018.day03;

import com.aoc.solutionbase.SolutionBase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionThree extends SolutionBase {
    private int[][] fabric = new int[1000][1000];

    private Set<Claim> claims = new HashSet<>();

    SolutionThree(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        prepareInput();
        doOverlap();
        countOverlaps();
    }

    @Override
    protected void solvePartTwo() {
        for (final Claim claim : claims) {
            final boolean doesOverlap = checkOverlaps(claim);
            if (!doesOverlap) {
                setSolutionTwo(claim.getId());
                break;
            }
        }
    }

    private void prepareInput() {
        for (final String row : input.split("\n")) {
            claims.add(Claim.make(row));
        }
    }

    private void doOverlap() {
        for (final Claim claim : claims) {
            for (int j = claim.getX(); j < claim.getX() + claim.getWidth(); j++) {
                for (int i = claim.getY(); i < claim.getY() + claim.getHeight(); i++) {
                    fabric[i][j]++;
                }
            }
        }
    }

    private boolean checkOverlaps(final Claim claim) {
        int startX = claim.getX();
        int startY = claim.getY();
        int endX = startX + claim.getWidth();
        int endY = startY + claim.getHeight();
        boolean doesOverlap = false;
        for (final Claim otherClaim : claims) {
            if (claim.getId() != otherClaim.getId()) {
                doesOverlap = doOverlap(startX, startY,
                    endX, endY,
                    otherClaim.getX(), otherClaim.getY(),
                    otherClaim.getX() + otherClaim.getWidth(), otherClaim.getY() + otherClaim.getHeight());
            }
            if (doesOverlap) {
                break;
            }
        }
        return doesOverlap;
    }

    private boolean doOverlap(final int l1x, final int l1y, final int r1x, final int r1y, final int l2x, final int l2y, final int r2x, final int r2y) {
        return !(l1x >= r2x || l2x >= r1x) && !(l1y >= r2y || l2y >= r1y);
    }

    private void countOverlaps() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (fabric[i][j] > 1) {
                    sum++;
                }
            }
        }
        setSolutionOne(sum);
    }


}