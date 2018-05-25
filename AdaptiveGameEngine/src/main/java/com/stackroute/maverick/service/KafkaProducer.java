package com.stackroute.maverick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.stackroute.maverick.domain.User;



@Service
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

//	public void sendUser(RecommendationUser user) {
//
//		log.info("sending data='{}'", user);
//		kafkaTemplate.send("recommendation-user.t", user);
//	}
	
	
}

