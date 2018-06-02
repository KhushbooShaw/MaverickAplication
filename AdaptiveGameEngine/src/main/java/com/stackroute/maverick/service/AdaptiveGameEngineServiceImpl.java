package com.stackroute.maverick.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.maverick.domain.AdaptiveCategory;
import com.stackroute.maverick.domain.AdaptiveLevel;
import com.stackroute.maverick.domain.AdaptiveOption;
import com.stackroute.maverick.domain.AdaptiveQuestion;
import com.stackroute.maverick.domain.AdaptiveTopic;
import com.stackroute.maverick.domain.AdaptiveUser;
import com.stackroute.maverick.repository.AdaptiveCategoriesRepository;
import com.stackroute.maverick.repository.AdaptiveCategoryRepository;
import com.stackroute.maverick.repository.AdaptiveLevelRepository;
import com.stackroute.maverick.repository.AdaptiveOptionRepository;
import com.stackroute.maverick.repository.AdaptiveQuestionRepository;
import com.stackroute.maverick.repository.AdaptiveTopicRepository;
import com.stackroute.maverick.repository.AdaptiveUserRepository;




@Service
public class AdaptiveGameEngineServiceImpl implements AdaptiveGameEngineService {
	
	private AdaptiveCategoriesRepository categoriesRepository;
	
	private AdaptiveCategoryRepository categoryRepository;
	
	private AdaptiveLevelRepository levelRepository;
	
	private AdaptiveOptionRepository optionRepository;
	
	private AdaptiveQuestionRepository questionRepository;
	
	private AdaptiveTopicRepository topicRepository;
	
	private AdaptiveUserRepository  userRepository;
	
	@Autowired
	public AdaptiveGameEngineServiceImpl(AdaptiveCategoryRepository categoryRepository,AdaptiveLevelRepository levelRepository,AdaptiveOptionRepository optionRepository,AdaptiveQuestionRepository questionRepository,AdaptiveTopicRepository topicRepository,AdaptiveUserRepository  userRepository) {
		this.categoryRepository=categoryRepository;
		this.levelRepository=levelRepository;
		this.optionRepository=optionRepository;
		this.questionRepository=questionRepository;
		this.topicRepository=topicRepository;
		this.userRepository=userRepository;
	}

	@Override
	public List<AdaptiveCategory> addCategory(int category_id, String time) {
		// TODO Auto-generated method stub
		return categoryRepository.addCategory(category_id, time);
	}

	@Override
	public List<AdaptiveCategory> checkCategoryId(int category_id) {
		// TODO Auto-generated method stub
		return categoryRepository.checkCategoryId(category_id);
	}

	@Override
	public List<AdaptiveTopic> addTopic(int category_id, int topic_id, String time) {
		// TODO Auto-generated method stub
		List<AdaptiveTopic> newTopic = topicRepository.addTopic(category_id, topic_id, time);
		addLevel1(topic_id);
		addLevel2(topic_id);
		addLevel3(topic_id);
		return newTopic;
	}

	@Override
	public List<AdaptiveTopic> checkTopicId(int topic_id) {
		// TODO Auto-generated method stub
		return topicRepository.checkTopicId(topic_id);
	}

	@Override
	public List<AdaptiveLevel> addLevel1(int topic_id) {
		// TODO Auto-generated method stub
		return levelRepository.addLevel1(topic_id);
	}

	@Override
	public List<AdaptiveLevel> addLevel2(int topic_id) {
		// TODO Auto-generated method stub
		return levelRepository.addLevel2(topic_id);
	}

	@Override
	public List<AdaptiveLevel> addLevel3(int topic_id) {
		// TODO Auto-generated method stub
		return levelRepository.addLevel3(topic_id);
	}

	@Override
	public List<AdaptiveQuestion> checkQuestionIdForLevel1(int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return questionRepository.checkQuestionIdForLevel1(topic_id, questionId);
	}

	@Override
	public List<AdaptiveQuestion> checkQuestionIdForLevel2(int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return questionRepository.checkQuestionIdForLevel2(topic_id, questionId);
	}

	@Override
	public List<AdaptiveQuestion> checkQuestionIdForLevel3(int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return questionRepository.checkQuestionIdForLevel3(topic_id, questionId);
	}

	@Override
	public List<AdaptiveQuestion> addQuestionInLevel1(int category_id, int topic_id, int questionId,
			String questionStem, String time) {
		// TODO Auto-generated method stub
		return questionRepository.addQuestionInLevel1(category_id, topic_id, questionId, questionStem, time);
	}

	@Override
	public List<AdaptiveQuestion> addQuestionInLevel2(int category_id, int topic_id, int questionId,
			String questionStem, String time) {
		// TODO Auto-generated method stub
		return questionRepository.addQuestionInLevel2(category_id, topic_id, questionId, questionStem, time);
	}

	@Override
	public List<AdaptiveQuestion> addQuestionInLevel3(int category_id, int topic_id, int questionId,
			String questionStem, String time) {
		// TODO Auto-generated method stub
		return questionRepository.addQuestionInLevel3(category_id, topic_id, questionId, questionStem, time);
	}

	@Override
	public List<AdaptiveOption> addOptionInQuestionOfLevel1(int category_id, int topic_id, int questionId,
			int option_id, String option_value, boolean ans, String time) {
		// TODO Auto-generated method stub
		return optionRepository.addOptionInQuestionOfLevel1(category_id, topic_id, questionId, option_id, option_value, ans, time);
	}

