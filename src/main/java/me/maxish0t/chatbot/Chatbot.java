package me.maxish0t.chatbot;

import me.maxish0t.chatbot.frame.MainFrame;
import me.maxish0t.chatbot.utilities.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Chatbot {

    /**
     * Frame width & height sizes.
     */
    public static final int displayWidth = 1600;
    public static final int displayHeight = 900;

    /**
     * Main method that gets ran.
     * @param args
     */
    public static void main(String[] args){
        getFrame();
    }

    /**
     * Gets the main frame screen.
     */
    private static void getFrame() {
        MainFrame mainPingPongGUI = new MainFrame();
        JFrame frm = new JFrame();
        frm.setTitle("Chatbot Program - " + Constants.VERSION);
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(displayWidth, displayHeight);
        frm.setResizable(false);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the Icon from the resources
        URL res = Chatbot.class.getClassLoader().getResource("icon.png");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        BufferedImage myImg = null;
        try {
            myImg = ImageIO.read(new File(absolutePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frm.setIconImage(myImg);
    }

}
