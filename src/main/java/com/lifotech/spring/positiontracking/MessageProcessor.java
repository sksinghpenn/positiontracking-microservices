package com.lifotech.spring.positiontracking;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
	
	@Autowired
	private Data data;
	
	@JmsListener(destination="positionQueue")
	public void processPositionMessageFromQueue(Map<String, String> incomingMessage ) 
	{
		data.updatePosition(incomingMessage);
		System.out.println("received message " + incomingMessage);
	}

}
