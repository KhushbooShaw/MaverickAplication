package com.stackroute.maverick.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
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

import com.google.gson.Gson;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.stackroute.maverick.domain.AdaptiveOption;
import com.stackroute.maverick.domain.AdaptiveQuestion;
import com.stackroute.maverick.domain.AdaptiveResponseQuestion;
import com.stackroute.maverick.domain.AdaptiveResult;
import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.Game;
import com.stackroute.maverick.domain.Questions;
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
@CrossOrigin("*")
// @Api(value = "RecommendationControllerApi", produces =
// MediaType.APPLICATION_JSON_VALUE)
public class AdaptiveGameEngineController {

	private AdaptiveGameEngineService adaptiveService;
	
    @Autowired

    private RestTemplate restTemplate;

    @Autowired

    private EurekaClient eurekaClient;

    @Value("${service.gameManagerIPAddress}")

    private String gameManagerIPAddress;
    
    private List<Questions> questionsInL1;
    
    private List<Questions> questionsInL2;
    
    private List<Questions> questionsInL3;
    
    private List<AdaptiveResponseQuestion> response;
    
    private AdaptiveResult adaptiveResult;
    
    private int category_id;
    
    private int topic_id;
    
    private int user_id;
    
    private int game_id;
    
    int i1,i2,i3;
    
    Date date ;
    DateFormat dateFormat ;
    String strDate ;
    
    @Autowired
	private SimpMessageSendingOperations msgTemplate;
	
	List<AdaptiveQuestion> quest;
	//Questions q;
	int i=0;

	//@Autowired
	//KafkaProducer producer;

	Logger log = LoggerFactory.getLogger(AdaptiveGameEngineController.class);

