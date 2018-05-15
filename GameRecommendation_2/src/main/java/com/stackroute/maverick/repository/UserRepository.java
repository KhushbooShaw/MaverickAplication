package com.stackroute.maverick.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.LocalUser;
import com.stackroute.maverick.domain.Topics;
import com.stackroute.maverick.domain.User;

public interface UserRepository extends Neo4jRepository<LocalUser, Long>{

	@Query("match (n:User)-[:plays]->(g:Topics) where ID(n)={id} return g;")
	List<Topics> gamePlayedByUser(@Param("id") long id);
	
	@Query("match (n:User)-[r:fav_category]->(m:Category) where id(n)={id} return n;")
	List<LocalUser> userFavCategory(@Param("id") long id);
    
}
