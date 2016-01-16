package com.t0lia.Task_G;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 */
public class ToHex {
    private static final File INPUT = Paths.get("tohex.in").toFile();
    private static final File OUTPUT = Paths.get("tohex.out").toFile();

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {
            while (scanner.hasNextLong()) {
                long input = scanner.nextLong();
                writer.printf(Long.toHexString(input).toUpperCase());
                writer.println();
            }

        }

    }
}
