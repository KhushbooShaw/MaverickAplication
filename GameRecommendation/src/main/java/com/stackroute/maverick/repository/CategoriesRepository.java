package com.stackroute.maverick.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.RecommendationCategories;
import com.stackroute.maverick.domain.RecommendationCategory;

public interface CategoriesRepository extends Neo4jRepository<RecommendationCategories, Long>{

	@Query("create (n:RecommendationCategories) set n.categories_id={id} return n;")
    List<RecommendationCategories> addCategory(@Param("id") int id);

	@Query("match (n:RecommendationCategories) where n.categories_id={id} return n;")
    List<RecommendationCategories> checkCategoryId(@Param("id") int id);
	
}
