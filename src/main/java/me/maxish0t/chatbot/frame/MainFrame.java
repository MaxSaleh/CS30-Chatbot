package me.maxish0t.chatbot.frame;

import me.maxish0t.chatbot.draw.DrawText;
import me.maxish0t.chatbot.draw.RenderTextTypeBox;
import me.maxish0t.chatbot.utilities.Constants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel {

    /**
     * Main Frame Constructor.
     */
    public MainFrame() {
        setBackground(Color.BLACK);
        add(RenderTextTypeBox.jTextField);
    }

    /**
     * Draws text, images, and etc. on the frame.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Text
        DrawText.drawText("Test Message", 40, 40, 30, Color.WHITE, g);

        // Draws the Text Field
        RenderTextTypeBox.renderTextField("Input Text", 100F, 50F, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Checks if the text field has any text.
        RenderTextTypeBox.jTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (RenderTextTypeBox.jTextField.getText().equals("Hello")) {
                    System.out.println("Hello back person!");
                    DrawText.drawText("Hello there person!", 100, 100, 30, Color.WHITE, g);
                }
                else {
                    System.out.println("Text is currently being changed....");
                }

            }
        });
    }

}
