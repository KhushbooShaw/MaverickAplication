package com.gameRecommendation.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameRecommendation.domain.Category;
import com.gameRecommendation.domain.Topics;
import com.gameRecommendation.domain.User;
import com.gameRecommendation.repository.CategoryRepository;
import com.gameRecommendation.repository.TopicsRespository;
import com.gameRecommendation.repository.UserRepository;

@Service
//@Transactional
public class RecommendationServiceImpl implements RecommendationService {

	private UserRepository userRepository;
	private TopicsRespository topicsRepository;
	private CategoryRepository categoryRepository;
	Logger log = LoggerFactory.getLogger(RecommendationServiceImpl.class);

	@Autowired
	public RecommendationServiceImpl(UserRepository productRepository, CategoryRepository categoryRepository,
			TopicsRespository gameRepository) {
		this.userRepository = productRepository;
		this.topicsRepository = gameRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<User> listAllUser() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add); // fun with Java 8
		return users;
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User saveOrUpdateUser(User user) {
		log.info("user save in service1");
		System.out.println("RecommendationServiceImpl: user details " + user);
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<Topics> listAllGame() {
		List<Topics> games = new ArrayList<>();

		topicsRepository.findAll().forEach(games::add);
		return games;
	}

	@Override
	public String[] friendPlayedGame(long id) {

		List<Topics> g = userRepository.gamePlayedByUser(id);
		String[] output = new String[g.size()];

		if (g.size() != 0) {
			for (int i = 0; i < g.size(); i++) {
				output[i] = g.get(i).getName();

			}
		} else {
			output[0] = "you play no game";
		}

		return output;
	}

	@Override
	public boolean checkUserId(Long id) {

		return userRepository.existsById(id);
	}

	@Override
	public Topics getGameById(Long id) {
		return topicsRepository.findById(id).orElse(null);
	}

	@Override
	public Topics saveOrUpdateGame(Topics game) {
		topicsRepository.save(game);
		return game;
	}

	@Override
	public void deleteGameById(Long id) {
		topicsRepository.deleteById(id);

	}

	@Override
	public boolean checkGameId(Long id) {
		return topicsRepository.existsById(id);
	}

	@Override
	public List<Category> listAllCategory() {
		List<Category> games = new ArrayList<>();

		categoryRepository.findAll().forEach(games::add);
		return games;
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public boolean checkCategoryId(Long id) {
		return categoryRepository.existsById(id);
	}

	@Override
	public List<Topics> topicsInCategory(Long id) {
		return topicsRepository.topicsInCategory(id);
	}

	@Override
	public List<Category> userFavCategory(Long id) {
		return categoryRepository.userFavCategory(id);
	}

}
