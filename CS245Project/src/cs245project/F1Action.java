/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;


public class F1Action extends AbstractAction{
    private static final String KEY_STROKE_AND_KEY = "F1";
    private static final KeyStroke F1_KEY_STROKE = KeyStroke.getKeyStroke(KEY_STROKE_AND_KEY);

    public F1Action() {
        super("F1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component component = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        JComponent rootPane = (JComponent) component;

        if (!(rootPane instanceof JRootPane)) {
            rootPane = (JComponent)SwingUtilities.getAncestorOfClass(JRootPane.class, component);
        }

        ActionListener f1Action = getF1Action(rootPane);

        if (f1Action != null) {
            f1Action.actionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(rootPane, 
                    "Erick Rivera, 009703473\n"
                    + "Jose Guitierrez, 009417096\n"
                    + "Michael Muinos, 009553206\n"
                    + "CS 245 Quarter Project\n"
                            + "Summer 2016", "CS 245 Quarter Project", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private ActionListener getF1Action(JComponent rootPane) {
        InputMap im = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        if (im == null) return null;
        im = im.getParent();
        if (im == null) return null;
        Object[] keys = im.keys();
        if (keys == null) return null;
        for (Object keyStroke: keys) {
            if (keyStroke.equals(F1_KEY_STROKE)) {
                Object key = im.get(F1_KEY_STROKE);
                return rootPane.getActionMap().get(key);
            }
        }
        return null;
    }


    public void register(JRootPane rootPane) {
        rootPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(F1_KEY_STROKE, KEY_STROKE_AND_KEY);
        rootPane.getActionMap().put(KEY_STROKE_AND_KEY, this);
    }
}
