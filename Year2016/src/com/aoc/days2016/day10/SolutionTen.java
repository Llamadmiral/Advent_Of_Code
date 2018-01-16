package com.aoc.days2016.day10;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionTen extends SolutionBase {

    private static final Integer LOW_TO_LOOK_FOR = 17;
    private static final Integer HIGH_TO_LOOK_FOR = 61;
    private final List<Operation> operations = new ArrayList<>();
    private final Map<Integer, Bot> bots = new HashMap<>();
    private final Map<Integer, Integer> outputs = new HashMap<>();

    SolutionTen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        boolean hasBotThatCanGive = true;
        while (hasBotThatCanGive) {
            hasBotThatCanGive = update();
        }
    }

    private boolean update() {
        boolean hasBotThatCanGive = false;
        for (final Operation operation : operations) {
            final Bot bot = getBot(operation.getGiver());
            if (bot.canGive()) {
                hasBotThatCanGive = true;
                if (bot.hasNumbers(LOW_TO_LOOK_FOR, HIGH_TO_LOOK_FOR)) {
                    setSolutionOne(bot.getId());
                }
                if (operation.isLowToOutput()) {
                    outputs.put(operation.getLowTo(), bot.getLow());
                } else {
                    getBot(operation.getLowTo()).addValue(bot.getLow());
                }
                if (operation.isHighToOutput()) {
                    outputs.put(operation.getHighTo(), bot.getHigh());
                } else {
                    getBot(operation.getHighTo()).addValue(bot.getHigh());
                }
            }
        }
        return hasBotThatCanGive;
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(outputs.get(0) * outputs.get(1) * outputs.get(2));
    }

    private void parseInput() {
        for (final String row : input.split("\n")) {
            final String[] data = row.split(" ");
            if ("value".equals(data[0])) {
                final Bot bot = getBot(Integer.parseInt(data[5]));
                bot.addValue(Integer.parseInt(data[1]));
            } else {
                operations.add(new Operation(data));
            }
        }
    }

    private Bot getBot(final int id) {
        Bot bot = bots.get(id);
        if (bot == null) {
            bot = new Bot(id);
            bots.put(id, bot);
        }
        return bot;
    }

}