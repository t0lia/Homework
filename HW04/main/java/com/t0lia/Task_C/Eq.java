package com.t0lia.Task_C;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 */
public class Eq {
    private static final File INPUT = Paths.get("eq.in").toFile();
    private static final File OUTPUT = Paths.get("eq.out").toFile();

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {
            String line = scanner.nextLine();
            String[] values = line.split(" ");
            BigDecimal a = new BigDecimal(values[0]);
            BigDecimal b = new BigDecimal(values[1]);
            BigDecimal c = new BigDecimal(values[2]);
            if(a.add(b).compareTo(c) == 0){
                writer.println("YES");
            } else{
                writer.println("NO");
            }
        }

    }
}