	@Override
	public List<AdaptiveOption> addOptionInQuestionOfLevel2(int category_id, int topic_id, int questionId,
			int option_id, String option_value, boolean ans, String time) {
		// TODO Auto-generated method stub
		return optionRepository.addOptionInQuestionOfLevel2(category_id, topic_id, questionId, option_id, option_value, ans, time);
	}

	@Override
	public List<AdaptiveOption> addOptionInQuestionOfLevel3(int category_id, int topic_id, int questionId,
			int option_id, String option_value, boolean ans, String time) {
		// TODO Auto-generated method stub
		return optionRepository.addOptionInQuestionOfLevel3(category_id, topic_id, questionId, option_id, option_value, ans, time);
	}

	@Override
	public void createCategoriesNode() {
//		if(categoriesRepository.checkCategoryId(1)==null)
//		{
//			categoriesRepository.addCategory(1);
//		}
//		
	}

	@Override
	public List<AdaptiveUser> checkUserId(int user_id) {
		// TODO Auto-generated method stub
		return userRepository.checkUserId(user_id);
	}

	@Override
	public List<AdaptiveUser> createUSer(int user_id, String time) {
		// TODO Auto-generated method stub
		return userRepository.createUSer(user_id, time);
	}

	@Override
	public List<AdaptiveUser> relateUserWithTopic(int user_id, int topic_id, int category_id) {
		// TODO Auto-generated method stub
		return userRepository.relateUserWithTopic(user_id, topic_id, category_id);
	}

	@Override
	public List<AdaptiveQuestion> listOfQuestionInLevel1(int category_id, int topic_id) {
		// TODO Auto-generated method stub
		return questionRepository.listOfQuestionInLevel1(category_id, topic_id);
	}

	@Override
	public List<AdaptiveQuestion> listOfQuestionInLevel2(int category_id, int topic_id) {
		// TODO Auto-generated method stub
		return questionRepository.listOfQuestionInLevel2(category_id, topic_id);
	}

	@Override
	public List<AdaptiveQuestion> listOfQuestionInLevel3(int category_id, int topic_id) {
		// TODO Auto-generated method stub
		return questionRepository.listOfQuestionInLevel3(category_id, topic_id);
	}

	@Override
	public List<AdaptiveOption> listOfOptionInQuestionInLevel1(int category_id, int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return optionRepository.listOfOptionInQuestionInLevel1(category_id, topic_id, questionId);
	}

	@Override
	public List<AdaptiveOption> listOfOptionInQuestionInLevel2(int category_id, int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return optionRepository.listOfOptionInQuestionInLevel2(category_id, topic_id, questionId);
	}

	@Override
	public List<AdaptiveOption> listOfOptionInQuestionInLevel3(int category_id, int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return optionRepository.listOfOptionInQuestionInLevel3(category_id, topic_id, questionId);
	}

	@Override
	public List<AdaptiveOption> correctOptionInQuestionInLevel3(int category_id, int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return optionRepository.correctOptionInQuestionInLevel3(category_id, topic_id, questionId);
	}

	@Override
	public List<AdaptiveOption> correctOptionInQuestionInLevel2(int category_id, int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return optionRepository.correctOptionInQuestionInLevel2(category_id, topic_id, questionId);
	}

	@Override
	public List<AdaptiveOption> correctOptionInQuestionInLevel1(int category_id, int topic_id, int questionId) {
		// TODO Auto-generated method stub
		return optionRepository.correctOptionInQuestionInLevel1(category_id, topic_id, questionId);
	}

	@Override
	public List<AdaptiveUser> optionAnsweredByUserInLevel1(int category_id, int topic_id, int questionId, int option_id,
			int user_id) {
		// TODO Auto-generated method stub
		return userRepository.optionAnsweredByUserInLevel1(category_id, topic_id, questionId, option_id, user_id);
	}

	@Override
	public List<AdaptiveUser> optionAnsweredByUserInLevel2(int category_id, int topic_id, int questionId, int option_id,
			int user_id) {
		// TODO Auto-generated method stub
		return userRepository.optionAnsweredByUserInLevel2(category_id, topic_id, questionId, option_id, user_id);
	}

	@Override
	public List<AdaptiveUser> optionAnsweredByUserInLevel3(int category_id, int topic_id, int questionId, int option_id,
			int user_id) {
		// TODO Auto-generated method stub
		return userRepository.optionAnsweredByUserInLevel3(category_id, topic_id, questionId, option_id, user_id);
	}

	@Override
	public List<AdaptiveUser> checkingUserPlayedTopic(int user_id, int topic_id, int category_id) {
		// TODO Auto-generated method stub
		return userRepository.checkingUserPlayedTopic(user_id, topic_id, category_id);
	}

	@Override
	public List<AdaptiveQuestion> questionsAnsweredByUserInLevel1(int user_id, int topic_id, int category_id) {
		// TODO Auto-generated method stub
		return questionRepository.questionsAnsweredByUserInLevel1(user_id, topic_id, category_id);
	}

	@Override
	public List<AdaptiveQuestion> questionsAnsweredByUserInLevel2(int user_id, int topic_id, int category_id) {
		// TODO Auto-generated method stub
		return questionRepository.questionsAnsweredByUserInLevel2(user_id, topic_id, category_id);
	}

	@Override
	public List<AdaptiveQuestion> questionsAnsweredByUserInLevel3(int user_id, int topic_id, int category_id) {
		// TODO Auto-generated method stub
		return questionRepository.questionsAnsweredByUserInLevel3(user_id, topic_id, category_id);
	}

}
