package com.stackroute.maverick.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.LocalUser;
import com.stackroute.maverick.domain.Topics;
import com.stackroute.maverick.domain.User;
import com.stackroute.maverick.service.KafkaProducer;
import com.stackroute.maverick.service.RecommendationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "*")
@Api(value = "RecommendationControllerApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecommendationController {

	private RecommendationService recommendationService;

	 @Autowired
	 KafkaProducer producer;

	Logger log = LoggerFactory.getLogger(RecommendationController.class);

	@Autowired
	public void setProductService(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}

	@GetMapping("/recommendation/userGame/{id}")
	@ApiOperation("get the list of games played by user's friends using user's id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok", response = Topics.class) })
	public ResponseEntity<String[]> getFriendGame(User user, @PathVariable("id") String id) throws Exception {

		if (recommendationService.checkUserId(Long.parseLong(id))) {

			String[] output = recommendationService.friendPlayedGame(Long.parseLong(id));

			// producer.sendRecommended(output);

			return new ResponseEntity<String[]>(output, HttpStatus.OK);
		} else {
			throw new Exception("user with id " + id + " does not exist");
		}

	}

	@GetMapping("/recommendation/users")
	public ResponseEntity<?> getAllUser() {

		Iterable<LocalUser> users = recommendationService.listAllUser();

		return new ResponseEntity<Iterable<LocalUser>>(users, HttpStatus.OK);

	}

	@GetMapping("/recommendation/user/{id}")
	public ResponseEntity<LocalUser> findUserById(LocalUser user, @PathVariable("id") String id) throws Exception {

		if (recommendationService.checkUserId(Long.parseLong(id))) {

			user.setId(Long.parseLong(id));
			//user.setId(Integer.parseInt(id));

			log.info(id);

			LocalUser user1 = recommendationService.getUserById(Long.parseLong(id));

			 producer.sendUser(user1);

			return new ResponseEntity<LocalUser>(user1, HttpStatus.OK);
		} else {
			throw new Exception("user with id " + id + " does not exist");
		}

	}

