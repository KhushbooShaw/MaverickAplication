package com.stackroute.maverick.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.RecommendationUser;
import com.stackroute.maverick.domain.RecommendationGame;
import com.stackroute.maverick.domain.User;

public interface UserRepository extends Neo4jRepository<RecommendationUser, Long>{

	@Query("match (n:User)-[:plays]->(g:Topics) where ID(n)={id} return g;")
	List<RecommendationGame> gamePlayedByUser(@Param("id") long id);
	
	@Query("match (n:User),(m:Category) where n.user_id={user_id} and m.category_id={category_id} create (n)-[r:fav_category]->(m) set r.timestamp={time} return n;")
	List<RecommendationUser> userFavCategory(@Param("user_id") int user_id,@Param("category_id") int category_id,@Param("time") Date time);
	@Query("create (n:User) set n.user_id={id},n.name={name},n.gender={gender},n.age={age},n.location={location},n.timestamp={time} return n;")
	List<RecommendationUser> saveUser(@Param("id") int id,@Param("name") String name,@Param("gender") String gender,@Param("age") int age,@Param("location") String location,@Param("time") Date time);
	@Query("match (n:User) where n.id={id} set n.name={name},n.gender={gender} return n;")
	List<RecommendationUser> setUserData(@Param("id") long id,@Param("name") String name,@Param("gender") String gender);
	@Query("match (n:User),(g:Game1) where n.user_id={user_id} and g.game_id={game_id} create (n)-[r:played]->(m) set r.timestamp={time} return n;")
	List<RecommendationUser> userPlayedGame(@Param("user_id") int user_id,@Param("game_id") int game_id,@Param("time") Date time);
	

}
