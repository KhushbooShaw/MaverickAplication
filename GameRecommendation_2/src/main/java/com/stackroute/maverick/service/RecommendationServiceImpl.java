package com.stackroute.maverick.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.LocalUser;
import com.stackroute.maverick.domain.Topics;
import com.stackroute.maverick.domain.User;
import com.stackroute.maverick.repository.CategoryRepository;
import com.stackroute.maverick.repository.TopicsRespository;
import com.stackroute.maverick.repository.UserRepository;

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
	public List<LocalUser> listAllUser() {
		List<LocalUser> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add); // fun with Java 8
		return users;
	}

	@Override
	public LocalUser getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public LocalUser saveOrUpdateUser(LocalUser user) {
		log.info("user save in service1");
		System.out.println("RecommendationServiceImpl: user details " + user);
		return userRepository.save(user,1);
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
