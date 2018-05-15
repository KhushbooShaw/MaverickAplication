package com.gameRecommendation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.gameRecommendation.domain.Topics;
import com.gameRecommendation.domain.User;



@Service
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Value("${jsa.kafka.topic}")
	String kafkaTopic;

	public void sendUser(User user) {

		log.info("sending data='{}'", user);
		kafkaTemplate.send("recommendation-user", user);
	}
	public void sendGame(Topics game) {

		log.info("sending data='{}'", game);
		kafkaTemplate.send("recommendation-game", game);
	}
	public void sendRecommended(String[] game) {

		log.info("sending data='{}'", game.length);
		kafkaTemplate.send("recommendation-game-by-user-friends", game);
	}
	
}

