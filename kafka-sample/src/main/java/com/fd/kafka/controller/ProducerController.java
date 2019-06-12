package com.fd.kafka.controller;

import com.fd.kafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fdanismaz
 * date: 5/1/19 2:09 PM
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

	@Autowired
	private Producer producer;

	@GetMapping("/heartbeat")
	public ResponseEntity<Boolean> heartbeat() {
		this.producer.sendMessage("test", "heartbeat", "up");
		return ResponseEntity.ok(true);
	}
}
