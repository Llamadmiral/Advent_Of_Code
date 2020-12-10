package com.aoc.days2015.day21;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyOne extends SolutionBase {

    private static final Item DUMMY_ITEM = new Item("Dummy", 0, 0, 0);

    private Contestant hero = new Contestant("Hero", 100, 0, 0);
    private Contestant boss = new Contestant("Boss", 100, 2, 8);

    private List<Item> weapons = new ArrayList<>();
    private List<Item> armours = new ArrayList<>();
    private List<Item> rings = new ArrayList<>();

    SolutionTwentyOne(final String day) {
        super(day);
    }

    @Override
    public void init() {
        armours.add(DUMMY_ITEM);
        rings.add(DUMMY_ITEM);

        input = input.replaceAll(" +", " ");
        final String[] rows = input.split("\n");
        int i = 1;
        while (!rows[i].startsWith("Armor")) {
            initItems(rows[i], weapons);
            i++;
        }
        i++;
        while (!rows[i].startsWith("Rings")) {
            initItems(rows[i], armours);
            i++;
        }
        i++;
        while (i < rows.length) {
            initItems(rows[i], rings);
            i++;
        }
    }

    private void initItems(final String row, final List<Item> items) {
        if (!row.isEmpty()) {
            final String[] parts = row.split(" ");
            items.add(new Item(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3])));
        }
    }

    @Override
    protected void solvePartOne() {
        final int[] combinations = new int[4];
        increment(combinations);
        int minimalCostToWin = 0;
        int maximumCostToLose = 0;
        while (!allZero(combinations)) {
            final List<Item> items = buyItems(combinations);
            final boolean playerWon = wouldPlayerWin(items);
            final int cost = getCostOfItems(items);
            if (playerWon) {
                if (minimalCostToWin == 0 || minimalCostToWin > cost) {
                    minimalCostToWin = cost;
                }
            } else {
                if (maximumCostToLose < cost) {
                    maximumCostToLose = cost;
                }
            }
            increment(combinations);
        }
        setSolutionOne(minimalCostToWin);
        setSolutionTwo(maximumCostToLose);
        //testFight();
    }

    @Override
    protected void solvePartTwo() {
    }

    private void testFight() {
        final List<Item> items = new ArrayList<>();
        items.add(armours.get(3));
        items.add(rings.get(3));
        items.add(rings.get(6));
        final boolean b = wouldPlayerWin(items);
        System.out.println(items);
        System.out.println(b);
        System.out.println(getCostOfItems(items));
    }

    private int getCostOfItems(final List<Item> items) {
        int cost = 0;
        for (final Item item : items) {
            cost += item.getCost();
        }
        return cost;
    }

    private boolean allZero(final int[] combinations) {
        boolean allZero = true;
        for (int i = combinations.length - 1; i >= 0; i--) {
            if (combinations[i] != 0) {
                allZero = false;
                break;
            }
        }
        return allZero;
    }

    private boolean wouldPlayerWin(final List<Item> items) {
        hero.reset();
        boss.reset();
        for (final Item item : items) {
            hero.applyItem(item);
        }
        boolean playerRound = true;
        while (hero.getHealthPoint() > 0 && boss.getHealthPoint() > 0) {
            if (playerRound) {
                boss.attackedBy(hero);
            } else {
                hero.attackedBy(boss);
            }
            playerRound = !playerRound;
        }
        return !playerRound;
    }

    private List<Item> buyItems(final int[] combinations) {
        final List<Item> boughtItems = new ArrayList<>();
        buyItem(combinations[3], weapons, boughtItems);
        buyItem(combinations[2], armours, boughtItems);
        buyItem(combinations[1], rings, boughtItems);
        buyItem(combinations[0], rings, boughtItems);
        return boughtItems;
    }

    private void buyItem(final int id, final List<Item> available, final List<Item> bought) {
        final Item item = available.get(id);
        if (!DUMMY_ITEM.equals(item)) {
            bought.add(item);
        }
    }

    private void increment(final int[] combinations) {
        int r = 1;
        for (int i = combinations.length - 1; i >= 0; i--) {
            combinations[i] += r;
            boolean rollOver = false;
            switch (i) {
                case 3:
                    rollOver = combinations[i] > weapons.size() - 1;
                    break;
                case 2:
                    rollOver = combinations[i] > armours.size() - 1;
                    break;
                case 1:
                    if (combinations[1] != 0 && combinations[1] == combinations[0]) {
                        combinations[1]++;
                    }
                case 0:
                    rollOver = combinations[i] > rings.size() - 1;
                    break;
            }
            if (rollOver) {
                combinations[i] = 0;
            } else {
                break;
            }
        }
    }
}