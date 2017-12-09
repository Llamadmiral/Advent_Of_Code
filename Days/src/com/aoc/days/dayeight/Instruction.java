package com.aoc.days.dayeight;

/**
 * There is really no need for a different class for this data model,
 * but I hate String arrays representing a model.
 *
 * @author maczaka
 */
class Instruction {
    private String registerToModify;
    private String operation;
    private Integer amount;
    private String conditionalRegisterName;
    private String condition;
    private Integer conditionalRegisterValue;

    Instruction(final String row) {
        final String[] data = row.split(" ");
        registerToModify = data[0];
        operation = data[1];
        amount = Integer.parseInt(data[2]);
        conditionalRegisterName = data[4];
        condition = data[5];
        conditionalRegisterValue = Integer.parseInt(data[6]);
    }

    public String getRegisterToModify() {
        return registerToModify;
    }

    public String getOperation() {
        return operation;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getConditionalRegisterName() {
        return conditionalRegisterName;
    }

    public String getCondition() {
        return condition;
    }

    public Integer getConditionalRegisterValue() {
        return conditionalRegisterValue;
    }
}
