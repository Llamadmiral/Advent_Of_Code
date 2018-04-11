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
    private int positionX = 1;
    private int positionY = 1;

    SolutionThirteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final String[] data = input.split("x");
        final String[] goals = data[1].split(",");
        int goalX = Integer.parseInt(goals[0]);
        int goalY = Integer.parseInt(goals[1]);
        this.setSolutionOne(getStepsTo(goalX, goalY));
    }

    @Override
    protected void solvePartTwo() {
        int reachablePlaces = 1;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (MazeTile.SPACE.equals(maze[i][j])) {
                    /*final Integer steps = getStepsTo(i, j);
                    if (steps != null && steps < 50) {
                        reachablePlaces++;
                        // System.out.println(i + "," + j);
                    }*/
                }
            }
        }
        setSolutionTwo(reachablePlaces);
    }

    private Integer getStepsTo(final int goalX, final int goalY) {
        generateMaze();
        boolean atGoal = false;
        maze[1][1] = MazeTile.WAS_THERE;
        path.add(new int[]{1, 1});
        positionX = 1;
        positionY = 1;
        Boolean couldProgress = true;
        while (!atGoal && couldProgress) {
            couldProgress = move();
            atGoal = positionX == goalX && positionY == goalY;
        }
        //reducePath();
        for (final int[] p : path) {
            System.out.println(p[0] + "," + p[1]);
        }
        final int steps = path.size();
        path.clear();
        return steps;
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
        final int favoriteNumber = Integer.parseInt(input.split("x")[0]);
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                maze[y][x] = getMazeTile(x * x + 3 * x + 2 * x * y + y + y * y + favoriteNumber);
            }
        }
    }

    private MazeTile getMazeTile(final int number) {
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

    private Boolean move() {
        boolean couldProgress = false;
        final int[] nextDirection = getNextDirection();
        if (nextDirection != null) {
            couldProgress = true;
            positionX = nextDirection[1];
            positionY = nextDirection[0];
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

    private int[] getNextDirection() {
        int[] nextDirection = null;
        for (int[] direction : DIRECTIONS) {
            final int newY = positionY + direction[0];
            final int newX = positionX + direction[1];
            if (checkRange(newX, newY) && MazeTile.SPACE.equals(maze[newY][newX])) {
                nextDirection = new int[]{newY, newX};
                //break;
            }
        }
        if (nextDirection == null && !path.isEmpty()) {
            nextDirection = path.remove(path.size() - 1);
        } else {
            path.add(new int[]{positionY, positionX});
        }
        maze[positionY][positionX] = MazeTile.WAS_THERE;
        return nextDirection;
    }

    private boolean checkRange(final int x, final int y) {
        return x > -1 && x < 50 && y > -1 && y < 50;
    }

    private enum MazeTile {
        SPACE,
        WALL,
        WAS_THERE
    }

}