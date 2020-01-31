package com.aoc.days2018.day23;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyThree extends SolutionBase {

    private static final int THRESHOLD = 20;

    private static final Comparator<Bot> BOT_COMPARATOR = (o1, o2) -> {
        int result;
        final int xCompare = Integer.compare(o1.getX(), o2.getX());
        if (xCompare == 0) {
            final int yCompare = Integer.compare(o1.getY(), o2.getY());
            result = yCompare == 0 ? Integer.compare(o1.getZ(), o2.getZ()) : yCompare;
        } else {
            result = xCompare;
        }
        return result;
    };
    private final List<Bot> bots = new ArrayList<>();
    private int[] xList;
    private int[] yList;
    private int[] zList;

    SolutionTwentyThree(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        xList = new int[rows.length];
        yList = new int[rows.length];
        zList = new int[rows.length];
        for (int i = 0; i < rows.length; i++) {
            final Bot bot = new Bot(rows[i]);
            bots.add(bot);
            xList[i] = bot.getX();
            yList[i] = bot.getY();
            zList[i] = bot.getZ();
        }
        sort(xList);
        sort(yList);
        sort(zList);
    }

    @Override
    protected void solvePartOne() {
        final Bot strongestSignalBot = getStrongestSignalBot();
        final int botsInRange = getBotsInRange(strongestSignalBot);
        setSolutionOne(botsInRange);
    }

    @Override
    protected void solvePartTwo() {
        Cube cube = new Cube(xList[0], yList[0], zList[0], xList[xList.length - 1], yList[yList.length - 1], zList[zList.length - 1]);
        List<Cube> smallerCubes;
        while ((cube.getMaxX() - cube.getMinX()) * (cube.getMaxY() - cube.getMinY()) * (cube.getMaxZ() - cube.getMinZ()) != 1) {
            smallerCubes = createCubesBetweenPoints(cube);
            cube = getMostTouchedCube(smallerCubes);
        }
        setSolutionTwo(Math.abs(cube.getMaxX()) + Math.abs(cube.getMaxY()) + Math.abs(cube.getMaxZ()));
        System.out.println(cube);
    }

    private List<Cube> createCubesBetweenPoints(final Cube cube) {
        final List<Cube> cubes = new ArrayList<>();
        final int[] middle = new int[]{(cube.getMaxX() + cube.getMinX()) / 2,
            (cube.getMaxY() + cube.getMinY()) / 2,
            (cube.getMaxZ() + cube.getMinZ()) / 2};
        final Cube cube1 = new Cube(cube.getMinX(), cube.getMinY(), cube.getMinZ(), middle[0], middle[1], middle[2]);
        final Cube cube2 = new Cube(middle[0], middle[1], middle[2], cube.getMaxX(), cube.getMaxY(), cube.getMaxZ());
        final Cube cube3 = new Cube(cube.getMinX(), cube.getMinY(), middle[2], middle[0], middle[1], cube.getMaxZ());
        final Cube cube4 = new Cube(middle[0], cube.getMinY(), middle[2], cube.getMaxX(), middle[1], cube.getMaxZ());
        final Cube cube5 = new Cube(cube.getMinX(), middle[1], cube.getMinZ(), middle[0], cube.getMaxY(), middle[2]);
        final Cube cube6 = new Cube(middle[0], cube.getMinY(), cube.getMinZ(), cube.getMaxX(), middle[1], middle[2]);
        final Cube cube7 = new Cube(cube.getMinX(), middle[1], middle[2], middle[0], cube.getMaxY(), cube.getMaxZ());
        final Cube cube8 = new Cube(middle[0], middle[1], cube.getMinZ(), cube.getMaxX(), cube.getMaxY(), middle[2]);
        cubes.add(cube1);
        cubes.add(cube2);
        cubes.add(cube3);
        cubes.add(cube4);
        cubes.add(cube5);
        cubes.add(cube6);
        cubes.add(cube7);
        cubes.add(cube8);
        return cubes;
    }

    private Cube getMostTouchedCube(final List<Cube> cubes) {
        final Map<Cube, Integer> intersectingMap = new HashMap<>();
        for (final Cube cube : cubes) {
            int count = 0;
            for (final Bot bot : bots) {
                if (getDistance(cube, bot) <= bot.getR()) {
                    count++;
                }
            }
            intersectingMap.put(cube, count);
        }
        return getClosestAndMaxCube(intersectingMap);
    }

    private Cube getClosestAndMaxCube(final Map<Cube, Integer> intersectingMap) {
        final int maxTouch = max(intersectingMap.values());
        Cube maxCube = null;
        int minDistance = 0;
        for (final Map.Entry<Cube, Integer> entry : intersectingMap.entrySet()) {
            if (maxTouch == entry.getValue()) {
                final Cube cube = entry.getKey();
                final int origoDistance = Math.abs(cube.getMaxX()) + Math.abs(cube.getMaxY()) + Math.abs(cube.getMaxZ());
                if (maxCube == null || origoDistance < minDistance) {
                    minDistance = origoDistance;
                    maxCube = cube;
                }
            }
        }
        return maxCube;
    }

    private int getDistance(final Cube cube, final Bot bot) {
        return (dist(bot.getX(), bot.getY(), bot.getZ(), cube.getMinX(), cube.getMinY(), cube.getMinZ())
            + dist(bot.getX(), bot.getY(), bot.getZ(), cube.getMaxX(), cube.getMaxY(), cube.getMaxZ())
            - dist(cube.getMinX(), cube.getMinY(), cube.getMinZ(), cube.getMaxX(), cube.getMaxY(), cube.getMaxZ())) / 2;
    }

    private int dist(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1) + Math.abs(z2 - z1);
    }

    private int getBotsInRange(final Bot strongestSignalBot) {
        int count = 0;
        for (final Bot bot : bots) {
            if (getDistance(bot, strongestSignalBot) <= strongestSignalBot.getR()) {
                count++;
            }
        }
        return count;
    }

    private int getDistance(final Bot bot1, final Bot bot2) {
        return Math.abs(bot1.getX() - bot2.getX()) + Math.abs(bot1.getY() - bot2.getY()) + Math.abs(bot1.getZ() - bot2.getZ());
    }

    private int getDistance(final Bot bot, final int x, final int y, final int z) {
        return Math.abs(bot.getX() - x) + Math.abs(bot.getY() - y) + Math.abs(bot.getZ() - z);
    }

    private Bot getStrongestSignalBot() {
        Bot strongestSignalBot = null;
        for (final Bot bot : bots) {
            if (strongestSignalBot == null || bot.getR() > strongestSignalBot.getR()) {
                strongestSignalBot = bot;
            }
        }
        return strongestSignalBot;
    }

    private void sort(final int[] array) {
        int i = 1;
        while (i < array.length) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j);
                j--;
            }
            i++;
        }
    }

    private void swap(final int[] array, final int j) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }

    private int max(final int... list) {
        int result = list[0];
        if (list.length > 1) {
            for (int i = 1; i < list.length; i++) {
                if (result < list[i]) {
                    result = list[i];
                }
            }
        }
        return result;
    }

    private int max(final Collection<Integer> integers) {
        int result = Integer.MIN_VALUE;
        for (final Integer integer : integers) {
            if (result < integer) {
                result = integer;
            }
        }
        return result;
    }

}