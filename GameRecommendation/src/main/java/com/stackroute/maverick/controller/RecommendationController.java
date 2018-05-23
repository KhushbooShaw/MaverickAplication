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
import com.stackroute.maverick.service.RecommendationService;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/v1/recommendation")
@RestController
@CrossOrigin(origins = "*")
@Api(value = "RecommendationControllerApi", produces =MediaType.APPLICATION_JSON_VALUE)
public class RecommendationController {

	private RecommendationService recommendationService;

	//@Autowired
	//KafkaProducer producer;

	Logger log = LoggerFactory.getLogger(RecommendationController.class);

	@Autowired
	public void setProductService(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}

	
	@GetMapping("/users")
	public ResponseEntity<Iterable<RecommendationUser>> sendGameId() {
        
		Iterable<RecommendationUser> users = recommendationService.listAllUser();

		return new ResponseEntity<Iterable<RecommendationUser>>(users, HttpStatus.OK);

	}

	

	@GetMapping("/user/{id}")
	public ResponseEntity<RecommendationUser> findUserById(@PathVariable("id") String id) throws Exception {

	

			RecommendationUser user1 = recommendationService.getUserById(Long.parseLong(id));


			return new ResponseEntity<RecommendationUser>(user1, HttpStatus.OK);


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

	 @Timed(value = "getAllCategory()", histogram = true, percentiles = { 0.95 }, extraTags = {
	            "version", "1.0" })
	 @GetMapping("/categories/{userId}")
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
	
	 @GetMapping("/categoryTopics/{userId}/{id}")
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
