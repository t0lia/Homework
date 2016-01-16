package com.t0lia.Task_F;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by t0lia on 15.01.16.
 */
public class ToBin {
    private static final File INPUT = Paths.get("tobin.in").toFile();
    private static final File OUTPUT = Paths.get("tobin.out").toFile();

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {
            int count = scanner.nextInt();
            while (count !=0) {
                long input = scanner.nextLong();
                writer.printf(Long.toBinaryString(input));
                writer.println();
                count--;
            }

        }

    }
}
