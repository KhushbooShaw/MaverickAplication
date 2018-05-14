package com.gameRecommendation.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.gameRecommendation.domain.Topics;
import com.gameRecommendation.domain.User;

public interface UserRepository extends Neo4jRepository<User, Long> {

	@Query("match (n:User)-[:plays]->(g:Topics) where ID(n)={id} return g;")
	List<Topics> gamePlayedByUser(@Param("id") long id);

}
