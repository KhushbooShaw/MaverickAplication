package com.stackroute.maverick.service;

import java.util.List;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.LocalUser;
import com.stackroute.maverick.domain.Topics;
import com.stackroute.maverick.domain.User;

public interface RecommendationService {

	List<LocalUser> listAllUser();

	LocalUser getUserById(Long id);

	LocalUser saveOrUpdateUser(LocalUser user);

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
