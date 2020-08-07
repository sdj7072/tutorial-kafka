package com.tutorial.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@RequestMapping(value = "/send")
	public String sendMessage() {
		try {
			kafkaTemplate.send("test", "hi-world").get();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		return "success";
	}

}
