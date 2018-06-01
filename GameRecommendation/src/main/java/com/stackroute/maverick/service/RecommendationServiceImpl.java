package com.stackroute.maverick.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.RecommendationCategory;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;
import com.stackroute.maverick.repository.CategoriesRepository;
import com.stackroute.maverick.repository.CategoryRepository;
import com.stackroute.maverick.repository.GameRespository;
import com.stackroute.maverick.repository.UserRepository;

@Service
//@Transactional
public class RecommendationServiceImpl implements RecommendationService {

	private UserRepository userRepository;
	private GameRespository gameRepository;
	private CategoryRepository categoryRepository;
	private CategoriesRepository categoriesRepository;
	Logger log = LoggerFactory.getLogger(RecommendationServiceImpl.class);

	@Autowired
	public RecommendationServiceImpl(UserRepository productRepository, CategoryRepository categoryRepository,
			GameRespository gameRepository) {
		this.userRepository = productRepository;
		this.gameRepository = gameRepository;
		this.categoryRepository = categoryRepository;
	}
    //method for getting all user nodes
	
	@Override
	public List<RecommendationUser> listAllUser() {
		List<RecommendationUser> users = new ArrayList<>();
		
		//calling repository method for getting all user
		
		userRepository.findAll().forEach(users::add);
		return users;
	}

	//method for getting all games nodes
	
	@Override
	public List<RecommendationGame> listAllGame() {
		List<RecommendationGame> games = new ArrayList<>();

		//calling repository method for getting all games
		
		gameRepository.findAll().forEach(games::add);
		return games;
	}
    
	//method for getting all category nodes
	
	@Override
	public List<RecommendationCategory> listAllCategory() {
		List<RecommendationCategory> games = new ArrayList<>();

		//calling repository method for getting all categories
		
		categoryRepository.findAll().forEach(games::add);
		return games;
	}

	//method for getting user favourite category
	
    @Override
	public List<RecommendationCategory> getUserFavCategory(int user_id) {

		return categoryRepository.getUserFavCategory(user_id);
	}

    //method for getting category by category id
    
	@Override
	public RecommendationCategory getCategoryById(int id) {
		
		return categoryRepository.checkCategoryId(id).get(0);
	}

	//method  for getting games in a category using category id
	
	@Override
	public List<RecommendationGame> gamesInCategory(int id) {
		
		return gameRepository.gamesInCategory(id);
	}

	//getting most played games by user  based on user id
	
	@Override
	public List<RecommendationGame> mostPlayedGame(int id) {
		
		return gameRepository.gamemostPlayedByUser(id);
	}

	

	
	

	

}
