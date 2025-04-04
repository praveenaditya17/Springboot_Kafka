package com.java.kafka.SpringBoot_kafkaTest.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.java.kafka.SpringBoot_kafkaTest.model.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics="javaguide_json",groupId="myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("json message received -> %s", user));
	}
}
