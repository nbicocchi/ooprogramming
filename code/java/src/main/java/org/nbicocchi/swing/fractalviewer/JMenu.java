package org.nbicocchi.swing.fractalviewer;

import javax.swing.*;

/**
 * Small fix for the <tt>javax.swing.JMenu</tt> class: This subclass of JMenu
 * behaves almost exactly like JMenu, but actually uses the ACCELERATOR_KEY
 * property of any Action values added to the menu.
 */
public class JMenu extends javax.swing.JMenu {
    private static final long serialVersionUID = 1L;

    /**
     * Initialize a new JMenu object with the given menu title.
     */
    public JMenu(String title) {
        super(title);
    }

    /**
     * Create an action component, install the correct accelerator key (if it is
     * set in the action) and return the created JMenuItem.
     *
     * @throws ClassCastException if the accelerator is not a KeyStroke
     */
    protected JMenuItem createActionComponent(Action action) {
        JMenuItem item = super.createActionComponent(action);

        // key stroke may be null here (which will clear the accelerator)
        item.setAccelerator((KeyStroke)
                action.getValue(Action.ACCELERATOR_KEY));
        return item;
    }

    /**
     * Insert an action component into the menu (at the specified position),
     * install the correct accelerator key (if it is set in the action) and
     * return the created JMenuItem.
     *
     * @throws ClassCastException if the accelerator is not a KeyStroke
     */
    public JMenuItem insert(Action action, int pos) {
        JMenuItem item = super.insert(action, pos);

        // key stroke may be null here (which will clear the accelerator)
        item.setAccelerator((KeyStroke)
                action.getValue(Action.ACCELERATOR_KEY));
        return item;
    }
}
