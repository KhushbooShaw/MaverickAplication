//package com.stackroute.maverick.controller;
//package com.gameRecommendation.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.gameRecommendation.domain.User;
//import com.gameRecommendation.service.RecommendationService;
//
//@Controller
//public class ControllerWay {
//	private RecommendationService recommendationService;
//
//	// @Autowired
//	// KafkaProducer producer;
//
//	Logger log = LoggerFactory.getLogger(ControllerWay.class);
//
//	@Autowired
//	public void setProductService(RecommendationService recommendationService) {
//		this.recommendationService = recommendationService;
//	}
//
//	 @RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String addUser(@RequestBody User user) throws Exception {
//
//		System.out.println("user details" + user);
//		log.info("user save in controller1");
//
//		User user1 = recommendationService.saveOrUpdateUser(user);
//
//		log.info("user save in controller2");
//
//		return "done";
//
//	}
//}
