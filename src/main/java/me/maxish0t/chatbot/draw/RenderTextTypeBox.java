package me.maxish0t.chatbot.draw;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RenderTextTypeBox {

    /**
     * Variable for the text field.
     */
    public static JTextField jTextField = new JTextField(40);

    /**
     * Constructor to render a Text Field on the frame.
     * @param text
     * @param alignmentX
     * @param alignmentY
     * @param actionListener
     */
    public static void renderTextField(String text, float alignmentX, float alignmentY, ActionListener actionListener) {
        jTextField.setText(text);
        jTextField.setAlignmentX(alignmentX);
        jTextField.setAlignmentY(alignmentY);
        jTextField.addActionListener(actionListener);
        // TODO Add a colored text field, sized text field, and fix the position alignment for X & Y.
    }

}
