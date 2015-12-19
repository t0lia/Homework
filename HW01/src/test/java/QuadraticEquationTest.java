package test.java;

import main.java.QuadraticEquation;

import static org.junit.Assert.*;

/**
 * Created by t0lia on 18.12.15.
 */
public class QuadraticEquationTest {
    @org.junit.Test
    public void solve_oneRoot() throws Exception {
        double a = 1, b = 2, c = 1;
        double[] expected = new double[]{-1};
        double[] actual = new QuadraticEquation().solve(a, b ,c);;
        assertArrayEquals(actual, expected, 1E-3);
    }
    @org.junit.Test
    public void solve_twoRoot() throws Exception {
        double a = 1, b = 4, c = 0;
        double[] expected = new double[]{-4, 0};
        double[] actual = new QuadraticEquation().solve(a, b ,c);;
        assertArrayEquals(actual, expected, 1E-3);
    }
    @org.junit.Test
    public void solve_noRoot() throws Exception {
        double a = 1, b = 1, c = 2;
        double[] expected = null;
        double[] actual = new QuadraticEquation().solve(a, b ,c);;
        assertArrayEquals(actual, expected, 1E-3);
    }
}