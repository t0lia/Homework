package com.t0lia;

import javax.swing.*;

/**
 * Created by t0lia on 23.01.16.
 */
public class PrimesGenerator implements Runnable {
    private DefaultListModel<String> primes;
    private int from, to;

    public PrimesGenerator(DefaultListModel<String> primes, int from, int to) {
        this.primes = primes;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            if (isPrime(i)) {
                final  int tmp = i;
                SwingUtilities.invokeLater(() ->
                primes.addElement(Integer.toString(tmp)));
            }
        }

    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }
}
