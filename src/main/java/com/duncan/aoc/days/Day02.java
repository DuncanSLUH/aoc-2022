package com.duncan.aoc.days;

import com.duncan.aoc.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
r = A X 1p
p = B Y 2p
s = C Z 3p
 */

public class Day02 extends Solution {

    private final ArrayList<String[]> games;
    private final HashMap<String, Integer> win, lose, draw;

    public Day02() {
        super("day02.txt");

        this.games = new ArrayList<>();
        Scanner scanner = this.getScanner();
        while (scanner.hasNextLine()) games.add(scanner.nextLine().split("\\s+"));

        this.win = new HashMap<>();
        win.put("A", 2);
        win.put("B", 3);
        win.put("C", 1);
        this.lose = new HashMap<>();
        lose.put("A", 3);
        lose.put("B", 1);
        lose.put("C", 2);
        this.draw = new HashMap<>();
        draw.put("A", 1);
        draw.put("B", 2);
        draw.put("C", 3);
    }

    @Override
    public String solveFirst() {
        Scanner scanner = this.getScanner();
        int score = 0;
        for (String[] game : games) {
            String elf = game[0];
            String me = game[1];
            switch (me) {
                case "X" -> score += 1;
                case "Y" -> score += 2;
                case "Z" -> score += 3;
            }
            try {
                score += win(elf, me);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(score);
    }

    @Override
    public String solveSecond() {
        HashMap<String, Integer> winMap = new HashMap<>();
        winMap.put("X", 0);
        winMap.put("Y", 3);
        winMap.put("Z", 6);
        int score = 0;
        for (String[] game : games) {
            score += winMap.get(game[1]);
            score += whichItem(game[0], game[1]);
        }
        return String.valueOf(score);
    }

    // 0 loss, 3 draw, 6 win
    public int win(String elf, String me) throws IllegalAccessException {
        String repl = me.replace("X", "A").replace("Y", "B").replace("Z", "C");
        if (elf.equals(repl)) return 3;
        if ((elf.equals("A") && repl.equals("C")) || (elf.equals("B") && repl.equals("A")) || (elf.equals("C") && repl.equals("B"))) return 0;
        if ((repl.equals("A") && elf.equals("C")) || (repl.equals("B") && elf.equals("A")) || (repl.equals("C") && elf.equals("B"))) return 6;
        throw new IllegalAccessException("Should not be able to get here :(");
    }

    // 1r 2p 3s
    public int whichItem(String elf, String me) {
        return switch (me) {
            case "X" -> lose.get(elf);
            case "Y" -> draw.get(elf);
            case "Z" -> win.get(elf);
            default -> 0;
        };
    }
}
