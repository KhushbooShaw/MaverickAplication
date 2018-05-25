package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


import com.stackroute.maverick.domain.AdaptiveTopic;

public interface AdaptiveTopicRepository extends Neo4jRepository<AdaptiveTopic, Long> {
	
	@Query("match (m:AdaptiveCategory) where m.category_id={category_id} create (n:AdaptiveTopic)-[r:adaptive_topic_of]->(m) set n.topic_id={topic_id},n.timeStamp={time} return n;")
	List<AdaptiveTopic> addTopic(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("time") String time);
	
	@Query("match (n:AdaptiveTopic) where n.topic_id={topic_id} return n;")
	List<AdaptiveTopic> checkTopicId(@Param("topic_id") int topic_id);

}
