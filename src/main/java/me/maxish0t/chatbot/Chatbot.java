package me.maxish0t.chatbot;

import com.google.protobuf.ByteString;
import me.maxish0t.chatbot.console.TalkingBot;
import me.maxish0t.chatbot.frame.MainFrame;
import me.maxish0t.chatbot.utilities.ChatbotLogger;
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
     * Main method that gets ran.
     * @param args
     */
    public static void main(String[] args) {
        //getFrame(); // TODO

        // Set program variables.
        String userInput, response;
        String filename = "src\\main\\resources\\responses.txt";

        int lines = TalkingBot.getLines(filename);
        String[] responsesArray = TalkingBot.getResponsesArray(filename, lines);

        // Display menu with startup message.
        TalkingBot.displayMenu(true);

        // ChatBot loop.
        do {
            userInput = TalkingBot.getUserInput();
            response = TalkingBot.getResponse(responsesArray, userInput);

            System.out.println(Constants.ANSI_RED + "Chatbot: " + response);

            if(!userInput.equals("bye")) {
                TalkingBot.displayMenu(false);
            }
        } while(!userInput.equals("bye"));
    }

    /**
     * Gets the main frame screen.
     */
    private static void getFrame() {
        MainFrame mainPingPongGUI = new MainFrame();
        JFrame frm = new JFrame();
        frm.setTitle("Chatbot Program - " + Constants.VERSION);
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(Constants.displayWidth, Constants.displayHeight);
        frm.setResizable(false);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

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
        ChatbotLogger.setInfoMessage("Main Frame has been loaded successfully!");
    }

}