//	@RequestMapping("/recommendation/user")
//	public ResponseEntity<User> addUser() throws Exception {
//
//		System.out.println("inside add user");
//		log.info("user save in controller1");
//
//		User user = new User();
//		user.
//
//		log.info("user save in controller2");
//
//		return new ResponseEntity<User>(user1, HttpStatus.OK);
//
//		// }
//
//	}

	 @PostMapping("/recommendation/user")
	 public ResponseEntity<LocalUser> addUser(@RequestBody LocalUser user) throws Exception
	 {
	
	 //if(recommendationService.checkUserId(user.getId()))
	// {
    // throw new Exception("user with id "+user.getId()+" already exist");
	 // }
	// // else
	// // {
	 System.out.println("user details" + user);
	 log.info("user save in controller1");
	
	 LocalUser user1 = recommendationService.saveOrUpdateUser(user);
	
	 log.info("user save in controller2");
	
	 return new ResponseEntity<LocalUser>(user1, HttpStatus.OK);
	//
	// // }
	//
	 }

	@PutMapping("/recommendation/user/{id}")
	public ResponseEntity<LocalUser> updateUserUsingId(@RequestBody LocalUser user, @PathVariable("id") String id)
			throws Exception {

		if (recommendationService.checkUserId(Long.parseLong(id))) {
			user.setId(Long.parseLong(id));

			LocalUser user1 = recommendationService.saveOrUpdateUser(user);

			return new ResponseEntity<LocalUser>(user1, HttpStatus.OK);
		} else {
			throw new Exception("user with id " + id + " does not exist");
		}

	}

	@DeleteMapping("/recommendation/user/{id}")
	public ResponseEntity<LocalUser> deleteUserUsingId(LocalUser user) throws Exception {

		if (recommendationService.checkUserId(user.getId())) {

			recommendationService.deleteUserById(user.getId());

			return new ResponseEntity<LocalUser>(user, HttpStatus.OK);

		} else {
			throw new Exception("user with id " + user.getId() + " does not exist");
		}

	}

	@GetMapping("/recommendation/userFavCategory/{id}")
	public ResponseEntity<List<Category>> userFavCategory(LocalUser user, @PathVariable("id") String id) throws Exception {

		if (recommendationService.checkUserId(Long.parseLong(id))) {

			user.setId(Long.parseLong(id));

			log.info(id);

			List<Category> topic = recommendationService.listAllCategory();

			List<Category> topics = recommendationService.userFavCategory(Long.parseLong(id));

			if (topics.size() != 0)

			{
				topic.removeAll(topics);

				topics.addAll(topic);

				return new ResponseEntity<>(topics, HttpStatus.OK);

			} else {
				throw new Exception("user with id " + id + " does not have any fav category");
			}
		} else {
			throw new Exception("user with id " + id + " does not exist");
		}
	}

	@GetMapping("/recommendation/topics")
	public ResponseEntity<Iterable<Topics>> getAllGame() {

		Iterable<Topics> game = recommendationService.listAllGame();

		return new ResponseEntity<>(game, HttpStatus.OK);

	}

	@GetMapping("/recommendation/topic/{id}")
	public ResponseEntity<Topics> findGameById(Topics game, @PathVariable("id") String id) throws Exception {

		if (recommendationService.checkGameId(Long.parseLong(id))) {

			game.setId(Long.parseLong(id));

			log.info(id);

			Topics game1 = recommendationService.getGameById(Long.parseLong(id));

			// producer.sendGame(game1);

			return new ResponseEntity<Topics>(game1, HttpStatus.OK);
		} else {
			throw new Exception("game with id " + id + " does not exist");
		}

	}

	@PostMapping("/recommendation/topic")
	public ResponseEntity<Topics> addGame(@RequestBody Topics game) throws Exception {

		if (recommendationService.checkUserId(game.getId())) {
			throw new Exception("user with id " + game.getId() + " already exist");
		} else {
			Topics game1 = recommendationService.saveOrUpdateGame(game);

			log.info("game save");

			return new ResponseEntity<Topics>(game1, HttpStatus.OK);

		}

	}

	@PutMapping("/recommendation/topic/{id}")
	public ResponseEntity<Topics> updateGameUsingId(@RequestBody Topics game, @PathVariable("id") String id)
			throws Exception {

		if (recommendationService.checkGameId(Long.parseLong(id))) {
			game.setId(Long.parseLong(id));

			Topics game1 = recommendationService.saveOrUpdateGame(game);

			return new ResponseEntity<Topics>(game1, HttpStatus.OK);
		} else {
			throw new Exception("game with id " + id + " does not exist");
		}

	}

	@DeleteMapping("/recommendation/topic/{id}")
	public ResponseEntity<Topics> deleteGameUsingId(Topics game) throws Exception {

		if (recommendationService.checkGameId(game.getId())) {

			recommendationService.deleteUserById(game.getId());

			return new ResponseEntity<Topics>(game, HttpStatus.OK);

		} else {
			throw new Exception("topic with id " + game.getId() + " does not exist");
		}

	}

	@GetMapping("/recommendation/categories")
	public ResponseEntity<Iterable<Category>> getAllCategory() {

		Iterable<Category> user = recommendationService.listAllCategory();

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@GetMapping("/recommendation/category/{id}")
	public ResponseEntity<Category> findCategoryById(Category category, @PathVariable("id") String id)
			throws Exception {

		if (recommendationService.checkCategoryId(Long.parseLong(id))) {

			category.setId(Long.parseLong(id));

			log.info(id);

			Category category1 = recommendationService.getCategoryById(Long.parseLong(id));

			return new ResponseEntity<Category>(category1, HttpStatus.OK);
		} else {
			throw new Exception("category with id " + id + " does not exist");
		}

	}

	@GetMapping("/recommendation/categoryTopics/{id}")
	public ResponseEntity<List<Topics>> findTopicsInCategory(Category category, @PathVariable("id") String id)
			throws Exception {

		if (recommendationService.checkCategoryId(Long.parseLong(id))) {

			category.setId(Long.parseLong(id));

			log.info(id);

			Category c = recommendationService.getCategoryById(Long.parseLong(id));

			List<Topics> topics = recommendationService.topicsInCategory(Long.parseLong(id));

			List<Topics> topics1 = recommendationService.listAllGame();

			if (topics.size() != 0)

			{
				topics1.removeAll(topics);
				topics.addAll(topics1);
				return new ResponseEntity<>(topics, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(topics1, HttpStatus.OK);
			}
		} else {
			throw new Exception("category with id " + id + " does not exist");
		}

	}
}
