package com.t0lia.Task_I;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by t0lia on 16.01.16.
 */
public class Roman {

    private static String[] roman =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};



    private static final File INPUT = Paths.get("roman.in").toFile();
    private static final File OUTPUT = Paths.get("roman.out").toFile();

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {
            int count = scanner.nextInt();

            while (count != 0) {
                int number = scanner.nextInt();
                writer.println(toRoman(number));
                count--;
            }
        }
    }

//    public static void main(String[] args) {
//        for (int i = 1; i <= 3000; i++) {
//            System.out.println(toRoman(i));
//        }
//
//    }

    public static String toRoman(int aNumber) {
        String numeric = "";
        int BitDepth;
        int index = 0;
        while (index < arabic.length) {
            BitDepth = (int) aNumber / arabic[index];
            for (int i = 0; i < BitDepth; i++) {
                numeric += roman[index];
            }
            aNumber -= BitDepth * arabic[index];
            index++;
        }
        return numeric;
    }
}

