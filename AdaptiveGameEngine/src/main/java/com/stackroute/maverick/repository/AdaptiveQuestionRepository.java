package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


import com.stackroute.maverick.domain.AdaptiveQuestion;

public interface AdaptiveQuestionRepository extends Neo4jRepository<AdaptiveQuestion, Long>{
	
	@Query("match (m:AdaptiveCategory)<-[r:adaptive_ topic-of]-(n:Adaptivetopic)<-[r1:adaptive_level_of]-(o:AdaptiveLevel1) where m.category_id={category_id} and n.topic_id={topic_id} create (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o) set p.questionId={questionId},p.questionStem={questionStem},p.timeStamp={time} return p;")
	List<AdaptiveQuestion> addQuestionInLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("questionStem") String questionStem,@Param("time") String time);
	
	@Query("match (m:AdaptiveCategory)<-[r:adaptive_ topic-of]-(n:Adaptivetopic)<-[r1:adaptive_level_of]-(o:AdaptiveLevel2) where m.category_id={category_id} and n.topic_id={topic_id} create (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o) set p.questionId={questionId},p.questionStem={questionStem},p.timeStamp={time} return p;")
	List<AdaptiveQuestion> addQuestionInLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("questionStem") String questionStem,@Param("time") String time);
	
	@Query("match (m:AdaptiveCategory)<-[r:adaptive_ topic-of]-(n:Adaptivetopic)<-[r1:adaptive_level_of]-(o:AdaptiveLevel3) where m.category_id={category_id} and n.topic_id={topic_id} create (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o) set p.questionId={questionId},p.questionStem={questionStem},p.timeStamp={time} return p;")
	List<AdaptiveQuestion> addQuestionInLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("questionStem") String questionStem,@Param("time") String time);
	
	@Query("match (m:AdaptiveTopic)<-[r:adaptive_level_of]-(u:AdaptiveLevel1)<-[r1:adaptive_question_of]-(n:AdaptiveQuestion) where n.questionId={questionId},m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> checkQuestionIdForLevel1(@Param("topic_id") int topic_id,@Param("questionId") int questionId);
    
	@Query("match (m:AdaptiveTopic)<-[r:adaptive_level_of]-(u:AdaptiveLevel2)<-[r1:adaptive_question_of]-(n:AdaptiveQuestion) where n.questionId={questionId},m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> checkQuestionIdForLevel2(@Param("topic_id") int topic_id,@Param("questionId") int questionId);

	@Query("match (m:AdaptiveTopic)<-[r:adaptive_level_of]-(u:AdaptiveLevel3)<-[r1:adaptive_question_of]-(n:AdaptiveQuestion) where n.questionId={questionId},m.topic_id={topic_id} return n;")
	List<AdaptiveQuestion> checkQuestionIdForLevel3(@Param("topic_id") int topic_id,@Param("questionId") int questionId);

}
