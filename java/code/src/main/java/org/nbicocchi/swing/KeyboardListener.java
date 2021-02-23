package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyboardListener extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    ArrayList<Integer> lastChars;
    JPanel p;
    JLabel l;

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // update last chars
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        lastChars.add(0, keyCode);
        lastChars.remove(3);

        // update label
        l.setText("RGB = " + lastChars);

        // update terminal
        System.out.print("RGB = " + lastChars);
        System.out.println("\tkeyPressed: VK Code is " + keyCode + ", Key char is " + keyChar);

        // update panel color
        p.setBackground(new Color(lastChars.get(0), lastChars.get(1), lastChars.get(2)));
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyboardListener::new);
    }

    public KeyboardListener() {
        lastChars = new ArrayList<>(Arrays.asList(0, 0, 0));

        p = new JPanel(new BorderLayout());
        l = new JLabel("");
        p.add(l, BorderLayout.PAGE_END);

        setContentPane(p);
        getContentPane().setFocusable(true);
        getContentPane().addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Testing Key Listener");
        setSize(300, 200);
        setVisible(true);
    }
}
