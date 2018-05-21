package com.stackroute.maverick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;



@Service
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

//	@Value("${jsa.kafka.topic}")
//	String kafkaTopic;

	public void sendUser(RecommendationUser user) {

		log.info("sending data='{}'", user);
		kafkaTemplate.send("recommendation-user.t", user);
	}
	public void sendGame(RecommendationGame game) {

		log.info("sending data='{}'", game);
		kafkaTemplate.send("recommendation-game.t", game);
	}
	public void sendRecommended(String[] game) {

		log.info("sending data='{}'", game.length);
		kafkaTemplate.send("recommendation-game-by-user-friends.t", game);
	}
	public void sendGameid(String gameId) {

		log.info("sending data='{}'", gameId);
		kafkaTemplate.send("recommendation-gameIdS.t", gameId);
	}
	public void sendGameid(int gameId) {

		log.info("sending data='{}'", gameId);
		kafkaTemplate.send("recommendation-gameId.t", gameId);
	}
	
}

