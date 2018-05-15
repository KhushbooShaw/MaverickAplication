package com.stackroute.maverick.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.Topics;

import java.util.List;




public interface TopicsRespository extends Neo4jRepository<Topics, Long>{

    @Query("match(n:Games) where n.category_id={id} return n;")
    List<Topics> topicsInCategory(@Param("id") long id);
    

}
