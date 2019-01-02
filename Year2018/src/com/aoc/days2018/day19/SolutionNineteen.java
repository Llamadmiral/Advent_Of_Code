package com.aoc.days2018.day19;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Llamadmiral.
 */
class SolutionNineteen extends SolutionBase {

    private final List<Program> programs = new ArrayList<>();
    private int pointer = 0;
    private int boundedRegistry;
    private int[] registry = new int[]{
        0, 0, 0, 0, 0, 0
    };

    SolutionNineteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] rows = input.split("\n");
        boundedRegistry = Integer.parseInt(rows[0].substring(4));
        for (int i = 1; i < rows.length; i++) {
            programs.add(new Program(rows[i].split(" ")));
        }
    }

    @Override
    protected void solvePartOne() {
        runPrograms();
        setSolutionOne(registry[0]);
    }

    @Override
    protected void solvePartTwo() {
        registry = new int[]{1, 0, 0, 0, 0, 0};
        pointer = 0;
        runPrograms();
        setSolutionTwo(registry[0]);
    }

    private void innerLoop() {
        registry[0] = registry[2] + 1;
        registry[3] = registry[2];
        registry[4] = 1;
        registry[1]++;
        registry[boundedRegistry] = 11;
    }

    private void runPrograms() {
        while (pointer < programs.size()) {
            registry[boundedRegistry] = pointer;
            if (pointer == 3) {
                innerLoop();
            } else {
                compute(pointer);
            }
            pointer = registry[boundedRegistry];
            pointer++;
        }
    }


    private void compute(final int pointer) {
        final Program program = programs.get(pointer);
        registry[program.getInstruction()[2]] = compute(program);
    }

    private int compute(final Program program) {
        int result = 0;
        switch (program.getType()) {
            case "addr":
                result = Operation.addr(registry, program.getInstruction());
                break;
            case "addi":
                result = Operation.addi(registry, program.getInstruction());
                break;
            case "mulr":
                result = Operation.mulr(registry, program.getInstruction());
                break;
            case "muli":
                result = Operation.muli(registry, program.getInstruction());
                break;
            case "banr":
                result = Operation.banr(registry, program.getInstruction());
                break;
            case "bani":
                result = Operation.bani(registry, program.getInstruction());
                break;
            case "borr":
                result = Operation.borr(registry, program.getInstruction());
                break;
            case "bori":
                result = Operation.bori(registry, program.getInstruction());
                break;
            case "setr":
                result = Operation.setr(registry, program.getInstruction());
                break;
            case "seti":
                result = Operation.seti(registry, program.getInstruction());
                break;
            case "gtir":
                result = Operation.gtir(registry, program.getInstruction());
                break;
            case "gtri":
                result = Operation.gtri(registry, program.getInstruction());
                break;
            case "gtrr":
                result = Operation.gtrr(registry, program.getInstruction());
                break;
            case "eqir":
                result = Operation.eqir(registry, program.getInstruction());
                break;
            case "eqri":
                result = Operation.eqri(registry, program.getInstruction());
                break;
            case "eqrr":
                result = Operation.eqrr(registry, program.getInstruction());
                break;
            default:
                System.out.println("WHAT");
                break;
        }
        return result;
    }
}