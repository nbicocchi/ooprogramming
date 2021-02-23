package org.nbicocchi.threads.producerconsumergui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerGUI extends JFrame implements ChangeListener, SizeListener {
    public static final int SIZE = 100;
    public static final int MIN_WAIT = 100;
    public static final int MAX_WAIT = 1000;
    public static final int INIT_WAIT = 100;
    private static final long serialVersionUID = 1L;
    protected JSlider speedProducer;
    protected JSlider speedConsumer;
    protected JProgressBar pb;
    protected List<Integer> l;
    protected Producer p;
    protected Consumer c;
    protected Thread tP;
    protected Thread tC;

    public ProducerConsumerGUI() {
        super("Producer-Consumer");

        /* secondary panel */
        speedProducer = new JSlider(JSlider.HORIZONTAL, MIN_WAIT, MAX_WAIT, INIT_WAIT);
        speedProducer.setMajorTickSpacing(300);
        speedProducer.setPaintTicks(true);
        speedProducer.setPaintLabels(true);
        speedProducer.addChangeListener(this);

        speedConsumer = new JSlider(JSlider.HORIZONTAL, MIN_WAIT, MAX_WAIT, INIT_WAIT);
        speedConsumer.setMajorTickSpacing(300);
        speedConsumer.setPaintTicks(true);
        speedConsumer.setPaintLabels(true);
        speedConsumer.addChangeListener(this);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Producer wait period (ms)"));
        panel.add(new JLabel("Consumer wait period (ms)"));
        panel.add(speedProducer);
        panel.add(speedConsumer);

        /* producer and consumer */
        l = new ArrayList<>();
        for (int i = 0; i < SIZE / 2; i++) l.add(i);

        p = new Producer(INIT_WAIT, l, SIZE);
        p.addListener(this);
        c = new Consumer(INIT_WAIT, l);
        c.addListener(this);

        tP = new Thread(p);
        tC = new Thread(c);
        tP.start();
        tC.start();

        /* main panel */
        pb = new JProgressBar(0, SIZE);
        setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(pb, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == speedProducer) {
            p.wait = speedProducer.getValue();
        }

        if (e.getSource() == speedConsumer) {
            c.wait = speedConsumer.getValue();
        }
    }

    @Override
    public void sizeChanged(int size) {
        pb.setValue(size);

    }
}
