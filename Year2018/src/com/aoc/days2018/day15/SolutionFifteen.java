package com.aoc.days2018.day15;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Llamadmiral.
 */
class SolutionFifteen extends SolutionBase {

    private static final String[] OP_NAMES = new String[]{
        "addr", "addi",
        "mulr", "muli",
        "banr", "bani",
        "borr", "bori",
        "setr", "seti",
        "gtir", "gtri", "gtrr",
        "eqir", "eqri", "eqrr"
    };
    private final int[] registry = new int[]{
        0, 0, 0, 0
    };

    private List<Sample> samples = new ArrayList<>();
    private Map<Integer, String> opcodes = new HashMap<>();
    private List<int[]> programs = new ArrayList<>();


    SolutionFifteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        final String[] row = input.split("\n");
        boolean firstPart = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals("")) {
                if (row[i + 1].equals("") && row[i + 2].equals("")) {
                    firstPart = true;
                }
            } else {
                if (!firstPart) {
                    samples.add(new Sample(row[i], row[i + 1], row[i + 2]));
                    i += 2;
                } else {
                    final String[] data = row[i].split(" ");
                    programs.add(new int[]{
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]),
                    });
                }
            }
        }
    }

    @Override
    protected void solvePartOne() {
        int sum = 0;
        for (final Sample sample : samples) {
            int matchingOpCOdes = 0;
            for (final String opName : OP_NAMES) {
                final int result = compute(opName, sample);
                if (result == sample.getAfter()[sample.getOperation()[3]]) {
                    matchingOpCOdes++;
                }
            }
            if (matchingOpCOdes >= 3) {
                sum++;
            }
        }
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        while (opcodes.size() != 16) {
            for (final Sample sample : samples) {
                int matchingCodes = 0;
                String onlyOpName = null;
                for (final String opName : OP_NAMES) {
                    if (!opcodes.containsValue(opName)) {
                        final int result = compute(opName, sample);
                        if (result == sample.getAfter()[sample.getOperation()[3]]) {
                            matchingCodes++;
                            onlyOpName = opName;
                        }
                    }
                }
                if (matchingCodes == 1) {
                    opcodes.put(sample.getOperation()[0], onlyOpName);
                }
            }
        }
        for (final int[] program : programs) {
            registry[program[3]] = compute(opcodes.get(program[0]), registry, program);
        }

        setSolutionTwo(registry[0]);
    }

    private int compute(final String operation, final Sample sample) {
        return compute(operation, sample.getBefore(), sample.getOperation());
    }

    private int compute(final String opName, final int[] before, final int[] operation) {
        int result = 0;
        switch (opName) {
            case "addr":
                result = Operation.addr(before, operation);
                break;
            case "addi":
                result = Operation.addi(before, operation);
                break;
            case "mulr":
                result = Operation.mulr(before, operation);
                break;
            case "muli":
                result = Operation.muli(before, operation);
                break;
            case "banr":
                result = Operation.banr(before, operation);
                break;
            case "bani":
                result = Operation.bani(before, operation);
                break;
            case "borr":
                result = Operation.borr(before, operation);
                break;
            case "bori":
                result = Operation.bori(before, operation);
                break;
            case "setr":
                result = Operation.setr(before, operation);
                break;
            case "seti":
                result = Operation.seti(before, operation);
                break;
            case "gtir":
                result = Operation.gtir(before, operation);
                break;
            case "gtri":
                result = Operation.gtri(before, operation);
                break;
            case "gtrr":
                result = Operation.gtrr(before, operation);
                break;
            case "eqir":
                result = Operation.eqir(before, operation);
                break;
            case "eqri":
                result = Operation.eqri(before, operation);
                break;
            case "eqrr":
                result = Operation.eqrr(before, operation);
                break;
            default:
                System.out.println("WHAT");
                break;
        }
        return result;
    }
}