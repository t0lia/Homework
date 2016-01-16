package com.t0lia.Task_D;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 */
public class SqrEq {
    private static final File INPUT = Paths.get("sqreq.in").toFile();
    private static final File OUTPUT = Paths.get("sqreq.out").toFile();


    public static void main(String[] args) throws IOException {


        try (Scanner scanner = new Scanner(new FileReader(INPUT));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)))) {



            String[] values = scanner.nextLine().split(" ");
            double[] result = solve(Double.parseDouble(values[0]),
                    Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]));

            if (result != null) {
                writer.print(result.length);
                Arrays.sort(result);
                for (double v : result) {
                    double r = BigDecimal.valueOf(v).round(MathContext.DECIMAL32).doubleValue();
                    writer.printf(" " + r);
                }
                writer.println();
            } else {
                // infinity counts of roots
                writer.println(-1);
            }

        }


    }

    public static final double DELTA = 1E-12;
    public static double[] solve(double a, double b, double c) {
        // Обработка вырожденных случаев
        if (abs(a) < DELTA) {
            if (abs(b) < DELTA) {
                if (abs(c) < DELTA)
                    return null;
                return new double[]{};
            }
            return new double[]{-c / b};
        }

        // Вычислим дискриминант
        double D = pow(b, 2) - 4 * a * c;

        // Если D = 0 => одно решение
        if (abs(D) < DELTA) {
            return new double[]{-b / (2 * a)};
        }

        // Если D > 0 => 2 решения
        if (D > 0) {
            return new double[]{
                    (-b - sqrt(D)) / (2 * a),
                    (-b + sqrt(D)) / (2 * a)
            };
        }
        // Нет решений
        return new double[]{};
    }
}
