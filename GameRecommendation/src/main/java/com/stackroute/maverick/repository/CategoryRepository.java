package com.stackroute.maverick.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.Category;
import com.stackroute.maverick.domain.RecommendationCategory;
import com.stackroute.maverick.domain.RecommendationGame;




public interface CategoryRepository extends Neo4jRepository<RecommendationCategory, Long> {
	
	@Query("match (m:RecommendationCategories) create (n:RecommendationCategory)-[r:recommendation_category_of]->(m) set n.category_id={id},n.name={name},n.img={img},n.timeStamp={time},r.timeStamp={time} return n;")
    List<RecommendationCategory> addCategory(@Param("id") int id,@Param("name") String name,@Param("img") String img,@Param("time") String time);

	@Query("match (n:RecommendationCategory) where n.category_id={id} return n;")
    List<RecommendationCategory> checkCategoryId(@Param("id") int id);
	
	@Query("match (n:RecommendationCategory) where n.category_id={id} set n.category_id={id},n.name={name},n.img={img},n.timeStamp={time},r.timeStamp={time} return n;")
    List<RecommendationCategory> updateCategory(@Param("id") int id,@Param("name") String name,@Param("img") String img,@Param("time") String time);

	@Query("match (n:RecommendationUser)-[r:recommendation_user_fav_category]->(m:RecommendationCategory) where n.userId={user_id} return m;")
	List<RecommendationCategory> getUserFavCategory(@Param("user_id") int user_id);
	
}