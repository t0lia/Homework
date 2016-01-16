package com.t0lia.Task_J;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) throws IOException {
        File iFile = Paths.get("gcd.in").toFile();
        File oFile = Paths.get("gcd.out").toFile();

        try (Scanner scanner = new Scanner(iFile);
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(oFile)))) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int gcd = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
            writer.println(gcd);

        }
    }
}
