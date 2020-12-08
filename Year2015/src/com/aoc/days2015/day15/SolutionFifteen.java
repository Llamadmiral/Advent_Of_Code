package com.aoc.days2015.day15;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionFifteen extends SolutionBase {

    private int[][] ingredients;
    private int bestCookie;
    private int bestDietCookie;

    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll(":", " ").replaceAll(" capacity ", "")
            .replaceAll(", durability ", " ")
            .replaceAll(", flavor ", " ")
            .replaceAll(", texture ", " ")
            .replaceAll(", calories ", " ");
        final String[] rows = input.split("\n");
        ingredients = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            final String row = rows[i];
            final String[] parts = row.split(" ");
            ingredients[i] = new int[]{Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3]),
                Integer.parseInt(parts[4]),
                Integer.parseInt(parts[5])};
        }
    }

    @Override
    protected void solvePartOne() {
        findBestCookie();
        setSolutionOne(bestCookie);
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(bestDietCookie);
    }

    private void findBestCookie() {
        final int[] amounts = new int[ingredients.length];
        int maxScore = 0;
        while (amounts[0] != 100) {
            int sum = increment(amounts);
            while (sum != 100) {
                sum = increment(amounts);
            }
            int score = calculateCookieScore(amounts);
            if (maxScore < score) {
                maxScore = score;
            }
        }
    }

    private int calculateCookieScore(final int[] amounts) {
        final int[] scoreParts = new int[5];
        for (int i = 0; i < amounts.length; i++) {
            final int amount = amounts[i];
            scoreParts[0] += ingredients[i][0] * amount;
            scoreParts[1] += ingredients[i][1] * amount;
            scoreParts[2] += ingredients[i][2] * amount;
            scoreParts[3] += ingredients[i][3] * amount;
            scoreParts[4] += ingredients[i][4] * amount;
        }
        int sum = 1;
        for (int i = 0; i < scoreParts.length - 1; i++) {
            final int scorePart = scoreParts[i];
            if (scorePart < 0) {
                sum = 0;
                break;
            }
            sum *= scorePart;
        }
        if (bestCookie < sum) {
            bestCookie = sum;
        }
        if (scoreParts[4] == 500 && bestDietCookie < sum) {
            bestDietCookie = sum;
        }
        return sum;
    }

    private int increment(final int[] amounts) {
        int r = 1;
        int sum = 0;
        for (int i = amounts.length - 1; i >= 0; i--) {
            amounts[i] += r;
            if (amounts[i] > 100) {
                amounts[i] = 0;
                r = 1;
            } else {
                r = 0;
            }
            sum += amounts[i];
        }
        return sum;
    }
}