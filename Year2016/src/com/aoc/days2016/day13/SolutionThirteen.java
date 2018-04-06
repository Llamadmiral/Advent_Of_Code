package com.aoc.days2016.day13;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.log.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * flags:
 * 0: space
 * 1: wall
 * -1: crossroad
 * 2: was there
 *
 * @author Llamadmiral.
 */
class SolutionThirteen extends SolutionBase {

    private static final int[][] DIRECTIONS = new int[][]{
        new int[]{-1, 0}, //0: north
        new int[]{1, 0}, //1: south
        new int[]{0, -1}, //2: west
        new int[]{0, 1} //3: east
    };
    private static final Logger LOG = new Logger();
    private final MazeTile[][] maze = new MazeTile[50][50];
    private final List<int[]> path = new ArrayList<>();
    private final List<int[]> reachablePlaces = new ArrayList<>();
    private int inp;
    private int goalX;
    private int goalY;
    private int positionX = 1;
    private int positionY = 1;

    SolutionThirteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final String[] data = input.split("x");
        inp = Integer.parseInt(data[0]);
        final String[] goals = data[1].split(",");
        goalX = Integer.parseInt(goals[0]);
        goalY = Integer.parseInt(goals[1]);
        generateMaze();
        boolean atGoal = false;
        maze[1][1] = MazeTile.WAS_THERE;
        path.add(new int[]{1, 1});
        boolean fallingBack = false;
        while (!atGoal) {
            fallingBack = move(fallingBack);
            atGoal = positionX == goalX && positionY == goalY;
        }
        reducePath();
        this.setSolutionOne(path.size());
    }

    @Override
    protected void solvePartTwo() {
        generateMaze();
        path.clear();
        positionX = 0;
        positionY = 0;
        maze[1][1] = MazeTile.WAS_THERE;
        path.add(new int[]{1, 1});
        boolean fallingBack = false;
        while (path.size() > 0 || getNextDirection() != null) {
            fallingBack = move(fallingBack);
            final int[] currentPos = new int[]{positionY, positionX};
            reachablePlaces.add(currentPos);
            if (path.size() > 50) {
                reducePath();
                fallingBack = path.size() > 50;
            }
        }
        reduceReachablePlaces(reachablePlaces);
        setSolutionTwo(reachablePlaces.size());
        for(final int[] row: reachablePlaces){
            System.out.println(row[0] + "," + row[1]);
        }
    }

    private void reduceReachablePlaces(final List<int[]> aReachablePlaces) {
        final List<int[]> uniquePlaces = new ArrayList<>();
        for (final int[] place : aReachablePlaces) {
            boolean contains = false;
            for (final int[] uniquePlace : uniquePlaces) {
                contains = uniquePlace[0] == place[0] && uniquePlace[1] == place[1];
            }
            if (!contains) {
                uniquePlaces.add(place);
            }
        }
        aReachablePlaces.clear();
        aReachablePlaces.addAll(uniquePlaces);
    }

    private void generateMaze() {
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                maze[y][x] = isBinaryEven(x * x + 3 * x + 2 * x * y + y + y * y + inp);
            }
        }
    }

    private MazeTile isBinaryEven(final int number) {
        int sumOfIndividualBits = 0;
        int r;
        int n = number;
        while (n > 0) {
            r = n % 2 == 0 ? 0 : 1;
            n = n / 2;
            sumOfIndividualBits += r;
        }
        return sumOfIndividualBits % 2 == 0 ? MazeTile.SPACE : MazeTile.WALL;
    }

    private boolean move(final boolean fallingBack) {
        boolean couldProgress = fallingBack;
        final Integer nextDirection = getNextDirection();
        if (nextDirection != null) {
            if (fallingBack) {
                path.add(new int[]{positionY, positionX});
                couldProgress = false;
            }
            positionX += DIRECTIONS[nextDirection][1];
            positionY += DIRECTIONS[nextDirection][0];
            maze[positionY][positionX] = MazeTile.WAS_THERE;
            path.add(new int[]{positionY, positionX});
        } else {
            couldProgress = true;
            final int[] lastPlace = path.remove(path.size() - 1);
            positionX = lastPlace[1];
            positionY = lastPlace[0];
        }
        return couldProgress;
    }

    private void reducePath() {
        final List<int[]> reducedPath = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            final int[] currentPlace = path.get(i);
            for (int j = path.size() - 1; j >= i + 2; j--) {
                final int[] nextPlace = path.get(j);
                if (Math.abs(currentPlace[0] - nextPlace[0]) + Math.abs(currentPlace[1] - nextPlace[1]) == 1) {
                    i = j - 1;
                    break;
                }
            }
            reducedPath.add(currentPlace);
        }
        path.clear();
        path.addAll(reducedPath);
    }

    private Integer getNextDirection() {
        Integer nextDirection = null;
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int[] direction = DIRECTIONS[i];
            final int newY = positionY + direction[0];
            final int newX = positionX + direction[1];
            if (newY > -1 && newX > -1) {
                if (newY < 50 && newX < 50) {
                    if (MazeTile.SPACE.equals(maze[newY][newX])) {
                        nextDirection = i;
                    }
                } else {
                    LOG.log("Trying to step out of maze...");
                }
            }
        }
        return nextDirection;
    }

    private enum MazeTile {
        SPACE,
        WALL,
        WAS_THERE
    }

}