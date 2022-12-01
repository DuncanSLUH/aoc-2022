package com.duncan.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Solution {

    private final String inputPath;

    public Solution(String inputPath) {
        this.inputPath = inputPath;
    }

    public Scanner getScanner() {
        try {
            return new Scanner(new File("input/" + inputPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract String solveFirst();
    public abstract String solveSecond();

}
