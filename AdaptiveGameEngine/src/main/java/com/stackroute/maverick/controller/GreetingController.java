package com.stackroute.maverick.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;
import com.stackroute.maverick.domain.*;
import com.stackroute.maverick.domain.HelloMessage;
@CrossOrigin(value="*")
@RestController
public class GreetingController {

//	@Autowired 
//	private ParticipantRepository participantRepository;
	
	@Autowired
	private SimpMessageSendingOperations msgTemplate;
	
	List<AdaptiveQuestion> quest;
	//Questions q;
	int i=0;
	
	
//	@SubscribeMapping("/chat.participants")
//	public Collection<JoiningEvent> retrieveParticipants() {
//		return participantRepository.getActiveSessions().values();
//	}
//	
	
	
//	EventDetails evd = new EventDetails();
//	String userId = evd.getUserId();
	String userId = "123";
	
//	public AdaptiveQuestion sendQuestion() {
//		
//		List<AdaptiveQuestion> quest=new ArrayList<AdaptiveQuestion>();
//        
//		
//		return quest;
//	}
//	@MessageMapping("/message")
//    @SendTo("/topic/reply")
//	public Questions storeResponse(@Payload  String message) throws Exception {
//		Gson data = new Gson();
//		MultiPlayerGameResponseData responseData = new MultiPlayerGameResponseData();
//
//		int userId = Integer.parseInt((data.fromJson(message, Map.class).get("userId").toString()));
//		int qId = Integer.parseInt(data.fromJson(message, Map.class).get("questionId").toString());
//		responseData.setUserId(userId);
//		responseData.setSelectedOption(data.fromJson(message, Map.class).get("selectedResponse").toString());
//		responseData.setQuestionStamp("questionStamp");
//		responseData.setQuestionId(qId);
//		
//		/*Getting response from user*/
//		String json = data.toJson(responseData);
//		System.out.println("Json Data ===>"+json);
//		
//		
//		
//		/*sending Question through socket*/
//		List<Questions> question = sendQuestion();
//		Questions q = new Questions();
//		q=question.get(i);
//		if(i<question.size()){
//            i++;
//		}
//		else{
//           i=0;
//		}
//				
//		System.out.println("here:"+i);
//		return q;
//	}
//	
	
	@MessageMapping("/message")
    @SendTo("/topic/reply")
	public String processMessageFromClient(@Payload  String message) throws Exception {
		//this.userId = userId;
	//	String name = "UserId : "+userId+"\n"+ "Client Message : \t"+new Gson().fromJson(message, Map.class).get("name").toString();
		String name = "Client Message : \t"+new Gson().fromJson(message, Map.class).get("name").toString();
        System.out.println("message :"+message);
		System.out.println("Name Getting..."+name);
		return name;
	}
//	@CrossOrigin
//	@MessageMapping("/chat.message")
//	public EventDetails filterMessage(@Payload EventDetails message, Principal principal) {
//		///checkProfanityAndSanitize(message);
//		
//		message.setUserName(principal.getName());
//		
//		return message;
//	}
//	
//	@MessageMapping("/chat.private.{userName}")
//	public void filterPrivateMessage(@Payload EventDetails message, @DestinationVariable("userName") String username, Principal principal) {
//		//checkProfanityAndSanitize(message);
//		
//		message.setUserName(principal.getName());
//
//		msgTemplate.convertAndSend("/user/" + username + "/exchange/amq.direct/chat.message", message);
//	}
//	
	@MessageExceptionHandler
    public String handleException(Throwable exception) {
		msgTemplate.convertAndSend("/errors", exception.getMessage());
	    return exception.getMessage();
    }
//
//	 private final SimpMessagingTemplate template;
//
//	    @Autowired
//	    GreetingController(SimpMessagingTemplate template){
//	        this.template = template;
//	    }
//
//	    @MessageMapping("/send/message")
//	    public void onReceivedMesage(String message){
//	        this.template.convertAndSend("/chat",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
//	}
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
//      //  Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//    }

}