package it.giovanni.example;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import it.giovanni.example.channels.GiovanniChannel;

public class GBBot extends TelegramLongPollingBot {
	@Override
	public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			// Set variables
			String user_username = update.getMessage().getChat().getUserName();
			if ("giovanni9".equals(user_username)) {
				giovanniChannel(update);
			} else if ("AndreaBF".equals(user_username)) {
				giangiChannel(update);
			}

		}
	}

	public void giovanniChannel(Update update) {
		GiovanniChannel gc=new GiovanniChannel(update);
		List<SendMessage> messages = gc.getMessages();
		if(messages!=null&&messages.size() > 0){
			for (SendMessage sendMessage : messages) {
				try {
					sendMessage(sendMessage);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void giangiChannel(Update update) {

		long chat_id = update.getMessage().getChatId();
		String message_text = update.getMessage().getText();
		if (StringUtils.containsIgnoreCase(message_text, "debug"))
			message_text = update.toString();

		SendMessage message = new SendMessage() // Create a message object
			.setChatId(chat_id).setText(message_text);
		try {
			sendMessage(message); // Sending our message object to user
		} catch (TelegramApiException e) {
			e.printStackTrace();
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
