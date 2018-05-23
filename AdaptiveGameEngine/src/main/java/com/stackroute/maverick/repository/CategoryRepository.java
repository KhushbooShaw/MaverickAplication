package com.stackroute.maverick.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.RecommendationGame;




public interface CategoryRepository extends Neo4jRepository<Category, Long> {
	
	@Query("match (n:User)-[:plays]->(g:Games) where ID(n)={id} return g;")
	List<RecommendationGame> gamePlayedByUser(@Param("id") long id);
	@Query("match(n:User)-[r:fav_category]->(m:Category) where id(n)={id} return m;")
    List<Category> userFavCategory(@Param("id") long id);
	@Query("match (m:Categories) create (n:Category)-[r:category_of]->(m) set n.category_id={id},n.name={name},n.img={img},n.timestamp={time},r.timestamp={time} return n;")
    List<Category> addCategory(@Param("id") int id,@Param("name") String name,@Param("img") String img,@Param("time") Date time);

}