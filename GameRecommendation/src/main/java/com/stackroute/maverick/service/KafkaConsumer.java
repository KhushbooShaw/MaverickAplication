package com.stackroute.maverick.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.CategoriesModel;
import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.Game;
import com.stackroute.maverick.domain.MultiPlayerGame;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.SinglePlayerResult;
import com.stackroute.maverick.domain.SelectedCategoriesModel;
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
	
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String strDate = dateFormat.format(date);
	@KafkaListener(topics="Results3.t")
    public void processEvent(SinglePlayerResult result) {
		System.out.println("calling from Game engine");
		System.out.println("received content = " + result.toString());
		log.info("received content = '{}'", result.toString());
		if(result.getPlayedData().size()>0)
		{
			userRepository.gamePlayedByUser(result.getPlayedData().get(0).getUserId(), result.getPlayedData().get(0).getGameId(), strDate);
    
		}
	}

	@KafkaListener(topics="created-new-game.t")
    public void processEvent(Game game) {
		System.out.println("Game create data from Game Manager");
		System.out.println("received content = " + game.toString());
		log.info("received content = '{}'", game.toString());
		if(gameRepository.checkGameId(game.getGameId()).size()==0)
		{
		    gameRepository.addGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),game.getTopic().getTopicId(),strDate);
		}
		else
		{
			gameRepository.updateGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),game.getTopic().getTopicId(),strDate);
			
		}
    }
	@KafkaListener(topics="created-new-multiplayer-game.t")
    public void processEvent(MultiPlayerGame game) {
		System.out.println("Game create data from Game Manager");
		System.out.println("received content = " + game.toString());
		log.info("received content = '{}'", game.toString());
		if(gameRepository.checkGameId(game.getGameId()).size()==0)
		{
		    gameRepository.addGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),11,strDate);
		}
		else
		{
			gameRepository.updateGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),11,strDate);
			
		}  
		}

	@KafkaListener(topics=" Categories.t")
    public void processEvent(CategoriesModel category) {
		System.out.println("Category create data from Question Generation");
		System.out.println("received content = " + category.toString());
		log.info("received content = '{}'", category.toString());
		if(categoryRepository.checkCategoryId(category.getCategoryId()).size()==0)
		{
		    categoryRepository.addCategory(category.getCategoryId(), category.getCategoryName(), category.getCategoryImage(),strDate);
		}
		else
		{
			categoryRepository.updateCategory(category.getCategoryId(), category.getCategoryName(), category.getCategoryImage(),strDate);	
		}
    }

	@KafkaListener(topics="selected_categories.t")
    public void processEvent(SelectedCategoriesModel user) {
		System.out.println("User create data from user category");
		
		System.out.println("received content = " + user.toString());
		
		userRepository.setUserFavCategory(user.getUserId(), user.getTid(), strDate);

    }
	@KafkaListener(topics="new-user-created.t")
    public void processEvent(User user) {
		System.out.println("User create data from user manager");
		System.out.println("received content = " + user.toString());
		log.info("received content = '{}'", user.toString());
		RecommendationUser u=new RecommendationUser();
		if(userRepository.checkUserId(user.getUserId()).size()==0)
		{
	         userRepository.addUser(user.getUserId(), user.getUserName(), user.getGender(), user.getAge(), user.getLocation(),strDate);
		}
		else
		{
			 userRepository.updateUser(user.getUserId(), user.getUserName(), user.getGender(), user.getAge(), user.getLocation(),strDate);
			
		}
    }
	
	


}