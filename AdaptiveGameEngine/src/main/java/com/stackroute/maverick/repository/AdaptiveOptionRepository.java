package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.AdaptiveOption;
import com.stackroute.maverick.domain.AdaptiveQuestion;


public interface AdaptiveOptionRepository extends Neo4jRepository<AdaptiveOption, Long>{

	@Query("match (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o1:AdaptiveLevel1)-[r1:adaptive_level_of]->(n:AdaptiveTopic)-[r:adaptive_topic_of]->(m:AdaptiveCategory) where m.category_id={category_id} and n.topic_id={topic_id} and p.questionId={questionId} create (o:AdaptiveOption)-[r4:adaptive_option_of]->(p) set o.option_id={option_id},o.option_value={option_value},o.timeStamp={time},r4.correct={ans} return o;")
	List<AdaptiveOption> addOptionInQuestionOfLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("option_value") String option_value,@Param("ans") boolean ans,@Param("time") String time);
	
	@Query("match (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o1:AdaptiveLevel2)-[r1:adaptive_level_of]->(n:AdaptiveTopic)-[r:adaptive_topic_of]->(m:AdaptiveCategory) where m.category_id={category_id} and n.topic_id={topic_id} and p.questionId={questionId} create (o:AdaptiveOption)-[r4:adaptive_option_of]->(p) set o.option_id={option_id},o.option_value={option_value},o.timeStamp={time},r4.correct={ans} return o;")
	List<AdaptiveOption> addOptionInQuestionOfLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("option_value") String option_value,@Param("ans") boolean ans,@Param("time") String time);
	
	@Query("match (p:AdaptiveQuestion)-[r3:adaptive_question_of]->(o1:AdaptiveLevel3)-[r1:adaptive_level_of]->(n:AdaptiveTopic)-[r:adaptive_topic_of]->(m:AdaptiveCategory) where m.category_id={category_id} and n.topic_id={topic_id} and p.questionId={questionId} create (o:AdaptiveOption)-[r4:adaptive_option_of]->(p) set o.option_id={option_id},o.option_value={option_value},o.timeStamp={time},r4.correct={ans} return o;")
	List<AdaptiveOption> addOptionInQuestionOfLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("option_value") String option_value,@Param("ans") boolean ans,@Param("time") String time);
	
	@Query("match (n1:AdaptiveOption)-[rr:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel1)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} return n1;")
	List<AdaptiveOption> listOfOptionInQuestionInLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId);
	
	@Query("match (n1:AdaptiveOption)-[rr:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel2)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} return n1;")
	List<AdaptiveOption> listOfOptionInQuestionInLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId);
	
	@Query("match (n1:AdaptiveOption)-[rr:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel3)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} return n1;")
	List<AdaptiveOption> listOfOptionInQuestionInLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId);
	
	@Query("match (n1:AdaptiveOption)-[rr:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel3)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} and rr.correct=true return n1;")
	List<AdaptiveOption> correctOptionInQuestionInLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId);
	
	@Query("match (n1:AdaptiveOption)-[rr:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel2)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} and rr.correct=true return n1;")
	List<AdaptiveOption> correctOptionInQuestionInLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId);
	
	@Query("match (n1:AdaptiveOption)-[rr:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel1)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} and rr.correct=true return n1;")
	List<AdaptiveOption> correctOptionInQuestionInLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId);
}
