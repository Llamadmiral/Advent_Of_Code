package com.aoc.days2020.day21;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Llamadmiral.
 */
class SolutionTwentyOne extends SolutionBase {
    private final List<Food> foods = new ArrayList<>();
    private final Map<String, Integer> ingredientCounter = new HashMap<>();

    SolutionTwentyOne(final String day) {
        super(day);
    }

    @Override
    public void init() {
        for (final String row : input.split("\n")) {
            foods.add(new Food(row));
        }
    }

    @Override
    protected void solvePartOne() {
        final Set<String> allAllergens = new HashSet<>();
        for (final Food food : foods) {
            for (final String ingredient : food.getIngredients()) {
                ingredientCounter.merge(ingredient, 1, (a, b) -> a + b);
            }
            allAllergens.addAll(food.getAllergens());
        }

        while (!allAllergens.isEmpty()) {
            final Map<String, Map<String, Integer>> allergenIngredientFrequency = getAllergenIngredientFrequency();
            final String maxIngredient = getMostFrequentIngredient(ingredientCounter);
            final String maxAllergen = getMostFrequentAllergen(allergenIngredientFrequency, maxIngredient);
            allAllergens.remove(maxAllergen);
            for (final Food food : foods) {
                food.removeIngredientAndAllergen(maxIngredient, maxAllergen);
            }
            ingredientCounter.remove(maxIngredient);
        }

        int counter = 0;
        for (final Integer i : ingredientCounter.values()) {
            counter += i;
        }
        setSolutionOne(counter);
    }

    private Map<String, Map<String, Integer>> getAllergenIngredientFrequency() {
        final Map<String, Map<String, Integer>> allergenIngredientFrequency = new HashMap<>();
        for (final Food food : foods) {
            for (final String allergen : food.getAllergens()) {
                allergenIngredientFrequency.putIfAbsent(allergen, new HashMap<>());
                final Map<String, Integer> stringIntegerMap = allergenIngredientFrequency.get(allergen);
                for (final String ingredient : food.getIngredients()) {
                    stringIntegerMap.merge(ingredient, 1, (a, b) -> a + b);
                }
            }
        }
        return allergenIngredientFrequency;
    }

    private String getMostFrequentAllergen(final Map<String, Map<String, Integer>> allergenCounter, final String ingredient) {
        String maxAllergen = null;
        int maxAllergenCounter = 0;
        for (final Map.Entry<String, Map<String, Integer>> entry : allergenCounter.entrySet()) {
            final Integer counter = entry.getValue().get(ingredient);
            if (counter != null && counter > maxAllergenCounter) {
                maxAllergenCounter = counter;
                maxAllergen = entry.getKey();
            }
        }
        return maxAllergen;
    }

    private String getMostFrequentIngredient(final Map<String, Integer> ingredientCounter) {
        String maxIngredient = null;
        int maxIngredientCounter = 0;
        for (final Map.Entry<String, Integer> entry : ingredientCounter.entrySet()) {
            if (entry.getValue() > maxIngredientCounter) {
                maxIngredient = entry.getKey();
                maxIngredientCounter = entry.getValue();
            }
        }
        return maxIngredient;
    }

    @Override
    protected void solvePartTwo() {
        foods.clear();
        init();

        final Map<String, String> allergenIngredientForSure = new TreeMap<>();
        final Set<String> uniqueIngredients = new HashSet<>();
        for (final Food food : foods) {
            food.getIngredients().removeAll(ingredientCounter.keySet());
            uniqueIngredients.addAll(food.getIngredients());
        }
        while (!uniqueIngredients.isEmpty()) {
            final Map<String, Map<String, Integer>> allergenIngredientFrequency = getAllergenIngredientFrequency();
            for (final Map.Entry<String, Map<String, Integer>> entry : allergenIngredientFrequency.entrySet()) {
                final String mostFrequentIngredient = getMostFrequentIngredient(entry.getValue());
                final int maxCounter = entry.getValue().get(mostFrequentIngredient);
                boolean unique = true;
                for (final Map.Entry<String, Integer> ingredientEntry : entry.getValue().entrySet()) {
                    if (!ingredientEntry.getKey().equals(mostFrequentIngredient) && maxCounter == ingredientEntry.getValue()) {
                        unique = false;
                        break;
                    }
                }
                if (unique) {
                    uniqueIngredients.remove(mostFrequentIngredient);
                    allergenIngredientForSure.put(entry.getKey(), mostFrequentIngredient);
                    for (final Food food : foods) {
                        food.removeIngredientAndAllergen(mostFrequentIngredient, entry.getKey());
                    }
                }
            }
        }
        final StringBuilder builder = new StringBuilder();
        for (final Map.Entry<String, String> entry : allergenIngredientForSure.entrySet()) {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(entry.getValue());
        }
        setSolutionTwo(builder.toString());
    }
}