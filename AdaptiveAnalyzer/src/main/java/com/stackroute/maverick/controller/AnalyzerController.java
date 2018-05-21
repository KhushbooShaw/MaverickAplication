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
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;
//import com.stackroute.maverick.service.KafkaProducer;
import com.stackroute.maverick.service.AnalyzerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/v1/recommendation")
@RestController
@CrossOrigin(origins = "*")
// @Api(value = "RecommendationControllerApi", produces =
// MediaType.APPLICATION_JSON_VALUE)
public class AnalyzerController {

	private AnalyzerService recommendationService;

	//@Autowired
	//KafkaProducer producer;

	Logger log = LoggerFactory.getLogger(AnalyzerController.class);

	@Autowired
	public void setProductService(AnalyzerService recommendationService) {
		this.recommendationService = recommendationService;
	}

	@GetMapping("/userGame/{id}")
	// @ApiOperation("get the list of games played by user's friends using user's
	// id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok", response = RecommendationGame.class) })
	public ResponseEntity<String[]> getFriendGame(User user, @PathVariable("id") String id) throws Exception {

		if (recommendationService.checkUserId(Long.parseLong(id))) {

			String[] output = recommendationService.friendPlayedGame(Long.parseLong(id));

			// producer.sendRecommended(output);

			return new ResponseEntity<String[]>(output, HttpStatus.OK);
		} else {
			throw new Exception("user with id " + id + " does not exist");
		}

	}

	@GetMapping("/users")
	public ResponseEntity<?> sendGameId() {
        RecommendationUser user=new RecommendationUser();
        user.setId((long)890);
        user.setGender("female");
        user.setName("Pari");
		//recommendationService.cretaeRelation(user.getId());
		Iterable<RecommendationUser> users = recommendationService.listAllUser();

		return new ResponseEntity<Iterable<RecommendationUser>>(users, HttpStatus.OK);

	}

	@GetMapping("/postGameIdInKafka/{id}")
	public ResponseEntity<?> getAllUser(@PathVariable("id") String id) {

		//producer.sendGameid(id);
		//producer.sendGameid(Integer.parseInt(id));

		return new ResponseEntity<>("ok", HttpStatus.OK);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<RecommendationUser> findUserById(@PathVariable("id") String id) throws Exception {

		// if (recommendationService.checkUserId(Long.parseLong(id))) {
		//
		// user.setId(Long.parseLong(id));
		// // user.setId(Integer.parseInt(id));
		//
		// log.info(id);

			RecommendationUser user1 = recommendationService.getUserById(Long.parseLong(id));

//			producer.sendUser(user1);

			return new ResponseEntity<RecommendationUser>(user1, HttpStatus.OK);
//		} else {
//			throw new Exception("user with id " + id + " does not exist");
//		}

	}
    
//	@GetMapping("/serach")
//	public ResponseEntity<List<RecommendationUser>> serachTest() throws Exception {
//		String s="Ash";
//		List<RecommendationUser> users=recommendationService.searchTest(s, s.length());
//		return new ResponseEntity<List<RecommendationUser>>(users, HttpStatus.OK);
//	}
	
	@PostMapping("/user")
	public ResponseEntity<RecommendationUser> addUser(@RequestBody RecommendationUser user) throws Exception {

		// if(recommendationService.checkUserId(user.getId()))
		// {
		// throw new Exception("user with id "+user.getId()+" already exist");
		// }
		// // else
		// // {
		System.out.println("user details" + user);
		log.info("user save in controller1");

		RecommendationUser user1 = recommendationService.saveOrUpdateUser(user);

		log.info("user save in controller2");

		return new ResponseEntity<RecommendationUser>(user1, HttpStatus.OK);

	}

	 @GetMapping("/topics")
	public ResponseEntity<Iterable<RecommendationGame>> getAllGame() {
	//
	 Iterable<RecommendationGame> game = recommendationService.listAllGame();
	//
	 return new ResponseEntity<>(game, HttpStatus.OK);
	
	 }

	
	 @GetMapping("/categories")
	 public ResponseEntity<Iterable<Category>> getAllCategory() {
	
	 Iterable<Category> user = recommendationService.listAllCategory();
	
	 return new ResponseEntity<>(user, HttpStatus.OK);
	//
	 }
	//
      @GetMapping("/recommendation/category/{id}")
	 public ResponseEntity<Category> findCategoryById(Category category,
	 @PathVariable("id") String id)
	 throws Exception {
	//
	// if (recommendationService.checkCategoryId(Long.parseLong(id))) {
	//
	// category.setId(Long.parseLong(id));
	//
	// log.info(id);
	//
      Category category1 =
	 recommendationService.getCategoryById(Long.parseLong(id));
	//
	 return new ResponseEntity<Category>(category1, HttpStatus.OK);
	// } else {
	// throw new Exception("category with id " + id + " does not exist");
	// }
	//
	 }
	
	 @GetMapping("/categoryTopics/{id}")
	 public ResponseEntity<List<RecommendationGame>> findTopicsInCategory(Category category,
	@PathVariable("id") String id)
	 throws Exception {
	
	 if (recommendationService.checkCategoryId(Long.parseLong(id))) {
	
	 category.setId(Long.parseLong(id));
	
	 log.info(id);
	
	 Category c = recommendationService.getCategoryById(Long.parseLong(id));
	
	 List<RecommendationGame> topics =
	 recommendationService.topicsInCategory(Long.parseLong(id));
	
	 List<RecommendationGame> topics1 = recommendationService.listAllGame();
	
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
