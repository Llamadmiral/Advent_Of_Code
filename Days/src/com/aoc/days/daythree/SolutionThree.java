package com.aoc.days.daythree;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.log.Logger;

import java.util.*;

/**
 * @author maczaka.
 */
public class SolutionThree extends SolutionBase {
    private static final Logger LOG = new Logger(SolutionThree.class);
    private static final Integer BASE_INPUT = 289326;
    private static final Map<Map.Entry<Integer, Integer>, Integer> MAP = new HashMap<>();
    private static final AbstractMap.SimpleEntry<Integer, Integer> STARTPOS = new AbstractMap.SimpleEntry<>(0, 0);
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
    private AbstractMap.SimpleEntry<Integer, Integer> position = STARTPOS;

    SolutionThree(final String day) {
        super(day);
        input = BASE_INPUT;
    }

    SolutionThree(final String day, final int input) {
        super(day);
        this.input = input;
    }

    @Override
    protected void solvePartOne() {
        setSolutionOne(getCurrentLevelForNumber((int) input));
    }

    @Override
    protected void solvePartTwo() {
        boolean found = false;
        while (!found) {
            if (checkIfCanTurn()) {
                direction = (direction + 1) % 4;
            }
            position = getNextPos();
            final Integer newFieldValue = gatherValuesFromSurroundingFields();
            if (newFieldValue <= BASE_INPUT) {
                MAP.put(position, newFieldValue);
            } else {
                found = true;
                setSolutionTwo(newFieldValue);
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

    //dont even ask about the default settings
    private Integer getCurrentLevelForNumber(final int number) {
        boolean found = false;
        int currentPos = 14;
        double currentLevel = 5;
        int jumpAmount = 3;
        int added = 1;
        int previousPos = 13;
        while (!found) {
            added++;
            previousPos = currentPos;
            currentLevel++;
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
        return calculateDistance(currentPos - 1, previousPos, number) + ((int) (Math.ceil((currentLevel) / 4)));
    }

    private Integer calculateDistance(final int endPos, final int prevPos, final int number) {
        int dist = (int) Math.floor((endPos - ((endPos - (prevPos - 1)) / 2.0)));
        return number > dist ? number - dist : dist - number;
    }

}
