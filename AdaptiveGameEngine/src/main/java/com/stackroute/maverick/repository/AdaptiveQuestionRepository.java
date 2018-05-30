package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


import com.stackroute.maverick.domain.AdaptiveQuestion;

public interface AdaptiveQuestionRepository extends Neo4jRepository<AdaptiveQuestion, Long>{
	
	@Query("match (o:AdaptiveLevel1)-[r1:adaptive_level_of]->(n:AdaptiveTopic)-[r:adaptive_topic_of]->(m:AdaptiveCategory) where m.category_id={category_id} and n.topic_id={topic_id} create (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o) set p.questionId={questionId},p.questionStem={questionStem},p.timeStamp={time} return p;")
	List<AdaptiveQuestion> addQuestionInLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("questionStem") String questionStem,@Param("time") String time);
	
	@Query("match (o:AdaptiveLevel2)-[r1:adaptive_level_of]->(n:AdaptiveTopic)-[r:adaptive_topic_of]->(m:AdaptiveCategory) where m.category_id={category_id} and n.topic_id={topic_id} create (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o) set p.questionId={questionId},p.questionStem={questionStem},p.timeStamp={time} return p;")
	List<AdaptiveQuestion> addQuestionInLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("questionStem") String questionStem,@Param("time") String time);
	
	@Query("match (o:AdaptiveLevel3)-[r1:adaptive_level_of]->(n:AdaptiveTopic)-[r:adaptive_topic_of]->(m:AdaptiveCategory) where m.category_id={category_id} and n.topic_id={topic_id} create (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o) set p.questionId={questionId},p.questionStem={questionStem},p.timeStamp={time} return p;")
	List<AdaptiveQuestion> addQuestionInLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("questionStem") String questionStem,@Param("time") String time);
	
	@Query("match (n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel1)-[r:adaptive_level_of]->(m:AdaptiveTopic) where n.questionId={questionId} and m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> checkQuestionIdForLevel1(@Param("topic_id") int topic_id,@Param("questionId") int questionId);
    
	@Query("match (n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel2)-[r:adaptive_level_of]->(m:AdaptiveTopic) where n.questionId={questionId} and m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> checkQuestionIdForLevel2(@Param("topic_id") int topic_id,@Param("questionId") int questionId);

	@Query("match (n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel3)-[r:adaptive_level_of]->(m:AdaptiveTopic) where n.questionId={questionId} and m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> checkQuestionIdForLevel3(@Param("topic_id") int topic_id,@Param("questionId") int questionId);
	
	@Query("match (n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel1)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> listOfQuestionInLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id);

	@Query("match (n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel2)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> listOfQuestionInLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id);
	
	@Query("match (n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel3)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> listOfQuestionInLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id);
}
