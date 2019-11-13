package me.maxish0t.chatbot.utilities;

import me.maxish0t.chatbot.Chatbot;

import java.util.logging.Logger;

public class ChatbotLogger {

    private static final Logger LOGGER = Logger.getLogger(Chatbot.class.getName());

    public static void setInfoMessage(String message) {
        LOGGER.info(message);
    }

    public static void setWarningMessage(String warningMessage) {
        LOGGER.warning(warningMessage);
    }

}
