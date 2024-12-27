package com.java.kafka.SpringBoot_kafkaTest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.kafka.SpringBoot_kafkaTest.kafka.JsonKafkaProducer;
import com.java.kafka.SpringBoot_kafkaTest.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	
	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
	}
	
	
}
