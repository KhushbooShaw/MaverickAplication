package com.stackroute.maverick.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.Game;
import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;
//import com.stackroute.maverick.service.KafkaProducer;
import com.stackroute.maverick.service.AdaptiveGameEngineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RefreshScope
@RequestMapping("/api/v1/adaptiveGameEngine")
@RestController
@CrossOrigin(origins = "*")
// @Api(value = "RecommendationControllerApi", produces =
// MediaType.APPLICATION_JSON_VALUE)
public class AdaptiveGameEngineController {

	private AdaptiveGameEngineService recommendationService;
	
    @Autowired

    private RestTemplate restTemplate;

    @Autowired

    private EurekaClient eurekaClient;

//    @Value("${service.employyesearch.serviceId}")
//
//    private String employeeSearchServiceId;

	//@Autowired
	//KafkaProducer producer;

	Logger log = LoggerFactory.getLogger(AdaptiveGameEngineController.class);

	@Autowired
	public void setProductService(AdaptiveGameEngineService recommendationService) {
		this.recommendationService = recommendationService;
	}
	
	
	@RequestMapping("/testing")
    public Collection < Game > findPeers() {

//        Application application = eurekaClient.getApplication(employeeSearchServiceId);
//
//        InstanceInfo instanceInfo = application.getInstances().get(0);

//        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/findall";

//        System.out.println("URL" + url);
        
       String url="http://172.23.238.185:8080/api/game/games";

        Collection < Game > list = restTemplate.getForObject(url, Collection.class);

        System.out.println("RESPONSE :" + list.size());

        return list;

    }
	
//	@PostMapping("/user")
//	public ResponseEntity<RecommendationUser> addUser(@RequestBody RecommendationUser user) throws Exception {
//
//		
//		System.out.println("user details" + user);
//		log.info("user save in controller1");
//
//		RecommendationUser user1 = recommendationService.saveOrUpdateUser(user);
//
//		log.info("user save in controller2");
//
//		return new ResponseEntity<RecommendationUser>(user1, HttpStatus.OK);
//
//	}

	
}
