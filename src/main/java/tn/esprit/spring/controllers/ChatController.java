package tn.esprit.spring.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Chat;

@Controller
public class ChatController {
	@MessageMapping("Chat.regester")
	@SendTo("/topic/public")
	public Chat register(@Payload Chat chatMessage, SimpMessageHeaderAccessor headerAccessor){
		headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
		return chatMessage;
		
	
	}
	@MessageMapping("Chat.send")
	@SendTo("/topic/public")
	public Chat SendMessage(@Payload Chat chatMessage){
		return chatMessage;
	}
}
