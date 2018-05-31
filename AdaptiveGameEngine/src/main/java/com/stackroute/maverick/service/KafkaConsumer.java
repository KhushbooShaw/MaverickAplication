package com.stackroute.maverick.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;






@Service
public class KafkaConsumer {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
   
//	@KafkaListener(topics="hello")
//    public void processEvent(String user) {
//		System.out.println("calling from kafka consumer recommendation");
//		System.out.println("received content = " + user.toString());
//		log.info("received content = '{}'", user.toString());
//	}
}