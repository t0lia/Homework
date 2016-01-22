package com.t0lia;

import javax.swing.*;
import java.awt.*;

/**
 * Created by t0lia on 22.01.16.
 */
public class MainForm implements Runnable {
    private static JFrame frame;
    private JPanel mainPanel;
    private JButton button1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JList<String> list1;


    public MainForm() {

        DefaultListModel<String> primes = new DefaultListModel<>();
        list1.setModel(primes);

        button1.addActionListener(e -> {
            primes.clear();
            int from = (int) spinner1.getValue();
            int to = (int) spinner2.getValue();

            PrimesGenerator generator = new PrimesGenerator(primes, from, to);
            new Thread(generator).start();

        });
    }

    public void run() {
        frame = new JFrame("window");
        MainForm mainForm = new MainForm();
        mainForm.mainPanel.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(mainForm.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
