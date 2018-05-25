package com.stackroute.maverick.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

	private AdaptiveGameEngineService adaptiveService;
	
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
	public void setProductService(AdaptiveGameEngineService adaptiveService) {
		this.adaptiveService = adaptiveService;
	}
	
	
	@RequestMapping("/gameManagerData")
    public Game[] findPeers() {

//        Application application = eurekaClient.getApplication(employeeSearchServiceId);
//
//        InstanceInfo instanceInfo = application.getInstances().get(0);

//        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/findall";

//        System.out.println("URL" + url);
        
       String url="http://172.23.238.185:8080/api/game/games";

        Game[] game = restTemplate.getForObject(url, Game[].class);
         System.out.println(game[0].getCategoryId());
        

         Date date = new Date();
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
         
         //to convert Date to String, use format method of SimpleDateFormat class.
         String strDate = dateFormat.format(date);
       for(int i=0;i<game.length;i++)
     {
        	if(adaptiveService.checkCategoryId(game[i].getCategoryId()).size()==0)
        	{
        		adaptiveService.addCategory(game[i].getCategoryId(), strDate);
         	}
        	if(adaptiveService.checkTopicId(game[i].getTopic().getTopicId()).size()==0)
        	{
       		adaptiveService.addTopic(game[i].getCategoryId(), game[i].getTopic().getTopicId(), strDate);
        	}
       	for(int j=0;j<game[i].getQuestions().size();j++)
       	{
       		if(adaptiveService.checkQuestionIdForLevel1(game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId()).size()==0 & adaptiveService.checkQuestionIdForLevel2(game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId()).size()==0 & adaptiveService.checkQuestionIdForLevel3(game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId()).size()==0)
        		{
        			if(game[i].getQuestions().get(j).getQuestionLevel()==1)
        			{
        				adaptiveService.addQuestionInLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), game[i].getQuestions().get(j).getQuestionStem(), strDate);
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption1()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 1, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
       				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 1, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption2()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 2, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 2, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption3()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 3, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 3, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption4()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 4, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 4, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        			}
        			else if(game[i].getQuestions().get(j).getQuestionLevel()==2)
        			{
        				adaptiveService.addQuestionInLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), game[i].getQuestions().get(j).getQuestionStem(), strDate);
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption1()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 1, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 1, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption2()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 2, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 2, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption3()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 3, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 3, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption4()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 4, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 4, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        			}
        			else if(game[i].getQuestions().get(j).getQuestionLevel()==3)
        			{
        				adaptiveService.addQuestionInLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), game[i].getQuestions().get(j).getQuestionStem(), strDate);
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption1()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 1, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 1, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption2()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 2, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 2, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption3()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 3, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 3, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getQuestions().get(j).getOption4()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 4, game[i].getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getQuestions().get(j).getQuestionId(), 4, game[i].getQuestions().get(j).getOption1(), false, strDate);
        				}
       			}
       		}
       	}
       }
        
        return game;

    }
	


	
}
