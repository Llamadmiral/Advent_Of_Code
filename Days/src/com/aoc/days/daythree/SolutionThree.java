package com.aoc.days.daythree;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.log.Logger;

import java.util.*;

/**
 * Since solving part one takes a gazillion amount of seconds because the length of the map,
 * I decided to use a different solution, albeit I do not like it.
 *
 * @author Llamadmiral.
 */
class SolutionThree extends SolutionBase {
    private static final Logger LOG = new Logger(SolutionThree.class);
    private static final Map<Map.Entry<Integer, Integer>, Integer> MAP = new HashMap<>();

    //dont even mention it
    private static final List<Integer[]> SURROUNDING_FIELDS = new ArrayList<>();

    static {
        MAP.put(new AbstractMap.SimpleEntry<>(0, 0), 1);

        SURROUNDING_FIELDS.add(new Integer[]{0, 1});
        SURROUNDING_FIELDS.add(new Integer[]{0, -1});
        SURROUNDING_FIELDS.add(new Integer[]{1, 1});
        SURROUNDING_FIELDS.add(new Integer[]{1, 0});
        SURROUNDING_FIELDS.add(new Integer[]{1, -1});
        SURROUNDING_FIELDS.add(new Integer[]{-1, -1});
        SURROUNDING_FIELDS.add(new Integer[]{-1, 0});
        SURROUNDING_FIELDS.add(new Integer[]{-1, 1});
    }

    private Integer direction = 0;
    private Integer steps = 1;
    private AbstractMap.SimpleEntry<Integer, Integer> position = new AbstractMap.SimpleEntry<>(0, 0);


    SolutionThree(final String day) {
        super(day);
    }


    @Override
    protected void solvePartOne() {
        setSolutionOne(getFullDistance((Integer) input));
    }

    @Override
    protected void solvePartTwo() {
        MAP.clear();
        MAP.put(new AbstractMap.SimpleEntry<>(0, 0), 1);
        position = new AbstractMap.SimpleEntry<>(0, 0);
        step(true);
    }

    private void step(final boolean partTwo) {
        boolean found = false;
        while (!found) {
            if (checkIfCanTurn()) {
                direction = (direction + 1) % 4;
            }
            position = getNextPos();
            if (partTwo) {
                final Integer newFieldValue = gatherValuesFromSurroundingFields();
                if (newFieldValue <= (Integer) input) {
                    MAP.put(position, newFieldValue);
                } else {
                    found = true;
                    setSolutionTwo(newFieldValue);
                }
            } else {
                steps++;
                if (!steps.equals(input)) {
                    MAP.put(position, steps);
                } else {
                    found = true;
                    setSolutionOne(Math.abs(position.getKey()) + Math.abs(position.getValue()));
                }
            }
        }
    }

    //hardcore duplication, but hey, what can you do
    private boolean checkIfCanTurn() {
        AbstractMap.SimpleEntry checkCoord = null;
        switch (direction) {
            case 0:
                checkCoord = new AbstractMap.SimpleEntry<>(position.getKey() + 1, position.getValue());
                break;
            case 1:
                checkCoord = new AbstractMap.SimpleEntry<>(position.getKey(), position.getValue() + 1);
                break;
            case 2:
                checkCoord = new AbstractMap.SimpleEntry<>(position.getKey() - 1, position.getValue());
                break;
            case 3:
                checkCoord = new AbstractMap.SimpleEntry<>(position.getKey(), position.getValue() - 1);
                break;
            default:
                LOG.log("Don't know where to go: " + direction);
        }
        return !MAP.containsKey(checkCoord);
    }

    private AbstractMap.SimpleEntry<Integer, Integer> getNextPos() {
        AbstractMap.SimpleEntry<Integer, Integer> nextPos = null;
        switch (direction) {
            case 0:
                nextPos = new AbstractMap.SimpleEntry<>(position.getKey(), position.getValue() - 1);
                break;
            case 1:
                nextPos = new AbstractMap.SimpleEntry<>(position.getKey() + 1, position.getValue());
                break;
            case 2:
                nextPos = new AbstractMap.SimpleEntry<>(position.getKey(), position.getValue() + 1);
                break;
            case 3:
                nextPos = new AbstractMap.SimpleEntry<>(position.getKey() - 1, position.getValue());
                break;
            default:
                LOG.log("Don't know where to go! " + direction);
        }
        return nextPos;
    }

    private Integer gatherValuesFromSurroundingFields() {
        Integer sumOfFields = 0;
        for (final Integer[] fieldCoords : SURROUNDING_FIELDS) {
            sumOfFields += getValueFromMap(new Integer[]{
                    fieldCoords[0] + position.getKey(),
                    fieldCoords[1] + position.getValue()
            });
        }
        return sumOfFields;
    }

    private Integer getValueFromMap(final Integer[] currentPosition) {
        Integer value = MAP.get(new AbstractMap.SimpleEntry<>(currentPosition[0], currentPosition[1]));
        return value == null ? 0 : value;
    }

    /**
     * Don't even ask about the default settings
     * Basically, what I am doing is jumping corner to corner, and see
     * if my number is in between the last corner and the current one, and if it is,
     * I calculate the distance based on the amount of jumps / 4. How the hell did I come up with this formula
     * is beyond me.
     */

    private Integer getFullDistance(final int number) {
        boolean found = false;
        int currentPos = 14;
        double jumps = 5;
        int jumpAmount = 3;
        int added = 1;
        int previousPos = 13;
        while (!found) {
            added++;
            previousPos = currentPos;
            jumps++;
            if (added == 2) {
                added = 0;
                jumpAmount++;
                currentPos += jumpAmount;
            } else {
                currentPos += jumpAmount;
            }
            if (previousPos <= number && currentPos > number) {
                found = true;
            }
        }
        return calculateDistance(currentPos - 1, previousPos, number) + ((int) (Math.ceil((jumps) / 4)));
    }

    private Integer calculateDistance(final int endPos, final int prevPos, final int number) {
        int dist = (int) Math.floor((endPos - ((endPos - (prevPos - 1)) / 2.0)));
        return number > dist ? number - dist : dist - number;
    }

}
