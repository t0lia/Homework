package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by t0lia on 18.12.15.
 *
 * Решение квадратного уравнения ax^2 + bx + c = 0
 * Вводим с клавиатуры или из файла a, b, c
 * Выводим весь процесс решения и результаты на экран (в консоль) или в файл
 * a = 0, b = 0, c = 0 => x - любое
 */

public class QuadraticEquation {
    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the data");
        try {
            System.out.printf("a: ");
            a = scanner.nextDouble();
            System.out.println("a = " + a);
            System.out.printf("b: ");
            b = scanner.nextDouble();
            System.out.println("b = " + b);
            System.out.printf("c: ");
            c = scanner.nextDouble();
            System.out.println("c = " + c);
        } catch (InputMismatchException e) {
            System.err.println("input is not correct");
            return;
        }

        double[] result = new QuadraticEquation().solve(a, b, c);
        if (result == null) {
            System.out.println("there is no root");
        } else if (result.length == 1) {
            System.out.println("root1 = " + result[0] + "root2 = " + result[0]);
        } else {
            System.out.println("root1 = " + result[0] + "root2 = " + result[1]);
        }
    }

    /**
     * @return null if discriminant < 0
     * {root1} if discriminant = 0
     * {root2, root2} if discriminant > 0
     */
    public double[] solve(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d < 0) {
            return null;
        } else if (d == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            return new double[]{(-b - Math.sqrt(d)) / (2 * a), (-b + Math.sqrt(d)) / (2 * a)};
        }

    }
}
