package com.aoc.days2015.day13;

import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.SolutionHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionThirteen extends SolutionBase {

    private static final String ADAM = "Adam";

    private final Map<String, Map<String, Integer>> people = new HashMap<>();
    private final List<String> names = new ArrayList<>();

    SolutionThirteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll(" would ", " ").replaceAll(" happiness units by sitting next to ", " ");
        for (final String row : input.split("\n")) {
            final String[] parts = row.split(" ");
            final String gainer = parts[0];
            final String neighbour = parts[3].substring(0, parts[3].length() - 1);
            final int happiness = Integer.parseInt(parts[2]) * (parts[1].equals("gain") ? 1 : -1);
            if (!people.containsKey(gainer)) {
                people.put(gainer, new HashMap<>());
            }
            people.get(gainer).put(neighbour, happiness);
            if (!names.contains(gainer)) {
                names.add(gainer);
            }
            if (!names.contains(neighbour)) {
                names.add(neighbour);
            }
        }
    }

    @Override
    protected void solvePartOne() {
        final List<String[]> permutations = new ArrayList<>();
        final String[] startingArray = names.toArray(new String[]{});
        SolutionHelper.doPermutations(permutations, startingArray, new String[0]);
        int maxHappiness = calculateTotalHappiness(permutations);
        setSolutionOne(maxHappiness);
    }

    @Override
    protected void solvePartTwo() {
        final List<String[]> permutations = new ArrayList<>();
        for (final Map.Entry<String, Map<String, Integer>> entry : people.entrySet()) {
            entry.getValue().put(ADAM, 0);
        }
        final Map<String, Integer> apathyMap = new HashMap<>();
        people.put(ADAM, apathyMap);
        for (final String name : names) {
            apathyMap.put(name, 0);
        }
        names.add(ADAM);
        final String[] startingArray = names.toArray(new String[]{});
        SolutionHelper.doPermutations(permutations, startingArray, new String[0]);
        int maxHappiness = calculateTotalHappiness(permutations);
        setSolutionTwo(maxHappiness);
    }

    private int calculateTotalHappiness(final List<String[]> permutations) {
        int maxHappiness = 0;
        for (final String[] circles : permutations) {
            final int currentHappiness = calculateHappiness(circles);
            if (maxHappiness < currentHappiness) {
                maxHappiness = currentHappiness;
            }
        }
        return maxHappiness;
    }

    private int calculateHappiness(final String[] circle) {
        final int[] happinesses = new int[circle.length];
        for (int i = 0; i < circle.length; i++) {
            int before = i - 1 >= 0 ? i - 1 : circle.length - 1;
            int after = (i + 1) % circle.length;
            final Map<String, Integer> neighbours = people.get(circle[i]);
            happinesses[i] = neighbours.get(circle[before]) + neighbours.get(circle[after]);
        }
        int totalHappiness = 0;
        for (final int happiness : happinesses) {
            totalHappiness += happiness;
        }
        return totalHappiness;
    }

}