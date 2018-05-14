package com.gameRecommendation.service;

import java.util.List;

import com.gameRecommendation.domain.Category;
import com.gameRecommendation.domain.Topics;
import com.gameRecommendation.domain.User;

public interface RecommendationService {

	List<User> listAllUser();

	User getUserById(Long id);

	User saveOrUpdateUser(User user);

	void deleteUserById(Long id);

	String[] friendPlayedGame(long id);

	boolean checkUserId(Long id);

	List<Topics> listAllGame();

	Topics getGameById(Long id);

	Topics saveOrUpdateGame(Topics topics);

	void deleteGameById(Long id);

	boolean checkGameId(Long id);

	List<Category> listAllCategory();

	Category getCategoryById(Long id);

	boolean checkCategoryId(Long id);

	List<Topics> topicsInCategory(Long id);

	List<Category> userFavCategory(Long id);
	
	
}
