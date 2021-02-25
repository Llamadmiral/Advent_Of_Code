package com.aoc.days2020.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {

    private static int counter = 0;

    private final List<String> ingredients = new ArrayList<>();
    private final List<String> allergens = new ArrayList<>();
    private int id;


    Food(final String list) {
        final String[] split = list.substring(0, list.length() - 1).split(" \\(contains ");
        ingredients.addAll(Arrays.asList(split[0].split(" ")));
        allergens.addAll(Arrays.asList(split[1].split(", ")));
        this.id = counter++;
    }

    boolean hasIngredient(final String ingredient) {
        return this.ingredients.contains(ingredient);
    }

    boolean hasAllergen(final String allergen) {
        return this.allergens.contains(allergen);
    }

    List<String> getIngredients() {
        return ingredients;
    }

    List<String> getAllergens() {
        return allergens;
    }

    void removeIngredientAndAllergen(final String ingredient, final String allergen) {
        this.ingredients.remove(ingredient);
        this.allergens.remove(allergen);
    }

    @Override
    public String toString() {
        return "{\"Food\":{"
            + "                        \"ingredients\":" + ingredients
            + ",                         \"allergens\":" + allergens
            + "}}";
    }

    @Override
    public boolean equals(final Object o) {
        boolean equals = false;
        if (o instanceof Food) {
            final Food food = (Food) o;
            equals = this.id == food.id;
        }
        return equals;
    }
}
