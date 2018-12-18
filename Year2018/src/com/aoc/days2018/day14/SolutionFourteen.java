package com.aoc.days2018.day14;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionFourteen extends SolutionBase {

    private int numberOfRecipes;

    private Recipe elfOne;
    private Recipe elfTwo;
    private Recipe first;
    private int[] inputArray;

    SolutionFourteen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        for (int i = 0; i < numberOfRecipes + 10; i++) {
            createRecipe();
        }
        int recipesToPrint = 10;
        int recipesToBlock = numberOfRecipes;
        Recipe current = first;
        final StringBuilder builder = new StringBuilder();
        while (recipesToPrint != 0) {
            if (recipesToBlock == 0) {
                builder.append(current.getScore());
                recipesToPrint--;
            } else {
                recipesToBlock--;
            }
            current = current.getNext();
        }
        setSolutionOne(builder.toString());
    }

    @Override
    protected void solvePartTwo() {
        int i = 1;
        int matched = 0;
        Recipe current = first.getNext();
        final long firstId = first.getId();
        boolean found = false;
        while (!found) {
            while (!found) {
                if (firstId == current.getId()) {
                    current = current.getPrevious();
                    i--;
                    break;
                }
                int score = current.getScore();
                if (inputArray[matched] == score) {
                    matched++;
                } else {
                    if (inputArray[0] == score) {
                        matched = 1;
                    } else {
                        matched = 0;
                    }
                }
                current = current.getNext();
                i++;
                found = matched == inputArray.length;
            }
            //Apparently, its totally random if you have already generated the answer or not...
            if (!found) {
                for (long j = 0; j < 1000000 + inputArray.length + 1; j++) {
                    createRecipe();
                }
            }
        }
        setSolutionTwo(i - inputArray.length);
    }

    private void createRecipe() {
        int sum = elfOne.getScore() + elfTwo.getScore();
        if (sum > 9) {
            new Recipe(first.getPrevious(), sum / 10);
            new Recipe(first.getPrevious(), sum % 10);
        } else {
            new Recipe(first.getPrevious(), sum);
        }
        elfOne = elfOne.step(elfOne.getScore() + 1);
        elfTwo = elfTwo.step(elfTwo.getScore() + 1);
    }

    @Override
    public void init() {
        inputArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            inputArray[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        elfOne = new Recipe(null, 3);
        elfTwo = new Recipe(elfOne, 7);
        numberOfRecipes = Integer.parseInt(input);
        first = elfOne;
    }

}