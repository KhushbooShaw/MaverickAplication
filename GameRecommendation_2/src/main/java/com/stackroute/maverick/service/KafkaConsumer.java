package com.stackroute.maverick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.LocalUser;
import com.stackroute.maverick.domain.User;




public class KafkaConsumer {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

		
	@KafkaListener(topics="recommendation-user.t")
    public void processEvent(LocalUser user) {
		System.out.println("calling from kafka consumer");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());

    }
	/*@KafkaListener(topics="${jsa.kafka.topic}")
    public void processEvent(Game game) {
		
		System.out.println("received content = " + game.toString());
		log.info("received content = '{}'", game.toString());

    }*/
	@KafkaListener(topics="helloworld1.t")
    public void processEvent(String user) {
		System.out.println("calling from kafka consumer");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());

    }
	@KafkaListener(topics="User_Data.t")
    public void processEvent(User user) {
		System.out.println("calling from kafka consumer");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());

    }
}