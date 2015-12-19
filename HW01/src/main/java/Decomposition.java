package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by t0lia on 18.12.15.
 * <p>
 * Разложение на слагаемые (рекурсия, массивы)
 * <p>
 * Пользователь вводит натуральное число N Надо вывести все разложения на слагаемые. Разложения отличающиеся порядком слагаемых считаются одинаковыми.
 * <p>
 * N = 4
 * 4 = 4
 * 4 = 3 + 1
 * 4 = 2 + 2
 * 4 = 2 + 1 + 1
 * 4 = 1 + 1 + 1 + 1
 * N <= 100
 */
public class Decomposition {
    public static void main(String[] args) {
        int input = 50;

//        String implementation
//        System.out.println("N = " + input);
//        mSB(new StringBuilder(Integer.toString(input) + " = "), input, input);

//        StringBuilder implementation
//        System.out.println("\nN = " + input);
//        mSTR(Integer.toString(input) + " = ", input, input);

//        Stack implementation

        System.out.println("\nN = " + input);
        ArrayDeque<Integer> stack = new ArrayDeque<>(input + 1);
        stack.push(input);
        mStack(stack, input, input);


    }

    // using String
    public static void mSTR(String result, int prev, int remainder) {
        for (int newRemainder = 0; newRemainder < remainder; newRemainder++) {
            int current = remainder - newRemainder;
            if (current > prev) {
                continue;
            }

            String temp;
            if (newRemainder == 0) {
                temp = result + current;
                System.out.println(temp);
            } else {
                temp = result + current + " + ";
                mSTR(temp, current, newRemainder);
            }
        }
    }

    // using StringBuilder
    public static void mSB(StringBuilder result, int prev, int remainder) {
        for (int newRemainder = 0; newRemainder < remainder; newRemainder++) {
            int current = remainder - newRemainder;
            if (current > prev) {
                continue;
            }

            int index = result.length();

            result.append(current);
            if (newRemainder == 0) {


                System.out.println(result);
            } else {
                result.append(" + ");
                mSB(result, current, newRemainder);
            }
            result.delete(index, result.length());
        }
    }

    // using Stack
    public static void mStack(Deque<Integer> stack, int prev, int remainder) {
        for (int newRemainder = 0; newRemainder < remainder; newRemainder++) {
            int current = remainder - newRemainder;
            if (current > prev) {
                continue;
            }

            stack.push(current);
            if (newRemainder == 0) {


                printStack(stack);
            } else {

                mStack(stack, current, newRemainder);
            }
            stack.pop();
        }
    }

    public static void printStack(Deque<Integer> stack) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();

        Iterator<Integer> iter = stack.descendingIterator();
        sb.append(iter.next() + " = " + iter.next());
        while (iter.hasNext()) {
            sb.append(" + ");
            sb.append(iter.next());
        }
        System.out.println(sb);

    }
}