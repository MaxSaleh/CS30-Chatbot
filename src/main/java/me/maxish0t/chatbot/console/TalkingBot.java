package me.maxish0t.chatbot.console;

import me.maxish0t.chatbot.utilities.Constants;

import java.io.*;

public class TalkingBot {

    public static void displayMenu(boolean shouldDisplay) {
        if (shouldDisplay)
            System.out.println(Constants.ANSI_GREEN + "Please enter a command or text.");
        System.out.print("> ");
    }

    // Get total number of lines in filename.
    public static int getLines(String filename) {
        int lines = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while(br.readLine() != null) lines++;
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        return lines;
    }

    // Get user input from the console.
    public static String getUserInput() {
        String userInput = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            userInput = br.readLine();
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        return userInput;
    }

    // Get all response lines from filename.
    public static String[] getResponsesArray(String filename, int lines) {
        int lineCount = 0;
        String line;
        String[] responsesArray = new String[lines];
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            do {
                line = br.readLine();
                if(line != null) {
                    responsesArray[lineCount] = line;
                    lineCount++;
                }
            } while(line != null);
        } catch(FileNotFoundException exc) {
            System.out.println("FileNotFoundException: " + exc);
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        return responsesArray;
    }

    // Get ChatBot response given user-defined input command
    public static String getResponse(String[] responses, String userInput) {
        String tag, response;
        String[] array;
        for(String responseLine: responses) {
            if(responseLine != null) {
                array = responseLine.split(" - ");
                tag = array[0];
                response = array[1];
                if(tag.compareToIgnoreCase(userInput) == 0)
                    return response;
            }
        }
        return "No response...";
    }

}
