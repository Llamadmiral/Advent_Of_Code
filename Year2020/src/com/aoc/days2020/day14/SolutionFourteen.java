package com.aoc.days2020.day14;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Llamadmiral.
 */
class SolutionFourteen extends SolutionBase {


    private List<Instruction> instructions = new ArrayList<>();
    private Map<Long, char[]> memory = new HashMap<>();


    SolutionFourteen(final String day) {
        super(day);
    }

    @Override
    public void init() {
        input = input.replaceAll("mem\\[", "");
        final String[] rows = input.split("\n");
        int i = 0;
        while (i < rows.length) {
            final String mask = rows[i].split(" = ")[1];
            final Instruction instruction = new Instruction(mask);
            i++;
            while (i < rows.length && !rows[i].startsWith("mask")) {
                final String[] parts = rows[i].split("] = ");
                instruction.put(parts[0], parts[1]);
                i++;
            }
            instructions.add(instruction);
        }
        //System.out.println(fromBits(instructions.get(0).getMaskedValue(0)));
    }

    @Override
    protected void solvePartOne() {
        for (final Instruction instruction : instructions) {
            performInstruction(instruction);
        }
        final long sum = getSumOfMemory();
        setSolutionOne(sum);
    }

    @Override
    protected void solvePartTwo() {
        memory.clear();
        for (final Instruction instruction : instructions) {
            for (int i = 0; i < instruction.size(); i++) {
                final char[] maskedAddress = maskAddress(instruction.getMask(), instruction.getAddress(i));
                final Set<char[]> addresses = new HashSet<>();
                buildAllAddresses(maskedAddress, "", 0, addresses);
                for (final char[] address : addresses) {
                    final long l = fromBits(address);
                    memory.put(l, instruction.getValue(i));
                }
            }
        }
        final long sum = getSumOfMemory();
        setSolutionTwo(sum);
    }

    private long getSumOfMemory() {
        long sum = 0;
        for (final char[] bits : memory.values()) {
            sum += fromBits(bits);
        }
        return sum;
    }

    private void performInstruction(final Instruction instruction) {
        for (int i = 0; i < instruction.size(); i++) {
            memory.put(instruction.getAddress(i), instruction.getMaskedValue(i));
        }
    }

    private long fromBits(final char[] bits) {
        long result = 0;
        for (int i = 0; i < bits.length; i++) {
            result += bits[bits.length - i - 1] == '1' ? Math.pow(2, i) : 0;
        }
        return result;
    }

    private void buildAllAddresses(final char[] bits, final String currentBits, final int index, final Set<char[]> addresses) {
        if (index == bits.length) {
            addresses.add(currentBits.toCharArray());
        } else {
            final char currentBit = bits[index];
            if (currentBit == 'X') {
                buildAllAddresses(bits, currentBits + '0', index + 1, addresses);
                buildAllAddresses(bits, currentBits + '1', index + 1, addresses);
            } else {
                buildAllAddresses(bits, currentBits + currentBit, index + 1, addresses);
            }
        }
    }

    private char[] maskAddress(final char[] mask, final long address) {
        final char[] result = new char[mask.length];
        final char[] bitAddress = Instruction.toBits(address);
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == '0') {
                result[i] = bitAddress[i];
            } else {
                result[i] = mask[i];
            }
        }
        return result;
    }

}