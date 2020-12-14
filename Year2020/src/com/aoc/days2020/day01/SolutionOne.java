package com.aoc.days2020.day01;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

/**
 * @author Llamadmiral.
 */
class SolutionOne extends SolutionBase {

    private static final int FAULTY_EXPENSE_SUM = 2020;
    private int[] expenses;


    SolutionOne(final String day) {
        super(day);
    }

    @Override
    public void init() {
        expenses = SolutionHelper.inputToIntArray(input, "\n");
    }

    @Override
    protected void solvePartOne() {
        int faultyExpenseOne = 0;
        int faultyExpenseTwo = 0;
        boolean foundFaultyExpense = false;
        for (int i = 0; i < expenses.length; i++) {
            for (int j = 0; j < expenses.length; j++) {
                if (i != j && expenses[i] + expenses[j] == FAULTY_EXPENSE_SUM) {
                    faultyExpenseOne = expenses[i];
                    faultyExpenseTwo = expenses[j];
                    foundFaultyExpense = true;
                    break;
                }
            }
            if (foundFaultyExpense) {
                break;
            }
        }
        setSolutionOne(faultyExpenseOne * faultyExpenseTwo);
    }

    @Override
    protected void solvePartTwo() {
        int faultyExpenseOne = 0;
        int faultyExpenseTwo = 0;
        int faultyExpenseThree = 0;
        outerLoop:
        for (int i = 0; i < expenses.length; i++) {
            for (int j = 0; j < expenses.length; j++) {
                for (int k = 0; k < expenses.length; k++) {
                    if (i != j && i != k && j != k && expenses[k] + expenses[i] + expenses[j] == FAULTY_EXPENSE_SUM) {
                        faultyExpenseOne = expenses[i];
                        faultyExpenseTwo = expenses[j];
                        faultyExpenseThree = expenses[k];
                        break outerLoop;
                    }
                }
            }
        }
        setSolutionTwo(faultyExpenseOne * faultyExpenseTwo * faultyExpenseThree);
    }
}