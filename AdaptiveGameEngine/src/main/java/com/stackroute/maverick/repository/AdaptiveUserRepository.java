package com.stackroute.maverick.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.AdaptiveOption;
import com.stackroute.maverick.domain.AdaptiveUser;

public interface AdaptiveUserRepository extends Neo4jRepository<AdaptiveUser, Long>{
	
	@Query("match (n:AdaptiveUser) where n.user_id={user_id} return n;")
	List<AdaptiveUser> checkUserId(@Param("user_id") int user_id);
	
	@Query("create (n:AdaptiveUser) set n.user_id={user_id},n.timeStamp={time} return n;")
	List<AdaptiveUser> createUSer(@Param("user_id") int user_id,@Param("time") String time);
	
	@Query("match (n:AdaptiveUser),(m:AdaptiveTopic)-[r:adaptive_topic_of]->(o:AdaptiveCategory) where n.user_id={user_id} and m.topic_id={topic_id} and o.category_id={category_id} create (n)-[r1:adaptive_user_played_topic]->(m) return n;")
	List<AdaptiveUser> relateUserWithTopic(@Param("user_id") int user_id,@Param("topic_id") int topic_id,@Param("category_id") int category_id);
	
	@Query("match (nn:AdaptiveUser),(n1:AdaptiveOption)-[rr1:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel1)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} and n1.option_id={option_id} and nn.user_id={user_id} create (nn)-[dd:adaptive_user_answered]->(n1) return nn;")
	List<AdaptiveUser> optionAnsweredByUserInLevel1(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("user_id") int user_id);

	@Query("match (nn:AdaptiveUser),(n1:AdaptiveOption)-[rr1:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel2)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} and n1.option_id={option_id} and nn.user_id={user_id} create (nn)-[dd:adaptive_user_answered]->(n1) return nn;")
	List<AdaptiveUser> optionAnsweredByUserInLevel2(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("user_id") int user_id);
	
	@Query("match (nn:AdaptiveUser),(n1:AdaptiveOption)-[rr1:adaptive_option_of]->(n:AdaptiveQuestion)-[r1:adaptive_question_of]->(u:AdaptiveLevel3)-[r:adaptive_level_of]->(m:AdaptiveTopic)-[r2:adaptive_topic_of]->(o:AdaptiveCategory) where o.category_id={category_id} and m.topic_id={topic_id} and n.questionId={questionId} and n1.option_id={option_id} and nn.user_id={user_id} create (nn)-[dd:adaptive_user_answered]->(n1) return nn;")
	List<AdaptiveUser> optionAnsweredByUserInLevel3(@Param("category_id") int category_id,@Param("topic_id") int topic_id,@Param("questionId") int questionId,@Param("option_id") int option_id,@Param("user_id") int user_id);
	
	@Query("match (n:AdaptiveUser)-[rf:adaptive_user_played_topic]->(m:AdaptiveTopic)-[r:adaptive_topic_of]->(o:AdaptiveCategory) where n.user_id={user_id} and m.topic_id={topic_id} and o.category_id={category_id} return n;")
	List<AdaptiveUser> checkingUserPlayedTopic(@Param("user_id") int user_id,@Param("topic_id") int topic_id,@Param("category_id") int category_id);
	
	
}
