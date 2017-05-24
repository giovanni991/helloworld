package it.giovanni.example;


import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class GBBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
    	// We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            
            if(StringUtils.containsIgnoreCase(message_text, "debug")){
                SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(update.toString());
                sendMessage(message);
            }
            
            if(StringUtils.containsIgnoreCase(message_text, "tilapia"))
        		message_text = "Di mare";
            
            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                sendMessage(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "Malgarbot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "365496129:AAG96gyhylXbJNZiIF4PWhsK-i-Xuoe49lU";
    }
}
