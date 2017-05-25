package it.giovanni.example.channels;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class BaseCustomChannel {

	final Update update;
	
	public BaseCustomChannel(Update update){
		this.update = update;
		getMessages();
	}

	public List<SendMessage> getMessages(){
		return new ArrayList<SendMessage>();
	}
	
	public Update getUpdate() {
		return update;
	}
}
