package com.stackroute.maverick.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.AdaptiveCategories;


public interface AdaptiveCategoriesRepository extends Neo4jRepository<AdaptiveCategories, Long>{

	@Query("create (n:AdaptiveCategories) set n.categories_id={id} return n;")
    List<AdaptiveCategories> addCategory(@Param("id") int id);

	@Query("match (n:AdaptiveCategories) where n.categories_id={id} return n;")
    List<AdaptiveCategories> checkCategoryId(@Param("id") int id);
}
