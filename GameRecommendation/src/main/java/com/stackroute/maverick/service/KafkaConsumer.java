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
import com.stackroute.maverick.repository.CategoriesRepository;
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
    @Autowired
    private CategoriesRepository categoriesRepository;
    
    //making object of date and converting into string
    
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String strDate = dateFormat.format(date);
    
    //consuming data produce by single player game engine
    
	@KafkaListener(topics="Results3.t")
    public void processEvent(SinglePlayerResult result) {
		
		log.info("received content = '{}'", result.toString());
		
		//logic for checking and making user played games
		
		if(result.getPlayedData().size()>0)
		{
			userRepository.gamePlayedByUser(result.getPlayedData().get(0).getUserId(), result.getPlayedData().get(0).getGameId(), strDate);
    
		}
	}

	//consuming from game manager when a single player game is created
	
	@KafkaListener(topics="created-new-game.t")
    public void processEvent(Game game) {
		
		log.info("received content = '{}'", game.toString());
		
		if(gameRepository.checkGameId(game.getGameId()).size()==0)
		{
			//creating new game node
			
		    gameRepository.addGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),game.getTopic().getTopicId(),strDate);
		}
		else
		{
			//updating existing game node
			
			gameRepository.updateGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),game.getTopic().getTopicId(),strDate);
			
		}
    }
	
	//consuming from game manager when a multi player game is created
	
	@KafkaListener(topics="created-new-multiplayer-game.t")
    public void processEvent(MultiPlayerGame game) {
		

		log.info("received content = '{}'", game.toString());
		if(gameRepository.checkGameId(game.getGameId()).size()==0)
		{
			//creating new game node
			
		    gameRepository.addGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),game.getTopic().getTopicId(),strDate);
		}
		else
		{
			//updating existing game node
			gameRepository.updateGame(game.getGameId(),game.getGameName(),game.getGameImage(),game.getCategoryId(),game.getGameType().getGameTypeId(),game.getGameType().getGameTypeName(),game.getGameRules(),"Recommended",game.getGameDescription(),game.getTopic().getTopicId(),strDate);
			
		}  
		}

	//consuming from question generator when a category is created
	
	@KafkaListener(topics="Categories.t")
    public void processEvent(CategoriesModel category) {
		
		log.info("received content = '{}'", category.toString());
		if(categoriesRepository.checkCategoryId(1).size()==0)
		{
			//new categories node
			
		    categoriesRepository.addCategory(1);
		}
		if(categoryRepository.checkCategoryId(category.getCategoryId()).size()==0)
		{
			//new category node
			
		    categoryRepository.addCategory(1,category.getCategoryId(), category.getCategoryName(), category.getCategoryImage(),strDate);
		}
		else
		{
			//updating existing category node
			
			categoryRepository.updateCategory(category.getCategoryId(), category.getCategoryName(), category.getCategoryImage(),strDate);	
		}
    }

	//consuming from user manager for user favourite category
	
	@KafkaListener(topics="selected_categories.t")
    public void processEvent(SelectedCategoriesModel user) {

		//creating user favourite category relationship
		
		userRepository.setUserFavCategory(user.getUserId(), user.getSelectedCategoryId(), strDate);

    }
	
	//consuming from user manager whenever a new user is created
	
	@KafkaListener(topics="new-user-created.t")
    public void processEvent(User user) {
		
		log.info("received content = '{}'", user.toString());
		RecommendationUser u=new RecommendationUser();
		if(userRepository.checkUserId(user.getUserId()).size()==0)
		{
			//creating new user node
			
	         userRepository.addUser(user.getUserId(), user.getUserName(), user.getGender(), user.getAge(), user.getLocation(),strDate);
		}
		else
		{
			//updating existing user node
			
			 userRepository.updateUser(user.getUserId(), user.getUserName(), user.getGender(), user.getAge(), user.getLocation(),strDate);
			
		}
    }
	

}