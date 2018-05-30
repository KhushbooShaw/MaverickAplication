package com.stackroute.maverick.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.RecommendationCategory;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;

public interface RecommendationService {
	
	List<RecommendationCategory> getUserFavCategory(int user_id);

	List<RecommendationUser> listAllUser();

	List<RecommendationGame> listAllGame();

	List<RecommendationCategory> listAllCategory();

	RecommendationCategory getCategoryById(int id);

	List<RecommendationGame> gamesInCategory(int parseInt);
    
	List<RecommendationGame> mostPlayedGame(int id);
	
	

}
