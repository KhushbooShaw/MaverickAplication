package com.stackroute.maverick.controller;

import java.util.ArrayList;
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
import com.stackroute.maverick.domain.RecommendationCategory;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;
import com.stackroute.maverick.service.KafkaProducer;
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

	@Autowired
	KafkaProducer producer;

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
	@Timed(value = "getAllGames()", histogram = true, percentiles = { 0.95 }, extraTags = {"version", "1.0" })
	@GetMapping("/games/{userId}")
	public ResponseEntity<List<RecommendationGame>> getAllGame(@PathVariable("userId") String userId) {
	
	 List<RecommendationGame> mostGame = recommendationService.mostPlayedGame(Integer.parseInt(userId));
		
	 List<RecommendationGame> games = recommendationService.listAllGame();
	 
	 List<RecommendationCategory> favCategories = recommendationService.getUserFavCategory(Integer.parseInt(userId));
	 
	 List<RecommendationGame> games1=new ArrayList<RecommendationGame>();
	 
	 for(int j=0;j<favCategories.size();j++)
	 {
		 List<RecommendationGame> games2 = recommendationService.gamesInCategory(favCategories.get(j).getCategory_id());
			
		games1.addAll(games2);

	 }
	 
	 int l1=mostGame.size();
	 games1.removeAll(mostGame);
	 int l2=games1.size();
	 mostGame.addAll(games1);
	 games.removeAll(mostGame);
	 mostGame.addAll(games);
	 
	 for(int i=0;i<mostGame.size();i++)
	 {
		 for(int j=0;j<l1;j++)
		 {
			 mostGame.get(j).setRecommendation("Most Played Games");
		 }
		 for(int j=l1;j<l2;j++)
		 {
			 mostGame.get(j).setRecommendation("Games in Favourite Category");
		 }
	 }
	
	 return new ResponseEntity<>(mostGame, HttpStatus.OK);
	
	 }

	 @Timed(value = "getAllCategory()", histogram = true, percentiles = { 0.95 }, extraTags = {"version", "1.0" })
	 @GetMapping("/categories/{userId}")
	 public ResponseEntity<List<RecommendationCategory>> getAllCategory(@PathVariable("userId") String userId) {
	
	 List<RecommendationCategory> categories = recommendationService.listAllCategory();
	 
	 List<RecommendationCategory> FavCategories = recommendationService.getUserFavCategory(Integer.parseInt(userId));
	 
	 categories.removeAll(FavCategories);
	 
	 FavCategories.addAll(categories);
	
	 return new ResponseEntity<>(FavCategories, HttpStatus.OK);
	
	 }
	
     @GetMapping("/recommendation/category/{id}")
	 public ResponseEntity<RecommendationCategory> findCategoryById(Category category, @PathVariable("id") String id) throws Exception {
	
     RecommendationCategory category1 = recommendationService.getCategoryById(Integer.parseInt(id));
	
	 return new ResponseEntity<RecommendationCategory>(category1, HttpStatus.OK);
	
	 }
     @Timed(value = "findGamesInCategory()", histogram = true, percentiles = { 0.95 }, extraTags = {"version", "1.0" })
	 @GetMapping("/categoryGames/{userId}/{id}")
	 public ResponseEntity<List<RecommendationGame>> findGamesInCategory(Category category,@PathVariable("id") String id) throws Exception {
	
	 category.setId(Long.parseLong(id));
	
	 RecommendationCategory c = recommendationService.getCategoryById(Integer.parseInt(id));
	
	 List<RecommendationGame> games = recommendationService.gamesInCategory(Integer.parseInt(id));
	
	 List<RecommendationGame> games1 = recommendationService.listAllGame();
	
	 if (games.size() != 0)
	 {
	 int l=games.size();
	 games1.removeAll(games);
	 games.addAll(games1);
	 for(int i=0;i<l;i++)
	 {
		 games.get(i).setRecommendation("Games In Selected Category");
	 }
	 return new ResponseEntity<>(games, HttpStatus.OK);
	
	 } else {
	 return new ResponseEntity<>(games1, HttpStatus.OK);
	 }
	 

	
	}
}
