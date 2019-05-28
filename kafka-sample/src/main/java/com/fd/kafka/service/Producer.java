package com.fd.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author fdanismaz
 * date: 5/1/19 2:14 PM
 */
@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topic, String key, String message) {
		this.kafkaTemplate.send(topic, key, message);
	}

}
