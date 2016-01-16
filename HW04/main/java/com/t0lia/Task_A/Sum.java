package com.t0lia.Task_A;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 */
public class Sum {
    public static void main(String[] args) throws Exception {

        try (Scanner in = new Scanner(new File("sum.in"));
             PrintWriter out = new PrintWriter("sum.out")) {
            long a = in.nextLong(), b = in.nextLong();
            out.println(a + b);
        }
    }
}

