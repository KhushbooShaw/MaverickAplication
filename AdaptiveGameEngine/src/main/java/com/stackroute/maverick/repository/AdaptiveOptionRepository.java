package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.AdaptiveOption;


public interface AdaptiveOptionRepository extends Neo4jRepository<AdaptiveOption, Long>{

	@Query("match (m:AdaptiveCategory)<-[r:adaptive_ topic-of]-(n:Adaptivetopic)<-[r1:adaptive_level_of]-(o:AdaptiveLevel1)<-[r3:adaptive_question_of]-(p:AdaptiveQuestion) where m.category_id={category_id} and n.topic_id={topic_id} and p.questionId} create (o:AdaptiveOption)-[r4:adaptive_option_of]->(q) set o.option_id={option_id},o.option_value={option_value},o.timeStamp={time},r4.correct={ans} return o;")
	List<AdaptiveOption> addOptionInQuestionOfLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("option_value") String option_value,@Param("ans") boolean ans,@Param("time") String time);
	
	@Query("match (m:AdaptiveCategory)<-[r:adaptive_ topic-of]-(n:Adaptivetopic)<-[r1:adaptive_level_of]-(o:AdaptiveLevel2)<-[r3:adaptive_question_of]-(p:AdaptiveQuestion) where m.category_id={category_id} and n.topic_id={topic_id} and p.questionId} create (o:AdaptiveOption)-[r4:adaptive_option_of]->(q) set o.option_id={option_id},o.option_value={option_value},o.timeStamp={time},r4.correct={ans} return o;")
	List<AdaptiveOption> addOptionInQuestionOfLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("option_value") String option_value,@Param("ans") boolean ans,@Param("time") String time);
	
	@Query("match (m:AdaptiveCategory)<-[r:adaptive_ topic-of]-(n:Adaptivetopic)<-[r1:adaptive_level_of]-(o:AdaptiveLevel3)<-[r3:adaptive_question_of]-(p:AdaptiveQuestion) where m.category_id={category_id} and n.topic_id={topic_id} and p.questionId} create (o:AdaptiveOption)-[r4:adaptive_option_of]->(q) set o.option_id={option_id},o.option_value={option_value},o.timeStamp={time},r4.correct={ans} return o;")
	List<AdaptiveOption> addOptionInQuestionOfLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("option_value") String option_value,@Param("ans") boolean ans,@Param("time") String time);
	
}
