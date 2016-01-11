package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by t0lia on 19.12.15.
 * <p>
 * Скобочные последовательности
 * <p>
 * N - количество открывающих скобок = количество закрывающих скобок Вывести в лексикографическом порядке все правильные скобочные последовательности из N пар скобок.
 * <p>
 * N = 1
 * ()
 * N = 2
 * (())
 * ()()
 * N = 3
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 */
public class BracketSequence {
    public static void main(String[] args) {

        int input = 10;
        int[] br = new int[]{0, 0, input, input};


        Deque<Character> stack = new ArrayDeque<>(input);

        m(br, stack);
    }

    public static void cBracket(int[] br, Deque<Character> stack) {
        br[3]--;
        br[1]++;
        stack.push(')');
        m(br, stack);
        stack.pop();
        br[1]--;
        br[3]++;
    }

    public static void oBracket(int[] br, Deque<Character> stack) {
        stack.push('(');
        br[2]--;
        br[0]++;
        m(br, stack);
        br[0]--;
        br[2]++;
        stack.pop();
    }

    /***
     * Recursive method. Puts valid brackets sequences in StdOut.
     * @param br:    count of brackets
     *               br[0] >= 0 - output (
     *               br[1] >= 0 - output )
     *               br[2] >= 0 - input (
     *               br[3] >= 0 - input )
     * @param stack: character from output string
     */
    public static void m(int[] br, Deque<Character> stack) {
        // if we have no input brackets -> print data from stack
        if (br[2] == 0 && br[3] == 0) {
            System.out.println(stackToString(stack));
        } else if (br[2] == 0) {
            // if we have only closed brackets -> put its onto the stack
            cBracket(br, stack);
        } else if (br[0] == br[1]) {
            // if counts of open and closed brackets are the same
            // put open bracket onto the stack
            oBracket(br, stack);
        } else if (br[0] > br[1]) {
            // if count of open brackets more than counts of closed brackets
            // try two cases.
            cBracket(br, stack);
            oBracket(br, stack);
        }
    }

    public static String stackToString(Deque<Character> stack) {

        Iterator<Character> iterator = stack.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
