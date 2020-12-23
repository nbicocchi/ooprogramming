package org.nbicocchi.threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnresponsiveUIwThread extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private boolean running = false;
    private int countValue = 1;

    private final JTextField tfCount;
    private final JButton btnStart;
    private final JButton btnStop;

    public UnresponsiveUIwThread() {
        super("Counter");
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        p1.add(new JLabel("Counter"));

        tfCount = new JTextField("" + countValue, 10);
        tfCount.setEditable(false);
        p1.add(tfCount);

        btnStart = new JButton("Start Counting");
        btnStart.addActionListener(this);
        p1.add(btnStart);

        btnStop = new JButton("Stop Counting");
        btnStop.addActionListener(this);
        p1.add(btnStop);

        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStop) {
            running = true;
        } else if (e.getSource() == btnStart) {
            running = false;

            /*
             * Use a separate thread for executing the updateCounter() method
             */
            Thread t = new Thread(this::updateCounter);
            t.start();

            /*
             * Execute the updateCounter() method in main thread. The alternative above
             * (execution inside thread must be commented)
             */
//			updateCounter();
        }
    }

    void updateCounter() {
        for (int i = 0; i < 100000; i++) {
            if (running)
                break;
            tfCount.setText(Integer.valueOf(countValue).toString());
            countValue++;
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(UnresponsiveUIwThread::new);
    }
}