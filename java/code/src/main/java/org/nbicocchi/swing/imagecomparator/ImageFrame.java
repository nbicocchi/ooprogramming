package org.nbicocchi.swing.imagecomparator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ImageFrame extends JFrame implements ActionListener, ProgressListener {

    private static final long serialVersionUID = 1L;
    private final ImagePanel firstImagePanel;
    private final ImagePanel secondImagePanel;
    private final JProgressBar progressBar;
    private AbstractComparator cmp;

    public ImageFrame() {
        super("Image Comparator");

        generateMenu();

        firstImagePanel = new ImagePanel();
        secondImagePanel = new ImagePanel();
        progressBar = new JProgressBar();

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(new JScrollPane(firstImagePanel));
        p.add(new JScrollPane(secondImagePanel));

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(p, BorderLayout.CENTER);
        c.add(progressBar, BorderLayout.SOUTH);

        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void generateMenu() {
        MenuItem openFirst = new MenuItem("Open First...");
        MenuItem openSecond = new MenuItem("Open Second...");
        MenuItem compare = new MenuItem("Compare...");
        MenuItem quit = new MenuItem("Quit");

        openFirst.addActionListener(this);
        openSecond.addActionListener(this);
        compare.addActionListener(this);
        quit.addActionListener(this);

        Menu file = new Menu("File");
        file.add(openFirst);
        file.add(openSecond);
        file.add(compare);
        file.add(quit);

        MenuBar menuBar = new MenuBar();
        menuBar.add(file);

        setMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open First...")) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    firstImagePanel.setImage(ImageIO.read(open.getSelectedFile()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getActionCommand().equals("Open Second...")) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    secondImagePanel.setImage(ImageIO.read(open.getSelectedFile()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getActionCommand().equals("Compare...")) {

            Object[] possibilities = {"Fast", "Accurate"};
            String s = (String) JOptionPane.showInputDialog(
                    this,
                    null,
                    "Compare...",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "Fast");

            if ((s != null) && (s.length() > 0)) {
                cmp = new FastComparator(
                        firstImagePanel.getImage(),
                        secondImagePanel.getImage());
                cmp.addListener(this);
                Thread t = new Thread(cmp);
                t.start();
            }
        }
    }

    @Override
    public void progressPerformed(int percent) {
        progressBar.setValue(percent);
        if (percent == 100) {
            JOptionPane.showMessageDialog(this,
                    "Similarity = " + cmp.getSimilarity() +
                            "; Coverage = " + cmp.getCoverage());
        }
    }
}
