package com.t0lia.Task_B;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayDeque;

/**
 * Task_B
 */

public class Str {
    public static void main(String[] args) throws IOException {
        String f1 = "string.in";
        String f2 = "string.out";
        String line = "";

//         read from file
        ArrayDeque<Character> stack = new ArrayDeque<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(Paths.get(f1).toFile()))) {
            line = reader.readLine();
        }

//        write to file
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(Paths.get(f2).toFile())
        )) {

            for (int i = line.length() - 1; i >= 0; i--) {
                writer.write(line.charAt(i));
            }
            writer.write("\n");

        }
    }
}
