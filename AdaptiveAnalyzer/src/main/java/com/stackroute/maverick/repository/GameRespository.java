package com.stackroute.maverick.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.maverick.domain.RecommendationGame;

import java.util.Date;
import java.util.List;




public interface GameRespository extends Neo4jRepository<RecommendationGame, Long>{

    @Query("match(n:Games) where n.category_id={id} return n;")
    List<RecommendationGame> topicsInCategory(@Param("id") long id);
    @Query("match (m:Category) where m.category_id={category_id} create (n:Game1)-[r:belongs_to]->(m) set r.timestamp={time},n.game_id={id},n.name={name},n.category_id={category_id},n.game_type={game_type_id},n.timestamp={time},n.game_rules={game_rules},n.game_description={game_description} return n;")
    List<RecommendationGame> addGame(@Param("id") int id,@Param("name") String name,@Param("category_id") int category_id,@Param("game_type_id") String game_type_id,@Param("game_rules") String game_rules,@Param("game_description") String game_description,@Param("time") Date timestamp);

}