	@Autowired
	public AdaptiveGameEngineController(AdaptiveGameEngineService adaptiveService) {
		this.adaptiveService = adaptiveService;
		date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        strDate = dateFormat.format(date);
        questionsInL1=new ArrayList<Questions>();
        
        questionsInL2=new ArrayList<Questions>();
        
        questionsInL3=new ArrayList<Questions>();
        
        response=new ArrayList<AdaptiveResponseQuestion>();
        
        adaptiveResult=new AdaptiveResult();
        i=0;
        i1=0;
        i2=0;
        i3=0;
	}
	
	
	@RequestMapping("/gameManagerData")
    public Game[] findPeers() {

//        Application application = eurekaClient.getApplication(employeeSearchServiceId);
//
//        InstanceInfo instanceInfo = application.getInstances().get(0);

//        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/findall";

//        System.out.println("URL" + url);
		
		System.out.println("IP:"+gameManagerIPAddress);
        
       String url=gameManagerIPAddress+"/api/game/games";

        Game[] game = restTemplate.getForObject(url, Game[].class);
         System.out.println(game[0].getCategoryId());
         
         adaptiveService.createCategoriesNode();
         
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
       	for(int j=0;j<game[i].getTopic().getQuestions().size();j++)
       	{
       		
       		if(adaptiveService.checkQuestionIdForLevel1(game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId()).size()==0 & adaptiveService.checkQuestionIdForLevel2(game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId()).size()==0 & adaptiveService.checkQuestionIdForLevel3(game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId()).size()==0)
        		{ 
       			 
        			if(game[i].getTopic().getQuestions().get(j).getQuestionLevel()==1)
       			{
        				adaptiveService.addQuestionInLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), game[i].getTopic().getQuestions().get(j).getQuestionStem(), strDate);
        				
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption1()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 1, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
       				    {
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 1, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption2()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 2, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 2, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption3()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 3, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 3, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption4()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 4, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel1(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 4, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        			}
        			else if(game[i].getTopic().getQuestions().get(j).getQuestionLevel()==2)
        			{
        				adaptiveService.addQuestionInLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), game[i].getTopic().getQuestions().get(j).getQuestionStem(), strDate);
        				
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption1()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 1, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 1, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption2()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 2, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 2, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption3()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 3, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 3, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption4()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 4, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel2(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 4, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        			}
        			else if(game[i].getTopic().getQuestions().get(j).getQuestionLevel()==3)
        			{

        				adaptiveService.addQuestionInLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), game[i].getTopic().getQuestions().get(j).getQuestionStem(), strDate);
        				
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption1()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 1, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 1, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption2()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 2, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 2, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption3()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 3, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 3, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
        				if(game[i].getTopic().getQuestions().get(j).getCorrectAnswer().equalsIgnoreCase(game[i].getTopic().getQuestions().get(j).getOption4()))
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 4, game[i].getTopic().getQuestions().get(j).getOption1(), true, strDate);
        			    }
        				else
        				{
        					adaptiveService.addOptionInQuestionOfLevel3(game[i].getCategoryId(), game[i].getTopic().getTopicId(), game[i].getTopic().getQuestions().get(j).getQuestionId(), 4, game[i].getTopic().getQuestions().get(j).getOption1(), false, strDate);
        				}
      			}
       		}
       	}
       }
        
        return game;

    }
	
   @GetMapping("/{category_id}/{topic_id}/{game_id}/{user_id}")
   public List<Questions> allQuestions(@PathVariable("category_id") int category_id,@PathVariable("topic_id") int topic_id,@PathVariable("game_id") int game_id,@PathVariable("user_id") int user_id)
   {
	   i1=0;
	   i2=0;
	   i3=0;
	   this.i=0;
	   this.user_id=user_id;
	   this.category_id=category_id;
	   this.topic_id=topic_id;
	   this.game_id=game_id;
	   
	   adaptiveResult.setCategory_id(category_id);
	   adaptiveResult.setTopic_id(topic_id);
	   adaptiveResult.setGame_id(game_id);
	   adaptiveResult.setUser_id(user_id);
	   
	   List<AdaptiveQuestion> questionsAttemptedInL1=new ArrayList<AdaptiveQuestion>();
	   List<AdaptiveQuestion> questionsAttemptedInL2=new ArrayList<AdaptiveQuestion>();
	   List<AdaptiveQuestion> questionsAttemptedInL3=new ArrayList<AdaptiveQuestion>();
	  
		  questionsAttemptedInL1=adaptiveService.questionsAnsweredByUserInLevel1(user_id, topic_id, category_id);
		  questionsAttemptedInL2=adaptiveService.questionsAnsweredByUserInLevel2(user_id, topic_id, category_id);
		  questionsAttemptedInL3=adaptiveService.questionsAnsweredByUserInLevel3(user_id, topic_id, category_id);
	  
	   List<AdaptiveQuestion> questionInL1=adaptiveService.listOfQuestionInLevel1(category_id, topic_id);
	   
	   List<AdaptiveOption> option;
	   if(questionInL1.size()!=0)
	   {
		   if(questionsAttemptedInL1.size()!=0)
		   {
		   questionsInL1.removeAll(questionsAttemptedInL1);
		   }
		   
	   for(int i=0;i<questionInL1.size();i++)
	   {
		   Questions question=new Questions();
		   question.setQuestionId(questionInL1.get(i).getQuestionId());
		   question.setQuestionStem(questionInL1.get(i).getQuestionStem());
		   question.setQuestionLevel(1);
		   option=adaptiveService.listOfOptionInQuestionInLevel1(category_id, topic_id, questionInL1.get(i).getQuestionId());
		   
		   for(int j=0;j<option.size();j++)
		   {
			   if(option.get(j).getOption_id()==1)
			   {
				   question.setOption1(option.get(j).getOption_value());
			   }
			   if(option.get(j).getOption_id()==2)
			   {
				   question.setOption2(option.get(j).getOption_value());
			   }
			   if(option.get(j).getOption_id()==3)
			   {
				   question.setOption3(option.get(j).getOption_value());
			   }
			   if(option.get(j).getOption_id()==4)
			   {
				   question.setOption4(option.get(j).getOption_value());
			   }
		   }
		   
		   question.setCorrectAnswer(adaptiveService.correctOptionInQuestionInLevel1(category_id, topic_id, questionInL1.get(i).getQuestionId()).get(0).getOption_value());
		   questionsInL1.add(question);
		   
	   }
	   }
	   List<AdaptiveQuestion> questionInL2=adaptiveService.listOfQuestionInLevel2(category_id, topic_id);
	   
	   List<AdaptiveOption> option2;
	   if(questionInL2.size()!=0)
	   {
		   if(questionsAttemptedInL2.size()!=0)
		   {
		   questionInL2.removeAll(questionsAttemptedInL2);
		   }
	   for(int i=0;i<questionInL2.size();i++)
	   {
		   Questions question=new Questions();
		   question.setQuestionId(questionInL2.get(i).getQuestionId());
		   question.setQuestionStem(questionInL2.get(i).getQuestionStem());
		   question.setQuestionLevel(2);
		   option2=adaptiveService.listOfOptionInQuestionInLevel2(category_id, topic_id, questionInL2.get(i).getQuestionId());
		   for(int j=0;j<option2.size();j++)
		   {
			   if(option2.get(j).getOption_id()==1)
			   {
				   question.setOption1(option2.get(j).getOption_value());
			   }
			   if(option2.get(j).getOption_id()==2)
			   {
				   question.setOption2(option2.get(j).getOption_value());
			   }
			   if(option2.get(j).getOption_id()==3)
			   {
				   question.setOption3(option2.get(j).getOption_value());
			   }
			   if(option2.get(j).getOption_id()==4)
			   {
				   question.setOption4(option2.get(j).getOption_value());
			   }
		   }
		   
		   question.setCorrectAnswer(adaptiveService.correctOptionInQuestionInLevel2(category_id, topic_id, questionInL2.get(i).getQuestionId()).get(0).getOption_value());
		   questionsInL2.add(question);
		   
	   }
	   }
	   
	   List<AdaptiveQuestion> questionInL3=adaptiveService.listOfQuestionInLevel3(category_id, topic_id);
	   
	   List<AdaptiveOption> option3;
	   if(questionInL3.size()!=0)
	   {
		   if(questionsAttemptedInL3.size()!=0)
		   {
		   questionInL3.removeAll(questionsAttemptedInL3);
		   }
	   for(int i=0;i<questionInL3.size();i++)
	   {
		   Questions question=new Questions();
		   question.setQuestionId(questionInL3.get(i).getQuestionId());
		   question.setQuestionStem(questionInL3.get(i).getQuestionStem());
		   question.setQuestionLevel(3);
		   option3=adaptiveService.listOfOptionInQuestionInLevel3(category_id, topic_id, questionInL3.get(i).getQuestionId());
		   for(int j=0;j<option3.size();j++)
		   {
			   if(option3.get(j).getOption_id()==1)
			   {
				   question.setOption1(option3.get(j).getOption_value());
			   }
			   if(option3.get(j).getOption_id()==2)
			   {
				   question.setOption2(option3.get(j).getOption_value());
			   }
			   if(option3.get(j).getOption_id()==3)
			   {
				   question.setOption3(option3.get(j).getOption_value());
			   }
			   if(option3.get(j).getOption_id()==4)
			   {
				   question.setOption4(option3.get(j).getOption_value());
			   }
		   }
		   
		   question.setCorrectAnswer(adaptiveService.correctOptionInQuestionInLevel3(category_id, topic_id, questionInL3.get(i).getQuestionId()).get(0).getOption_value());
		   questionsInL3.add(question);
		   
	   }
	   }
	   return questionsInL3;
	   
   }
   @MessageMapping("/message")
   @SendTo("/topic/reply")
	public Questions processMessageFromClient(@Payload String message) throws Exception {
	  
	   Questions questions=questionsInL1.get(i1);
	   i1++;
		String answer = "Client Message : \t"+new Gson().fromJson(message, Map.class).get("selectedResponse").toString();
//		while(i<10)
//		{
//		while(i1<10)
//		{
//		questions=questionsInL1.get(i1);
//		i1++;
//		
//		}
//		
//		}
//		response.get(i).setQuestionId(questions.getQuestionId());
//		response.get(i).setQuestionStem(questions.getQuestionStem());
//		response.get(i).setQuestionLevel(questions.getQuestionLevel());
//		response.get(i).setOption1(questions.getOption1());
//		i++;
        System.out.println("message :"+message);
		System.out.println("answer Getting..."+answer);
		return questions;
	}
   @MessageExceptionHandler
   public String handleException(Throwable exception) {
		msgTemplate.convertAndSend("/errors", exception.getMessage());
	    return exception.getMessage();
   }
	
}
