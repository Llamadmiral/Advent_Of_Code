package com.aoc.years.year2017.days.dayeight;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.log.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka
 */
class SolutionEight extends SolutionBase {

    private static final Logger LOG = new Logger();

    private static final Map<String, Integer> REGISTER = new HashMap<>();

    private Integer maxValue = 0;

    SolutionEight(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        fillRegister();
        setSolutionOne(REGISTER.values().stream().max(Integer::compareTo).orElse(0));
    }

    @Override
    protected void solvePartTwo() {
        setSolutionTwo(maxValue);
    }

    private void fillRegister() {
        final String[] rows = ((String) input).split("\n");
        for (final String row : rows) {
            final Instruction instruction = new Instruction(row);
            if (evaluateCondition(instruction)) {
                modifyRegistry(instruction);
            }
        }
    }

    private Integer getRegisterValue(final String registerName) {
        Integer value = 0;
        if (REGISTER.containsKey(registerName)) {
            value = REGISTER.get(registerName);
        } else {
            REGISTER.put(registerName, 0);
        }
        return value;
    }

    private void modifyRegistry(final Instruction instruction) {
        Integer newValue = getValueAfterCheck(getRegisterValue(instruction.getRegisterToModify()));
        if (instruction.getOperation().equals("inc")) {
            newValue += instruction.getAmount();
        } else {
            newValue -= instruction.getAmount();
        }
        REGISTER.put(instruction.getRegisterToModify(), newValue);
    }

    /**
     * There has to be a better way, lol.
     */
    private boolean evaluateCondition(final Instruction instruction) {
        boolean valuated = false;
        final Integer regValue = getValueAfterCheck(getRegisterValue(instruction.getConditionalRegisterName()));
        final Integer conditionalRegValue = getValueAfterCheck(instruction.getConditionalRegisterValue());
        switch (instruction.getCondition()) {
            case ">":
                valuated = regValue > conditionalRegValue;
                break;
            case "<":
                valuated = regValue < conditionalRegValue;
                break;
            case ">=":
                valuated = regValue >= conditionalRegValue;
                break;
            case "<=":
                valuated = regValue <= conditionalRegValue;
                break;
            case "==":
                valuated = regValue.equals(conditionalRegValue);
                break;
            case "!=":
                valuated = !regValue.equals(conditionalRegValue);
                break;
            default:
                LOG.log("Unkown condition: " + instruction.getCondition());
                break;
        }
        return valuated;
    }

    private Integer getValueAfterCheck(final Integer integer) {
        if (maxValue < integer) {
            maxValue = integer;
        }
        return integer;
    }

}
