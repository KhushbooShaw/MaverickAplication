package com.stackroute.maverick.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;

public interface AnalyzerService {

	List<RecommendationUser> listAllUser();

	RecommendationUser getUserById(Long id);

	RecommendationUser saveOrUpdateUser(RecommendationUser user);

	void deleteUserById(Long id);

	String[] friendPlayedGame(long id);

	boolean checkUserId(Long id);

	List<RecommendationGame> listAllGame();

	RecommendationGame getGameById(Long id);

	RecommendationGame saveOrUpdateGame(RecommendationGame topics);

	void deleteGameById(Long id);

	boolean checkGameId(Long id);

	List<Category> listAllCategory();

	Category getCategoryById(Long id);

	boolean checkCategoryId(Long id);

	List<RecommendationGame> topicsInCategory(Long id);

	List<Category> userFavCategory(Long id);
	
//	List<RecommendationUser> saveUser(Long id);
//	
//	List<RecommendationUser> setUserData(Long id,String name,String gender);
//	
//	List<RecommendationUser> cretaeRelation(Long id);
//	
//	List<RecommendationUser> searchTest(String data,int length);
}
