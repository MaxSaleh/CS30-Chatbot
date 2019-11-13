package me.maxish0t.chatbot.draw;

import java.awt.*;

public class DrawText {

    /**
     * Draws a text on the screen frame.
     * @param text Define a message to be rendered.
     * @param positionX Position for the X position on the text.
     * @param positionY Position for the Y position on the text.
     * @param textSize Size of the text.
     * @param color Color of the text.
     * @param graphics Define the graphics.
     */
    public static void drawText(String text, int positionX, int positionY, int textSize, Color color, Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(color);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, textSize));
        g2.drawString(text, positionX, positionY);
    }

}
