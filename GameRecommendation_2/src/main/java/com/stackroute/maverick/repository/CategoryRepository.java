package com.stackroute.maverick.repository;


import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.Topics;




public interface CategoryRepository extends Neo4jRepository<Category, Long> {
	
	@Query("match (n:User)-[:plays]->(g:Games) where ID(n)={id} return g;")
	List<Topics> gamePlayedByUser(@Param("id") long id);
	@Query("match(n:User)-[r:fav_category]->(m:Category) where id(n)={id} return m;")
    List<Category> userFavCategory(@Param("id") long id);
}