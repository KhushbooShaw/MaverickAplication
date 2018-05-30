package com.stackroute.maverick.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.AdaptiveCategory;
import com.stackroute.maverick.domain.AdaptiveLevel;
import com.stackroute.maverick.domain.AdaptiveOption;
import com.stackroute.maverick.domain.AdaptiveQuestion;
import com.stackroute.maverick.domain.AdaptiveTopic;
import com.stackroute.maverick.domain.AdaptiveUser;
import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.User;

public interface AdaptiveGameEngineService {
	
 void createCategoriesNode();
	
 List<AdaptiveCategory> addCategory(int category_id,String time);
 
 List<AdaptiveCategory> checkCategoryId(int category_id);
 
 List<AdaptiveTopic> addTopic(int category_id,int topic_id,String time);
 
 List<AdaptiveTopic> checkTopicId(int topic_id);
 
 List<AdaptiveLevel> addLevel1(int topic_id);
 
 List<AdaptiveLevel> addLevel2(int topic_id);
 
 List<AdaptiveLevel> addLevel3(int topic_id);
 
 List<AdaptiveQuestion> checkQuestionIdForLevel1(int topic_id,int questionId);
 
 List<AdaptiveQuestion> checkQuestionIdForLevel2(int topic_id,int questionId);
 
 List<AdaptiveQuestion> checkQuestionIdForLevel3(int topic_id,int questionId);
	
 List<AdaptiveQuestion> addQuestionInLevel1(int category_id,int topic_id,int questionId,String questionStem,String time);

 List<AdaptiveQuestion> addQuestionInLevel2(int category_id,int topic_id,int questionId,String questionStem,String time);

 List<AdaptiveQuestion> addQuestionInLevel3(int category_id,int topic_id,int questionId,String questionStem,String time);

 List<AdaptiveOption> addOptionInQuestionOfLevel1(int category_id,int topic_id,int questionId,int option_id,String option_value,boolean ans,String time);

 List<AdaptiveOption> addOptionInQuestionOfLevel2(int category_id,int topic_id,int questionId,int option_id,String option_value,boolean ans,String time);

 List<AdaptiveOption> addOptionInQuestionOfLevel3(int category_id,int topic_id,int questionId,int option_id,String option_value,boolean ans,String time);

 List<AdaptiveUser> checkUserId(int user_id);
 
 List<AdaptiveUser> createUSer(int user_id,String time);
 
 List<AdaptiveUser> relateUserWithTopic(int user_id,int topic_id,int category_id);
 
 List<AdaptiveQuestion> listOfQuestionInLevel1(int category_id,int topic_id);
 
 List<AdaptiveQuestion> listOfQuestionInLevel2(int category_id,int topic_id);
 
 List<AdaptiveQuestion> listOfQuestionInLevel3(int category_id,int topic_id);
 
 List<AdaptiveOption> listOfOptionInQuestionInLevel1(int category_id,int topic_id,int questionId);
 
 List<AdaptiveOption> listOfOptionInQuestionInLevel2(int category_id,int topic_id,int questionId);
 
 List<AdaptiveOption> listOfOptionInQuestionInLevel3(int category_id,int topic_id,int questionId);
 
 List<AdaptiveOption> correctOptionInQuestionInLevel3(int category_id,int topic_id,int questionId);
 
 List<AdaptiveOption> correctOptionInQuestionInLevel2(int category_id,int topic_id,int questionId);
 
 List<AdaptiveOption> correctOptionInQuestionInLevel1(int category_id,int topic_id,int questionId);
 
 List<AdaptiveUser> optionAnsweredByUserInLevel1(int category_id,int topic_id,int questionId,int option_id,int user_id);
 
 List<AdaptiveUser> optionAnsweredByUserInLevel2(int category_id,int topic_id,int questionId,int option_id,int user_id);
 
 List<AdaptiveUser> optionAnsweredByUserInLevel3(int category_id,int topic_id,int questionId,int option_id,int user_id);
 
}
