package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationCategory;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;

public interface UserRepository extends Neo4jRepository<RecommendationUser, Long>{
	
	//query for making user favourite category relationship
	
	@Query("match (n:RecommendationUser),(m:RecommendationCategory) where n.userId={user_id} and m.category_id={category_id} create (n)-[r:recommendation_user_fav_category]->(m) set r.timestamp={time} return n;")
	List<RecommendationUser> setUserFavCategory(@Param("user_id") int user_id,@Param("category_id") int category_id,@Param("time") String time);
	
	 //query for creating node of RecommendationUser
	
	@Query("create (n:RecommendationUser) set n.userId={id},n.userName={name},n.gender={gender},n.age={age},n.location={location},n.timestamp={time} return n;")
	List<RecommendationUser> addUser(@Param("id") int id,@Param("name") String name,@Param("gender") String gender,@Param("age") String age,@Param("location") String location,@Param("time") String time);
	
	//query for making game played by user relationship
	
	@Query("match (n:RecommendationUser),(g:RecommendationGame) where n.userId={user_id} and g.game_id={game_id} create (n)-[r:recommendation_game_playedBy_user]->(g) set r.timestamp={time} return n;")
	List<RecommendationUser> gamePlayedByUser(@Param("user_id") int user_id,@Param("game_id") int game_id,@Param("time") String time);
	
	 //query for checking whether a RecommendationUser node exists or not
	
	@Query("match (n:RecommendationUser) where n.userId={id} return n;")
    List<RecommendationUser> checkUserId(@Param("id") int id);
	
	//query for updating an existing RecommendationUser node
	
	@Query("match (n:RecommendationUser) where n.userId={id} set n.userId={id},n.userName={name},n.gender={gender},n.age={age},n.location={location},n.timestamp={time} return n;")
	List<RecommendationUser> updateUser(@Param("id") int id,@Param("name") String name,@Param("gender") String gender,@Param("age") String age,@Param("location") String location,@Param("time") String time);

}
