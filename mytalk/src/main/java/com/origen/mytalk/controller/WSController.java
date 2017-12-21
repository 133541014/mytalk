
package com.origen.mytalk.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.origen.mytalk.model.RequestMessage;
import com.origen.mytalk.model.ResponseMessage;

@Controller
public class WSController {

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public ResponseMessage say(RequestMessage message) {

		System.out.println(message.getName());
		return new ResponseMessage("welcome," + message.getName() + " !");
	}
}
