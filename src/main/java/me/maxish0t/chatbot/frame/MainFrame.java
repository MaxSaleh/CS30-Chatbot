package me.maxish0t.chatbot.frame;

import me.maxish0t.chatbot.draw.DrawText;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JPanel {

    /**
     * Main Frame Constructor.
     */
    public MainFrame() {
        setBackground(Color.BLACK);
    }

    /**
     * Draws text, images, and etc. on the frame.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        DrawText.drawText("Test", 40, 40, 30, Color.WHITE, g);
    }

}
