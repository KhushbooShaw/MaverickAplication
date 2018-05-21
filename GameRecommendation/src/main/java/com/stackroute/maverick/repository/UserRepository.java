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
	
	@Query("match (n:User)-[r:fav_category]->(m:Category) where id(n)={id} return n;")
	List<RecommendationUser> userFavCategory(@Param("id") long id);
	@Query("create (n:User) set n.user_id={id},n.name={name},n.gender={gender},n.age={age},n.location={location},n.timestamp={time} return n;")
	List<RecommendationUser> saveUser(@Param("id") int id,@Param("name") String name,@Param("gender") String gender,@Param("age") int age,@Param("location") String location,@Param("time") Date time);
	@Query("match (n:User) where n.id={id} set n.name={name},n.gender={gender} return n;")
	List<RecommendationUser> setUserData(@Param("id") long id,@Param("name") String name,@Param("gender") String gender);
	@Query("match (n:User) where n.id={id} create (n)-[r:player]->(m:game) return n;")
	List<RecommendationUser> createRelation(@Param("id") long id);
	@Query("match (n:User) where substring(n.name,0,{length})={data} return n;")
	List<RecommendationUser> searchTest(@Param("data") String data,@Param("length") int length);

}
