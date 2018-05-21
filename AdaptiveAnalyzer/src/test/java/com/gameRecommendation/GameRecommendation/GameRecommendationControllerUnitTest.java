//package com.gameRecommendation.GameRecommendation;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.gameRecommendation.controller.RecommendationController;
//import com.gameRecommendation.domain.User;
//import com.gameRecommendation.service.RecommendationService;
//
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(RecommendationController.class)
//public class GameRecommendationControllerUnitTest {
//
//	@Autowired
//	MockMvc mockMvc;
//    User user;
//	@MockBean
//	RecommendationService recommendationService;
//	@InjectMocks
//	private RecommendationController recommendationController;
//	@Before
//	public void setup() {
//
//		MockitoAnnotations.initMocks(this);
//
//		mockMvc = MockMvcBuilders.standaloneSetup(recommendationController).build();
//		
//		user=new User();
//		
//		user.setId((long) 333);
//		
//		user.setName("Khushboo");
//		
//		user.setGender("female");
//		
//		user.setFav_category(null);
//		
//		user.setLocation("Kolkata");
//		
//		//recommendationService.saveOrUpdateUser(user);
//
//	}
//	@Test
//	 public void getAllUserTest() throws Exception {
//	
//	 List<User> users = new ArrayList<User>();
//	
//	 users.add(user);
//	
//	 Mockito.when(recommendationService.listAllUser()).thenReturn(users);
//	
//	 mockMvc.perform(get("/api/v1/recommendation/users"))
//	 
//	 .andExpect(status().isOk())
//	 
//	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
//	 
//	 verify(recommendationService, times(1)).listAllUser();
//	 }
//	@Ignore
//	@Test
//	 public void findUserByIdTest() throws Exception {
//	
////	 List<User> users = new ArrayList<User>();
////	
////	 users.add(user);
//		 Mockito.when(recommendationService.getUserById((long) 208)).thenReturn(new User());
//	 
//	 
//	 System.out.println(recommendationService.listAllUser());
//	
//	 mockMvc.perform(get("/api/v1/recommendation/user/208"))
//	 
//	 .andExpect(status().isOk())
//	 
//	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
//	 
//	// verify(recommendationService, times(1)).getUserById((long) 208);
//	 }
//	@Test
//	 public void addUserTest() throws Exception {
//			
////		 List<User> users = new ArrayList<User>();
//	//	
////		 users.add(user);
//		
//		Mockito.when(recommendationService.saveOrUpdateUser(user)).thenReturn(user);
//		 
//		 System.out.println(recommendationService.listAllUser());
//		
//		 mockMvc.perform(post("/api/v1/recommendation/user"))
//		 
//		 .andExpect(status().isOk())
//		 
//		 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
//		 
//		// verify(recommendationService, times(1)).getUserById((long) 208);
//		 } 
//	
//	
//}
