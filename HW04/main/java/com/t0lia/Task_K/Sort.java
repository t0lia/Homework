package com.t0lia.Task_K;

import java.io.*;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 *
 */

public class Sort {
    private static final File INPUT = Paths.get("sort.in").toFile();
    private static final File OUTPUT = Paths.get("sort.out").toFile();

    private static final int TEST_DIGIT_COUNT = 300_000;
    private static final int UPPER_BOUND = 1000;

    public static void initFile() throws IOException {


        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(INPUT)))) {
            Random random = new Random(17);
            writer.println(TEST_DIGIT_COUNT);
            for (int i = 0; i < TEST_DIGIT_COUNT; i++) {
                writer.print(random.nextInt(UPPER_BOUND) + 1 + " ");
            }
            writer.println();
        }
    }

    public static void main(String[] args) throws IOException {
//        initFile();


//        long timeBegin = System.nanoTime();

        int[] numberCount = new int[UPPER_BOUND + 1];
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(INPUT), 1024));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {

            int size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                numberCount[scanner.nextInt()]++;
            }
            for (int i = 0; i <= UPPER_BOUND; i++) {
                while (numberCount[i] != 0) {
                    writer.print(i + " ");
                    numberCount[i]--;
                }
            }
            writer.println();
        }

//        System.out.println((System.nanoTime() - timeBegin) / 1_000_000 + "ms");
    }

}
