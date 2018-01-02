package com.aoc.days.day20;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Part one is easy, part two is hard as hell. I know what I am supposed to do, but I lack the geometrical knowledge to implement that.
 *
 * @author maczaka.
 */
class SolutionTwenty extends SolutionBase {

    private final List<Particle> particles = new ArrayList<>();

    SolutionTwenty(final String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        int smallestAcc = particles.get(0).getManhattanAcceleration();
        int smallestAccId = 0;
        for (int i = 1; i < particles.size(); i++) {
            final Particle particle = particles.get(i);
            final int newSmallestAcc = particle.getManhattanAcceleration();
            if (newSmallestAcc < smallestAcc) {
                smallestAccId = particle.getId();
                smallestAcc = newSmallestAcc;
            }
        }
        setSolutionOne(smallestAccId);
    }

    @Override
    protected void solvePartTwo() {
        particles.clear();
        parseInput();
        for (int i = 0; i < 40; i++) {
            for (final Particle particle : particles) {
                if (!particle.isRemoved()) {
                    particle.update();
                }
            }
            removeCollidedParticles();
        }
        setSolutionTwo(getRemainingParticles());
    }

    private void removeCollidedParticles() {
        for (int i = 0; i < particles.size(); i++) {
            final Particle particle = particles.get(i);
            if (!particle.isRemoved()) {
                boolean collided = false;
                for (int j = 0; j < particles.size(); j++) {
                    final Particle otherParticle = particles.get(j);
                    if (i != j && !otherParticle.isRemoved() && otherParticle.getPositionEquals(particle)) {
                        otherParticle.remove();
                        collided = true;
                    }
                }
                if (collided) {
                    particle.remove();
                }
            }
        }
    }

    private void parseInput() {
        final String[] rows = ((String) input).split("\n");
        for (final String row : rows) {
            particles.add(new Particle(row));
        }
    }

    private int getRemainingParticles() {
        int remainingParticles = 0;
        for (int i = 0; i < particles.size(); i++) {
            if (!particles.get(i).isRemoved()) {
                remainingParticles++;
            }
        }
        return remainingParticles;
    }
}
