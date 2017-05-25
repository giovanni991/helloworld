package it.giovanni.example.channels;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class GiovanniChannel extends BaseCustomChannel{

	public GiovanniChannel(Update update) {
		super(update);
	}

	@Override
	public List<SendMessage> getMessages() {
		List<SendMessage> processMessage = super.getMessages();
		long chat_id = getUpdate().getMessage().getChatId();
		String message_text = getUpdate().getMessage().getText();
		
		if(StringUtils.containsIgnoreCase(message_text, "debug")){
			processMessage.add(new SendMessage().setChatId(chat_id).setText(getUpdate().toString()));
			return processMessage;
		}

		if(StringUtils.containsIgnoreCase(message_text, "tilapia"))
			message_text = "Di mare";
		
		if(StringUtils.containsIgnoreCase(message_text, "spendi poco"))
			message_text = "hai poco";
		
		if(StringUtils.containsIgnoreCase(message_text, "Coppo")){
			StringBuilder msg = new StringBuilder("Coppo");
			for(int i=0;i<3;i++){
				SendMessage message = new SendMessage().setChatId(chat_id).setText(msg.append("o").toString());
				processMessage.add(message);
			}
			return processMessage;
		}

		SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
		processMessage.add(message);
		return processMessage;
		
	}
	
}
