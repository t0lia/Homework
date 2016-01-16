package com.t0lia.Task_H;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 */
public class ToAny {
    private static final File INPUT = Paths.get("toany.in").toFile();
    private static final File OUTPUT = Paths.get("toany.out").toFile();

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                long numberSystem = scanner.nextLong();
                writer.println(convert(number, numberSystem));
            }
        }
    }

    public static String convert(long number, long numberSystem) {
        if (number == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        long remainder;
        while (number != 0) {
            remainder = number % numberSystem;
            if (remainder < 10) {
                sb.append(remainder);

            } else {
                sb.append((char) ('A' + remainder - 10));
            }

            number /= numberSystem;
        }
        return sb.reverse().toString();
    }
}
