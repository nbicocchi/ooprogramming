package org.nbicocchi.swing.bouncingballs;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int maxBalls = 5;
    private Clip sounds;
    private Ball[] balls;
    private ControlPanel controlPanel;
    private final Properties props;

    public GamePanel(Properties props) {
        super();
        this.props = props;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void init() {
        Random r = new Random();

        balls = new Ball[maxBalls];
        Color[] colors = {Color.black, Color.yellow, Color.red, Color.green, Color.orange, Color.blue, Color.pink};

        // generate balls
        for (int i = 0; i < maxBalls; i++) {
            double radius = 25 * r.nextDouble() + 5;
            balls[i] = new Ball(getWidth() * r.nextDouble() * 0.5 + radius, getHeight() * r.nextDouble() * 0.5 + radius,
                    radius, 10 * r.nextDouble() - 5, 10 * r.nextDouble() - 5,
                    colors[(int) (colors.length * r.nextDouble())]);
        }

        // generate sound threads
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    new BufferedInputStream(new FileInputStream("src/main/resources/sounds/clunk.wav")));
            sounds = AudioSystem.getClip();
            sounds.open(inputStream);
        } catch (Exception e) {
            // disable sound if something goes wrong
            System.out.println(e.getMessage());
        }

        // this panel implements runnable
        new Thread(this).start();
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        long sleepTime, skipTicks, nextTick = System.nanoTime();

        while (true) {
            // game pause option
            // if paused sleeps in chunks of 100ms
            while (props.getProperty("pause").equals("on")) {
                try {
                    Thread.sleep(100);
                    nextTick = System.nanoTime();
                } catch (InterruptedException ignored) {
                }
            }

            // fps manager
            skipTicks = (long) (Math.pow(10, 9) / Integer.parseInt(props.getProperty("fps")));
            nextTick += skipTicks;
            sleepTime = nextTick - System.nanoTime();

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1000000);
                } catch (InterruptedException ignored) {
                }
            }

            // main loop
            int w = getWidth();
            int h = getHeight();

            for (Ball b : balls) {
                b.move();
                if (b.collideWall(w, h)) {
                    if (props.getProperty("sounds").equals("on")) {
                        sounds.start();
                        sounds.setFramePosition(0);
                    }
                }
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < maxBalls; i++) {
            balls[i].paint(g);
        }
    }
}