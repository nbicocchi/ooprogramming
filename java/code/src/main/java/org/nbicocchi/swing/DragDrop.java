package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;

public class DragDrop extends JFrame implements DropTargetListener {
    private static final long serialVersionUID = 1L;
    DropTarget dt;
    JTextField tf;

    public DragDrop() {
        super("Drag & Drop Example");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf = new JTextField();
        dt = new DropTarget(tf, this);

        this.getContentPane().add(tf, BorderLayout.CENTER);
        this.setSize(400, 60);
        this.setVisible(true);
    }

    @Override
    public void dragEnter(DropTargetDragEvent e) {
        System.out.println("Drag Init");
    }

    @Override
    public void dragExit(DropTargetEvent e) {
        System.out.println("Drag End");
    }

    @Override
    public void dragOver(DropTargetDragEvent e) {
        System.out.println("Drag Over");
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent e) {
        System.out.println("Drop Action Changed");
    }

    @Override
    public void drop(DropTargetDropEvent e) {
        try {
            /* Get the dropped object */
            Transferable tr = e.getTransferable();
            DataFlavor[] flavors = tr.getTransferDataFlavors();
            for (DataFlavor flavor : flavors) {
                System.out.println("Possible flavor: " + flavor.getMimeType());
                /* Check for file lists specifically */
                if (flavor.isFlavorJavaFileListType()) {
                    /* Drop Accepted */
                    e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    /* ta.setText("Successful file list drop.\n\n"); */

                    /* And add the list of file name to our text field */
                    @SuppressWarnings("rawtypes")
                    java.util.List list = (java.util.List) tr.getTransferData(flavor);
                    /* The program allows to take a folder at time */
                    /*
                     * if i want more folders/files at time, change the tf into jTextarea and use
                     * list.get(j) below
                     */
                    for (int j = 0; j < list.size(); j++) {
                        tf.setText(list.get(0) + "\n");
                    }

                    /* Everything worked */
                    e.dropComplete(true);
                    return;
                }
            }

            /* the user must not have dropped a file/folder list */
            System.out.println("Drop failed: " + e);
            e.rejectDrop();
        } catch (Exception ex) {
            ex.printStackTrace();
            e.rejectDrop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DragDrop::new);
    }

}
