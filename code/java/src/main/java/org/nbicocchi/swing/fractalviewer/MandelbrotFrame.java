package org.nbicocchi.swing.fractalviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MandelbrotFrame {

    public static final int DEFAULT_LIMIT = 255;
    protected static int windows;
    protected JFrame frame;
    protected MandelbrotPanel panel;

    public MandelbrotFrame(int limit) {
        JMenuBar menubar = new JMenuBar();

        frame = new JFrame(getClass().getName());
        panel = new MandelbrotPanel(limit);

        insertActions(menubar);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new CloseAction());

        frame.getContentPane().add(panel);
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setSize(800, 800);            // initial size
        frame.setVisible(true);                // show window
        ++windows;                    // count open windows
    }

    /**
     * Insert all available actions into the menus and set the mnemonics.
     */
    protected void insertActions(JMenuBar menubar) {
        JMenu file = new JMenu("File");        // build menus
        JMenu view = new JMenu("View");
        JMenu help = new JMenu("Help");

        file.add(new JMenuItem("New Window"));
        file.add(new JMenuItem("CLose Window"));
        file.addSeparator();
        file.add(new JMenuItem("Quit"));

        view.add(new JMenuItem("Show Details..."));
        view.addSeparator();
        view.add(new JMenuItem("Set Depth..."));

        help.add(new JMenuItem("About"));

        menubar.add(file);
        menubar.add(view);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(help);
    }

    /**
     * Action implementation for File -&gt; New Window.
     */
    protected class NewWindowAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public NewWindowAction() {
            super("New Window");
            putValue(Action.ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke("control N"));
            putValue(Action.MNEMONIC_KEY, Integer.valueOf("N"));
            putValue(Action.SHORT_DESCRIPTION, "Open a New Window");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            new MandelbrotFrame(DEFAULT_LIMIT);        // new window
        }
    }

    /**
     * Action implementation for File -&gt; Close &amp; WindowListener.
     */
    protected class CloseAction extends AbstractAction implements WindowListener {
        private static final long serialVersionUID = 1L;

        public CloseAction() {
            super("Close");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            frame.dispose();                // destroy window
        }

        @Override
        public void windowClosing(WindowEvent event) {
            frame.dispose();                // destroy window
        }

        @Override
        public void windowClosed(WindowEvent event) {
            if (--windows == 0) System.exit(0);        // last window?
        }

        @Override
        public void windowActivated(WindowEvent event) {
        }

        @Override
        public void windowDeactivated(WindowEvent event) {
        }

        @Override
        public void windowDeiconified(WindowEvent event) {
        }

        @Override
        public void windowIconified(WindowEvent event) {
        }

        @Override
        public void windowOpened(WindowEvent event) {
        }
    }

    /**
     * Action implementation for File -&gt; Quit.
     */
    protected class QuitAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public QuitAction() {
            super("Quit");
            putValue(Action.ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke("control Q"));
            putValue(Action.MNEMONIC_KEY, Integer.valueOf("Q"));
            putValue(Action.SHORT_DESCRIPTION, "Exit Program");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    /**
     * Action implementation for View -&gt; Show Information.
     */
    protected class ShowInfoAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public ShowInfoAction() {
            super("Show Information");
            putValue(Action.ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke("control I"));
            putValue(Action.MNEMONIC_KEY, Integer.valueOf("I"));
            putValue(Action.SHORT_DESCRIPTION, "Show Information");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            JPanel grid = new JPanel(new GridLayout(5, 2, 2, 2));

            // fill the information panel
            grid.add(new JLabel("Re Minimum:"));
            grid.add(new JLabel(Double.toString(panel.re_min), JLabel.RIGHT));
            grid.add(new JLabel("Re Maximum:"));
            grid.add(new JLabel(Double.toString(panel.re_max), JLabel.RIGHT));
            grid.add(new JLabel("Im Minimum:"));
            grid.add(new JLabel(Double.toString(panel.im_min), JLabel.RIGHT));
            grid.add(new JLabel("Im Maximum:"));
            grid.add(new JLabel(Double.toString(panel.im_max), JLabel.RIGHT));
            grid.add(new JLabel("Depth Limit:"));
            grid.add(new JLabel(Integer.toString(panel.limit), JLabel.RIGHT));

            // display modal information panel
            showMessage(grid, JOptionPane.INFORMATION_MESSAGE);
        }
    }


    protected class SetDepthAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public SetDepthAction() {
            super("Set Depth Limit");
            putValue(Action.ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke("control L"));
            putValue(Action.MNEMONIC_KEY, Integer.valueOf("L"));
            putValue(Action.SHORT_DESCRIPTION, "Set Depth Limit");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String limit =
                    JOptionPane.showInputDialog(frame, "Enter new Depth Limit:");

            try {
                if (limit != null) panel.setLimit(Integer.parseInt(limit));
            } catch (RuntimeException e) {
                showMessage(e, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Action implementation for Help -&gt; About.
     */
    protected class AboutAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public AboutAction() {
            super("About");
            putValue(Action.MNEMONIC_KEY, Integer.valueOf("A"));
            putValue(Action.SHORT_DESCRIPTION, "About this Application");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            showMessage("Mandelbrot Viewer Version 0.1",   // info panel
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Display a simple modal info/message/warning/error dialogue window (using
     * the appropriate JOptionPane methods).
     *
     * @param msg  message text to display (<tt>msg.toString()</tt>)
     * @param type type of message (e.g. JOptionPane.ERROR_MESSAGE)
     */
    public void showMessage(Object msg, int type) {
        JOptionPane.showMessageDialog(frame, msg, getClass().getName(), type);
    }
}
