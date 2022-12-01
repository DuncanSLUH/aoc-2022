package com.duncan.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 extends Solution {

    private final ArrayList<Integer> elves;

    public Day01() {
        super("day01.txt");

        elves = new ArrayList<>();
        Scanner scanner = this.getScanner();
        int elf = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                elves.add(elf);
                elf = 0;
            } else {
                elf += Integer.parseInt(line);
            }
        }
    }

    @Override
    public String solveFirst() {
        return Collections.max(elves).toString();
    }

    @Override
    public String solveSecond() {
        Collections.sort(elves);
        Collections.reverse(elves);
        System.out.println("1: " + elves.get(0));
        System.out.println("2: " + elves.get(1));
        System.out.println("3: " + elves.get(2));
        int total = elves.get(0) + elves.get(1) + elves.get(2);
        return String.valueOf(total);
    }

}
