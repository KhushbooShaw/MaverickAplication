package com.stackroute.maverick.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.CategoriesModel;
import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.Game;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.Result;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;
import com.stackroute.maverick.repository.CategoryRepository;
import com.stackroute.maverick.repository.GameRespository;
import com.stackroute.maverick.repository.UserRepository;



@Service
public class KafkaConsumer {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
	private UserRepository userRepository;
    @Autowired
	private GameRespository gameRepository;
    @Autowired
	private CategoryRepository categoryRepository;
	
    
	
	@KafkaListener(topics="recommendation-user.t")
    public void processEvent(RecommendationUser user) {
		System.out.println("calling from kafka consumer recommendation");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());

    }
	@KafkaListener(topics="Results3.t")
    public void processEvent(Result result) {
		System.out.println("calling from Game engine");
		System.out.println("received content = " + result.toString());
		log.info("received content = '{}'", result.toString());

    }
	@KafkaListener(topics="recommendation-game.t")
    public void processEvent(RecommendationGame user) {
		System.out.println("calling from kafka consumer recommendation");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());

    }
	
	@KafkaListener(topics="created-new-game.t")
    public void processEvent(Game game) {
		System.out.println("Game create data from Game Manager");
		System.out.println("received content = " + game.toString());
		log.info("received content = '{}'", game.toString());
		gameRepository.addGame(game.getGameId(),game.getGameName(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),game.getGameDescription(),new Date());

    }

	
	@KafkaListener(topics=" Categories.t")
    public void processEvent(CategoriesModel category) {
		System.out.println("Category create data from Question Generation");
		System.out.println("received content = " + category.toString());
		log.info("received content = '{}'", category.toString());
		categoryRepository.addCategory(category.getCategoryId(), category.getCategoryName(), category.getCategoryImage(),new Date());

    }
	
	@KafkaListener(topics="new-user-created.t")
    public void processEvent(User user) {
		System.out.println("User create data from user manager");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());
		RecommendationUser u=new RecommendationUser();
		
	    userRepository.saveUser(user.getId(), user.getUserName(), user.getGender(), user.getAge(), user.getLocation(),new Date());

    }
	@KafkaListener(topics="recommendation-gameIdS.t")
    public void processEvent(String gameId) {
		System.out.println("calling from kafka game id");
		System.out.println("received content = " + gameId);
		log.info("received content = '{}'", gameId);

    }
	@KafkaListener(topics="recommendation-gameId.t")
    public void processEvent(int gameId) {
		System.out.println("calling from kafka game id int");
		System.out.println("received content = " + gameId);
		log.info("received content = '{}'", gameId);

    }
	

}