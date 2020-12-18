package com.aoc.days2020.day17;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionSeventeen extends SolutionBase {

    SolutionSeventeen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final DimensionalEnergy DimensionalEnergy = new DimensionalEnergy(input, 3);
        for (int i = 0; i < 6; i++) {
            DimensionalEnergy.simulate();
        }
        setSolutionOne(DimensionalEnergy.countActiveCubes());
    }

    @Override
    protected void solvePartTwo() {
        final DimensionalEnergy dimensionalEnergy = new DimensionalEnergy(input, 4);
        for (int i = 0; i < 6; i++) {
            dimensionalEnergy.simulate();
        }
        setSolutionTwo(dimensionalEnergy.countActiveCubes());
    }


}