package com.aoc.days2020.day17;

import com.aoc.solutionbase.SolutionBase;

/**
 * @author Llamadmiral.
 */
class SolutionSeventeen extends SolutionBase {

    //TODO: Rework this with a single solution.

    SolutionSeventeen(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        final ThreeDimensionalEnergy threeDimensionalEnergy = new ThreeDimensionalEnergy(input);
        for (int i = 0; i < 6; i++) {
            threeDimensionalEnergy.simulate();
        }
        setSolutionOne(threeDimensionalEnergy.countActiveCubes());
    }

    @Override
    protected void solvePartTwo() {
        final FourDimensionalEnergy fourDimensionalEnergy = new FourDimensionalEnergy(input);
        for (int i = 0; i < 6; i++) {
            fourDimensionalEnergy.simulate();
        }
        setSolutionTwo(fourDimensionalEnergy.countActiveCubes());
    }


}