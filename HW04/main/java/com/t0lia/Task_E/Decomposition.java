package com.t0lia.Task_E;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 */
public class Decomposition {

    private static final File INPUT = Paths.get("decomposition.in").toFile();
    private static final File OUTPUT = Paths.get("decomposition.out").toFile();

    public static void main(String[] args) throws IOException {

//        long timeBegin = System.nanoTime();
//        PrintStream outBc = System.out;

        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(OUTPUT)))) {

            int input = scanner.nextInt();
            System.setOut(out);
            mSB(new StringBuilder(Integer.toString(input) + " = "), input, input);
        }

//        System.setOut(outBc);
//        System.out.println("elapsed time: " + ((System.nanoTime() - timeBegin) / 1_000_000) + "ms");
    }

    // using StringBuilder
    public static void mSB(StringBuilder result, int prev, int remainder) {
        for (int newRemainder = 0; newRemainder < remainder; newRemainder++) {
            int current = remainder - newRemainder;
            if (current > prev) {
                continue;
            }

            int index = result.length();

            result.append(current);
            if (newRemainder == 0) {


                System.out.println(result);
            } else {
                result.append(" + ");
                mSB(result, current, newRemainder);
            }
            result.delete(index, result.length());
        }
    }

}